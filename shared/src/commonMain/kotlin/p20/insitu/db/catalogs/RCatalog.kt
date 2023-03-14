package p20.insitu.db.catalogs

import io.realm.kotlin.types.RealmObject

class RCatalog: RealmObject {
    var key: String? = null
    var name: String? = null
    var version: String? = null
}
