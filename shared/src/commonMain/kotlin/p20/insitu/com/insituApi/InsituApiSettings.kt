package p20.insitu.com.insituApi

import p20.insitu.util.DEV_BASE_URL
import p20.insitu.util.DEV_SERVER_PORT

object InsituApiSettings {
    // INSITU Server
    const val BASE_SERVER_URL = DEV_BASE_URL // TODO change for production
    const val SERVER_PORT = DEV_SERVER_PORT // TODO change for production
    const val SERVER_URL = "http://$BASE_SERVER_URL:$SERVER_PORT"
    const val SERVER_CLIENT_ID = "insitu"
    const val DI_SERVER_API = "insitu_api"
    const val SEVER_CLIENT_SECRET = "Jf5Pi9WERQM109P8dr3bZeQuoLz0ZL6O"
}