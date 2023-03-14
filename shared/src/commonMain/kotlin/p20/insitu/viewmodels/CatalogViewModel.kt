package p20.insitu.viewmodels

import co.touchlab.kermit.Logger
import kotlinx.coroutines.flow.*
import org.koin.core.component.KoinComponent
import p20.insitu.catalogues.CatalogCategory
import p20.insitu.catalogues.CatalogItem
import p20.insitu.catalogues.CatalogItems
import p20.insitu.catalogues.CatalogSubCategory
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.stateHandler.UiStateHandler

class CatalogViewModel(
    private val log: Logger,
    private val uiStateHandler: UiStateHandler,
    private val catalogRepo: CatalogRepo
) : KoinComponent {

    private val _catalogCategory: MutableStateFlow<CatalogCategory?> = MutableStateFlow(null)
    val catalogCategory: StateFlow<CatalogCategory?> get() = _catalogCategory

    private val _catalogSubCategory: MutableStateFlow<CatalogSubCategory?> = MutableStateFlow(null)
    val catalogSubCategory: StateFlow<CatalogSubCategory?> get() = _catalogSubCategory

    private val _catalogItems: MutableStateFlow<List<CatalogItem>> = MutableStateFlow(listOf())
    private val _catalogItemsFiltered: MutableStateFlow<List<CatalogItem>> =
        MutableStateFlow(listOf())
    val catalogItemsFiltered: StateFlow<List<CatalogItem>> get() = _catalogItemsFiltered

    // UI
    private val _catalogSearchText = MutableStateFlow<String?>(null)
    val catalogSearchText: StateFlow<String?> = _catalogSearchText
    fun setCatalogSearchText(catalogSearchText: String?) {
        _catalogSearchText.value = catalogSearchText
        catalogSearchText?.let { searchText ->
            _catalogItemsFiltered.value = _catalogItems.value.filter {
                it.designation(uiStateHandler.language.value).lowercase().contains(searchText.lowercase())
            }.sortedBy { it.designation(uiStateHandler.language.value) }
        }?: run {
            _catalogItemsFiltered.value = _catalogItems.value
        }
    }

    suspend fun init(category: CatalogCategory? = null, subCategory: CatalogSubCategory? = null) {
        _catalogCategory.value = category
        _catalogSubCategory.value = subCategory
        // The order is important here (poor design, needs to be refactored)!
        // If we have a sub category, we use that for determining the items and we ignore the parent category!
        val items = when {
            catalogSubCategory.value != null -> CatalogItems.getItems(
                catalogSubCategory.value!!,
                catalogRepo
            )
            catalogCategory.value != null -> CatalogItems.getItems(
                catalogCategory.value!!,
                catalogRepo
            )
            else -> listOf()
        }
        _catalogItems.value = items.sortedBy { it.designation(uiStateHandler.language.value) }
        _catalogItemsFiltered.value = items.sortedBy { it.designation(uiStateHandler.language.value) }
    }

}