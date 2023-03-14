package p20.insitu.server.gis

import io.ktor.client.*
import io.ktor.server.application.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.auth.*
import io.ktor.server.routing.*
import io.ktor.server.cio.*
import io.ktor.server.engine.*
import io.ktor.server.plugins.*
import io.ktor.server.sessions.*
import p20.insitu.com.authApi.AuthApiSettings
import p20.insitu.com.authApi.TokenInfo
import p20.insitu.com.authApi.authRedirectUri
import p20.insitu.com.gisApi.GisApiSettings

val keycloakProvider = OAuthServerSettings.OAuth2ServerSettings(
    name = "keycloak",
    authorizeUrl = AuthApiSettings.AUTH_ENDPOINT,
    accessTokenUrl = AuthApiSettings.TOKEN_ENDPOINT,
    clientId = GisApiSettings.GIS_CLIENT_ID,
    clientSecret = GisApiSettings.GIS_CLIENT_SECRET,
    accessTokenRequiresBasicAuth = false,
    requestMethod = HttpMethod.Post, // must POST to token endpoint
    defaultScopes = listOf("openid roles")
)

fun startGisServer() {
    embeddedServer(CIO, host =  GisApiSettings.BASE_GIS_URL, port = GisApiSettings.GIS_PORT) {
        install(ContentNegotiation) {
            json()
        }
        install(Sessions) {
            cookie<TokenInfo>(AuthApiSettings.USER_SESSION_COOKIE) {
                cookie.path = "/"
                cookie.maxAgeInSeconds = 60
            }
        }
        install(Authentication) {
            oauth(AuthApiSettings.KEYCLOAK_OATUH) {
                client = HttpClient{
                    followRedirects = false
                }
                providerLookup = { keycloakProvider }
                urlProvider = { authRedirectUri() }
            }
        }
        routing {
            authenticate(AuthApiSettings.KEYCLOAK_OATUH) {
                test()
            }
        }
    }.start(wait = true)
}