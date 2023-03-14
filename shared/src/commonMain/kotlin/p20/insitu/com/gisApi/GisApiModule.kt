package p20.insitu.com.gisApi

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import org.koin.core.qualifier.named
import org.koin.dsl.module
import p20.insitu.com.initGisClient

val gisApiModule = module {
    single<HttpClient>(named(GisApiSettings.DI_GIS_API)) {
        initGisClient {
            install(ContentNegotiation) {
                json()
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
        }
    }
    single { GisService() }
}