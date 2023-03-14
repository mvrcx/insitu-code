package p20.insitu.resources.icons

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import p20.insitu.catalogues.CatalogCategory
import p20.insitu.catalogues.CatalogSubCategory
import p20.insitu.catalogues.CatalogCategoryGroup
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.nav.NavRoute
import p20.insitu.resources.Language
import p20.insitu.resources.strings.TabStrings

object Icons {

    const val DefaultIconDimension = 24f

    object Filled

    inline fun makeImageVector(
        name: String,
        width: Dp = DefaultIconDimension.dp,
        height: Dp = DefaultIconDimension.dp,
        viewportWidth: Float = DefaultIconDimension,
        viewportHeight: Float = DefaultIconDimension,
        block: ImageVector.Builder.() -> ImageVector.Builder
    ): ImageVector = ImageVector.Builder(
        name = name,
        defaultWidth = width,
        defaultHeight = height,
        viewportWidth = viewportWidth,
        viewportHeight = viewportHeight
    ).block().build()

    fun catalogCategoryGroup(category: CatalogCategoryGroup): ImageVector {
        return when (category) {
            CatalogCategoryGroup.CRIME_SCENE_SITES -> Filled.OtherSites
            CatalogCategoryGroup.OBJECTS -> Icons.Filled.HelpCenter
            CatalogCategoryGroup.TRACES -> Icons.Filled.AddLocation
            CatalogCategoryGroup.VEHICLES -> Filled.Vehicle
            CatalogCategoryGroup.WEAPONS -> Filled.Weapon
            CatalogCategoryGroup.BUILDING_ELEMENTS -> Filled.BuildingElements
            CatalogCategoryGroup.BUILDING_SITES -> Icons.Filled.Home
            CatalogCategoryGroup.OTHER_SITES -> Filled.OtherSites
            CatalogCategoryGroup.PERSONS -> Icons.Filled.Groups
        }
    }

    fun catalogCategory(category: CatalogCategory): ImageVector {
        return when (category) {
            CatalogCategory.ELECTRONICS -> Filled.Electronics
            CatalogCategory.FURNITURE -> Filled.Furniture
            CatalogCategory.BUILDING_SITES -> Icons.Filled.Home
            CatalogCategory.OTHER_SITES -> Filled.OtherSites
            CatalogCategory.PERSONS -> Icons.Filled.Groups
            CatalogCategory.VEHICLES -> Filled.Vehicle
            CatalogCategory.WEAPONS -> Filled.Weapon
            CatalogCategory.TRACES -> Icons.Filled.AddLocation
            CatalogCategory.BUILDING_ELEMENTS -> Filled.BuildingElements
            CatalogCategory.OTHER_OBJECTS -> Icons.Filled.HelpCenter
        }
    }

    fun catalogSubCategory(category: CatalogSubCategory): ImageVector {
        return when (category) {
            CatalogSubCategory.CHAIRS -> Filled.Chair
            CatalogSubCategory.CLOSETS -> Filled.Closet
            CatalogSubCategory.TABLES -> Filled.Table
            else -> {
                getEntityTypeIcon(category.entityType)
            }
        }
    }

    fun docuModeNavItem(navRoute: NavRoute): ImageVector {
        return when (navRoute) {
            NavRoute.DOCU_MODE_HOME -> Icons.Filled.Folder
            NavRoute.DOCU_MODE_LIST -> Icons.Filled.FormatListNumbered
            NavRoute.DOCU_MODE_DETAILS -> Icons.Filled.Info
            else -> Filled.GenericObject
        }
    }

    fun getEntityTypeIcon(entityType: EntityType): ImageVector {
        return when (entityType) {
            EntityType.ADDRESS -> Icons.Filled.LocationOn
            EntityType.ADDRESS_RELATION -> Icons.Filled.Share
            EntityType.AIRCRAFT -> Icons.Filled.Flight
            EntityType.ANNOTATION_RELATION -> Icons.Filled.Share
            EntityType.APARTMENT -> Filled.Apartment
            EntityType.AREA -> Filled.GenericObject
            EntityType.AUDIO -> Icons.Filled.Audiotrack
            EntityType.AUDIT_ENTRY -> Filled.GenericObject
            EntityType.AUTHORITY -> Filled.GenericObject
            EntityType.BICYCLE -> Filled.GenericObject
            EntityType.BUILDING -> Icons.Filled.Home
            EntityType.BODY_PART -> Filled.GenericObject
            EntityType.CASH -> Filled.GenericObject
            EntityType.CORPSE -> Filled.GenericObject
            EntityType.COUNTERFEIT_MONEY -> Filled.GenericObject
            EntityType.CRIME_SCENE -> Filled.CrimeScene
            EntityType.CRIME_SCENE_RELATION -> Icons.Filled.Share
            EntityType.CRIMINAL_OFFENSE -> Filled.CriminalOffense
            EntityType.CRIMINAL_OFFENSE_RELATION -> Filled.GenericObject
            EntityType.DEVICE -> Filled.GenericObject
            EntityType.DNA_TRACE -> Filled.DNA
            EntityType.DOCUMENT -> Icons.Filled.Description
            EntityType.DOOR -> Filled.SingleWingDoor
            EntityType.DRUG -> Filled.GenericObject
            EntityType.DRUG_RAW_MATERIAL -> Filled.GenericObject
            EntityType.EVENT -> Filled.GenericObject
            EntityType.EVENT_RELATION -> Filled.GenericObject
            EntityType.EXPLOSIVE_DEVICE -> Filled.GenericObject
            EntityType.EXPLOSIVE_SUBSTANCE -> Filled.GenericObject
            EntityType.FIREARM -> Filled.GenericObject
            EntityType.FLOOR -> Filled.Floor
            EntityType.IMAGE -> Icons.Filled.Image
            EntityType.GENERAL_RELATION -> Filled.GenericObject
            EntityType.IMAGE_TAG -> Filled.GenericObject
            EntityType.INVESTIGATION -> Icons.Filled.Folder
            EntityType.INVESTIGATION_RELATION -> Filled.GenericObject
            EntityType.LICENSE_PLATE -> Filled.GenericObject
            EntityType.MEDICINE -> Filled.GenericObject
            EntityType.MOTOR_VEHICLE -> Filled.GenericObject
            EntityType.AMMUNITION -> Filled.GenericObject
            EntityType.NOTE -> Icons.Filled.Notes
            EntityType.PAYMENT_CARD -> Filled.PaymentCard
            EntityType.PERSON -> Icons.Filled.Person
            EntityType.PERSON_GROUP -> Icons.Filled.Groups
            EntityType.PHYSICAL_TRACE -> Icons.Filled.AddLocation
            EntityType.POINT_CLOUD -> Filled.GenericObject
            EntityType.PORTABLE_OBJECT -> Filled.GenericObject
            EntityType.RAIL_VEHICLE -> Filled.GenericObject
            EntityType.RECORD -> Filled.GenericObject
            EntityType.SITE_RELATION -> Filled.GenericObject
            EntityType.SKETCH -> Filled.GenericObject
            EntityType.ROOM -> Filled.Room
            EntityType.SOME_OBJECT -> Icons.Filled.HelpCenter
            EntityType.SOME_SITE -> Filled.SomeSite
            EntityType.SOME_VEHICLE -> Filled.GenericObject
            EntityType.SOVEREIGN_ACT -> Filled.GenericObject
            EntityType.SOVEREIGN_ACT_RELATION -> Filled.GenericObject
            EntityType.TOPOLOGICAL_RELATION -> Filled.GenericObject
            EntityType.USER_SETTINGS -> Filled.GenericObject
            EntityType.VIDEO -> Icons.Filled.SmartDisplay
            EntityType.WALL -> Filled.GenericObject
            EntityType.WATERCRAFT -> Filled.GenericObject
            EntityType.WEAPON_OF_MASS_DESTRUCTION -> Filled.GenericObject
            EntityType.WEAPON_PART -> Filled.GenericObject
            EntityType.WEAPON_SYSTEM -> Filled.GenericObject
            EntityType.WINDOW -> Filled.Window
        }
    }

}