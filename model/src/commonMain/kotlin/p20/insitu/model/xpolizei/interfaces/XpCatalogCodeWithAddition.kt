package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.Catalog

interface XpCatalogCodeWithAddition<C> {

    val code: String?
    val name: String?
    val additionalValue: String?
    val catalog: Catalog

    @Suppress("UNCHECKED_CAST", "IMPLICIT_CAST_TO_ANY")
    fun getKatalogCodeMitZusatz(): C? {
        val catalogCode = when (catalog.key) {
                "225" -> {
                    KatalogCode225_MitZusatz().also {
                        it.katalog = KatalogCode225().also {
                            it.code = code
                            it.name = name
                            it.listURI = catalog.getListUri()
                            it.listVersionID = catalog.getListVersionUri()
                        }
                        it.zusatz = additionalValue
                    }
                }
                "244" -> {
                    KatalogCode244_MitZusatz().also {
                        it.katalog = KatalogCode244().also {
                            it.code = code
                            it.name = name
                            it.listURI = catalog.getListUri()
                            it.listVersionID = catalog.getListVersionUri()
                        }
                        it.zusatz = additionalValue
                    }
                }
                "252" -> {
                    KatalogCode252_MitZusatz().also {
                        it.katalog = KatalogCode252().also {
                            it.code = code
                            it.name = name
                            it.listURI = catalog.getListUri()
                            it.listVersionID = catalog.getListVersionUri()
                        }
                        it.zusatz = additionalValue
                    }
                }
                "258" -> {
                    KatalogCode258_MitZusatz().also {
                        it.katalog = KatalogCode258().also {
                            it.code = code
                            it.name = name
                            it.listURI = catalog.getListUri()
                            it.listVersionID = catalog.getListVersionUri()
                        }
                        it.zusatz = additionalValue
                    }
                }
                "288" -> {
                    KatalogCode288_MitZusatz().also {
                        it.katalog = KatalogCode288().also {
                            it.code = code
                            it.name = name
                            it.listURI = catalog.getListUri()
                            it.listVersionID = catalog.getListVersionUri()
                        }
                        it.zusatz = additionalValue
                    }
                }
                "318" -> {
                    KatalogCode318_MitZusatz().also {
                        it.katalog = KatalogCode318().also {
                            it.code = code
                            it.name = name
                            it.listURI = catalog.getListUri()
                            it.listVersionID = catalog.getListVersionUri()
                        }
                        it.zusatz = additionalValue
                    }
                }
                "383" -> {
                    KatalogCode383_MitZusatz().also {
                        it.katalog = KatalogCode383().also {
                            it.code = code
                            it.name = name
                            it.listURI = catalog.getListUri()
                            it.listVersionID = catalog.getListVersionUri()
                        }
                        it.zusatz = additionalValue
                    }
                }
                else -> null
            }
        return catalogCode as? C
    }

}