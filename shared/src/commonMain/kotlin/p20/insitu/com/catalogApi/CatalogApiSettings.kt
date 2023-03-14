package p20.insitu.com.catalogApi

import p20.insitu.util.DEV_BASE_URL
import p20.insitu.util.DEV_CATALOG_PORT

object CatalogApiSettings {
    // Catalog API
    const val BASE_CATALOG_URL = DEV_BASE_URL // TODO change for production
    const val CATALOG_PORT = DEV_CATALOG_PORT // TODO change for production
    const val CATALOG_URL = "http://$BASE_CATALOG_URL:$CATALOG_PORT"
    const val CATALOG_CLIENT_ID = "catalog"
    const val DI_CATALOG_API = "catalog_api"
    const val CATALOG_CLIENT_SECRET = "mjAb0JRdPvoUn3sBoMYXPFh4ZkiLI1rO"
}