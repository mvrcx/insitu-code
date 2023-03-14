package p20.insitu.model.entities

import p20.insitu.model.xpolizei.interfaces.XpLocation
import p20.insitu.model.xpolizei.schema.Oertlichkeit

interface Location: DocumentationObject, XpLocation {

    override fun getOertlichkeit(): Oertlichkeit {
        return Oertlichkeit().also {
            // Base class attributes
            it.id = id
            // Class attributes
            it.art = locationType?.getKatalogCodeNichtAbgeschlossen()
            it.bezeichnung = designation
        }
    }

}