package p20.insitu.com.catalogApi

import co.touchlab.kermit.Logger
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import p20.insitu.com.ComService
import p20.insitu.db.catalogs.CatalogRepo

class CatalogService(
    private val log: Logger,
    private val catalogRepo: CatalogRepo,
    private val coroutineScope: CoroutineScope
) : KoinComponent, ComService {

    override val client: HttpClient by inject(named(CatalogApiSettings.DI_CATALOG_API))

    private suspend fun getCatalogs(): List<KatalogJsonApi> =
        withContext(coroutineScope.coroutineContext) {
            // Endpoint: "api/v1/anwendung/XPOLIZEI/katalog"
            val catalogs: MutableList<KatalogJsonApi> = mutableListOf()
            try {
                client.get(CatalogApiSettings.CATALOG_URL + CatalogApiRoutes.GET_CATALOGS)
                    .let { response ->
                        val json = response.bodyAsText()
                        (Json.parseToJsonElement(json) as? JsonArray)?.forEach { jsonElement ->
                            Json.decodeFromJsonElement(KatalogJsonApi.serializer(), jsonElement)
                                .let {
                                    catalogs.add(it)
                                }
                        }
                    }
            } catch (ex: RedirectResponseException) {
                // 3xx - responses
                // TODO logging
                println("Error: ${ex.response.status.description}")
            } catch (ex: ClientRequestException) {
                // 4xx - responses
                // TODO logging
                println("Error: ${ex.response.status.description}")
            } catch (ex: ServerResponseException) {
                // 5xx - response
                // TODO logging
                println("Error: ${ex.response.status.description}")
            } catch (ex: Exception) {
                // TODO logging
                ex.printStackTrace()
            }
            return@withContext catalogs
        }

    private suspend fun getLatestCatalog(catalogCode: String): KatalogJsonApi? =
        withContext(coroutineScope.coroutineContext) {
            // Endpoint: "api/v1/anwendung/XPOLIZEI/katalog/$catalogCode/version-latest"
            var catalog: KatalogJsonApi? = null
            try {
                client.get(CatalogApiSettings.CATALOG_URL + CatalogApiRoutes.GET_LATEST_CATALOG(catalogCode))
                    .let { response ->
                        val json = response.bodyAsText()
                        Json.decodeFromString(KatalogJsonApi.serializer(), json).let {
                            catalog = it
                        }
                    }
            } catch (ex: RedirectResponseException) {
                // 3xx - responses
                // TODO logging
                println("Error: ${ex.response.status.description}")
            } catch (ex: ClientRequestException) {
                // 4xx - responses
                // TODO logging
                println("Error: ${ex.response.status.description}")
            } catch (ex: ServerResponseException) {
                // 5xx - response
                // TODO logging
                println("Error: ${ex.response.status.description}")
            } catch (ex: Exception) {
                // TODO logging
                ex.printStackTrace()
            }
            return@withContext catalog
        }

    private suspend fun getLatestCatalogValues(catalogCode: String): List<KatalogwertJsonApi> =
            withContext(coroutineScope.coroutineContext) {
                // Endpoint: ""api/v1/anwendung/XPOLIZEI/katalog/$catalogCode/version-latest/katalogwerte"
                val catalogValues: MutableList<KatalogwertJsonApi> = mutableListOf()
                try {
                    client.get(CatalogApiSettings.CATALOG_URL + CatalogApiRoutes.GET_LATEST_CATALOG_VALUES(catalogCode))
                        .let { response ->
                            val json = response.bodyAsText()
                            (Json.parseToJsonElement(json) as? JsonArray)?.forEach { jsonElement ->
                                Json.decodeFromJsonElement(KatalogwertJsonApi.serializer(), jsonElement)
                                    .let {
                                        catalogValues.add(it)
                                    }
                            }
                        }
                } catch (ex: RedirectResponseException) {
                    // 3xx - responses
                    // TODO logging
                    println("Error: ${ex.response.status.description}")
                } catch (ex: ClientRequestException) {
                    // 4xx - responses
                    // TODO logging
                    println("Error: ${ex.response.status.description}")
                } catch (ex: ServerResponseException) {
                    // 5xx - response
                    // TODO logging
                    println("Error: ${ex.response.status.description}")
                } catch (ex: Exception) {
                    // TODO logging
                    ex.printStackTrace()
                }
                return@withContext catalogValues
            }

    suspend fun updateCatalogDatabase() =
        withContext(coroutineScope.coroutineContext) {
            // Clear the database
            catalogRepo.deleteAll()

            // Get request for all XPolizei catalogs (and all their versions)
            // Make distinct list of all catalog codes
            val catalogCodes = getCatalogs().map { it.schluessel }.filterNotNull().distinct()

            // For each catalog code:
            // - Get the latest catalog data and catalog values
            // - Update the local database accordingly
            val updateJobs: MutableList<Job> = mutableListOf()
            catalogCodes.forEach { catalogCode ->
                // Get latest catalog
                getLatestCatalog(catalogCode)?.getCatalogInfo()?.let { catalog ->
                    // Get latest catalog values -> map from json API objects to RCatalogValue list
                    val catalogValues = getLatestCatalogValues(catalogCode).map {
                        it.getCatalogCode()
                    }
                    // Update catalog data asyc
                    updateJobs.add(
                        async {
                            catalog.let { catalogRepo.upsertCatalog(it) }
                        }
                    )
                    // Update catalog values async
                    updateJobs.add(
                        async {
                            catalogValues.let { catalogRepo.upsertCatalogValues(it) }
                        }
                    )
                }
            }
            // Wait for all async jobs to finish
            joinAll(*updateJobs.toTypedArray())

        }

}