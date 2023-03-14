package p20.insitu.com

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*

interface ComService {

    val client: HttpClient

    suspend fun logout() {
        val provider = client.plugin(Auth).providers.filterIsInstance<BearerAuthProvider>().first()
        provider.clearToken()
    }
}