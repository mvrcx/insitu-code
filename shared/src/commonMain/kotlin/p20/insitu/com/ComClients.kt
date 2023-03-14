package p20.insitu.com

import io.ktor.client.*

expect fun initAuthClient(config: HttpClientConfig<*>.() -> Unit): HttpClient

expect fun initInsituClient(config: HttpClientConfig<*>.() -> Unit): HttpClient

expect fun initCatalogClient(config: HttpClientConfig<*>.() -> Unit): HttpClient

expect fun initGisClient(config: HttpClientConfig<*>.() -> Unit): HttpClient