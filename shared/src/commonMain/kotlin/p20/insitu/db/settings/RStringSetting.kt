package p20.insitu.db.settings

import io.realm.kotlin.types.RealmObject

class RStringSetting: RealmObject {
    var key: String = ""
    var value: String? = null
}
