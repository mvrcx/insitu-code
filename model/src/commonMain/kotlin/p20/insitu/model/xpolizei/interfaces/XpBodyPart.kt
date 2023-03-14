package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.components.*
import p20.insitu.model.xpolizei.schema.*

interface XpBodyPart : XpCommonBaseClass {

    var type: BodyPartDescription?
    var recoveryNumber: String?
    var identificationNumber: String?
    var child: CatalogCodeFixed<KatalogCode217>?
    var comment: String?
    var injury: List<Injury>?
    var characteristics: List<PhysicalFeature>?
    var tatoo: List<Tatoo>?
    var dentures: Dentures?

    fun getKoerperteil(): Koerperteil

}