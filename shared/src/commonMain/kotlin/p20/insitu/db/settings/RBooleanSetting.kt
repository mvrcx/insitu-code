package p20.insitu.db.settings

import io.realm.kotlin.types.RealmObject

class RBooleanSetting: RealmObject {
    var key: String = ""
    var value: Boolean = false
}
