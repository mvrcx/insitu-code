package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpLegalBasis
import p20.insitu.model.xpolizei.schema.*

@Serializable
data class LegalBasis(
    override var proceduralLaw: CatalogCodeFixed<KatalogCode237>?,
    override var policeLaw: CatalogCodeFixed<KatalogCode356>?,
    override var law: CatalogCodeNotComplete<KatalogCode387_NichtAbgeschlossen>?
) : Component(), XpLegalBasis{

    override fun getRechtsgrundlage(): Rechtsgrundlage {
        return Rechtsgrundlage(
            strafprozessordnung = proceduralLaw?.getKatalogCode(),
            polizeigesetz = policeLaw?.getKatalogCode(),
            sonstigesGesetz = law?.getKatalogCodeNichtAbgeschlossen()
        )
    }
}
