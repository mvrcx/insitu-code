package p20.insitu.model.entities

import p20.insitu.model.xpolizei.interfaces.XpSomeObject
import p20.insitu.model.xpolizei.schema.SonstigeSache

interface ISomeObject: Evidence, XpSomeObject {

    override fun getSonstigeSache(): SonstigeSache {
        return SonstigeSache().also {
            // Base class attributes
            it.id = id
            // Class attributes
            it.art = typeOfObject?.getKatalogCodeNichtAbgeschlossen()
            it.bezeichnung = designation
            it.bemerkung = comment
            it.besondereMerkmale = specialFeatures
            it.material = material?.map { it.getMaterial() }
            it.farbangabe = color?.map { it.getFarbangabe() }
            it.laenge = length?.getAusmass()
            it.breite = width?.getAusmass()
            it.hoehe = height?.getAusmass()
            it.volumen = volume?.getVolumen()
            it.gewicht = weight?.getGewicht()
            it.stueckzahl = numberOfPieces
            it.asservat = getAsservat()
        }
    }

}