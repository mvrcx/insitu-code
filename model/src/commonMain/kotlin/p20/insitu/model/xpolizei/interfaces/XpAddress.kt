package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.components.spatial.geodetic.shapes.GeoPositionMarker
import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.AdministrativeEncoding
import p20.insitu.model.components.PostalAddress

interface XpAddress: XpCommonBaseClass {

    var postalAddress: PostalAddress?
    var comment: String?
    var administrativeEncoding: AdministrativeEncoding?
    var geolocation: GeoPositionMarker?
    var region: String?

    fun getAdresse(): Adresse {
        return Adresse().also {
            it.id = id
            it.adresstyp = Adresstyp().also {
                it.lage_Postanschrift = Lage_Postanschrift().also {
                    it.anschrift = postalAddress?.getAnschrift()
                }
            }
            it.bemerkung = comment
            it.verwaltungspolitischeKodierung =
                administrativeEncoding?.getVerwaltungspolitischeKodierung()
            it.geokodierung = Geometrie(
                referenzsystem = geolocation?.referenceSystem?.toKatalogCode231(),
                geoDaten = GeoDaten().also {
                    it.punkt = geolocation?.worldPosition?.getXpGeoPoint()
                }
            )
            it.region = region
        }
    }

}

