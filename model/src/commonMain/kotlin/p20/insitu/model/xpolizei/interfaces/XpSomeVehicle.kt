package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.SonstigesFahrzeug

interface XpSomeVehicle : XpVehicle {

    fun getSonstigesFahrzeug(): SonstigesFahrzeug

}