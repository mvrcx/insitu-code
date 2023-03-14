package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.Namensangabe

interface XpNameData {

    var designation: String?
    var differentSpelling: List<String>?

    fun getNamensangabe(): Namensangabe
}