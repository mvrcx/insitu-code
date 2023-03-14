package p20.insitu.model.util

import p20.insitu.model.components.Catalog

enum class CatalogInfo(
    val key: String,
    val shortName:String,
    val longName: String
) {
    CATALOG_001_ROLLENWERTE("001", "Rollenwerte", "Rollenwerte"),
    CATALOG_101_ART_DES_ALLGEMEINEN_EREIGNISSES(
        "101",
        "Art des allgemeinen Ereignisses",
        "Art des allgemeinen Ereignisses"
    ),
    CATALOG_102_ART_DER_AUFZEICHNUNG("102", "Art der Aufzeichnung", "Art der Aufzeichnung"),
    CATALOG_103_ART_DER_AUSGEUEBTEN_TAETIGKEIT("103", "Art der ausgeübten Tätigkeit", "Art der ausgeübten Tätigkeit"),
    CATALOG_104_ART_DES_GELDES("104", "Art des Geldes", "Art des Geldes"),
    CATALOG_105_ART_DES_BETAEUBUNGSMITTELS("105", "Art des Betäubungsmittels", "Art des Betäubungsmittels"),
    CATALOG_106_ART_DER_FINANZTRANSAKTION("106", "Art der Finanztransaktion", "Art der Finanztransaktion"),
    CATALOG_108_ART_DER_HOHEITLICHEN_MASSNAHME("108", "Art der hoheitlichen Maßnahme", "Art der hoheitlichen Maßnahme"),
    CATALOG_109_ART_DES_KRAFTFAHRZEUGKENNZEICHENS(
        "109",
        "Art des Kraftfahrzeugkennzeichens",
        "Art des Kraftfahrzeugkennzeichens"
    ),
    CATALOG_110_ART_DES_KOMMUNIKATIONSANSCHLUSSES(
        "110",
        "Art des Kommunikationsanschlusses",
        "Art des Kommunikationsanschlusses"
    ),
    CATALOG_111_ART_DES_KOMMUNIKATIONSEREIGNISSES(
        "111",
        "Art des Kommunikationsereignisses",
        "Art des Kommunikationsereignisses"
    ),
    CATALOG_112_ART_DES_KONTOS("112", "Art des Kontos", "Art des Kontos"),
    CATALOG_113_ART_DES_KRAFTFAHRZEUGS("113", "Art des Kraftfahrzeugs", "Art des Kraftfahrzeugs"),
    CATALOG_114_ART_DES_LUFTFAHRZEUGS("114", "Art des Luftfahrzeugs", "Art des Luftfahrzeugs"),
    CATALOG_115_ART_DER_OERTLICHKEIT("115", "Art der Örtlichkeit", "Art der Örtlichkeit"),
    CATALOG_116_ART_DER_ORGANISATION("116", "Art der Organisation", "Art der Organisation"),
    CATALOG_117_ART_DER_PERSONALIE("117", "Art der Personalie", "Art der Personalie"),
    CATALOG_118_ART_DES_SCHIENENFAHRZEUGS("118", "Art des Schienenfahrzeugs", "Art des Schienenfahrzeugs"),
    CATALOG_119_ART_DER_SONSTIGEN_SACHE("119", "Art der sonstigen Sache", "Art der sonstigen Sache"),
    CATALOG_120_ART_DER_MATERIELLEN_SPUR("120", "Art der materiellen Spur", "Art der materiellen Spur"),
    CATALOG_121_ART_DES_DELIKTS("121", "Art des Delikts", "Art des Delikts"),
    CATALOG_122_ART_DER_URKUNDE("122", "Art der Urkunde", "Art der Urkunde"),
    CATALOG_123_ART_DES_VORGANGS("123", "Art des Vorgangs", "Art des Vorgangs"),
    CATALOG_124_ART_DES_WASSERFAHRZEUGS("124", "Art des Wasserfahrzeugs", "Art des Wasserfahrzeugs"),
    CATALOG_125_ART_DER_ZAHLUNGSKARTE("125", "Art der Zahlungskarte", "Art der Zahlungskarte"),
    CATALOG_201_AUSPRAEGUNG_EINES_ALLELS("201", "Ausprägung eines Allels", "Ausprägung eines Allels"),
    CATALOG_202_TURNUS("202", "Turnus", "Turnus"),
    CATALOG_203_SPRACHE("203", "Sprache", "Sprache"),
    CATALOG_204_BRANCHE("204", "Branche", "Branche"),
    CATALOG_205_SICHERHEITSRELEVANTE_EINRICHTUNG(
        "205",
        "Sicherheitsrelevante Einrichtung",
        "Sicherheitsrelevante Einrichtung"
    ),
    CATALOG_206_ART_DER_FESTSTELLUNG("206", "Art der Feststellung", "Art der Feststellung"),
    CATALOG_207_MASSEINHEIT_DES_AUSMASSES("207", "Maßeinheit des Ausmaßes", "Maßeinheit des Ausmaßes"),
    CATALOG_208_STAAT("208", "Staat", "Staat"),
    CATALOG_209_EMITTENT_DES_GELDES("209", "Emittent des Geldes", "Emittent des Geldes"),
    CATALOG_211_BESCHAFFENHEIT_DES_BETAEUBUNGSMITTELS(
        "211",
        "Beschaffenheit des Betäubungsmittels",
        "Beschaffenheit des Betäubungsmittels"
    ),
    CATALOG_212_ART_DER_BETEILIGTEN_STELLE("212", "Art der beteiligten Stelle", "Art der beteiligten Stelle"),
    CATALOG_213_ART_DER_BETEILIGUNG_EINER_STELLE(
        "213",
        "Art der Beteiligung einer Stelle",
        "Art der Beteiligung einer Stelle"
    ),
    CATALOG_214_JA_NEIN_UNBEKANNT("214", "Ja/Nein/Unbekannt", "Ja/Nein/Unbekannt"),
    CATALOG_215_DATENSCHUTZRECHTLICHER_STATUS_GEM_BKAG(
        "215",
        "Datenschutzrechtlicher Status gem. BKAG",
        "Datenschutzrechtlicher Status gem. BKAG"
    ),
    CATALOG_216_ART_DES_SCHUSSWAFFENGEBRAUCHS("216", "Art des Schusswaffengebrauchs", "Art des Schusswaffengebrauchs"),
    CATALOG_217_JA_NEIN("217", "Ja/Nein", "Ja/Nein"),
    CATALOG_218_BLUTGRUPPE("218", "Blutgruppe", "Blutgruppe"),
    CATALOG_219_RHESUSFAKTOR("219", "Rhesusfaktor", "Rhesusfaktor"),
    CATALOG_221_BEARBEITUNGSSTAND("221", "Bearbeitungsstand", "Bearbeitungsstand"),
    CATALOG_222_ART_DER_FAELSCHUNG_ALLGEMEIN("222", "Art der Fälschung (Allgemein)", "Art der Fälschung (Allgemein)"),
    CATALOG_223_SACHGEBUNDENER_HINWEIS_BEI_FAHRZEUGEN(
        "223",
        "Sachgebundener Hinweis bei Fahrzeugen",
        "Sachgebundener Hinweis bei Fahrzeugen"
    ),
    CATALOG_224_ART_DER_VERWENDUNG_EINES_FAHRZEUGS(
        "224",
        "Art der Verwendung eines Fahrzeugs",
        "Art der Verwendung eines Fahrzeugs"
    ),
    CATALOG_225_ART_DER_NUMMER_BEI_FAHRZEUGEN("225", "Art der Nummer bei Fahrzeugen", "Art der Nummer bei Fahrzeugen"),
    CATALOG_226_ART_DER_FAELSCHUNG_BEI_FALSCHGELD(
        "226",
        "Art der Fälschung bei Falschgeld",
        "Art der Fälschung bei Falschgeld"
    ),
    CATALOG_227_ART_DER_FALSCHGELDFESTSTELLUNG(
        "227",
        "Art der Falschgeldfeststellung",
        "Art der Falschgeldfeststellung"
    ),
    CATALOG_228_FARBE("228", "Farbe", "Farbe"),
    CATALOG_229_FARBEFFEKT("229", "Farbeffekt", "Farbeffekt"),
    CATALOG_230_WAEHRUNG("230", "Währung", "Währung"),
    CATALOG_231_GEODAETISCHES_REFERENZSYSTEM("231", "geodätisches Referenzsystem", "geodätisches Referenzsystem"),
    CATALOG_232_MASSEINHEIT_DES_GEWICHTES("232", "Maßeinheit des Gewichtes", "Maßeinheit des Gewichtes"),
    CATALOG_234_ART_DES_HINWEISEINGANGS("234", "Art des Hinweiseingangs", "Art des Hinweiseingangs"),
    CATALOG_235_PRIORITAET("235", "Priorität", "Priorität"),
    CATALOG_237_RECHTSGRUNDLAGE_GEM_STPO("237", "Rechtsgrundlage gem. StPO", "Rechtsgrundlage gem. StPO"),
    CATALOG_238_KONTOTYP("238", "Kontotyp", "Kontotyp"),
    CATALOG_239_AUFBAU_DES_KRAFTFAHRZEUGS("239", "Aufbau des Kraftfahrzeugs", "Aufbau des Kraftfahrzeugs"),
    CATALOG_240_KRAFTFAHRZEUGMARKE("240", "Kraftfahrzeugmarke", "Kraftfahrzeugmarke"),
    CATALOG_241_ART_DER_AUFBRINGUNG_EINES_LOGOS_BEI_BETAEUBUNGSMITTELN(
        "241",
        "Art der Aufbringung eines Logos bei Betäubungsmitteln",
        "Art der Aufbringung eines Logos bei Betäubungsmitteln"
    ),
    CATALOG_242_ART_DES_MATERIALS("242", "Art des Materials", "Art des Materials"),
    CATALOG_243_ART_DES_MERKMALS("243", "Art des Merkmals", "Art des Merkmals"),
    CATALOG_244_KOERPERTEIL("244", "Körperteil", "Körperteil"),
    CATALOG_245_MODUS_OPERANDI("245", "Modus Operandi", "Modus Operandi"),
    CATALOG_246_AUFLOESUNGSGRUND_EINER_ORGANISATION(
        "246",
        "Auflösungsgrund einer Organisation",
        "Auflösungsgrund einer Organisation"
    ),
    CATALOG_247_BETAETIGUNGSFELD_EINER_ORGANISATION(
        "247",
        "Betätigungsfeld einer Organisation",
        "Betätigungsfeld einer Organisation"
    ),
    CATALOG_249_IDEOLOGIE("249", "Ideologie", "Ideologie"),
    CATALOG_250_DEUTSCHE_RECHTSFORM("250", "deutsche Rechtsform", "deutsche Rechtsform"),
    CATALOG_251_VOLKSZUGEHOERIGKEIT("251", "Volkszugehörigkeit", "Volkszugehörigkeit"),
    CATALOG_252_TITEL("252", "Titel", "Titel"),
    CATALOG_254_FAMILIENSTAND("254", "Familienstand", "Familienstand"),
    CATALOG_255_GESCHLECHT("255", "Geschlecht", "Geschlecht"),
    CATALOG_256_PERSONENGEBUNDENER_HINWEIS("256", "Personengebundener Hinweis", "Personengebundener Hinweis"),
    CATALOG_257_RELIGION("257", "Religion", "Religion"),
    CATALOG_258_SCHULABSCHLUSS("258", "Schulabschluss", "Schulabschluss"),
    CATALOG_259_ART_DES_BARTES("259", "Art des Bartes", "Art des Bartes"),
    CATALOG_260_ERSCHEINUNGSBILD_EINER_PERSON_GEOGRAFIEBEZOGEN(
        "260",
        "Erscheinungsbild einer Person - geografiebezogen",
        "Erscheinungsbild einer Person - geografiebezogen"
    ),
    CATALOG_261_GESICHTSFORM("261", "Gesichtsform", "Gesichtsform"),
    CATALOG_262_GESTALT_EINER_PERSON("262", "Gestalt einer Person", "Gestalt einer Person"),
    CATALOG_264_STIMM_SPRACHMERKMAL("264", "Stimm-/Sprachmerkmal", "Stimm-/Sprachmerkmal"),
    CATALOG_265_PMK_POLITISCHER_KALENDER("265", "PMK-politischer Kalender", "PMK-politischer Kalender"),
    CATALOG_266_PMK_DELIKTSQUALITAET("266", "PMK-Deliktsqualität", "PMK-Deliktsqualität"),
    CATALOG_267_PMK_PHAENOMENBEREICH("267", "PMK-Phänomenbereich", "PMK-Phänomenbereich"),
    CATALOG_268_PMK_THEMA("268", "PMK-Thema", "PMK-Thema"),
    CATALOG_269_MASSEINHEIT_DER_SCHUHGROESSE("269", "Maßeinheit der Schuhgröße", "Maßeinheit der Schuhgröße"),
    CATALOG_271_SPRACHNIVEAU("271", "Sprachniveau", "Sprachniveau"),
    CATALOG_272_EUROPAEISCHE_STRAFTATENKATEGORIE(
        "272",
        "europäische Straftatenkategorie",
        "europäische Straftatenkategorie"
    ),
    CATALOG_273_RELEVANZ_DER_STRAFTAT("273", "Relevanz der Straftat", "Relevanz der Straftat"),
    CATALOG_274_MOTIV_EINER_TAETOWIERUNG("274", "Motiv einer Tätowierung", "Motiv einer Tätowierung"),
    CATALOG_277_GRAD_DER_VERLETZUNG("277", "Grad der Verletzung", "Grad der Verletzung"),
    CATALOG_278_MASSEINHEIT_DES_VOLUMENS("278", "Maßeinheit des Volumens", "Maßeinheit des Volumens"),
    CATALOG_279_DATENSCHUTZKLAUSEL("279", "Datenschutzklausel", "Datenschutzklausel"),
    CATALOG_280_GRUND_DER_PRIORITAET("280", "Grund der Priorität", "Grund der Priorität"),
    CATALOG_282_DACHMARKENGESELLSCHAFT_FUER_KREDIT_UND_DEBITKARTEN(
        "282",
        "Dachmarkengesellschaft für Kredit- und Debitkarten",
        "Dachmarkengesellschaft für Kredit- und Debitkarten"
    ),
    CATALOG_283_ART_DER_FAELSCHUNG_BEI_ZAHLUNGSKARTEN(
        "283",
        "Art der Fälschung bei Zahlungskarten",
        "Art der Fälschung bei Zahlungskarten"
    ),
    CATALOG_284_ART_DES_WASSERFAHRZEUGKENNZEICHENS(
        "284",
        "Art des Wasserfahrzeugkennzeichens",
        "Art des Wasserfahrzeugkennzeichens"
    ),
    CATALOG_285_LAND_GEBIET("285", "Land/Gebiet", "Land/Gebiet"),
    CATALOG_286_IMO_MITGLIEDSSTAAT("286", "IMO-Mitgliedsstaat", "IMO-Mitgliedsstaat"),
    CATALOG_287_TEILNEHMERSCHLUESSEL("287", "Teilnehmerschlüssel", "Teilnehmerschlüssel"),
    CATALOG_288_EUROPOL_HANDLINGCODE("288", "Europol Handlingcode", "Europol Handlingcode"),
    CATALOG_290_SCHUSSWAFFENHERSTELLER("290", "Schusswaffenhersteller", "Schusswaffenhersteller"),
    CATALOG_291_ART_DER_SCHUSSWAFFE("291", "Art der Schusswaffe", "Art der Schusswaffe"),
    CATALOG_292_ART_DER_MUNITION("292", "Art der Munition", "Art der Munition"),
    CATALOG_293_ART_DES_TRAGBAREN_GEGENSTANDS("293", "Art des tragbaren Gegenstands", "Art des tragbaren Gegenstands"),
    CATALOG_294_ART_DES_WAFFENZUBEHOERS_TEILS(
        "294",
        "Art des Waffenzubehörs / -teils",
        "Art des Waffenzubehörs / -teils"
    ),
    CATALOG_295_KALIBER_XWAFFE("295", "Kaliber XWaffe", "Kaliber XWaffe"),
    CATALOG_296_STATUS_DER_SCHUSSWAFFE("296", "Status der Schusswaffe", "Status der Schusswaffe"),
    CATALOG_297_ART_DES_WAFFENSYSTEMS("297", "Art des Waffensystems", "Art des Waffensystems"),
    CATALOG_298_OK_INDIKATOR("298", "OK-Indikator", "OK-Indikator"),
    CATALOG_299_ART_DER_MASSENVERNICHTUNGSWAFFE(
        "299",
        "Art der Massenvernichtungswaffe",
        "Art der Massenvernichtungswaffe"
    ),
    CATALOG_300_ART_DER_SPRENG_BRANDVORRICHTUNG(
        "300",
        "Art der Spreng- / Brandvorrichtung",
        "Art der Spreng- / Brandvorrichtung"
    ),
    CATALOG_301_ART_DER_LABORIERUNG("301", "Art der Laborierung", "Art der Laborierung"),
    CATALOG_302_KATEGORISIERUNG_DER_SPRENG_BRANDVORRICHTUNG(
        "302",
        "Kategorisierung der Spreng- / Brandvorrichtung",
        "Kategorisierung der Spreng- / Brandvorrichtung"
    ),
    CATALOG_303_AUSWERTEMERKER("303", "Auswertemerker", "Auswertemerker"),
    CATALOG_304_TATBESTANDSMERKMAL_EINER_STRAFTAT(
        "304",
        "Tatbestandsmerkmal einer Straftat",
        "Tatbestandsmerkmal einer Straftat"
    ),
    CATALOG_305_KATEGORISIERUNG_DER_SCHUSSWAFFE(
        "305",
        "Kategorisierung der Schusswaffe",
        "Kategorisierung der Schusswaffe"
    ),
    CATALOG_306_EU_KATEGORIE("306", "EU-Kategorie", "EU-Kategorie"),
    CATALOG_307_ART_DES_EXPLOSIONSGEFAEHRLICHEN_STOFFES(
        "307",
        "Art des explosionsgefährlichen Stoffes",
        "Art des explosionsgefährlichen Stoffes"
    ),
    CATALOG_308_ART_DES_TEILNEHMERANKERS("308", "Art des Teilnehmerankers", "Art des Teilnehmerankers"),
    CATALOG_309_EUROPOL_MANDATSBEREICH("309", "Europol Mandatsbereich", "Europol Mandatsbereich"),
    CATALOG_310_SEPA_PURPOSE_CODE("310", "SEPA Purpose Code", "SEPA Purpose Code"),
    CATALOG_311_ZAHNNUMMER("311", "Zahnnummer", "Zahnnummer"),
    CATALOG_312_GERUCH("312", "Geruch", "Geruch"),
    CATALOG_313_ART_DES_BETAEUBUNGSMITTELGRUNDSTOFFS(
        "313",
        "Art des Betäubungsmittelgrundstoffs",
        "Art des Betäubungsmittelgrundstoffs"
    ),
    CATALOG_314_MOTIV_EINER_STRAFTAT("314", "Motiv einer Straftat", "Motiv einer Straftat"),
    CATALOG_315_ART_DER_INTERNETRESSOURCE("315", "Art der Internetressource", "Art der Internetressource"),
    CATALOG_316_TATPHASE("316", "Tatphase", "Tatphase"),
    CATALOG_317_AUGENFARBE("317", "Augenfarbe", "Augenfarbe"),
    CATALOG_318_OPFERTYPUS_TAETERTYPUS("318", "Opfertypus / Tätertypus", "Opfertypus / Tätertypus"),
    CATALOG_321_BUNDESLAND("321", "Bundesland", "Bundesland"),
    CATALOG_322_ART_DER_PERSONENIDENTIFIKATIONSNUMMER(
        "322",
        "Art der Personenidentifikationsnummer",
        "Art der Personenidentifikationsnummer"
    ),
    CATALOG_323_ART_DES_ARZNEIMITTELS("323", "Art des Arzneimittels", "Art des Arzneimittels"),
    CATALOG_324_DARREICHUNGSFORM_DES_ARZNEIMITTELS(
        "324",
        "Darreichungsform des Arzneimittels",
        "Darreichungsform des Arzneimittels"
    ),
    CATALOG_325_VERWENDUNGSZWECK_DES_ARZNEIMITTELS(
        "325",
        "Verwendungszweck des Arzneimittels",
        "Verwendungszweck des Arzneimittels"
    ),
    CATALOG_326_ART_DER_VERBOTENEN_SUBSTANZ("326", "Art der verbotenen Substanz", "Art der verbotenen Substanz"),
    CATALOG_327_VERWERTBARKEIT("327", "Verwertbarkeit", "Verwertbarkeit"),
    CATALOG_328_ART_DES_FAHRRADS("328", "Art des Fahrrads", "Art des Fahrrads"),
    CATALOG_329_KALIBER("329", "Kaliber", "Kaliber"),
    CATALOG_330_KATEGORISIERUNG_DES_VORGANGS("330", "Kategorisierung des Vorgangs", "Kategorisierung des Vorgangs"),
    CATALOG_331_LAGERSTATUS_DES_ASSERVATS("331", "Lagerstatus des Asservats", "Lagerstatus des Asservats"),
    CATALOG_332_ART_DES_VERKEHRSUNFALLS("332", "Art des Verkehrsunfalls", "Art des Verkehrsunfalls"),
    CATALOG_333_ORTSLAGE("333", "Ortslage", "Ortslage"),
    CATALOG_334_VERKEHRSUNFALLKATEGORIE("334", "Verkehrsunfallkategorie", "Verkehrsunfallkategorie"),
    CATALOG_335_VERKEHRSUNFALLTYP("335", "Verkehrsunfalltyp", "Verkehrsunfalltyp"),
    CATALOG_336_ALLGEMEINE_VERKEHRSUNFALLURSACHEN(
        "336",
        "Allgemeine Verkehrsunfallursachen",
        "Allgemeine Verkehrsunfallursachen"
    ),
    CATALOG_337_STATUS_DER_LICHTZEICHENANLAGE("337", "Status der Lichtzeichenanlage", "Status der Lichtzeichenanlage"),
    CATALOG_338_GESCHWINDIGKEITSBEGRENZUNG("338", "Geschwindigkeitsbegrenzung", "Geschwindigkeitsbegrenzung"),
    CATALOG_339_LICHTVERHAELTNISSE("339", "Lichtverhältnisse", "Lichtverhältnisse"),
    CATALOG_340_STRASSENZUSTAND("340", "Straßenzustand", "Straßenzustand"),
    CATALOG_341_ART_DES_AUFPRALLHINDERNISSES("341", "Art des Aufprallhindernisses", "Art des Aufprallhindernisses"),
    CATALOG_342_CHARAKTERISTIK_DER_UNFALLSTELLE(
        "342",
        "Charakteristik der Unfallstelle",
        "Charakteristik der Unfallstelle"
    ),
    CATALOG_343_BESONDERHEIT_DER_UNFALLSTELLE("343", "Besonderheit der Unfallstelle", "Besonderheit der Unfallstelle"),
    CATALOG_344_PERSONENBEZOGENE_UNFALLURSACHE(
        "344",
        "Personenbezogene Unfallursache",
        "Personenbezogene Unfallursache"
    ),
    CATALOG_347_ART_DER_VERKEHRSBETEILIGUNG_PERSONENBEZOGEN(
        "347",
        "Art der Verkehrsbeteiligung (personenbezogen)",
        "Art der Verkehrsbeteiligung (personenbezogen)"
    ),
    CATALOG_348_ART_DER_VERKEHRSBETEILIGUNG_FAHRZEUGBEZOGEN(
        "348",
        "Art der Verkehrsbeteiligung (fahrzeugbezogen)",
        "Art der Verkehrsbeteiligung (fahrzeugbezogen)"
    ),
    CATALOG_349_GEFAHRGUT_UN_NUMMER("349", "Gefahrgut UN-Nummer", "Gefahrgut UN-Nummer"),
    CATALOG_350_GEFAHRGUT_AUSNAHMEVERORDNUNG("350", "Gefahrgut-Ausnahmeverordnung", "Gefahrgut-Ausnahmeverordnung"),
    CATALOG_351_ART_DER_ORDNUNGSWIDRIGKEIT("351", "Art der Ordnungswidrigkeit", "Art der Ordnungswidrigkeit"),
    CATALOG_352_TATBESTANDSNUMMER_KBA_BUSSGELDKATALOG(
        "352",
        "Tatbestandsnummer KBA Bußgeldkatalog",
        "Tatbestandsnummer KBA Bußgeldkatalog"
    ),
    CATALOG_353_EU_FUEHRERSCHEINKLASSE("353", "EU-Führerscheinklasse", "EU-Führerscheinklasse"),
    CATALOG_354_ERMITTLUNGSUNTERSTUETZENDER_HINWEIS_EHW(
        "354",
        "Ermittlungsunterstützender Hinweis (EHW)",
        "Ermittlungsunterstützender Hinweis (EHW)"
    ),
    CATALOG_355_ERMITTLUNGSUNTERSTUETZENDER_HINWEIS_AUSPRAEGUNG(
        "355",
        "Ermittlungsunterstützender Hinweis - Ausprägung",
        "Ermittlungsunterstützender Hinweis - Ausprägung"
    ),
    CATALOG_356_RECHTSGRUNDLAGE_GEM_POLIZEIGESETZ(
        "356",
        "Rechtsgrundlage gem. Polizeigesetz",
        "Rechtsgrundlage gem. Polizeigesetz"
    ),
    CATALOG_357_FAELSCHUNGSMERKMALE_BEI_URKUNDEN(
        "357",
        "Fälschungsmerkmale bei Urkunden",
        "Fälschungsmerkmale bei Urkunden"
    ),
    CATALOG_358_GESPRAECHSKLASSIFIZIERUNG("358", "Gesprächsklassifizierung", "Gesprächsklassifizierung"),
    CATALOG_359_ERMITTLUNGSRELEVANZ("359", "Ermittlungsrelevanz", "Ermittlungsrelevanz"),
    CATALOG_360_STATUS_DER_KERNBEREICHSLOESCHUNG(
        "360",
        "Status der Kernbereichslöschung",
        "Status der Kernbereichslöschung"
    ),
    CATALOG_361_ART_DER_ITUE_MASSNAHME("361", "Art der ITÜ-Maßnahme", "Art der ITÜ-Maßnahme"),
    CATALOG_362_STATUS_DER_NACHRICHTENUEBERTRAGUNG(
        "362",
        "Status der Nachrichtenübertragung",
        "Status der Nachrichtenübertragung"
    ),
    CATALOG_363_ART_DER_FESTSTELLUNG_EINER_SPRACHANGABE(
        "363",
        "Art der Feststellung einer Sprachangabe",
        "Art der Feststellung einer Sprachangabe"
    ),
    CATALOG_364_ART_DER_UEBERSETZUNG("364", "Art der Übersetzung", "Art der Übersetzung"),
    CATALOG_365_ART_DER_NUMMER_BEI_ORGANISATIONEN(
        "365",
        "Art der Nummer bei Organisationen",
        "Art der Nummer bei Organisationen"
    ),
    CATALOG_366_ART_DES_AUFENTHALTSSTATUS("366", "Art des Aufenthaltsstatus", "Art des Aufenthaltsstatus"),
    CATALOG_367_ART_DES_FEUERMODUS_BEI_SCHUSSWAFFEN(
        "367",
        "Art des Feuermodus bei Schusswaffen",
        "Art des Feuermodus bei Schusswaffen"
    ),
    CATALOG_368_PMK_SCHLAGWORT("368", "PMK-Schlagwort", "PMK-Schlagwort"),
    CATALOG_369_ZWECK_DER_ASSERVIERUNG("369", "Zweck der Asservierung", "Zweck der Asservierung"),
    CATALOG_370_RECHTSGUT("370", "Rechtsgut", "Rechtsgut"),
    CATALOG_371_GEMEINDESCHLUESSEL("371", "Gemeindeschlüssel", "Gemeindeschlüssel"),
    CATALOG_372_UNTERSCHEIDUNGSZEICHEN_FUER_KRAFTFAHRZEUGE(
        "372",
        "Unterscheidungszeichen für Kraftfahrzeuge",
        "Unterscheidungszeichen für Kraftfahrzeuge"
    ),
    CATALOG_373_SZENETYPISCHE_AUFFAELLIGE_BEKLEIDUNG(
        "373",
        "szenetypische / auffällige Bekleidung",
        "szenetypische / auffällige Bekleidung"
    ),
    CATALOG_374_GEBISSAUFFAELLIGKEIT("374", "Gebissauffälligkeit", "Gebissauffälligkeit"),
    CATALOG_376_LAGESPEZIFIKATION("376", "Lagespezifikation", "Lagespezifikation"),
    CATALOG_377_FRISUR("377", "Frisur", "Frisur"),
    CATALOG_378_HAARFARBE("378", "Haarfarbe", "Haarfarbe"),
    CATALOG_379_HAARLAENGE("379", "Haarlänge", "Haarlänge"),
    CATALOG_380_HAARWUCHS("380", "Haarwuchs", "Haarwuchs"),
    CATALOG_381_HAARFORM("381", "Haarform", "Haarform"),
    CATALOG_382_VERMUTETES_GESCHLECHT("382", "vermutetes Geschlecht", "vermutetes Geschlecht"),
    CATALOG_383_MUNDART("383", "Mundart", "Mundart"),
    CATALOG_384_AUFFAELLIGES_VERHALTEN_GEWOHNHEIT(
        "384",
        "auffälliges Verhalten / Gewohnheit",
        "auffälliges Verhalten / Gewohnheit"
    ),
    CATALOG_385_HAUTFARBE("385", "Hautfarbe", "Hautfarbe"),
    CATALOG_386_SACHGEBUNDENER_HINWEIS_BEI_ZAHLUNGSMITTELN(
        "386",
        "sachgebundener Hinweis bei Zahlungsmitteln",
        "sachgebundener Hinweis bei Zahlungsmitteln"
    ),
    CATALOG_387_RECHTSGRUNDLAGE_GEM_SONSTIGEM_GESETZ(
        "387",
        "Rechtsgrundlage gem. sonstigem Gesetz",
        "Rechtsgrundlage gem. sonstigem Gesetz"
    ),
    CATALOG_388_ART_DES_DOKUMENTS("388", "Art des Dokuments", "Art des Dokuments"),
    CATALOG_390_ART_DES_AUFENTHALTSENDES("390", "Art des Aufenthaltsendes", "Art des Aufenthaltsendes"),
    CATALOG_393_ART_DES_HINWEISES("393", "Art des Hinweises", "Art des Hinweises"),
    CATALOG_394_RELEVANZ_EINES_VORGANGS("394", "Relevanz eines Vorgangs", "Relevanz eines Vorgangs"),
    CATALOG_395_NUMMER_ZUR_KENNZEICHNUNG_DER_GEFAHR(
        "395",
        "Nummer zur Kennzeichnung der Gefahr",
        "Nummer zur Kennzeichnung der Gefahr"
    ),
    CATALOG_397_HASHFUNKTION("397", "Hashfunktion", "Hashfunktion"),
    CATALOG_398_STAAT_GEBIET_ORGANISATION("398", "Staat / Gebiet / Organisation", "Staat / Gebiet / Organisation"),
    CATALOG_399_HIMMELSRICHTUNG("399", "Himmelsrichtung", "Himmelsrichtung"),
    CATALOG_400_STATUS_DES_GPS_PACKS("400", "Status des GPS-Packs", "Status des GPS-Packs"),
    CATALOG_401_MASSEINHEIT_DER_SPEICHERGROESSE("401", "Maßeinheit der Speichergröße", "Maßeinheit der Speichergröße"),
    CATALOG_402_ART_DER_ZULASSUNG_EINES_WASSERFAHRZEUGS(
        "402",
        "Art der Zulassung eines Wasserfahrzeugs",
        "Art der Zulassung eines Wasserfahrzeugs"
    ),
    CATALOG_403_GEFAEHRDUNGSSTUFE("403", "Gefährdungsstufe", "Gefährdungsstufe"),
    CATALOG_404_SPEZIFIKATION_EINER_HOHEITLICHEN_MASSNAHME(
        "404",
        "Spezifikation einer hoheitlichen Maßnahme",
        "Spezifikation einer hoheitlichen Maßnahme"
    ),
    CATALOG_405_SICHERUNGSART("405", "Sicherungsart", "Sicherungsart"),
    CATALOG_406_JA("406", "Ja", "Ja"),
    CATALOG_407_BESONDERER_SCHUSSWAFFENTYP("407", "besonderer Schusswaffentyp", "besonderer Schusswaffentyp"),
    CATALOG_408_HYDANE_KATEGORIE("408", "hyDaNe-Kategorie", "hyDaNe-Kategorie"),
    CATALOG_409_HYDANE_AUSNAHME("409", "hyDaNe-Ausnahme", "hyDaNe-Ausnahme"),
    CATALOG_410_HYDANE_VORLIEGENDE_GEFAHR("410", "hyDaNe–vorliegende Gefahr", "hyDaNe–vorliegende Gefahr"),
    CATALOG_412_VEREINE_MANNSCHAFTEN_FUSSBALL_EISHOCKEY(
        "412",
        "Vereine / Mannschaften (Fußball / Eishockey)",
        "Vereine / Mannschaften (Fußball / Eishockey)"
    ),
    CATALOG_413_FANKATEGORIE("413", "Fankategorie", "Fankategorie");
}

fun CatalogInfo.toCatalog():Catalog{
    return Catalog(
        key = key,
        name = shortName
    )
}

fun Catalog.toCatalogInfo():CatalogInfo? {
    return CatalogInfo.values().find { it.key == this.key }
}
