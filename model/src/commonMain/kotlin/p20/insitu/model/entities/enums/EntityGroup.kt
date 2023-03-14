package p20.insitu.model.entities.enums

enum class EntityGroup(val types: List<EntityType>) : EntityTypeIdentifier {

    ALL(
        listOf(
            EntityType.ADDRESS,
            EntityType.ADDRESS_RELATION,
            EntityType.AIRCRAFT,
            EntityType.AMMUNITION,
            EntityType.ANNOTATION_RELATION,
            EntityType.APARTMENT,
            EntityType.AREA,
            EntityType.AUDIO,
            EntityType.AUDIT_ENTRY,
            EntityType.AUTHORITY,

            EntityType.BICYCLE,
            EntityType.BODY_PART,
            EntityType.BUILDING,

            EntityType.CASH,
            EntityType.CORPSE,
            EntityType.COUNTERFEIT_MONEY,
            EntityType.CRIME_SCENE,
            EntityType.CRIME_SCENE_RELATION,
            EntityType.CRIMINAL_OFFENSE,
            EntityType.CRIMINAL_OFFENSE_RELATION,

            EntityType.DEVICE,
            EntityType.DNA_TRACE,
            EntityType.DOCUMENT,
            EntityType.DOOR,
            EntityType.DRUG,
            EntityType.DRUG_RAW_MATERIAL,

            EntityType.EVENT,
            EntityType.EVENT_RELATION,
            EntityType.EXPLOSIVE_DEVICE,
            EntityType.EXPLOSIVE_SUBSTANCE,

            EntityType.FIREARM,
            EntityType.FLOOR,

            EntityType.GENERAL_RELATION,

            EntityType.IMAGE,
            EntityType.IMAGE_TAG,
            EntityType.INVESTIGATION,
            EntityType.INVESTIGATION_RELATION,

            EntityType.LICENSE_PLATE,

            EntityType.MEDICINE,
            EntityType.MOTOR_VEHICLE,

            EntityType.NOTE,

            EntityType.PAYMENT_CARD,
            EntityType.PERSON,
            EntityType.PERSON_GROUP,
            EntityType.PHYSICAL_TRACE,
            EntityType.POINT_CLOUD,
            EntityType.PORTABLE_OBJECT,

            EntityType.RAIL_VEHICLE,
            EntityType.RECORD,
            EntityType.ROOM,

            EntityType.SITE_RELATION,
            EntityType.SKETCH,
            EntityType.SOME_OBJECT,
            EntityType.SOME_SITE,
            EntityType.SOME_VEHICLE,
            EntityType.SOVEREIGN_ACT,
            EntityType.SOVEREIGN_ACT_RELATION,

            EntityType.TOPOLOGICAL_RELATION,

            EntityType.VIDEO,

            EntityType.WALL,
            EntityType.WATERCRAFT,
            EntityType.WEAPON_OF_MASS_DESTRUCTION,
            EntityType.WEAPON_PART,
            EntityType.WEAPON_SYSTEM,
            EntityType.WINDOW
        )
    ),

    ANNOTATIONS(
        listOf(
            EntityType.AUDIO,
            EntityType.DOCUMENT,
            EntityType.IMAGE,
            EntityType.NOTE,
            EntityType.POINT_CLOUD,
            EntityType.SKETCH,
            EntityType.VIDEO
        )
    ),
    RELATIONS(
        listOf(
            EntityType.ADDRESS_RELATION,
            EntityType.ANNOTATION_RELATION,
            EntityType.CRIME_SCENE_RELATION,
            EntityType.CRIMINAL_OFFENSE_RELATION,
            EntityType.EVENT_RELATION,
            EntityType.GENERAL_RELATION,
            EntityType.INVESTIGATION_RELATION,
            EntityType.SITE_RELATION,
            EntityType.SOVEREIGN_ACT_RELATION,
            EntityType.TOPOLOGICAL_RELATION
        )
    ),
    SITES(
        listOf(
            // Building parts
            EntityType.APARTMENT,
            EntityType.BUILDING,
            EntityType.FLOOR,
            EntityType.ROOM,
            // Vehicles
            EntityType.AIRCRAFT,
            EntityType.BICYCLE,
            EntityType.MOTOR_VEHICLE,
            EntityType.RAIL_VEHICLE,
            EntityType.SOME_VEHICLE,
            EntityType.WATERCRAFT,
            // Persons
            EntityType.CORPSE,
            EntityType.PERSON

        )
    ),
    BUILDING_SITES(
        listOf(
            EntityType.APARTMENT,
            EntityType.BUILDING,
            EntityType.FLOOR,
            EntityType.ROOM
        )
    ),
    VEHICLE_SITES(
        listOf(
            EntityType.AIRCRAFT,
            EntityType.BICYCLE,
            EntityType.MOTOR_VEHICLE,
            EntityType.RAIL_VEHICLE,
            EntityType.SOME_VEHICLE,
            EntityType.WATERCRAFT
        )
    ),
    PERSON_SITES(
        listOf(
            EntityType.CORPSE,
            EntityType.PERSON
        )
    ),
    OTHER_SITES(
        listOf(
            EntityType.SOME_SITE
        )
    ),
    HIERARCHICAL_RELATIONS(
        listOf(
            EntityType.CRIME_SCENE_RELATION,
            EntityType.SITE_RELATION,
            EntityType.TOPOLOGICAL_RELATION
        )
    ),
    ASSOCIATIVE_RELATIONS(
        listOf(
            EntityType.ADDRESS_RELATION,
            EntityType.ANNOTATION_RELATION,
            EntityType.CRIMINAL_OFFENSE_RELATION,
            EntityType.EVENT_RELATION,
            EntityType.GENERAL_RELATION,
            EntityType.INVESTIGATION_RELATION,
            EntityType.SOVEREIGN_ACT_RELATION
        )
    )

}