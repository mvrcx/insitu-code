package p20.insitu.server.insitu

import io.ktor.server.application.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.cio.*
import io.ktor.server.engine.*
import io.ktor.server.plugins.ContentNegotiation
import io.ktor.server.sessions.*
import kotlinx.serialization.json.Json
import p20.insitu.com.authApi.AuthApiSettings
import p20.insitu.com.authApi.TokenInfo
import p20.insitu.com.authApi.authRedirectUri
import p20.insitu.com.insituApi.InsituApiSettings
import p20.insitu.server.HttpClient
import java.io.File

val keycloakProvider = OAuthServerSettings.OAuth2ServerSettings(
    name = "keycloak",
    authorizeUrl = AuthApiSettings.AUTH_ENDPOINT,
    accessTokenUrl = AuthApiSettings.TOKEN_ENDPOINT,
    clientId = InsituApiSettings.SERVER_CLIENT_ID,
    clientSecret = InsituApiSettings.SEVER_CLIENT_SECRET,
    accessTokenRequiresBasicAuth = false,
    requestMethod = HttpMethod.Post, // must POST to token endpoint
    defaultScopes = listOf("openid roles")
)

fun startInsituServer() {
    embeddedServer(CIO, host =  InsituApiSettings.BASE_SERVER_URL, port = InsituApiSettings.SERVER_PORT) {
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
        install(Sessions) {
            cookie<TokenInfo>(AuthApiSettings.USER_SESSION_COOKIE) {
                cookie.path = "/"
                cookie.maxAgeInSeconds = 60
            }
        }
        install(Authentication) {
            oauth(AuthApiSettings.KEYCLOAK_OATUH) {
                client = HttpClient.client
                providerLookup = { keycloakProvider }
                urlProvider = { authRedirectUri() }
            }
        }
        routing {
            start()
            authenticate(AuthApiSettings.KEYCLOAK_OATUH) {
                login()
                successfulLogin()
            }
            test()
            detectObjectsInImage()
            formDetectObjectsInImage()
            hello()
            getUserInfoById()
        }
    }.start(wait = true)
}

suspend fun respondFile(call: ApplicationCall, filePath: String) {
    call.respondFile(File(filePath))
}