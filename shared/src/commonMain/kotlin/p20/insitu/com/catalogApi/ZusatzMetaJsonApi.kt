package p20.insitu.com.catalogApi

import kotlinx.serialization.Serializable

@Serializable
data class ZusatzMetaJsonApi(
    var name: String? = null,
    var excelName: String? = null
)
