package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpNameData
import p20.insitu.model.xpolizei.schema.Namensangabe

@Serializable
data class NameData(
    override var designation: String? = null,
    override var differentSpelling: List<String>? = listOf()
) :Component(),  XpNameData{

    override fun getNamensangabe(): Namensangabe {
        return Namensangabe(
            bezeichnung = designation,
            abweichendeSchreibweise = differentSpelling
        )
    }
}

