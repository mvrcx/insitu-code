package p20.insitu.com.gisApi

import p20.insitu.util.DEV_BASE_URL
import p20.insitu.util.DEV_GIS_PORT

object GisApiSettings {
    // GIS API
    const val BASE_GIS_URL = DEV_BASE_URL // TODO change for production
    const val GIS_PORT = DEV_GIS_PORT // TODO change for production
    const val GIS_URL = "http://$BASE_GIS_URL:$GIS_PORT"
    const val GIS_CLIENT_ID = "gis"
    const val DI_GIS_API = "gis_api"
    const val GIS_CLIENT_SECRET = "mjAb0JRdPvoUn3sBoMYXPFh4ZkiLI1rO"
}