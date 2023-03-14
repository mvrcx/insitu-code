package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.Datei

interface XpFile {

    var data: ByteArray?
    var download: String?

    fun getDatei(): Datei {
        return Datei(
            daten = data,
            download = download
        )
    }
}