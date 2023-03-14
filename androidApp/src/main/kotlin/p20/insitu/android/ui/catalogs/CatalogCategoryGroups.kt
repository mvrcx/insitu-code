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
import p20.insitu.catalogues.CatalogCategoryGroup
import p20.insitu.nav.NavDestination
import p20.insitu.nav.NavRoute
import p20.insitu.resources.strings.TitleStrings
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.theme.InsituTheme
import p20.insitu.android.ui.components.Lists
import p20.insitu.android.util.LockScreenOrientation
import p20.insitu.android.ui.components.TopAppBars
import p20.insitu.stateHandler.SessionHandler

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CatalogCategoryGroups(
    sessionHandler: SessionHandler = get(),
    uiStateHandler: UiStateHandler = get(),
    sourceDestination: String? = null
) {
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    // Reconstruct source NavRoute
    val sourceDestinationRoute = sourceDestination?.let { dest -> NavRoute.valueOf(dest) }

    // Setup navigation change listener
    val navigationState = rememberNavigationState()

    // UiStateHandler states
    val language = uiStateHandler.language.collectAsState()

    Scaffold(
        topBar = {
            TopAppBars.Catalog(
                title = TitleStrings.catalog(language.value),
                subTitle = null,
                navigationState = navigationState,
                sessionHandler = sessionHandler,
                uiStateHandler = uiStateHandler
            )
        },
        content = {
            Lists.CatalogCategoryGroups(
                list = listOf(
                    CatalogCategoryGroup.BUILDING_ELEMENTS,
                    CatalogCategoryGroup.BUILDING_SITES,
                    CatalogCategoryGroup.VEHICLES,
                    CatalogCategoryGroup.OBJECTS,
                    CatalogCategoryGroup.OTHER_SITES,
                    CatalogCategoryGroup.PERSONS,
                    CatalogCategoryGroup.TRACES,
                    CatalogCategoryGroup.WEAPONS
                ),
                language = language.value
            ) { group ->
                val navAction = if (group.categories.size > 1) {
                    NavDestination.Catalog.Categories.withCatalogArgs(
                        categoryGroup = group,
                        category = null,
                        subCategory = null,
                        sourceDestination = sourceDestinationRoute
                    )
                } else if (group.categories.size == 1 && group.categories[0].hasSubCategories()) {
                    NavDestination.Catalog.SubCategories.withCatalogArgs(
                        categoryGroup = null,
                        category = group.categories[0],
                        subCategory = null,
                        sourceDestination = sourceDestinationRoute
                    )
                } else if(group.categories.size == 1 && !group.categories[0].hasSubCategories()){
                    NavDestination.Catalog.Items.withCatalogArgs(
                        categoryGroup = null,
                        category = group.categories[0],
                        subCategory = null,
                        sourceDestination = sourceDestinationRoute
                    )
                } else null
                navAction?.let {
                    navigationState.value = it.navigate()
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun CatalogCategoryGroupsPreview() {
    CompositionLocalProvider(LocalNavController provides rememberNavController()) {
        InsituTheme(true) {
            CatalogCategoryGroups()
        }
    }
}

