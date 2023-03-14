package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.DigitaleDaten
import p20.insitu.model.components.File

interface XpDigitalData {

    var mimeType: String?
    var fileID: String?
    var senderID: String?
    var checksum: String?
    var file: File?

    fun getDigitaleDaten(): DigitaleDaten
}