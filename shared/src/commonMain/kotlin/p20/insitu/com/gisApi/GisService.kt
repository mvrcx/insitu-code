package p20.insitu.com.gisApi

import io.ktor.client.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import p20.insitu.com.ComService

class GisService : KoinComponent, ComService {

    override val client: HttpClient by inject(named(GisApiSettings.DI_GIS_API))

}