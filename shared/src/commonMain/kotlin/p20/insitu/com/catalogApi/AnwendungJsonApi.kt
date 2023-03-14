package p20.insitu.com.catalogApi

import kotlinx.serialization.Serializable

@Serializable
data class AnwendungJsonApi(
    var id : Long? = null,
    var name: String? = null,
    var bezeichnung: String? = null,
    var externalPk: Long? = null
)
