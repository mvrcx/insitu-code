package p20.insitu.resources.strings

import p20.insitu.resources.Language

object TextFieldStrings {

    private const val add_keyword_DE = "Schlagwort hinzufügen"
    private const val add_keyword_EN = "Add keyword"
    fun addKeyword(language: Language): String {
        return when (language) {
            Language.DE -> add_keyword_DE
            Language.EN -> add_keyword_EN
        }
    }

    private const val alternative_address_DE = "Alternative Adressangabe"
    private const val alternative_address_EN = "Alternative address"
    fun alternativeAddress(language: Language): String {
        return when (language) {
            Language.DE -> alternative_address_DE
            Language.EN -> alternative_address_EN
        }
    }

    private const val attempt_DE = "Versuch"
    private const val attempt_EN = "Attempt"
    fun attempt(language: Language): String {
        return when (language) {
            Language.DE -> attempt_DE
            Language.EN -> attempt_EN
        }
    }

    private const val audio_transcription_DE = "Transkription"
    private const val audio_transcription_EN = "Transcription"
    fun audioTranscription(language: Language): String {
        return when (language) {
            Language.DE -> audio_transcription_DE
            Language.EN -> audio_transcription_EN
        }
    }

    private const val birthday_DE = "Geburtstag"
    private const val birthday_EN = "Birthday"
    fun birthday(language: Language): String {
        return when (language) {
            Language.DE -> birthday_DE
            Language.EN -> birthday_EN
        }
    }

    private const val birth_name_DE = "Geburtsname"
    private const val birth_name_EN = "Birth name"
    fun birthName(language: Language): String {
        return when (language) {
            Language.DE -> birth_name_DE
            Language.EN -> birth_name_EN
        }
    }

    private const val catalog_search_DE = "Katalogsuche"
    private const val catalog_search_EN = "Catalog search"
    fun catalogSearch(language: Language): String {
        return when (language) {
            Language.DE -> catalog_search_DE
            Language.EN -> catalog_search_EN
        }
    }

    private const val category_DE = "Kategorie"
    private const val category_EN = "Category"
    fun category(language: Language): String {
        return when (language) {
            Language.DE -> category_DE
            Language.EN -> category_EN
        }
    }

    private const val city_DE = "Stadt"
    private const val city_EN = "City"
    fun city(language: Language): String {
        return when (language) {
            Language.DE -> city_DE
            Language.EN -> city_EN
        }
    }

    private const val color_DE = "Farbe"
    private const val color_EN = "Color"
    fun color(language: Language): String {
        return when (language) {
            Language.DE -> color_DE
            Language.EN -> color_EN
        }
    }

    private const val comments_DE = "Bemerkungen"
    private const val comments_EN = "Comments"
    fun comment(language: Language): String {
        return when (language) {
            Language.DE -> comments_DE
            Language.EN -> comments_EN
        }
    }

    private const val coordinates_DE = "Koordinaten"
    private const val coordinates_EN = "Coordinates"
    fun coordinates(language: Language): String {
        return when (language) {
            Language.DE -> coordinates_DE
            Language.EN -> coordinates_EN
        }
    }

    private const val country_DE = "Land"
    private const val country_EN = "Country"
    fun country(language: Language): String {
        return when (language) {
            Language.DE -> country_DE
            Language.EN -> country_EN
        }
    }

    private const val county_DE = "Kreis"
    private const val county_EN = "County"
    fun county(language: Language): String {
        return when (language) {
            Language.DE -> county_DE
            Language.EN -> county_EN
        }
    }

    private const val crime_characteristics_DE = "Tatbestandsmerkmale"
    private const val crime_characteristics_EN = "Crime characteristics"
    fun crimeCharacteristics(language: Language): String {
        return when (language) {
            Language.DE -> crime_characteristics_DE
            Language.EN -> crime_characteristics_EN
        }
    }

    private const val criminal_offense_type_DE = "Art des Delikts"
    private const val criminal_offense_type_EN = "Type of crime"
    fun criminalOffenseType(language: Language): String {
        return when (language) {
            Language.DE -> criminal_offense_type_DE
            Language.EN -> criminal_offense_type_EN
        }
    }

    private const val damage_permission_DE = "Beschaedigungserlaubnis"
    private const val damage_permission_EN = "Damage permission"
    fun damagePermission(language: Language): String {
        return when (language) {
            Language.DE -> damage_permission_DE
            Language.EN -> damage_permission_EN
        }
    }

    private const val dangerous_goods_number_DE = "Gefahrennummer"
    private const val dangerous_goods_number_EN = "Dangerous goods number"
    fun dangerousGoodsNumber(language: Language): String {
        return when (language) {
            Language.DE -> dangerous_goods_number_DE
            Language.EN -> dangerous_goods_number_EN
        }
    }

    private const val date_DE = "Datum"
    private const val date_EN = "Date"
    fun date(language: Language): String {
        return when (language) {
            Language.DE -> date_DE
            Language.EN -> date_EN
        }
    }

    private const val datetime_DE = "Zeitpunkt"
    private const val datetime_EN = "Date time"
    fun dateTime(language: Language): String {
        return when (language) {
            Language.DE -> datetime_DE
            Language.EN -> datetime_EN
        }
    }

    private const val description_DE = "Beschreibung"
    private const val description_EN = "Description"
    fun description(language: Language): String {
        return when (language) {
            Language.DE -> description_DE
            Language.EN -> description_EN
        }
    }

    private const val designation_DE = "Bezeichnung"
    private const val designation_EN = "Designation"
    fun designation(language: Language): String {
        return when (language) {
            Language.DE -> designation_DE
            Language.EN -> designation_EN
        }
    }

    private const val district_DE = "Bezirk"
    private const val district_EN = "District"
    fun district(language: Language): String {
        return when (language) {
            Language.DE -> district_DE
            Language.EN -> district_EN
        }
    }

    private const val documented_by_DE = "Dokumentiert durch"
    private const val documented_by_EN = "Documented by"
    fun documentedBy(language: Language): String {
        return when (language) {
            Language.DE -> documented_by_DE
            Language.EN -> documented_by_EN
        }
    }

    private const val eMail_DE = "E-Mail"
    private const val eMail_EN = "E-Mail"
    fun eMail(language: Language): String {
        return when (language) {
            Language.DE -> eMail_DE
            Language.EN -> eMail_EN
        }
    }

    private const val end_date_DE = "Enddatum"
    private const val end_date_EN = "End date"
    fun endDate(language: Language): String {
        return when (language) {
            Language.DE -> end_date_DE
            Language.EN -> end_date_EN
        }
    }

    private const val end_datetime_DE = "Ende"
    private const val end_datetime_EN = "End"
    fun endDateTime(language: Language): String {
        return when (language) {
            Language.DE -> end_datetime_DE
            Language.EN -> end_datetime_EN
        }
    }

    private const val european_crime_categories_DE = "Europäische Straftatenkategorie "
    private const val european_crime_categories_EN = "European crime categories"
    fun europeanCrimeCategories(language: Language): String {
        return when (language) {
            Language.DE -> european_crime_categories_DE
            Language.EN -> european_crime_categories_EN
        }
    }

    private const val evidence_doc_number_DE = "Asservatennummer"
    private const val evidence_doc_number_EN = "Evidence number"
    fun evidenceDocNumber(language: Language): String {
        return when (language) {
            Language.DE -> evidence_doc_number_DE
            Language.EN -> evidence_doc_number_EN
        }
    }

    private const val external_system_id_DE = "Externe System-ID"
    private const val external_system_id_EN = "Evidence number"
    fun externalSystemId(systemName: String?, language: Language): String {
        return when (language) {
            Language.DE -> external_system_id_DE + if(systemName != null){ " - $systemName" } else ""
            Language.EN -> external_system_id_EN + if(systemName != null){ " - $systemName" } else ""
        }
    }

    private const val fax_number_DE = "Faxnummer"
    private const val fax_number_EN = "Fax number"
    fun faxNumber(language: Language): String {
        return when (language) {
            Language.DE -> fax_number_DE
            Language.EN -> fax_number_EN
        }
    }

    private const val federal_state_DE = "Bundesland"
    private const val federal_state_EN = "Federal state"
    fun federalState(language: Language): String {
        return when (language) {
            Language.DE -> federal_state_DE
            Language.EN -> federal_state_EN
        }
    }

    private const val first_name_DE = "Vorname"
    private const val first_name_EN = "First name"
    fun firstName(language: Language): String {
        return when (language) {
            Language.DE -> first_name_DE
            Language.EN -> first_name_EN
        }
    }

    private const val forensic_analysis_DE = "KT-Untersuchung"
    private const val forensic_analysis_EN = "Forensic analysis"
    fun forensicAnalysis(language: Language): String {
        return when (language) {
            Language.DE -> forensic_analysis_DE
            Language.EN -> forensic_analysis_EN
        }
    }

    private const val hazard_warning_DE = "Gefahrenhinweis"
    private const val hazard_warning_EN = "Hazard warning"
    fun hazardWarning(language: Language): String {
        return when (language) {
            Language.DE -> hazard_warning_DE
            Language.EN -> hazard_warning_EN
        }
    }

    private const val height_in_meter_DE = "Höhe [m]"
    private const val height_in_meter_EN = "Height [m]"
    fun heightInMeter(language: Language): String {
        return when (language) {
            Language.DE -> height_in_meter_DE
            Language.EN -> height_in_meter_EN
        }
    }

    private const val house_number_DE = "Hausnummer"
    private const val house_number_EN = "House number"
    fun houseNumber(language: Language): String {
        return when (language) {
            Language.DE -> house_number_DE
            Language.EN -> house_number_EN
        }
    }

    private const val investigation_number_DE = "Vorgangsnummer"
    private const val investigation_number_EN = "Investigation number"
    fun investigationNumber(language: Language): String {
        return when (language) {
            Language.DE -> investigation_number_DE
            Language.EN -> investigation_number_EN
        }
    }

    private const val type_of_process_DE = "Art des Vorgangs"
    private const val type_of_process_EN = "Investigation type"
    fun typeOfProcess(language: Language): String {
        return when (language) {
            Language.DE -> type_of_process_DE
            Language.EN -> type_of_process_EN
        }
    }

    private const val keywords_DE = "Schlagworte"
    private const val keywords_EN = "Keywords"
    fun keywords(language: Language): String {
        return when (language) {
            Language.DE -> keywords_DE
            Language.EN -> keywords_EN
        }
    }

    private const val last_name_DE = "Nachname"
    private const val last_name_EN = "Last name"
    fun lastName(language: Language): String {
        return when (language) {
            Language.DE -> last_name_DE
            Language.EN -> last_name_EN
        }
    }

    private const val leading_doc_number_DE = "Leitzahl"
    private const val leading_doc_number_EN = "Number"
    fun leadingDocNumber(language: Language): String {
        return when (language) {
            Language.DE -> leading_doc_number_DE
            Language.EN -> leading_doc_number_EN
        }
    }

    private const val legal_assets_DE = "Rechtsgüter"
    private const val legal_assets_EN = "Legal assets"
    fun legalAssets(language: Language): String {
        return when (language) {
            Language.DE -> legal_assets_DE
            Language.EN -> legal_assets_EN
        }
    }

    private const val length_in_meter_DE = "Länge [m]"
    private const val length_in_meter_EN = "Length [m]"
    fun lengthInMeter(language: Language): String {
        return when (language) {
            Language.DE -> length_in_meter_DE
            Language.EN -> length_in_meter_EN
        }
    }

    private const val location_type_DE = "Art der Örtlichkeit"
    private const val location_type_EN = "Type of location"
    fun locationType(language: Language): String {
        return when (language) {
            Language.DE -> location_type_DE
            Language.EN -> location_type_EN
        }
    }

    private const val material_DE = "Material"
    private const val material_EN = "Material"
    fun material(language: Language): String {
        return when (language) {
            Language.DE -> material_DE
            Language.EN -> material_EN
        }
    }

    private const val modus_operandi_type_DE = "Modus Operandi - Art"
    private const val modus_operandi_type_EN = "Modus Operandi - Type"
    fun modusOperandiType(language: Language): String {
        return when (language) {
            Language.DE -> modus_operandi_type_DE
            Language.EN -> modus_operandi_type_EN
        }
    }

    private const val municipalityCode_DE = "Gemeindeschlüssel"
    private const val municipalityCode_EN = "Municipality code"
    fun municipalityCode(language: Language): String {
        return when (language) {
            Language.DE -> municipalityCode_DE
            Language.EN -> municipalityCode_EN
        }
    }

    private const val note_text_DE = "Notiz"
    private const val note_text_EN = "Note"
    fun noteText(language: Language): String {
        return when (language) {
            Language.DE -> note_text_DE
            Language.EN -> note_text_EN
        }
    }

    private const val number_of_pieces_DE = "Anzahl"
    private const val number_of_pieces_EN = "Number of pieces"
    fun numberOfPieces(language: Language): String {
        return when (language) {
            Language.DE -> number_of_pieces_DE
            Language.EN -> number_of_pieces_EN
        }
    }

    private const val offender_type_DE = "Tätertypus"
    private const val offender_type_EN = "Offender type"
    fun offenderType(language: Language): String {
        return when (language) {
            Language.DE -> offender_type_DE
            Language.EN -> offender_type_EN
        }
    }

    private const val password_DE = "Passwort"
    private const val password_EN = "Password"
    fun password(language: Language): String {
        return when (language) {
            Language.DE -> password_DE
            Language.EN -> password_EN
        }
    }

    private const val phone_number_DE = "Telefonnummer"
    private const val phone_number_EN = "Phone number"
    fun phoneNumber(language: Language): String {
        return when (language) {
            Language.DE -> phone_number_DE
            Language.EN -> phone_number_EN
        }
    }

    private const val priority_DE = "Priorität"
    private const val priority_EN = "Priority"
    fun priority(language: Language): String {
        return when (language) {
            Language.DE -> priority_DE
            Language.EN -> priority_EN
        }
    }

    private const val position_description_DE = "Positionsbeschreibung"
    private const val position_description_EN = "Position description"
    fun positionDescription(language: Language): String {
        return when (language) {
            Language.DE -> position_description_DE
            Language.EN -> position_description_EN
        }
    }

    private const val postal_code_DE = "Postleitzahl"
    private const val postal_code_EN = "Postal code"
    fun postalCode(language: Language): String {
        return when (language) {
            Language.DE -> postal_code_DE
            Language.EN -> postal_code_EN
        }
    }

    private const val processing_status_DE = "Bearbeitungsstand"
    private const val processing_status_EN = "Processing status"
    fun processingStatus(language: Language): String {
        return when (language) {
            Language.DE -> processing_status_DE
            Language.EN -> processing_status_EN
        }
    }

    private const val quality_of_trace_DE = "Verwertbarkeit"
    private const val quality_of_trace_EN = "Quality"
    fun qualityOfTrace(language: Language): String {
        return when (language) {
            Language.DE -> quality_of_trace_DE
            Language.EN -> quality_of_trace_EN
        }
    }

    private const val purpose_of_securing_DE = "Zweck der Asservierung"
    private const val purpose_of_securing_EN = "Purpose of securing"
    fun purposeOfSecuring(language: Language): String {
        return when (language) {
            Language.DE -> purpose_of_securing_DE
            Language.EN -> purpose_of_securing_EN
        }
    }

    private const val region_DE = "Region"
    private const val region_EN = "Region"
    fun region(language: Language): String {
        return when (language) {
            Language.DE -> region_DE
            Language.EN -> region_EN
        }
    }

    private const val region_code_DE = "Regionalschlüssel"
    private const val region_code_EN = "Regional code"
    fun regionCode(language: Language): String {
        return when (language) {
            Language.DE -> region_code_DE
            Language.EN -> region_code_EN
        }
    }

    private const val room_type_DE = "Raumtyp"
    private const val room_type_EN = "Room type"
    fun roomType(language: Language): String {
        return when (language) {
            Language.DE -> room_type_DE
            Language.EN -> room_type_EN
        }
    }

    private const val securing_by_DE = "Gesichert durch"
    private const val securing_by_EN = "Securing by"
    fun securedBy(language: Language): String {
        return when (language) {
            Language.DE -> securing_by_DE
            Language.EN -> securing_by_EN
        }
    }

    private const val securing_method_DE = "Sicherungsmethode"
    private const val securing_method_EN = "Securing method"
    fun securingMethod(language: Language): String {
        return when (language) {
            Language.DE -> securing_method_DE
            Language.EN -> securing_method_EN
        }
    }

    private const val securing_timestamp_DE = "Sicherungszeitpunkt"
    private const val securing_timestamp_EN = "Securing timestamp"
    fun securingTimestamp(language: Language): String {
        return when (language) {
            Language.DE -> securing_timestamp_DE
            Language.EN -> securing_timestamp_EN
        }
    }

    private const val sex_DE = "Geschlecht"
    private const val sex_EN = "Sex"
    fun sex(language: Language): String {
        return when (language) {
            Language.DE -> sex_DE
            Language.EN -> sex_EN
        }
    }

    private const val short_description_DE = "Kurzbeschreibung"
    private const val short_description_EN = "Short description"
    fun shortDescription(language: Language): String {
        return when (language) {
            Language.DE -> short_description_DE
            Language.EN -> short_description_EN
        }
    }

    private const val size_DE = "Größe"
    private const val size_EN = "Size"
    fun size(language: Language): String {
        return when (language) {
            Language.DE -> size_DE
            Language.EN -> size_EN
        }
    }

    private const val size_length_DE = "Länge"
    private const val size_length_EN = "Length"
    fun sizeLength(language: Language): String {
        return when (language) {
            Language.DE -> size_length_DE
            Language.EN -> size_length_EN
        }
    }

    private const val size_width_DE = "Breite"
    private const val size_width_EN = "Width"
    fun sizeWidth(language: Language): String {
        return when (language) {
            Language.DE -> size_width_DE
            Language.EN -> size_width_EN
        }
    }

    private const val size_height_DE = "Höhe"
    private const val size_height_EN = "Height"
    fun sizeHeight(language: Language): String {
        return when (language) {
            Language.DE -> size_height_DE
            Language.EN -> size_height_EN
        }
    }

    private const val size_diameter_DE = "Durchmesser"
    private const val size_diameter_EN = "Diameter"
    fun sizeDiameter(language: Language): String {
        return when (language) {
            Language.DE -> size_diameter_DE
            Language.EN -> size_diameter_EN
        }
    }

    private const val special_features_DE = "Besondere Merkmale"
    private const val special_features_EN = "Special features"
    fun specialFeatures(language: Language): String {
        return when (language) {
            Language.DE -> special_features_DE
            Language.EN -> special_features_EN
        }
    }

    private const val suspected_trace_carrier_DE = "Potentieller Spurenträger"
    private const val suspected_trace_carrier_EN = "Potential trace carrier"
    fun suspectedTraceCarrier(language: Language): String {
        return when (language) {
            Language.DE -> suspected_trace_carrier_DE
            Language.EN -> suspected_trace_carrier_EN
        }
    }

    private const val start_date_DE = "Angelegt am"
    private const val start_date_EN = "Created"
    fun startDate(language: Language): String {
        return when (language) {
            Language.DE -> start_date_DE
            Language.EN -> start_date_EN
        }
    }

    private const val start_datetime_DE = "Beginn"
    private const val start_datetime_EN = "Start"
    fun startDateTime(language: Language): String {
        return when (language) {
            Language.DE -> start_datetime_DE
            Language.EN -> start_datetime_EN
        }
    }

    private const val storage_status_DE = "Lagerstatus"
    private const val storage_status_EN = "Storage status"
    fun storageStatus(language: Language): String {
        return when (language) {
            Language.DE -> storage_status_DE
            Language.EN -> storage_status_EN
        }
    }

    private const val street_DE = "Straße"
    private const val street_EN = "Street"
    fun street(language: Language): String {
        return when (language) {
            Language.DE -> street_DE
            Language.EN -> street_EN
        }
    }

    private const val street_code_DE = "Straßenschlüssel"
    private const val street_code_EN = "Street code"
    fun streetCode(language: Language): String {
        return when (language) {
            Language.DE -> street_code_DE
            Language.EN -> street_code_EN
        }
    }

    private const val time_DE = "Zeit"
    private const val time_EN = "Time"
    fun time(language: Language): String {
        return when (language) {
            Language.DE -> time_DE
            Language.EN -> time_EN
        }
    }

    private const val time_of_day_DE = "Uhr"
    private const val time_of_day_EN = "o´clock"
    fun timeOfDay(language: Language): String {
        return when (language) {
            Language.DE -> time_of_day_DE
            Language.EN -> time_of_day_EN
        }
    }

    private const val time_of_arrival_DE = "Eintreffzeit"
    private const val time_of_arrival_EN = "Time of arrival"
    fun timeOfArrival(language: Language): String {
        return when (language) {
            Language.DE -> time_of_arrival_DE
            Language.EN -> time_of_arrival_EN
        }
    }

    private const val time_of_reporting_DE = "Feststellungszeitpunkt"
    private const val time_of_reporting_EN = "Time of reporting"
    fun timeOfReporting(language: Language): String {
        return when (language) {
            Language.DE -> time_of_reporting_DE
            Language.EN -> time_of_reporting_EN
        }
    }

    private const val transport_and_storage_advice_DE = "Transport- und Lagerhinweis"
    private const val transport_and_storage_advice_EN = "Transport and storage advice"
    fun transportAndStorageAdvice(language: Language): String {
        return when (language) {
            Language.DE -> transport_and_storage_advice_DE
            Language.EN -> transport_and_storage_advice_EN
        }
    }

    private const val type_DE = "Art"
    private const val type_EN = "Type"
    fun type(language: Language): String {
        return when (language) {
            Language.DE -> type_DE
            Language.EN -> type_EN
        }
    }

    private const val type_of_measurement_determination_DE = "Feststellungsart"
    private const val type_of_measurement_determination_EN = "Type of determination"
    fun typeOfMeasurementDetermination(language: Language): String {
        return when (language) {
            Language.DE -> type_of_measurement_determination_DE
            Language.EN -> type_of_measurement_determination_EN
        }
    }

    private const val type_of_object_DE = "Art des Gegenstandes"
    private const val type_of_object_EN = "Type of object"
    fun typeOfObject(language: Language): String {
        return when (language) {
            Language.DE -> type_of_object_DE
            Language.EN -> type_of_object_EN
        }
    }

    private const val type_of_physical_trace_DE = "Art der materiellen Spur"
    private const val type_of_physical_trace_EN = "Type of physical trace"
    fun typeOfPhysicalTrace(language: Language): String {
        return when (language) {
            Language.DE -> type_of_physical_trace_DE
            Language.EN -> type_of_physical_trace_EN
        }
    }

    private const val un_dangerous_goods_number_DE = "UN-Gefahrennummer"
    private const val un_dangerous_goods_number_EN = "UN Dangerous goods number"
    fun unDangerousGoodsNumber(language: Language): String {
        return when (language) {
            Language.DE -> un_dangerous_goods_number_DE
            Language.EN -> un_dangerous_goods_number_EN
        }
    }

    private const val unit_DE = "Einheit"
    private const val unit_EN = "Unit"
    fun unit(language: Language): String {
        return when (language) {
            Language.DE -> unit_DE
            Language.EN -> unit_EN
        }
    }

    private const val username_DE = "Benutzername"
    private const val username_EN = "Username"
    fun username(language: Language): String {
        return when (language) {
            Language.DE -> username_DE
            Language.EN -> username_EN
        }
    }

    private const val value_DE = "Wert"
    private const val value_EN = "Value"
    fun value(language: Language): String {
        return when (language) {
            Language.DE -> value_DE
            Language.EN -> value_EN
        }
    }

    private const val victim_type_DE = "Opfertypus"
    private const val victim_type_EN = "Victim type"
    fun victimType(language: Language): String {
        return when (language) {
            Language.DE -> victim_type_DE
            Language.EN -> victim_type_EN
        }
    }

    private const val volume_DE = "Volumen"
    private const val volume_EN = "Volume"
    fun volume(language: Language): String {
        return when (language) {
            Language.DE -> volume_DE
            Language.EN -> volume_EN
        }
    }

    private const val weight_DE = "Gewicht"
    private const val weight_EN = "Weight"
    fun weight(language: Language): String {
        return when (language) {
            Language.DE -> weight_DE
            Language.EN -> weight_EN
        }
    }

    private const val width_in_meter_DE = "Breite [m]"
    private const val width_in_meter_EN = "Width [m]"
    fun widthInMeter(language: Language): String {
        return when (language) {
            Language.DE -> width_in_meter_DE
            Language.EN -> width_in_meter_EN
        }
    }
}