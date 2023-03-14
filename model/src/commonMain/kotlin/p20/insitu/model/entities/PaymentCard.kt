package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.components.DocNumber
import p20.insitu.model.components.EvidenceData
import p20.insitu.model.components.spatial.SpatialRepresentation
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.interfaces.*
import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.BankAccount
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.MoneyAmount

@Serializable
data class PaymentCard(
    override var deleted: Boolean = false,
    override var designation: String?,
    override var thumbnailId: String?,
    override var docNumber: DocNumber? = null,
    override var spatialRepresentation: SpatialRepresentation?,
    override var evidenceData: EvidenceData?,
    override var type: CatalogCodeFixed<KatalogCode125>?,
    override var provider: String?,
    override var number: String?,
    override var name: String?,
    override var comment: String?,
    override var validFrom: String?,
    override var validUntil: String?,
    override var bankAccount: BankAccount?,
    override var creditBalance: MoneyAmount?,
    override var numberOfPieces: Int?
) : BaseEntity(), Evidence, XpPaymentCard {

    override val entityType: String = EntityType.PAYMENT_CARD.toString()

    override fun getZahlungskarte(): Zahlungskarte {
        return Zahlungskarte().also {
            // Base class attributes
            it.id = id
            // Class attributes
            it.art = type?.getKatalogCode()
            it.emittent = provider
            it.nummer = number
            it.name = name
            it.bemerkung = comment
            it.bezeichnung = designation
            it.gueltigVon = validFrom
            it.gueltigBis = validUntil
            it.konto = bankAccount?.getBankkontoinformation()
            it.guthaben = creditBalance?.getGeldbetrag()
            it.stueckzahl = numberOfPieces
            it.asservat = getAsservat()
        }
    }

}
