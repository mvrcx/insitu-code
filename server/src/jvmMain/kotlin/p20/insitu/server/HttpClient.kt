package p20.insitu.server

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import p20.insitu.com.authApi.AuthApiSettings
import p20.insitu.com.authApi.UserInfo
import p20.insitu.com.insituApi.InsituApiSettings

object HttpClient {
    val client = HttpClient(CIO) {
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
        followRedirects = false
    }

    suspend fun verifyToken(accessToken: String): UserInfo? {
        return try {
            client.post(AuthApiSettings.USER_INFO_ENDPOINT)
                 {
                     headers.append(HttpHeaders.Authorization,
                         "Bearer $accessToken")
                }.body()
        } catch (ex: Exception) {
            null
        }
    }
}
