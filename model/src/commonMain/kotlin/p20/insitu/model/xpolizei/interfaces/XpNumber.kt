package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.Nummer
import p20.insitu.model.components.Authority

interface XpNumber {

    var designation: String?
    var value: String?
    var authority: Authority?

    fun getNummer(): Nummer
}