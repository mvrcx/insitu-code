package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.components.*
import p20.insitu.model.components.Material
import p20.insitu.model.xpolizei.schema.*

interface XpSomeObject {

    var designation:String?
    var typeOfObject: CatalogCodeNotComplete<KatalogCode119_NichtAbgeschlossen>?
    var specialFeatures: String?
    var comment: String?
    var material: List<Material>?
    var color: List<ColorDescription>?
    var length: Size?
    var width: Size?
    var height: Size?
    var volume: Volume?
    var weight: Weight?
    var numberOfPieces: Int?

    fun getSonstigeSache(): SonstigeSache

}
