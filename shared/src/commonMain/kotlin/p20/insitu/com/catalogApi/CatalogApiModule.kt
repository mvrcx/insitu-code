package p20.insitu.com.catalogApi

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import org.koin.core.qualifier.named
import org.koin.dsl.module
import p20.insitu.com.initCatalogClient
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.getWith

val catalogApiModule = module {
    single<HttpClient>(named(CatalogApiSettings.DI_CATALOG_API)) {
        initCatalogClient {
            install(ContentNegotiation) {
                json()
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
        }
    }

    single { CatalogService(getWith("CatalogService"), get(), get()) }

    single {
        CatalogRepo(
            log = getWith("CatalogRepo"),
            coroutineScope = get()
        )
    }
}