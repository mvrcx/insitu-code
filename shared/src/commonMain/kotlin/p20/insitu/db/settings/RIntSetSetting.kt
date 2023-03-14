package p20.insitu.db.settings

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject

class RIntSetSetting: RealmObject {
    var key: String = ""
    var value: RealmList<Int> = realmListOf()
}
