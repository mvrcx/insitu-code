package p20.insitu.server.catalog

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import org.koin.java.KoinJavaComponent.inject
import p20.insitu.com.authApi.AuthApiSettings
import p20.insitu.com.authApi.TokenInfo
import p20.insitu.com.catalogApi.CatalogApiRoutes
import p20.insitu.com.insituApi.InsituApiRoutes
import p20.insitu.resources.FileDir
import p20.insitu.resources.FileHandler

const val CATALOGS_LIST_FILE_NAME = "catalogs.json"

fun Route.test() {
    get(CatalogApiRoutes.TEST) {
        call.respondText { "Helle Welt!" }
    }
}

fun Route.getCatalogs() {
    get(CatalogApiRoutes.GET_CATALOGS) {
        (call.sessions.get(AuthApiSettings.USER_SESSION_COOKIE) as? TokenInfo)?.let { tokenInfo ->
            val fileHandler: FileHandler by inject(FileHandler::class.java)
            fileHandler.getBinaryFile(FileDir.SERVER_CATALOGS.path, CATALOGS_LIST_FILE_NAME)?.let { data ->
                call.respond(String(data))
            }
        } ?: run {
            call.respondRedirect(InsituApiRoutes.LOGIN)
        }
    }
}

fun Route.getCatalog() {
    get(CatalogApiRoutes.GET_LATEST_CATALOG) {
        (call.sessions.get(AuthApiSettings.USER_SESSION_COOKIE) as? TokenInfo)?.let { tokenInfo ->
            val catalogCode = call.parameters["code"]
            val fileHandler: FileHandler by inject(FileHandler::class.java)
            fileHandler.getBinaryFile(FileDir.SERVER_CATALOGS.path, "catalog$catalogCode-latest.json")?.let { data ->
                call.respond(String(data))
            }
        } ?: run {
            call.respondRedirect(InsituApiRoutes.LOGIN)
        }
    }
}

fun Route.getCatalogValues() {
    get(CatalogApiRoutes.GET_LATEST_CATALOG_VALUES) {
        (call.sessions.get(AuthApiSettings.USER_SESSION_COOKIE) as? TokenInfo)?.let { tokenInfo ->
            val catalogCode = call.parameters["code"]
            val fileHandler: FileHandler by inject(FileHandler::class.java)
            fileHandler.getBinaryFile(FileDir.SERVER_CATALOGS.path, "catalog$catalogCode-values-latest.json")?.let { data ->
                call.respond(String(data))
            }
        } ?: run {
            call.respondRedirect(InsituApiRoutes.LOGIN)
        }
    }
}