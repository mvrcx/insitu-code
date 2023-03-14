package p20.insitu.com.authApi

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.http.*
import kotlinx.datetime.Clock
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import p20.insitu.com.ComService
import p20.insitu.com.insituApi.InsituApiSettings

class AuthService(private val clock: Clock) : KoinComponent, ComService {

    override val client: HttpClient by inject(named(AuthApiSettings.DI_AUTH_API))

    suspend fun authenticate(username: String, password: String): TokenInfo? {
        return try {
            client.submitForm(
                url = AuthApiSettings.TOKEN_ENDPOINT,
                formParameters = Parameters.build {
                    append("grant_type", "password")
                    append("username", username)
                    append("password", password)
                    append("client_id", InsituApiSettings.SERVER_CLIENT_ID)
                    append("client_secret", InsituApiSettings.SEVER_CLIENT_SECRET)
                    append("redirect_uri", authRedirectUri())
                }
            ).body()
        } catch (ex: RedirectResponseException) {
            // 3xx - responses
            println("Error: ${ex.response.status.description}")
            null
        } catch (ex: ClientRequestException) {
            // 4xx - responses
            println("Error: ${ex.response.status.description}")
            null
        } catch (ex: ServerResponseException) {
            // 5xx - response
            println("Error: ${ex.response.status.description}")
            null
        } catch (ex: Exception) {
            //println("Error: ${ex.message}")
            ex.printStackTrace()
            null
        }
    }

    @OptIn(ExperimentalSerializationApi::class)
    suspend fun verifyToken(accessToken: String): UserInfo? {
        return try {
            client.post(AuthApiSettings.USER_INFO_ENDPOINT)
            {
                headers.append(HttpHeaders.Authorization,
                    "Bearer $accessToken")
            }.body()
        } catch (ex: RedirectResponseException) {
            // 3xx - responses
            println("Error: ${ex.response.status.description}")
            null
        } catch (ex: ClientRequestException) {
            // 4xx - responses
            println("Error: ${ex.response.status.description}")
            null
        } catch (ex: ServerResponseException) {
            // 5xx - response
            println("Error: ${ex.response.status.description}")
            null
        } catch (ex: Exception) {
            //println("Error: ${ex.message}")
            ex.printStackTrace()
            null
        }
    }

    suspend fun refreshToken(refreshToken: String): TokenInfo? {
        return try {
            client.submitForm(
                url = AuthApiSettings.TOKEN_ENDPOINT,
                formParameters = Parameters.build {
                    append("grant_type", "refresh_token")
                    append("client_id", InsituApiSettings.SERVER_CLIENT_ID)
                    append("client_secret", InsituApiSettings.SEVER_CLIENT_SECRET)
                    append("refresh_token", refreshToken)
                }).body()
        } catch (ex: RedirectResponseException) {
            // 3xx - responses
            println("Error: ${ex.response.status.description}")
            null
        } catch (ex: ClientRequestException) {
            // 4xx - responses
            println("Error: ${ex.response.status.description}")
            null
        } catch (ex: ServerResponseException) {
            // 5xx - response
            println("Error: ${ex.response.status.description}")
            null
        } catch (ex: Exception) {
            //println("Error: ${ex.message}")
            ex.printStackTrace()
            null
        }
    }
}