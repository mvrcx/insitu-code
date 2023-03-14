package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.Serie

interface XpBankNoteSeries {

    var quantity: Int
    var increment: Int

    fun getSerie(): Serie

}