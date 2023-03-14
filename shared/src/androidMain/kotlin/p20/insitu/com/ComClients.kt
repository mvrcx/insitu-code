package p20.insitu.com

import io.ktor.client.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.engine.cio.*

actual fun initAuthClient(config: HttpClientConfig<*>.() -> Unit) = HttpClient(CIO) {
    config(this)
}

actual fun initInsituClient(config: HttpClientConfig<*>.() -> Unit) = HttpClient(CIO) {
    config(this)
}

actual fun initCatalogClient(config: HttpClientConfig<*>.() -> Unit) = HttpClient(CIO) {
    config(this)
}

actual fun initGisClient(config: HttpClientConfig<*>.() -> Unit) = HttpClient(CIO) {
    config(this)
}