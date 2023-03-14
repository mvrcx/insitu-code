package p20.insitu.com.authApi

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.core.qualifier.named
import org.koin.dsl.module
import p20.insitu.com.initAuthClient

val authApiModule = module {
    single<HttpClient>(named(AuthApiSettings.DI_AUTH_API)) {
        initAuthClient {
            install(ContentNegotiation) {
                json(json = Json {
                    encodeDefaults = true
                    isLenient = true
                    allowSpecialFloatingPointValues = true
                    allowStructuredMapKeys = true
                    prettyPrint = false
                    useArrayPolymorphism = false
                    ignoreUnknownKeys = true
                }
                )
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
            //install(Auth){}
        }
    }

    single { AuthService(clock = get()) }
}