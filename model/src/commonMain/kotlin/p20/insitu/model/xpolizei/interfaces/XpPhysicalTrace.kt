package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.components.*
import p20.insitu.model.components.Material
import p20.insitu.model.xpolizei.schema.*

interface XpPhysicalTrace {

    var typeOfPhysicalTrace: CatalogCodeFixed<KatalogCode120>?
    var designation: String?
    var numberOfPieces: Int?
    var position: String?
    var comment: String?
    var weight: Weight?
    var color: List<ColorDescription>?
    var volume: Volume?
    var material: List<Material>?
    var length: Size?
    var width: Size?
    var height: Size?
    var diameter: Size?
    var quality: CatalogCodeFixed<KatalogCode327>?

    fun getSpurMateriell(): SpurMateriell

}