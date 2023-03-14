package p20.insitu.db.settings

import io.realm.kotlin.types.RealmObject

class RFloatSetting: RealmObject {
    var key: String = ""
    var value: Float = 0f
}
