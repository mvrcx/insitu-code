package p20.insitu.server.gis

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import p20.insitu.com.gisApi.GisApiRoutes

fun Route.test() {
    get(GisApiRoutes.TEST) {
        call.respondText { "Helle World!" }
    }
}