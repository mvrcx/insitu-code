package p20.insitu.db.catalogs

import io.realm.kotlin.types.RealmObject

class RCatalogCode: RealmObject {
    var code: String? = null
    var designation: String? = null
    var additionalValue: String? = null
    var unlistedValue: String? = null
    var catalogKey: String? = null
    var catalogName: String? = null
    var catalogVersion: String? = null

    override fun toString(): String {
        return designation ?: additionalValue ?: unlistedValue ?: ""
    }
}