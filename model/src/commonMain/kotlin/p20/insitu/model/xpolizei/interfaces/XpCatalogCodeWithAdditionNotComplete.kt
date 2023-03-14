package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.Catalog

interface XpCatalogCodeWithAdditionNotComplete<C> {

    val code: String?
    val name: String?
    val additionalValue: String?
    val unlistedValue: String?
    val catalog: Catalog

    @Suppress("UNCHECKED_CAST", "IMPLICIT_CAST_TO_ANY")
    fun getKatalogCodeMitZusatzNichtAbgeschlossen(): C? {
        val catalogCode = when (catalog.key) {
                    "225" -> {
                        KatalogCode225_MitZusatz_NichtAbgeschlossen().also {
                            it.katalog = KatalogCode225_MitZusatz().also {
                                it.katalog = KatalogCode225().also {
                                    it.code = code
                                    it.name = name
                                    it.listURI = catalog.getListUri()
                                    it.listVersionID = catalog.getListVersionUri()
                                }
                                it.zusatz = additionalValue
                            }
                            it.nichtGelisteterWert = unlistedValue
                        }
                    }
                    "252" -> {
                        KatalogCode252_MitZusatz_NichtAbgeschlossen().also {
                            it.katalog = KatalogCode252_MitZusatz().also {
                                it.katalog = KatalogCode252().also {
                                    it.code = code
                                    it.name = name
                                    it.listURI = catalog.getListUri()
                                    it.listVersionID = catalog.getListVersionUri()
                                }
                                it.zusatz = additionalValue
                            }
                            it.nichtGelisteterWert = unlistedValue
                        }
                    }
                    "383" -> {
                        KatalogCode383_MitZusatz_NichtAbgeschlossen().also {
                            it.katalog = KatalogCode383_MitZusatz().also {
                                it.katalog = KatalogCode383().also {
                                    it.code = code
                                    it.name = name
                                    it.listURI = catalog.getListUri()
                                    it.listVersionID = catalog.getListVersionUri()
                                }
                                it.zusatz = additionalValue
                            }
                            it.nichtGelisteterWert = unlistedValue
                        }
                    }
                    else -> null
                }
        return catalogCode as? C
    }

}