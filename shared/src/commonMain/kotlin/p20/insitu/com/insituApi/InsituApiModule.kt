package p20.insitu.com.insituApi

import io.ktor.client.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.core.qualifier.named
import org.koin.dsl.module
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.com.initInsituClient
import p20.insitu.db.app.AppDataRepo
import p20.insitu.getWith

val insituApiModule = module {

    single<HttpClient>(named(InsituApiSettings.DI_SERVER_API)) {
        val sessionHandler: SessionHandler by inject()
        val log: co.touchlab.kermit.Logger = getWith("InsituHttpClient")
        initInsituClient {
            install(Auth) {
                bearer {
                    // Load tokens ...
                    loadTokens {
                        // Load tokens from a local storage and return them as the 'BearerTokens' instance
                        log.d("loading bearer token...")
                        sessionHandler.getLatestToken()?.let { tokenInfo ->
                            log.d("found token!")
                            BearerTokens(tokenInfo.accessToken, tokenInfo.refreshToken ?: "")
                        }
                    }
                    // Refresh tokens ...
                    refreshTokens { // this: RefreshTokensParams
                        // Refresh tokens and return them as the 'BearerTokens' instance
                        log.d("token needs to be refreshed. using this refresh token: ${oldTokens?.refreshToken}")
                        oldTokens?.refreshToken?.let {
                            val result = sessionHandler.refreshToken(it)
                            log.d("received new token: $result")
                            sessionHandler.getLatestToken()?.let { tokenInfo ->
                                BearerTokens(tokenInfo.accessToken, tokenInfo.refreshToken ?: "")
                            }
                        }
                    }
                }
            }
            install(ContentNegotiation) {
                json(json = Json {
                    encodeDefaults = true
                    isLenient = true
                    allowSpecialFloatingPointValues = true
                    allowStructuredMapKeys = true
                    prettyPrint = false
                    useArrayPolymorphism = false
                    ignoreUnknownKeys = true
                })
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
        }
    }

    single { InsituService(log = getWith(InsituService::class.simpleName)) }

    single {
        AppDataRepo(
            log = getWith(AppDataRepo::class.simpleName),
            coroutineScope = get()
        )
    }
}