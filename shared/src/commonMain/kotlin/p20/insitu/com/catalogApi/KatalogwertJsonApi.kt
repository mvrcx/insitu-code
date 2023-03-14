package p20.insitu.com.catalogApi

import kotlinx.serialization.Serializable
import p20.insitu.model.components.*
import p20.insitu.model.xpolizei.schema.Code

@Serializable
data class KatalogwertJsonApi(
    var id: Long? = null,
    var schluessel: String? = null,
    var bezeichnung: String? = null,
    var loeschstatus: Char? = null,
    var auswahlerlaubt: Char? = null,
    var anzeigereihenfolge: Int? = null,
    var externalPk: Long? = null,
    var katalog: KatalogJsonApi? = null,
    var oberwerte: List<String>? = null,
    var unterwerte: List<String>? = null,
    var zusatzwerte: List<ZusatzwertJsonApi>? = null
) {
    fun getCatalogCode(): CatalogCode {
        val additionalValue =
            zusatzwerte?.find { it.zusatzMeta?.name == "Zusatz" }?.data_string != null // TODO check meta data attribute name!
        val unlistedValue =
            zusatzwerte?.find { it.zusatzMeta?.name == "Ungelisteter Wert" }?.data_string != null // TODO check meta data attribute name!

        return when {
            additionalValue && unlistedValue -> {
                CatalogCodeWithAdditionNotComplete<Code>(
                    schluessel,
                    bezeichnung,
                    zusatzwerte?.find { it.zusatzMeta?.name == "Zusatz" }?.data_string,
                    zusatzwerte?.find { it.zusatzMeta?.name == "Ungelisteter Wert" }?.data_string,
                    Catalog(
                        katalog?.schluessel ?: "",
                        katalog?.name,
                        katalog?.version
                    )
                )
            }
            additionalValue -> {
                CatalogCodeWithAddition<Code>(
                    schluessel,
                    bezeichnung,
                    zusatzwerte?.find { it.zusatzMeta?.name == "Zusatz" }?.data_string,
                    Catalog(
                        katalog?.schluessel ?: "",
                        katalog?.name,
                        katalog?.version
                    )
                )
            }
            unlistedValue -> {
                CatalogCodeNotComplete<Code>(
                    schluessel,
                    bezeichnung,
                    zusatzwerte?.find { it.zusatzMeta?.name == "Ungelisteter Wert" }?.data_string,
                    Catalog(
                        katalog?.schluessel ?: "",
                        katalog?.name,
                        katalog?.version
                    )
                )
            }
            else -> {
                CatalogCodeFixed<Code>(
                    schluessel ?: "",
                    bezeichnung ?: "",
                    Catalog(
                        katalog?.schluessel ?: "",
                        katalog?.name,
                        katalog?.version
                    )
                )
            }
        }
    }
}
