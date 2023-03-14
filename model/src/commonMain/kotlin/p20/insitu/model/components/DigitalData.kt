package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpDigitalData
import p20.insitu.model.xpolizei.schema.DigitaleDaten

@Serializable
data class DigitalData(
    override var mimeType: String?,
    override var fileID: String?,
    override var senderID: String?,
    override var checksum: String?,
    override var file: File?
) : Component(),  XpDigitalData{

    override fun getDigitaleDaten(): DigitaleDaten {
        return DigitaleDaten(
            mimeType = mimeType,
            dateiID = fileID,
            absenderID = senderID,
            pruefsumme = checksum,
            datei = file?.getDatei()
        )
    }
}
