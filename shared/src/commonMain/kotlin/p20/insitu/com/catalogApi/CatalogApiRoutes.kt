package p20.insitu.com.catalogApi

object CatalogApiRoutes {
    // ROUTES MUST BE CONST
    const val TEST = "/test"
    const val GET_CATALOGS = "/api/v1/anwendung/XPOLIZEI/katalog"
    fun GET_LATEST_CATALOG(catalogCode: String): String = "/api/v1/anwendung/XPOLIZEI/katalog/$catalogCode/version-latest"
    fun GET_LATEST_CATALOG_VALUES(catalogCode: String): String = "/api/v1/anwendung/XPOLIZEI/katalog/$catalogCode/version-latest/katalogwerte"
}