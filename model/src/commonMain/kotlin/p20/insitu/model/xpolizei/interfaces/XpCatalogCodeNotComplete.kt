package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.Catalog

@Suppress("UNCHECKED_CAST")
interface XpCatalogCodeNotComplete<C> {

    val code: String?
    val name: String?
    val unlistedValue: String?
    val catalog: Catalog

    fun getKatalogCodeNichtAbgeschlossen(): C? {
        @Suppress("IMPLICIT_CAST_TO_ANY") val catalogCode = when (catalog.key) {
            "101" -> {
                KatalogCode101_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode101().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "109" -> {
                KatalogCode109_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode109().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "115" -> {
                KatalogCode115_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode115().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "119" -> {
                KatalogCode119_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode119().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "122" -> {
                KatalogCode122_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode122().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "202" -> {
                KatalogCode202_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode202().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "203" -> {
                KatalogCode203_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode203().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "208" -> {
                KatalogCode208_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode208().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "209" -> {
                KatalogCode209_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode209().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "212" -> {
                KatalogCode212_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode212().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "223" -> {
                KatalogCode223_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode223().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "224" -> {
                KatalogCode224_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode224().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "225" -> {
                KatalogCode225_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode225().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "226" -> {
                KatalogCode226_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode226().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "228" -> {
                KatalogCode228_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode228().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "230" -> {
                KatalogCode230_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode230().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "238" -> {
                KatalogCode238_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode238().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "239" -> {
                KatalogCode239_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode239().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "240" -> {
                KatalogCode240_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode240().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "241" -> {
                KatalogCode241_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode241().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "242" -> {
                KatalogCode242_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode242().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "243" -> {
                KatalogCode243_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode243().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "246" -> {
                KatalogCode246_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode246().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "247" -> {
                KatalogCode247_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode247().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "249" -> {
                KatalogCode249_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode249().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "250" -> {
                KatalogCode250_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode250().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "251" -> {
                KatalogCode251_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode251().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "252" -> {
                KatalogCode252_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode252().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "257" -> {
                KatalogCode257_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode257().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "259" -> {
                KatalogCode259_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode259().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "269" -> {
                KatalogCode269_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode269().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "272" -> {
                KatalogCode272_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode272().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "274" -> {
                KatalogCode274_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode274().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "279" -> {
                KatalogCode279_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode279().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "280" -> {
                KatalogCode280_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode280().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "284" -> {
                KatalogCode284_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode284().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "285" -> {
                KatalogCode285_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode285().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "286" -> {
                KatalogCode286_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode286().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "289" -> {
                KatalogCode289_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode289().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "290" -> {
                KatalogCode290_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode290().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "295" -> {
                KatalogCode295_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode295().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "304" -> {
                KatalogCode304_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode304().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "312" -> {
                KatalogCode312_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode312().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "319" -> {
                KatalogCode319_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode319().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "322" -> {
                KatalogCode322_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode322().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "328" -> {
                KatalogCode328_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode328().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "365" -> {
                KatalogCode365_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode365().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "372" -> {
                KatalogCode372_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode372().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "383" -> {
                KatalogCode383_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode383().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "384" -> {
                KatalogCode384_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode384().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "387" -> {
                KatalogCode387_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode387().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "388" -> {
                KatalogCode388_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode388().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "397" -> {
                KatalogCode397_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode397().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "398" -> {
                KatalogCode398_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode398().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "405" -> {
                KatalogCode405_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode405().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            "412" -> {
                KatalogCode412_NichtAbgeschlossen().also {
                    it.katalog = KatalogCode412().also {
                        it.code = code
                        it.name = name
                        it.listURI = catalog.getListUri()
                        it.listVersionID = catalog.getListVersionUri()
                    }
                    it.nichtGelisteterWert = unlistedValue
                }
            }
            else -> null
        }
        return try {
            catalogCode as? C
        } catch (e: ClassCastException) {
            null
        }
    }

}