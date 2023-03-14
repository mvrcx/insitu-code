package p20.insitu.com.catalogApi

import kotlinx.serialization.Serializable

@Serializable
data class ZusatzwertJsonApi(
    var data_number: Double? = null,
    var data_string: String? = null,
    var data_char: Char? = null,
    var data_date: String? = null,
    var zusatzMeta: ZusatzMetaJsonApi? = null
)
