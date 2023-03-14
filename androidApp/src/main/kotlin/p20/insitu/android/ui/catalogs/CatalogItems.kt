package p20.insitu.android.ui.catalogs

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.get
import p20.insitu.android.LocalNavController
import p20.insitu.android.rememberNavigationState
import p20.insitu.android.util.LockScreenOrientation
import p20.insitu.catalogues.*
import p20.insitu.nav.NavRoute
import p20.insitu.resources.strings.CatalogStrings
import p20.insitu.resources.strings.TextFieldStrings
import p20.insitu.resources.strings.TitleStrings
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.nav.NavDestination
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.theme.InsituTheme
import p20.insitu.viewmodels.CatalogViewModel
import p20.insitu.android.ui.components.Grids
import p20.insitu.android.ui.components.SpacersAndDividers
import p20.insitu.android.ui.components.TextFields
import p20.insitu.android.ui.components.TopAppBars
import p20.insitu.android.ui.components.dimen.Padding
import p20.insitu.stateHandler.SessionHandler

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CatalogItems(
    sessionHandler: SessionHandler = get(),
    uiStateHandler: UiStateHandler = get(),
    viewModel: CatalogViewModel = get(),
    catalogGroup: String? = null,
    catalogCategory: String? = null,
    catalogSubCategory: String? = null,
    sourceDestination: String? = null
) {
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    // Init view model
    LaunchedEffect(key1 = Unit, block = {
        viewModel.init(
            catalogCategory?.let { CatalogCategory.valueOf(it) },
            catalogSubCategory?.let { CatalogSubCategory.valueOf(it) }
        )
    })

    // Setup navigation change listener
    val navigationState = rememberNavigationState()

    // UiStateHandler states
    val language = uiStateHandler.language.collectAsState()

    // Catalog state
    val group = remember { mutableStateOf(catalogGroup?.let { CatalogCategoryGroup.valueOf(it) }) }
    val category = remember { mutableStateOf(catalogCategory?.let { CatalogCategory.valueOf(it) }) }
    val subCategory =
        remember { mutableStateOf(catalogSubCategory?.let { CatalogSubCategory.valueOf(it) }) }
    val catalogItems = viewModel.catalogItemsFiltered.collectAsState(listOf())
    val catalogSearchText = viewModel.catalogSearchText.collectAsState(null)

    val title = when {
        subCategory.value != null -> {
            CatalogStrings.subCategory(subCategory.value!!, language.value)
        }
        category.value != null -> {
            CatalogStrings.category(category.value!!, language.value)
        }
        else -> TitleStrings.catalog(language.value)
    }

    val subTitle = if (subCategory.value != null) {
        when {
            group.value != null && category.value != null -> {
                CatalogStrings.categoryGroup(
                    group.value!!,
                    language.value
                ) + " > " + CatalogStrings.category(category.value!!, language.value)
            }
            group.value != null && category.value == null -> {
                CatalogStrings.categoryGroup(group.value!!, language.value)
            }
            group.value == null && category.value != null -> {
                CatalogStrings.category(category.value!!, language.value)
            }
            else -> null
        }
    } else {
        group.value?.let {
            CatalogStrings.categoryGroup(it, language.value)
        }
    }


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
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(all = Padding.screen),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                TextFields.SimpleSearchBar(
                    modifier = Modifier.fillMaxWidth(),
                    label = TextFieldStrings.catalogSearch(language.value),
                    value = catalogSearchText.value ?: "",
                    enabled = true,
                    onValueChanged = { viewModel.setCatalogSearchText(it) },
                    onClearClick = { viewModel.setCatalogSearchText(null) },
                    language = language.value
                )

                SpacersAndDividers.VerticalSpacer()

                Grids.Catalog(
                    catalogItems = catalogItems.value,
                    language = language.value,
                    onClickAction = { catalogItem ->
                        navigationState.value = NavDestination.getEntityCreationView(
                            catalogItem.entityType,
                            sourceDestination?.let { dest -> NavRoute.valueOf(dest) },
                            catalogItem.xpCode
                        ).navigate(launchSingleTop = false)
                    }
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun CatalogPreview() {
    CompositionLocalProvider(LocalNavController provides rememberNavController()) {
        InsituTheme(true) {
            CatalogItems()
        }
    }
}

