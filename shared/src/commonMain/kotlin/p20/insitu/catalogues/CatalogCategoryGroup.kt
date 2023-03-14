package p20.insitu.catalogues

enum class CatalogCategoryGroup(val categories: List<CatalogCategory>) {

    CRIME_SCENE_SITES(
        listOf(
            CatalogCategory.BUILDING_SITES,
            CatalogCategory.VEHICLES,
            CatalogCategory.PERSONS,
            CatalogCategory.OTHER_SITES
        )
    ),
    BUILDING_ELEMENTS(
        listOf(
            CatalogCategory.BUILDING_ELEMENTS
        )
    ),
    BUILDING_SITES(
        listOf(
            CatalogCategory.BUILDING_SITES
        )
    ),
    PERSONS(
        listOf(
            CatalogCategory.PERSONS
        )
    ),
    OBJECTS(
        listOf(
            CatalogCategory.ELECTRONICS,
            CatalogCategory.FURNITURE,
            CatalogCategory.OTHER_OBJECTS
        )
    ),
    OTHER_SITES(
        listOf(
            CatalogCategory.OTHER_SITES
        )
    ),
    TRACES(
        listOf(
            CatalogCategory.TRACES
        )
    ),
    VEHICLES(
        listOf(
            CatalogCategory.VEHICLES
        )
    ),
    WEAPONS(
        listOf(
            CatalogCategory.WEAPONS
        )
    )
    ;

    fun hasCategories(): Boolean {
        return this.categories.isNotEmpty()
    }

}