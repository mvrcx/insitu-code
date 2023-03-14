package p20.insitu.model.util

import p20.insitu.model.components.*
import p20.insitu.model.components.ModusOperandi
import p20.insitu.model.entities.*
import p20.insitu.model.entities.Annotation
import p20.insitu.model.entities.InvestigationRelation
import p20.insitu.model.entities.Person
import p20.insitu.model.entities.enums.AuditType
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.schema.*

object ObjectFactory {

    fun createUserSettings(
        userId: String,
        lastActiveInvestigationId: String?,
        lastActiveCrimeSceneId: String?,
        lastActiveDocuObjectId: String?
    ): UserSettings {
        return UserSettings(
            userId = userId,
            lastActiveInvestigationId = lastActiveInvestigationId,
            lastActiveCrimeSceneId = lastActiveCrimeSceneId,
            lastActiveDocuObjectId = lastActiveDocuObjectId
        )
    }

    fun createVideoAnnotation(fileExtension: String): Video {
        return Video(
            annotationType = CatalogCodeFixed(
                code = "102_1",
                name = "Film",
                catalog = CatalogInfo.CATALOG_102_ART_DER_AUFZEICHNUNG.toCatalog()
            )
        ).also {
            it.filename = it.id + fileExtension
        }
    }

    fun createImageAnnotation(fileExtension: String): Image {
        return Image(
            annotationType = CatalogCodeFixed(
                code = "102_2",
                name = "Bild",
                catalog = CatalogInfo.CATALOG_102_ART_DER_AUFZEICHNUNG.toCatalog()
            )
        ).also {
            it.filename = it.id + fileExtension
        }
    }

    fun createAudioAnnotation(fileExtension: String): Audio {
        return Audio(
            annotationType = CatalogCodeFixed(
                code = "102_3",
                name = "Ton",
                catalog = CatalogInfo.CATALOG_102_ART_DER_AUFZEICHNUNG.toCatalog()
            )
        ).also {
            it.filename = it.id + fileExtension
        }
    }

    fun createNoteAnnotation(): Note {
        return Note(
            annotationType = CatalogCodeFixed(
                code = "102_4",
                name = "Text",
                catalog = CatalogInfo.CATALOG_102_ART_DER_AUFZEICHNUNG.toCatalog()
            )
        )
    }

    fun createAddressRelation(
        crimeScene: CrimeScene,
        address: Address,
        role: CatalogCodeFixed<KatalogCode001> = createDefaultRole(EntityType.ADDRESS_RELATION),
        designation: String? = EntityType.ADDRESS_RELATION.toString(),
        comment: String? = "CrimeScene ${crimeScene.designation}[ID: ${crimeScene.id}] is related to " +
                "Address ${address.designation ?: address.toString()}[ID: ${address.id}]."
    ): AddressRelation {
        return AddressRelation(
            sourceId = crimeScene.id,
            targetId = address.id,
            role = role,
            designation = designation,
            comment = comment
        )
    }

    fun createAnnotationRelation(
        docuObject: DocumentationObject,
        annotation: Annotation,
        role: CatalogCodeFixed<KatalogCode001> = createDefaultRole(EntityType.ANNOTATION_RELATION),
        designation: String? = EntityType.ANNOTATION_RELATION.toString(),
        comment: String? = "Object ${docuObject.designation} [ID: ${docuObject.id}] " +
                "is related to annotation ${annotation.designation} [ID: ${annotation.id}]."
    ): AnnotationRelation {
        return AnnotationRelation(
            sourceId = docuObject.id,
            sourceType = docuObject.entityType,
            targetId = annotation.id,
            targetType = annotation.entityType,
            role = role,
            designation = designation,
            comment = comment
        )
    }

    fun createAuditEntryForInsert(
        timestamp: ZonedDateTime,
        entity: IBaseEntity,
        properties: Map<String, Any?>,
        userId: String
    ): AuditEntry {
        val mapDifference = mapDifference(oldMap = mapOf(), newMap = properties)
        return AuditEntry(
            timestamp = timestamp,
            auditType = AuditType.CREATE,
            auditEntityId = entity.id,
            auditEntityType = entity.entityType,
            userId = userId,
            entriesAdded = mapDifference.entriesAdded,
            entriesInCommon = mapDifference.entriesInCommon,
            entriesRemoved = mapDifference.entriesRemoved,
            entriesDiffering = mapDifference.entriesDiffering
        )
    }

    fun createAuditEntryForUpdate(
        timestamp: ZonedDateTime,
        entity: IBaseEntity,
        oldProperties: Map<String, Any?>,
        newProperties: Map<String, Any?>,
        userId: String
    ): AuditEntry {
        val mapDifference = mapDifference(oldMap = oldProperties, newMap = newProperties)
        return AuditEntry(
            timestamp = timestamp,
            auditType = AuditType.EDIT,
            auditEntityId = entity.id,
            auditEntityType = entity.entityType,
            userId = userId,
            entriesAdded = mapDifference.entriesAdded,
            entriesInCommon = mapDifference.entriesInCommon,
            entriesRemoved = mapDifference.entriesRemoved,
            entriesDiffering = mapDifference.entriesDiffering
        )
    }

    fun createAuditEntryForDelete(
        timestamp: ZonedDateTime,
        entity: IBaseEntity,
        oldProperties: Map<String, Any?>,
        newProperties: Map<String, Any?>,
        userId: String
    ): AuditEntry {
        val mapDifference = mapDifference(oldMap = oldProperties, newMap = newProperties)
        return AuditEntry(
            timestamp = timestamp,
            auditType = AuditType.DELETE,
            auditEntityId = entity.id,
            auditEntityType = entity.entityType,
            userId = userId,
            entriesAdded = mapDifference.entriesAdded,
            entriesInCommon = mapDifference.entriesInCommon,
            entriesRemoved = mapDifference.entriesRemoved,
            entriesDiffering = mapDifference.entriesDiffering
        )
    }

    fun createCrimeScene(
        timeOfArrival: ZonedDateTime
    ): CrimeScene {
        return CrimeScene(
            timeOfArrival = timeOfArrival
        )
    }

    fun createCrimeSceneRelation(
        investigation: Investigation,
        crimeScene: CrimeScene,
        role: CatalogCodeFixed<KatalogCode001> = createDefaultRole(EntityType.CRIME_SCENE_RELATION),
        designation: String? = EntityType.CRIME_SCENE_RELATION.toString(),
        comment: String? = "Investigation ${investigation.designation} [Number: ${investigation.number}] " +
                "is related to crime scene ${crimeScene.designation} [ID: ${crimeScene.id}]."
    ): CrimeSceneRelation {
        return CrimeSceneRelation(
            sourceId = investigation.id,
            targetId = crimeScene.id,
            role = role,
            designation = designation,
            comment = comment
        )
    }

    fun createCriminalOffense(typeOfCrime: CatalogCodeFixed<KatalogCode121>? = null): CriminalOffense {
        return CriminalOffense(typeOfCrime = typeOfCrime)
    }

    private fun createDefaultRole(relationType: EntityType): CatalogCodeFixed<KatalogCode001> {
        return when (relationType) {
            EntityType.ADDRESS_RELATION -> {
                CatalogCodeFixed(
                    code = "001_3",
                    name = "Anschrift",
                    catalog = CatalogInfo.CATALOG_001_ROLLENWERTE.toCatalog()
                )
            }
            EntityType.SITE_RELATION,
            EntityType.TOPOLOGICAL_RELATION -> {
                CatalogCodeFixed(
                    code = "001_8",
                    name = "befindet sich",
                    catalog = CatalogInfo.CATALOG_001_ROLLENWERTE.toCatalog()
                )
            }
            else -> CatalogCodeFixed(
                code = "001_75",
                name = "Zusammenhang",
                catalog = CatalogInfo.CATALOG_001_ROLLENWERTE.toCatalog()
            )
        }
    }

    fun createInvestigation(
        designation: String,
        number: String,
        startDate: ZonedDateTime
    ): Investigation {
        return Investigation(
            designation = designation,
            number = number,
            startDate = startDate
        )
    }

    fun createCriminalOffenseRelation(
        relatedObject: DocumentationObject,
        criminalOffense: CriminalOffense,
        role: CatalogCodeFixed<KatalogCode001> = createDefaultRole(EntityType.CRIME_SCENE_RELATION),
        designation: String? = EntityType.CRIME_SCENE_RELATION.toString(),
        comment: String? = "Object ${relatedObject.designation}[ID: ${relatedObject.id}] is related to " +
                "CriminalOffense ${criminalOffense.designation}[ID: ${criminalOffense.id}]."
    ): CriminalOffenseRelation {
        return CriminalOffenseRelation(
            sourceId = relatedObject.id,
            sourceType = relatedObject.entityType,
            targetId = criminalOffense.id,
            role = role,
            designation = designation,
            comment = comment
        )
    }

    fun createInvestigationRelation(
        relatedObject: DocumentationObject,
        investigation: Investigation,
        role: CatalogCodeFixed<KatalogCode001> = createDefaultRole(EntityType.INVESTIGATION_RELATION),
        designation: String? = EntityType.INVESTIGATION_RELATION.toString(),
        comment: String? = "Object ${relatedObject.designation}[ID: ${relatedObject.id}] is related to " +
                "Investigation ${investigation.designation}[Number: ${investigation.number}]."
    ): InvestigationRelation {
        return InvestigationRelation(
            sourceId = relatedObject.id,
            sourceType = relatedObject.entityType,
            targetId = investigation.id,
            role = role,
            designation = designation,
            comment = comment
        )
    }

    fun createTopologicalRelation(
        child: DocNumberObject,
        parent: DocNumberObject,
        role: CatalogCodeFixed<KatalogCode001> = createDefaultRole(EntityType.TOPOLOGICAL_RELATION),
        designation: String? = EntityType.TOPOLOGICAL_RELATION.toString(),
        comment: String? = "Object ${child.designation} [ID: ${child.id}] is the topological child " +
                "of object ${parent.designation} [ID: ${parent.id}]."
    ): TopologicalRelation {
        return TopologicalRelation(
            sourceId = parent.id,
            sourceType = parent.entityType,
            targetId = child.id,
            targetType = child.entityType,
            role = role,
            designation = designation,
            comment = comment
        )
    }

    fun createSiteRelation(
        crimeScene: CrimeScene,
        site: Site,
        role: CatalogCodeFixed<KatalogCode001> = createDefaultRole(EntityType.SITE_RELATION),
        designation: String? = EntityType.SITE_RELATION.toString(),
        comment: String? = "Crime scene ${crimeScene.designation} [ID: ${crimeScene.id}] " +
                "is related to site ${site.designation} [ID: ${site.id}]."
    ): SiteRelation {
        return SiteRelation(
            sourceId = crimeScene.id,
            sourceType = crimeScene.entityType,
            targetId = site.id,
            targetType = site.entityType,
            role = role,
            designation = designation,
            comment = comment
        )
    }

    fun createSomeSite(
        designation: String = "",
        locationType: CatalogCodeNotComplete<KatalogCode115_NichtAbgeschlossen>? = null
    ): SomeSite {
        return SomeSite(
            designation = designation,
            locationType = locationType,
        )
    }

    fun createBuilding(
        designation: String = ""
    ): Building {
        return Building(
            designation = designation,
            locationType = CatalogCodeNotComplete(
                code = "115_305",
                name = "Gebäude / Bauwerk",
                unlistedValue = null,
                catalog = CatalogInfo.CATALOG_115_ART_DER_OERTLICHKEIT.toCatalog()
            )
        )
    }

    fun createFloor(
        designation: String = ""
    ): Floor {
        return Floor(
            designation = designation,
            locationType = CatalogCodeNotComplete(
                code = "115_363",
                name = "Räumlichkeit / Gebäudeteil",
                unlistedValue = null,
                catalog = CatalogInfo.CATALOG_115_ART_DER_OERTLICHKEIT.toCatalog()
            )
        )
    }

    fun createApartment(
        designation: String = ""
    ): Apartment {
        return Apartment(
            designation = designation,
            locationType = CatalogCodeNotComplete(
                code = "115_322",
                name = "Wohnung",
                unlistedValue = null,
                catalog = CatalogInfo.CATALOG_115_ART_DER_OERTLICHKEIT.toCatalog()
            )
        )
    }

    fun createRoom(
        designation: String = ""
    ): Room {
        return Room(
            designation = designation,
            locationType = CatalogCodeNotComplete(
                code = "115_363",
                name = "Räumlichkeit / Gebäudeteil",
                unlistedValue = null,
                catalog = CatalogInfo.CATALOG_115_ART_DER_OERTLICHKEIT.toCatalog()
            )
        )
    }

    fun createDNATrace(securingTimestamp: ZonedDateTime): DNATrace {
        return DNATrace(evidenceData = EvidenceData(securingTimestamp = securingTimestamp))
    }

    fun createPerson(): Person {
        return Person()
    }

    fun createPhysicalTrace(securingTimestamp: ZonedDateTime): PhysicalTrace {
        return PhysicalTrace(evidenceData = EvidenceData(securingTimestamp = securingTimestamp))
    }

    fun createSomeObject(): SomeObject {
        return SomeObject()
    }

    fun createDoor(): Door {
        return Door()
    }

    fun createModusOperandiPlanningPhase(): ModusOperandi {
        return ModusOperandi(
            type = null,
            designation = null,
            crimePhase = CatalogCodeFixed(
                code = "316_1",
                name = "Vortat / Tatvorbereitung",
                catalog = CatalogInfo.CATALOG_316_TATPHASE.toCatalog()
            )
        )
    }

    fun createModusOperandiExecutionPhase(): ModusOperandi {
        return ModusOperandi(
            type = null,
            designation = null,
            crimePhase = CatalogCodeFixed(
                code = "316_1",
                name = "Tatdurchführung",
                catalog = CatalogInfo.CATALOG_316_TATPHASE.toCatalog()
            )
        )
    }

    fun createModusOperandiPostExecutionPhase(): ModusOperandi {
        return ModusOperandi(
            type = null,
            designation = null,
            crimePhase = CatalogCodeFixed(
                code = "316_3",
                name = "Nachtat (-verhalten)",
                catalog = CatalogInfo.CATALOG_316_TATPHASE.toCatalog()
            )
        )
    }
}