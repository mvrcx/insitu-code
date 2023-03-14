package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.Person

interface XpPerson: XpCommonBaseClass {

    fun getPerson(): Person

}