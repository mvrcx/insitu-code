package p20.insitu.android.ui.catalogs

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.get
import p20.insitu.android.LocalNavController
import p20.insitu.android.rememberNavigationState
import p20.insitu.catalogues.CatalogCategory
import p20.insitu.catalogues.CatalogCategoryGroup
import p20.insitu.nav.NavDestination
import p20.insitu.nav.NavRoute
import p20.insitu.resources.strings.CatalogStrings
import p20.insitu.resources.strings.TitleStrings
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.theme.InsituTheme
import p20.insitu.android.ui.components.Lists
import p20.insitu.android.ui.components.TopAppBars
import p20.insitu.android.util.LockScreenOrientation
import p20.insitu.stateHandler.SessionHandler

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CatalogSubCategories(
    sessionHandler: SessionHandler = get(),
    uiStateHandler: UiStateHandler = get(),
    catalogGroup: String? = null,
    catalogCategory: String? = null,
    sourceDestination: String? = null
) {
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    // Reconstruct source NavRoute
    val sourceDestinationRoute = sourceDestination?.let { dest -> NavRoute.valueOf(dest) }

    // Setup navigation change listener
    val navigationState = rememberNavigationState()

    // UiStateHandler states
    val language = uiStateHandler.language.collectAsState()

    // Catalog state
    val group = remember { mutableStateOf(catalogGroup?.let { CatalogCategoryGroup.valueOf(it) }) }
    val category = remember { mutableStateOf(catalogCategory?.let { CatalogCategory.valueOf(it) }) }

    val title = category.value?.let { CatalogStrings.category(it, language.value) }
        ?: TitleStrings.catalog(language.value)
    val subTitle = group.value?.let { CatalogStrings.categoryGroup(it, language.value) }

    Scaffold(
        topBar = {
            TopAppBars.Catalog(
                title = title,
                subTitle = subTitle,
                navigationState = navigationState,
                sessionHandler = sessionHandler,
                uiStateHandler = uiStateHandler
            )
        },
        content = {
            category.value?.let {
                Lists.CatalogSubCategories(
                    list = it.subCategories,
                    language = language.value
                ) { subCategory ->
                    val navAction = NavDestination.Catalog.Items.withCatalogArgs(
                        categoryGroup = group.value,
                        category = it,
                        subCategory = subCategory,
                        sourceDestination = sourceDestinationRoute
                    )
                    navigationState.value = navAction.navigate()
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun CatalogSubCategoriesPreview() {
    CompositionLocalProvider(LocalNavController provides rememberNavController()) {
        InsituTheme(true) {
            CatalogSubCategories()
        }
    }
}

