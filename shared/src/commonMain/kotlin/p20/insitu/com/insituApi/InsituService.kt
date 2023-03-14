package p20.insitu.com.insituApi

import co.touchlab.kermit.Logger
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import p20.insitu.com.ComService
import p20.insitu.com.authApi.*

class InsituService(private val log: Logger,) : KoinComponent, ComService {

    override val client: HttpClient by inject(named(InsituApiSettings.DI_SERVER_API))

    suspend fun getHelloWorld(): String {
        return try {
            client.get(InsituApiSettings.SERVER_URL + InsituApiRoutes.TEST) { }.body()
        } catch (ex: RedirectResponseException) {
            // 3xx - responses
            log.e("Error: ${ex.response.status.description}")
            "Error: ${ex.response.status.description}"
        } catch (ex: ClientRequestException) {
            // 4xx - responses
            log.e("Error: ${ex.response.status.description}")
            "Error: ${ex.response.status.description}"
        } catch (ex: ServerResponseException) {
            // 5xx - response
            log.e("Error: ${ex.response.status.description}")
            "Error: ${ex.response.status.description}"
        } catch (ex: Exception) {
            //println("Error: ${ex.message}")
            log.e(ex.printStackTrace().toString())
            "Error: ${ex.message}"
        }
    }


    @OptIn(ExperimentalSerializationApi::class)
    suspend fun getUserInfoById(userId: String): UserInfo? {
        return try {
            client.get(InsituApiSettings.SERVER_URL + InsituApiRoutes.USER + "/$userId") { }.body()
        } catch (ex: RedirectResponseException) {
            // 3xx - responses
            log.e("Error: ${ex.response.status.description}")
            null
        } catch (ex: ClientRequestException) {
            // 4xx - responses
            log.e("Error: ${ex.response.status.description}")
            null
        } catch (ex: ServerResponseException) {
            // 5xx - response
            log.e("Error: ${ex.response.status.description}")
            null
        } catch (ex: Exception) {
            //println("Error: ${ex.message}")
            log.e(ex.printStackTrace().toString())
            null
        }
    }
}