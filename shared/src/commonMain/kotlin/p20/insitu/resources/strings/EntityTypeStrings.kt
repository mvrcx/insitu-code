package p20.insitu.resources.strings

import p20.insitu.model.entities.enums.EntityType
import p20.insitu.resources.Language

object EntityTypeStrings {

    fun typeString(entityType: EntityType, language: Language): String {
        return when (entityType){
            EntityType.ADDRESS -> address(language)
            EntityType.ADDRESS_RELATION -> addressRelation(language)
            EntityType.AIRCRAFT -> aircraft(language)
            EntityType.AMMUNITION -> ammunition(language)
            EntityType.ANNOTATION_RELATION -> ammunitionRelation(language)
            EntityType.APARTMENT -> apartment(language)
            EntityType.AREA -> area(language)
            EntityType.AUDIO -> audio(language)
            EntityType.AUDIT_ENTRY -> auditEntry(language)
            EntityType.AUTHORITY -> authority(language)
            EntityType.BICYCLE -> bicycle(language)
            EntityType.BUILDING -> building(language)
            EntityType.BODY_PART -> bodyPart(language)
            EntityType.CASH -> cash(language)
            EntityType.CORPSE -> corpse(language)
            EntityType.COUNTERFEIT_MONEY -> counterfeitMoney(language)
            EntityType.CRIME_SCENE -> crimeScene(language)
            EntityType.CRIME_SCENE_RELATION -> crimeSceneRelation(language)
            EntityType.CRIMINAL_OFFENSE -> criminalOffense(language)
            EntityType.CRIMINAL_OFFENSE_RELATION -> criminalOffenseRelation(language)
            EntityType.DEVICE -> device(language)
            EntityType.DNA_TRACE -> dnaTrace(language)
            EntityType.DOCUMENT -> document(language)
            EntityType.DOOR -> door(language)
            EntityType.DRUG -> drug(language)
            EntityType.DRUG_RAW_MATERIAL -> drugRawMaterial(language)
            EntityType.EVENT -> event(language)
            EntityType.EVENT_RELATION -> eventRelation(language)
            EntityType.EXPLOSIVE_DEVICE -> explosiveDevice(language)
            EntityType.EXPLOSIVE_SUBSTANCE -> explosiveSubstance(language)
            EntityType.FIREARM -> firearm(language)
            EntityType.FLOOR -> floor(language)
            EntityType.GENERAL_RELATION -> generalRelation(language)
            EntityType.IMAGE -> image(language)
            EntityType.IMAGE_TAG -> imageTag(language)
            EntityType.INVESTIGATION -> investigation(language)
            EntityType.INVESTIGATION_RELATION -> investigationRelation(language)
            EntityType.LICENSE_PLATE -> licensePlate(language)
            EntityType.MEDICINE -> medicine(language)
            EntityType.MOTOR_VEHICLE -> motorVehicle(language)
            EntityType.NOTE -> note(language)
            EntityType.PAYMENT_CARD -> paymentCard(language)
            EntityType.PERSON -> person(language)
            EntityType.PERSON_GROUP -> personGroup(language)
            EntityType.PHYSICAL_TRACE -> physicalTrace(language)
            EntityType.POINT_CLOUD -> pointCloud(language)
            EntityType.PORTABLE_OBJECT -> portableObject(language)
            EntityType.RAIL_VEHICLE -> railVehicle(language)
            EntityType.RECORD -> record(language)
            EntityType.ROOM -> room(language)
            EntityType.SITE_RELATION -> siteRelation(language)
            EntityType.SKETCH -> sketch(language)
            EntityType.SOME_OBJECT -> someObject(language)
            EntityType.SOME_SITE -> someSite(language)
            EntityType.SOME_VEHICLE -> someVehicle(language)
            EntityType.SOVEREIGN_ACT -> sovereignAct(language)
            EntityType.SOVEREIGN_ACT_RELATION -> sovereignActRelation(language)
            EntityType.TOPOLOGICAL_RELATION -> topologicalRelation(language)
            EntityType.USER_SETTINGS -> userSettings(language)
            EntityType.VIDEO -> video(language)
            EntityType.WALL -> wall(language)
            EntityType.WATERCRAFT -> watercraft(language)
            EntityType.WEAPON_OF_MASS_DESTRUCTION -> weaponOfMassDestruction(language)
            EntityType.WEAPON_PART -> weaponPart(language)
            EntityType.WEAPON_SYSTEM -> weaponSystem(language)
            EntityType.WINDOW -> window(language)
        }
    }

    private const val address_DE = "Adresse"
    private const val address_EN = "Address"
    fun address(language: Language): String {
        return when (language) {
            Language.DE -> address_DE
            Language.EN -> address_EN
        }
    }

    private const val address_relation_DE = "Adressbeziehung"
    private const val address_relation_EN = "Address Relation"
    fun addressRelation(language: Language): String {
        return when (language) {
            Language.DE -> address_relation_DE
            Language.EN -> address_relation_EN
        }
    }

    private const val aircraft_DE = "Luftfahrzeug"
    private const val aircraft_EN = "Aircraft"
    fun aircraft(language: Language): String {
        return when (language) {
            Language.DE -> aircraft_DE
            Language.EN -> aircraft_EN
        }
    }

    private const val ammunition_DE = "Munition"
    private const val ammunition_EN = "Ammunition"
    fun ammunition(language: Language): String {
        return when (language) {
            Language.DE -> ammunition_DE
            Language.EN -> ammunition_EN
        }
    }

    private const val ammunition_relation_DE = "Munitionsbeziehung"
    private const val ammunition_relation_EN = "Ammunition Relation"
    fun ammunitionRelation(language: Language): String {
        return when (language) {
            Language.DE -> ammunition_relation_DE
            Language.EN -> ammunition_relation_EN
        }
    }

    private const val apartment_DE = "Wohnung"
    private const val apartment_EN = "Apartment"
    fun apartment(language: Language): String {
        return when (language) {
            Language.DE -> apartment_DE
            Language.EN -> apartment_EN
        }
    }

    private const val area_DE = "Fläche"
    private const val area_EN = "Area"
    fun area(language: Language): String {
        return when (language) {
            Language.DE -> area_DE
            Language.EN -> area_EN
        }
    }

    private const val audio_DE = "Audioaufnahme"
    private const val audio_EN = "Audio recording"
    fun audio(language: Language): String {
        return when (language) {
            Language.DE -> audio_DE
            Language.EN -> audio_EN
        }
    }

    private const val audit_entry_DE = "Protokolleintrag"
    private const val audit_entry_EN = "Audit Entry"
    fun auditEntry(language: Language): String {
        return when (language) {
            Language.DE -> audit_entry_DE
            Language.EN -> audit_entry_EN
        }
    }

    private const val authority_DE = "Beteiligte Stelle"
    private const val authority_EN = "Authority"
    fun authority(language: Language): String {
        return when (language) {
            Language.DE -> authority_DE
            Language.EN -> authority_EN
        }
    }

    private const val bicycle_DE = "Fahrrad"
    private const val bicycle_EN = "Bicycle"
    fun bicycle(language: Language): String {
        return when (language) {
            Language.DE -> bicycle_DE
            Language.EN -> bicycle_EN
        }
    }

    private const val building_DE = "Gebäude"
    private const val building_EN = "Building"
    fun building(language: Language): String {
        return when (language) {
            Language.DE -> building_DE
            Language.EN -> building_EN
        }
    }

    private const val body_part_DE = "Körperteil"
    private const val body_part_EN = "Body Part"
    fun bodyPart(language: Language): String {
        return when (language) {
            Language.DE -> body_part_DE
            Language.EN -> body_part_EN
        }
    }

    private const val cash_DE = "Bargeld"
    private const val cash_EN = "Cash"
    fun cash(language: Language): String {
        return when (language) {
            Language.DE -> cash_DE
            Language.EN -> cash_EN
        }
    }

    private const val corpse_DE = "Leiche"
    private const val corpse_EN = "Corpse"
    fun corpse(language: Language): String {
        return when (language) {
            Language.DE -> corpse_DE
            Language.EN -> corpse_EN
        }
    }

    private const val counterfeit_money_DE = "Falschgeld"
    private const val counterfeit_money_EN = "Counterfeit Money"
    fun counterfeitMoney(language: Language): String {
        return when (language) {
            Language.DE -> counterfeit_money_DE
            Language.EN -> counterfeit_money_EN
        }
    }

    private const val crime_scene_DE = "Tatort"
    private const val crime_scene_EN = "Crime Scene"
    fun crimeScene(language: Language): String {
        return when (language) {
            Language.DE -> crime_scene_DE
            Language.EN -> crime_scene_EN
        }
    }

    private const val crime_scene_relation_DE = "Tatortbeziehung"
    private const val crime_scene_relation_EN = "Crime Scene Relation"
    fun crimeSceneRelation(language: Language): String {
        return when (language) {
            Language.DE -> crime_scene_relation_DE
            Language.EN -> crime_scene_relation_EN
        }
    }

    private const val criminal_offense_DE = "Straftat"
    private const val criminal_offense_EN = "Criminal Offense"
    fun criminalOffense(language: Language): String {
        return when (language) {
            Language.DE -> criminal_offense_DE
            Language.EN -> criminal_offense_EN
        }
    }

    private const val criminal_offense_relation_DE = "Straftatbeziehung"
    private const val criminal_offense_relation_EN = "Criminal Offense Relation"
    fun criminalOffenseRelation(language: Language): String {
        return when (language) {
            Language.DE -> criminal_offense_relation_DE
            Language.EN -> criminal_offense_relation_EN
        }
    }

    private const val device_DE = "Gerät"
    private const val device_EN = "Device"
    fun device(language: Language): String {
        return when (language) {
            Language.DE -> device_DE
            Language.EN -> device_EN
        }
    }

    private const val dna_trace_DE = "DNA-Spur"
    private const val dna_trace_EN = "DNA trace"
    fun dnaTrace(language: Language): String {
        return when (language) {
            Language.DE -> dna_trace_DE
            Language.EN -> dna_trace_EN
        }
    }

    private const val document_DE = "Dokument"
    private const val document_EN = "Document"
    fun document(language: Language): String {
        return when (language) {
            Language.DE -> document_DE
            Language.EN -> document_EN
        }
    }

    private const val door_DE = "Tür"
    private const val door_EN = "Door"
    fun door(language: Language): String {
        return when (language) {
            Language.DE -> door_DE
            Language.EN -> door_EN
        }
    }

    private const val drug_DE = "Betäubungsmittel"
    private const val drug_EN = "Drug"
    fun drug(language: Language): String {
        return when (language) {
            Language.DE -> drug_DE
            Language.EN -> drug_EN
        }
    }

    private const val drug_raw_material_DE = "Betäubungsmittelgrundstoff"
    private const val drug_raw_material_EN = "Drug Raw Material"
    fun drugRawMaterial(language: Language): String {
        return when (language) {
            Language.DE -> drug_raw_material_DE
            Language.EN -> drug_raw_material_EN
        }
    }

    private const val event_DE = "Ereignis"
    private const val event_EN = "Event"
    fun event(language: Language): String {
        return when (language) {
            Language.DE -> event_DE
            Language.EN -> event_EN
        }
    }

    private const val event_relation_DE = "Ereignisbeziehung"
    private const val event_relation_EN = "Event Relation"
    fun eventRelation(language: Language): String {
        return when (language) {
            Language.DE -> event_relation_DE
            Language.EN -> event_relation_EN
        }
    }

    private const val explosive_device_DE = "Spreng-/Brandvorrichtung"
    private const val explosive_device_EN = "Explosive Device"
    fun explosiveDevice(language: Language): String {
        return when (language) {
            Language.DE -> explosive_device_DE
            Language.EN -> explosive_device_EN
        }
    }

    private const val explosive_substance_DE = "Explosionsgefährlicher Stoff"
    private const val explosive_substance_EN = "Explosive Substance"
    fun explosiveSubstance(language: Language): String {
        return when (language) {
            Language.DE -> explosive_substance_DE
            Language.EN -> explosive_substance_EN
        }
    }

    private const val firearm_DE = "Schusswaffe"
    private const val firearm_EN = "Firearm"
    fun firearm(language: Language): String {
        return when (language) {
            Language.DE -> firearm_DE
            Language.EN -> firearm_EN
        }
    }

    private const val floor_DE = "Stockwerk"
    private const val floor_EN = "Floor"
    fun floor(language: Language): String {
        return when (language) {
            Language.DE -> floor_DE
            Language.EN -> floor_EN
        }
    }

    private const val general_relation_DE = "Beziehung"
    private const val general_relation_EN = "General Relation"
    fun generalRelation(language: Language): String {
        return when (language) {
            Language.DE -> general_relation_DE
            Language.EN -> general_relation_EN
        }
    }

    private const val image_DE = "Bild"
    private const val image_EN = "Image"
    fun image(language: Language): String {
        return when (language) {
            Language.DE -> image_DE
            Language.EN -> image_EN
        }
    }

    private const val image_tag_DE = "Bild-Label"
    private const val image_tag_EN = "Image Tag"
    fun imageTag(language: Language): String {
        return when (language) {
            Language.DE -> image_tag_DE
            Language.EN -> image_tag_EN
        }
    }

    private const val investigation_DE = "Vorgang"
    private const val investigation_EN = "Investigation"
    fun investigation(language: Language): String {
        return when (language) {
            Language.DE -> investigation_DE
            Language.EN -> investigation_EN
        }
    }

    private const val investigation_relation_DE = "Vorgangsbeziehung"
    private const val investigation_relation_EN = "Investigation Relation"
    fun investigationRelation(language: Language): String {
        return when (language) {
            Language.DE -> investigation_relation_DE
            Language.EN -> investigation_relation_EN
        }
    }

    private const val license_plate_DE = "Kfz-Kennzeichen"
    private const val license_plate_EN = "License Plate"
    fun licensePlate(language: Language): String {
        return when (language) {
            Language.DE -> license_plate_DE
            Language.EN -> license_plate_EN
        }
    }

    private const val medicine_DE = "Medizin"
    private const val medicine_EN = "Medicine"
    fun medicine(language: Language): String {
        return when (language) {
            Language.DE -> medicine_DE
            Language.EN -> medicine_EN
        }
    }

    private const val motor_vehicle_DE = "Kraftfahrzeug"
    private const val motor_vehicle_EN = "Motor vehicle"
    fun motorVehicle(language: Language): String {
        return when (language) {
            Language.DE -> motor_vehicle_DE
            Language.EN -> motor_vehicle_EN
        }
    }

    private const val note_DE = "Notiz"
    private const val note_EN = "Note"
    fun note(language: Language): String {
        return when (language) {
            Language.DE -> note_DE
            Language.EN -> note_EN
        }
    }

    private const val payment_card_DE = "Zahlungskarte"
    private const val payment_card_EN = "Payment card"
    fun paymentCard(language: Language): String {
        return when (language) {
            Language.DE -> payment_card_DE
            Language.EN -> payment_card_EN
        }
    }

    private const val person_DE = "Person"
    private const val person_EN = "Person"
    fun person(language: Language): String {
        return when (language) {
            Language.DE -> person_DE
            Language.EN -> person_EN
        }
    }

    private const val person_group_DE = "Personengruppe"
    private const val person_group_EN = "Person group"
    fun personGroup(language: Language): String {
        return when (language) {
            Language.DE -> person_group_DE
            Language.EN -> person_group_EN
        }
    }

    private const val physical_trace_DE = "Materielle Spur"
    private const val physical_trace_EN = "Physical trace"
    fun physicalTrace(language: Language): String {
        return when (language) {
            Language.DE -> physical_trace_DE
            Language.EN -> physical_trace_EN
        }
    }

    private const val point_cloud_DE = "Punktewolke"
    private const val point_cloud_EN = "Point cloud"
    fun pointCloud(language: Language): String {
        return when (language) {
            Language.DE -> point_cloud_DE
            Language.EN -> point_cloud_EN
        }
    }

    private const val portable_object_DE = "Tragbares Gegenstand"
    private const val portable_object_EN = "Portable object"
    fun portableObject(language: Language): String {
        return when (language) {
            Language.DE -> portable_object_DE
            Language.EN -> portable_object_EN
        }
    }

    private const val rail_vehicle_DE = "Schienenfahrzeug"
    private const val rail_vehicle_EN = "Rail vehicle"
    fun railVehicle(language: Language): String {
        return when (language) {
            Language.DE -> rail_vehicle_DE
            Language.EN -> rail_vehicle_EN
        }
    }

    private const val record_DE = "Aufzeichnung"
    private const val record_EN = "Record"
    fun record(language: Language): String {
        return when (language) {
            Language.DE -> record_DE
            Language.EN -> record_EN
        }
    }

    private const val site_relation_DE = "Lagebeziehung"
    private const val site_relation_EN = "Site relation"
    fun siteRelation(language: Language): String {
        return when (language) {
            Language.DE -> site_relation_DE
            Language.EN -> site_relation_EN
        }
    }

    private const val sketch_DE = "Skizze"
    private const val sketch_EN = "Sketch"
    fun sketch(language: Language): String {
        return when (language) {
            Language.DE -> sketch_DE
            Language.EN -> sketch_EN
        }
    }

    private const val space_DE = "Raum"
    private const val space_EN = "Space"
    fun room(language: Language): String {
        return when (language) {
            Language.DE -> space_DE
            Language.EN -> space_EN
        }
    }

    private const val some_object_DE = "Sonstige Sache"
    private const val some_object_EN = "Some object"
    fun someObject(language: Language): String {
        return when (language) {
            Language.DE -> some_object_DE
            Language.EN -> some_object_EN
        }
    }

    private const val some_site_DE = "Sonstige Lage"
    private const val some_site_EN = "Some site"
    fun someSite(language: Language): String {
        return when (language) {
            Language.DE -> some_site_DE
            Language.EN -> some_site_EN
        }
    }

    private const val some_vehicle_DE = "Sonstiges Fahrzeug"
    private const val some_vehicle_EN = "Some vehicle"
    fun someVehicle(language: Language): String {
        return when (language) {
            Language.DE -> some_vehicle_DE
            Language.EN -> some_vehicle_EN
        }
    }

    private const val sovereign_act_DE = "Hoheitliche Maßnahme"
    private const val sovereign_act_EN = "Sovereign act"
    fun sovereignAct(language: Language): String {
        return when (language) {
            Language.DE -> sovereign_act_DE
            Language.EN -> sovereign_act_EN
        }
    }

    private const val sovereign_act_relation_DE = "Beziehung zu hoheitlicher Maßnahme"
    private const val sovereign_act_relation_EN = "Sovereign act relation"
    fun sovereignActRelation(language: Language): String {
        return when (language) {
            Language.DE -> sovereign_act_relation_DE
            Language.EN -> sovereign_act_relation_EN
        }
    }

    private const val topological_relation_DE = "Topologische Beziehung"
    private const val topological_relation_EN = "Topological relation"
    fun topologicalRelation(language: Language): String {
        return when (language) {
            Language.DE -> topological_relation_DE
            Language.EN -> topological_relation_EN
        }
    }

    private const val user_settings_DE = "Benutzer-Einstellungen"
    private const val user_settings_EN = "User settings"
    fun userSettings(language: Language): String {
        return when (language) {
            Language.DE -> user_settings_DE
            Language.EN -> user_settings_EN
        }
    }

    private const val video_DE = "Video"
    private const val video_EN = "Video"
    fun video(language: Language): String {
        return when (language) {
            Language.DE -> video_DE
            Language.EN -> video_EN
        }
    }

    private const val wall_DE = "Wand"
    private const val wall_EN = "Wall"
    fun wall(language: Language): String {
        return when (language) {
            Language.DE -> wall_DE
            Language.EN -> wall_EN
        }
    }

    private const val watercraft_DE = "Wasserfahrzeug"
    private const val watercraft_EN = "Watercraft"
    fun watercraft(language: Language): String {
        return when (language) {
            Language.DE -> watercraft_DE
            Language.EN -> watercraft_EN
        }
    }

    private const val weapon_of_mass_destruction_DE = "Massenvernichtungswaffe"
    private const val weapon_of_mass_destruction_EN = "Weapon of mass destruction"
    fun weaponOfMassDestruction(language: Language): String {
        return when (language) {
            Language.DE -> weapon_of_mass_destruction_DE
            Language.EN -> weapon_of_mass_destruction_EN
        }
    }

    private const val weapon_part_DE = "Waffenteil"
    private const val weapon_part_EN = "Weapon part"
    fun weaponPart(language: Language): String {
        return when (language) {
            Language.DE -> weapon_part_DE
            Language.EN -> weapon_part_EN
        }
    }

    private const val weapon_system_DE = "Waffensystem"
    private const val weapon_system_EN = "Weapon system"
    fun weaponSystem(language: Language): String {
        return when (language) {
            Language.DE -> weapon_system_DE
            Language.EN -> weapon_system_EN
        }
    }

    private const val window_DE = "Fenster"
    private const val window_EN = "Window"
    fun window(language: Language): String {
        return when (language) {
            Language.DE -> window_DE
            Language.EN -> window_EN
        }
    }

}