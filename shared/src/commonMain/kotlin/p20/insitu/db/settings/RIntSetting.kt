package p20.insitu.db.settings

import io.realm.kotlin.types.RealmObject

class RIntSetting: RealmObject {
    var key: String = ""
    var value: Int = 0
}
