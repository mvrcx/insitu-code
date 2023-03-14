package p20.insitu.nav

import p20.insitu.catalogues.CatalogCategory
import p20.insitu.catalogues.CatalogCategoryGroup
import p20.insitu.catalogues.CatalogSubCategory
import p20.insitu.model.entities.*
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.util.TabType

sealed class NavDestination(val baseRoute: NavRoute) {
    protected var _route: String = baseRoute.toString()
    protected val _args: MutableMap<NavArg, String?> = mutableMapOf()

    object DebugView : NavDestination(NavRoute.DEBUG_VIEW)
    object FunctionNotAvailable : NavDestination(NavRoute.FUNCTION_NOT_AVAILABLE)

    object AudioFilterSettings: NavDestination(NavRoute.AUDIO_FILTER_SETTINGS)
    object AudioRecorder : NavDestination(NavRoute.AUDIO_RECORDER)
    object BACK : NavDestination(NavRoute.BACK)
    object Camera : NavDestination(NavRoute.CAMERA)
    object Help : NavDestination(NavRoute.HELP)
    object ImageFilterSettings: NavDestination(NavRoute.IMAGE_FILTER_SETTINGS)
    object ImagePager : NavDestination(NavRoute.IMAGE_PAGER)
    object InvestigationList : NavDestination(NavRoute.INVESTIGATION_LIST)
    object Login : NavDestination(NavRoute.LOGIN)
    object Logout : NavDestination(NavRoute.LOGIN) // TODO should there be an actual logout screen?
    object NoteFilterSettings: NavDestination(NavRoute.NOTE_FILTER_SETTINGS)
    object QrCodeScanner : NavDestination(NavRoute.QR_CODE_SCANNER)
    object ReleaseNotes : NavDestination(NavRoute.RELEASE_NOTES)
    object Settings : NavDestination(NavRoute.SETTINGS)
    object Start : NavDestination(NavRoute.START)
    object VideoFilterSettings: NavDestination(NavRoute.VIDEO_FILTER_SETTINGS)
    object VideoRecorder : NavDestination(NavRoute.VIDEO_RECORDER)

    object Catalog {
        object Groups : NavDestination(NavRoute.CATALOG_GROUPS)
        object Categories : NavDestination(NavRoute.CATALOG_CATEGORIES)
        object SubCategories : NavDestination(NavRoute.CATALOG_SUB_CATEGORIES)
        object Items : NavDestination(NavRoute.CATALOG_ITEMS)
    }

    object DocuMode {
        object Home : NavDestination(NavRoute.DOCU_MODE_HOME)
        object List : NavDestination(NavRoute.DOCU_MODE_LIST)
        object Details : NavDestination(NavRoute.DOCU_MODE_DETAILS)
    }

    sealed class EntityDetailViews(
        baseRoute: NavRoute,
        val entityId: String?,
        val specificBackDestination: NavRoute?,
        val catalogCode: String?
    ) : NavDestination(baseRoute) {
        class Apartment(
            entityId: String? = null,
            specificBackDestination: NavRoute? = null,
            catalogCode: String? = null
        ) :
            EntityDetailViews(NavRoute.APARTMENT, entityId, specificBackDestination, catalogCode)

        class Audio(
            entityId: String? = null,
            specificBackDestination: NavRoute? = null,
            catalogCode: String? = null
        ) :
            EntityDetailViews(NavRoute.AUDIO, entityId, specificBackDestination, catalogCode)

        class Building(
            entityId: String? = null,
            specificBackDestination: NavRoute? = null,
            catalogCode: String? = null
        ) :
            EntityDetailViews(NavRoute.BUILDING, entityId, specificBackDestination, catalogCode)

        class CrimeScene(
            entityId: String? = null,
            specificBackDestination: NavRoute? = null,
            catalogCode: String? = null
        ) :
            EntityDetailViews(NavRoute.CRIME_SCENE, entityId, specificBackDestination, catalogCode)

        class CriminalOffense(
            entityId: String? = null,
            specificBackDestination: NavRoute? = null,
            catalogCode: String? = null
        ) :
            EntityDetailViews(
                NavRoute.CRIMINAL_OFFENSE,
                entityId,
                specificBackDestination,
                catalogCode
            )

        class DNATrace(
            entityId: String? = null,
            specificBackDestination: NavRoute? = null,
            catalogCode: String? = null
        ) :
            EntityDetailViews(NavRoute.DNA_TRACE, entityId, specificBackDestination, catalogCode)

        class Door(
            entityId: String? = null,
            specificBackDestination: NavRoute? = null,
            catalogCode: String? = null
        ) :
            EntityDetailViews(NavRoute.DOOR, entityId, specificBackDestination, catalogCode)

        class Floor(
            entityId: String? = null,
            specificBackDestination: NavRoute? = null,
            catalogCode: String? = null
        ) :
            EntityDetailViews(NavRoute.FLOOR, entityId, specificBackDestination, catalogCode)

        class Image(
            entityId: String? = null,
            specificBackDestination: NavRoute? = null,
            catalogCode: String? = null
        ) :
            EntityDetailViews(NavRoute.IMAGE, entityId, specificBackDestination, catalogCode)

        class Investigation(
            entityId: String? = null,
            specificBackDestination: NavRoute? = null,
            catalogCode: String? = null
        ) :
            EntityDetailViews(
                NavRoute.INVESTIGATION,
                entityId,
                specificBackDestination,
                catalogCode
            )

        class Note(
            entityId: String? = null,
            specificBackDestination: NavRoute? = null,
            catalogCode: String? = null
        ) :
            EntityDetailViews(NavRoute.NOTE, entityId, specificBackDestination, catalogCode)

        class Person(
            entityId: String? = null,
            specificBackDestination: NavRoute? = null,
            catalogCode: String? = null
        ) :
            EntityDetailViews(
                NavRoute.PERSON,
                entityId,
                specificBackDestination,
                catalogCode
            )

        class PhysicalTrace(
            entityId: String? = null,
            specificBackDestination: NavRoute? = null,
            catalogCode: String? = null
        ) :
            EntityDetailViews(
                NavRoute.PHYSICAL_TRACE,
                entityId,
                specificBackDestination,
                catalogCode
            )

        class Room(
            entityId: String? = null,
            specificBackDestination: NavRoute? = null,
            catalogCode: String? = null
        ) :
            EntityDetailViews(NavRoute.ROOM, entityId, specificBackDestination, catalogCode)

        class SomeObject(
            entityId: String? = null,
            specificBackDestination: NavRoute? = null,
            catalogCode: String? = null
        ) :
            EntityDetailViews(NavRoute.SOME_OBJECT, entityId, specificBackDestination, catalogCode)

        class SomeSite(
            entityId: String? = null,
            specificBackDestination: NavRoute? = null,
            catalogCode: String? = null
        ) :
            EntityDetailViews(NavRoute.SOME_SITE, entityId, specificBackDestination, catalogCode)

        class Video(
            entityId: String? = null,
            specificBackDestination: NavRoute? = null,
            catalogCode: String? = null
        ) :
            EntityDetailViews(NavRoute.VIDEO, entityId, specificBackDestination, catalogCode)

        override fun route(): String {
            var argsStr = ""
            entityId?.let {
                argsStr += "${NavArg.ENTITY_ID.argName}=${it}&"
            }
            specificBackDestination?.let {
                argsStr += "${NavArg.DESTINATION.argName}=${it.name}&"
            }
            catalogCode?.let {
                argsStr += "${NavArg.CATALOG_CODE.argName}=${it}&"
            }
            _args.forEach {
                if (it.value != null) {
                    argsStr += "${it.key.argName}=${it.value}&"
                }
            }
            argsStr = argsStr.trimEnd('&')
            _route = if (argsStr.isNotBlank()) "$baseRoute?$argsStr" else baseRoute.toString()
            return _route
        }
    }

    open fun route(): String {
        var argsStr = ""
        _args.forEach {
            if (it.value != null) {
                argsStr += "${it.key.argName}=${it.value}&"
            }
        }
        argsStr = argsStr.trimEnd('&')
        _route = if (argsStr.isNotBlank()) "$baseRoute?$argsStr" else baseRoute.toString()
        return _route
    }

    fun withCatalogArgs(
        categoryGroup: CatalogCategoryGroup?,
        category: CatalogCategory?,
        subCategory: CatalogSubCategory?,
        sourceDestination: NavRoute?
    ): NavDestination {
        _args.clear()
        categoryGroup?.let {
            _args[NavArg.CATALOG_GROUP] = it.toString()
        }
        category?.let {
            _args[NavArg.CATALOG_CATEGORY] = it.toString()
        }
        subCategory?.let {
            _args[NavArg.CATALOG_SUB_CATEGORY] = it.toString()
        }
        sourceDestination?.let {
            _args[NavArg.DESTINATION] = it.name
        }
        return this
    }

    fun withMessage(message: String): NavDestination {
        _args[NavArg.MESSAGE] = message
        return this
    }

    fun setSelectedTab(tabType: TabType): NavDestination {
        _args[NavArg.INITIAL_TAB] = tabType.toString()
        return this
    }

    fun withImagePagerArgs(entityId: String, imageIndex: Int, showNested: Boolean): NavDestination {
        _args[NavArg.ENTITY_ID] = entityId
        _args[NavArg.IMAGE_INDEX] = imageIndex.toString()
        _args[NavArg.SHOW_NESTED] = showNested.toString()
        return this
    }

    fun navigate(launchSingleTop: Boolean = false): NavAction {
        return NavAction(
            destination = this,
            navOptions = NavOptions.Navigate(launchSingleTop)
        )
    }

    fun popUpTo(
        popUpDestination: NavDestination = this,
        launchSingleTop: Boolean = false,
        inclusive: Boolean = true,
        saveState: Boolean = false,
        restoreState: Boolean = false
    ): NavAction {
        return NavAction(
            destination = this,
            navOptions = NavOptions.PopUpTo(
                popUpDestination = popUpDestination,
                launchSingleTop = launchSingleTop,
                inclusive = inclusive,
                saveState = saveState,
                restoreState = restoreState
            )
        )
    }

    companion object {
        fun getEntityDetailView(entity: IBaseEntity): NavDestination {
            return when (entity) {
                is Apartment -> EntityDetailViews.Apartment(entity.id)
                is Audio -> EntityDetailViews.Audio(entity.id)
                is Building -> EntityDetailViews.Building(entity.id)
                is CrimeScene -> EntityDetailViews.CrimeScene(entity.id)
                is CriminalOffense -> EntityDetailViews.CriminalOffense(entity.id)
                is DNATrace -> EntityDetailViews.DNATrace(entity.id)
                is Door -> EntityDetailViews.Door(entity.id)
                is Floor -> EntityDetailViews.Floor(entity.id)
                is Image -> EntityDetailViews.Image(entity.id)
                is Investigation -> EntityDetailViews.Investigation(entity.id)
                is Note -> EntityDetailViews.Note(entity.id)
                is Person -> EntityDetailViews.Person(entity.id)
                is PhysicalTrace -> EntityDetailViews.PhysicalTrace(entity.id)
                is Room -> EntityDetailViews.Room(entity.id)
                is SomeObject -> EntityDetailViews.SomeObject(entity.id)
                is SomeSite -> EntityDetailViews.SomeSite(entity.id)
                is Video -> EntityDetailViews.Video(entity.id)
                else -> FunctionNotAvailable
            }
        }

        fun getEntityCreationView(
            entityType: EntityType,
            onCreationFinishedDestination: NavRoute? = null,
            catalogCode: String? = null
        ): NavDestination {
            return when (entityType) {
                EntityType.APARTMENT -> EntityDetailViews.Apartment(
                    null,
                    onCreationFinishedDestination,
                    catalogCode
                )
                EntityType.AUDIO -> EntityDetailViews.Audio(
                    null,
                    onCreationFinishedDestination,
                    catalogCode
                )
                EntityType.BUILDING -> EntityDetailViews.Building(
                    null,
                    onCreationFinishedDestination,
                    catalogCode
                )
                EntityType.CRIME_SCENE -> EntityDetailViews.CrimeScene(
                    null,
                    onCreationFinishedDestination,
                    catalogCode
                )
                EntityType.CRIMINAL_OFFENSE -> EntityDetailViews.CriminalOffense(
                    null,
                    onCreationFinishedDestination,
                    catalogCode
                )
                EntityType.DNA_TRACE -> EntityDetailViews.DNATrace(
                    null,
                    onCreationFinishedDestination,
                    catalogCode
                )
                EntityType.DOOR -> EntityDetailViews.Door(
                    null,
                    onCreationFinishedDestination,
                    catalogCode
                )
                EntityType.FLOOR -> EntityDetailViews.Floor(
                    null,
                    onCreationFinishedDestination,
                    catalogCode
                )
                EntityType.INVESTIGATION -> EntityDetailViews.Investigation(
                    null,
                    onCreationFinishedDestination,
                    catalogCode
                )
                EntityType.NOTE -> EntityDetailViews.Note(
                    null,
                    onCreationFinishedDestination,
                    catalogCode
                )
                EntityType.PERSON -> EntityDetailViews.Person(
                    null,
                    onCreationFinishedDestination,
                    catalogCode
                )
                EntityType.PHYSICAL_TRACE -> EntityDetailViews.PhysicalTrace(
                    null,
                    onCreationFinishedDestination,
                    catalogCode
                )
                EntityType.ROOM -> EntityDetailViews.Room(
                    null,
                    onCreationFinishedDestination,
                    catalogCode
                )
                EntityType.SOME_OBJECT -> EntityDetailViews.SomeObject(
                    null,
                    onCreationFinishedDestination,
                    catalogCode
                )
                EntityType.SOME_SITE -> EntityDetailViews.SomeSite(
                    null,
                    onCreationFinishedDestination,
                    catalogCode
                )
                EntityType.VIDEO -> EntityDetailViews.Video(
                    null,
                    onCreationFinishedDestination,
                    catalogCode
                )
                else -> FunctionNotAvailable
            }
        }

        fun getDebugView(message: String = "DebugView"): NavDestination {
            return DebugView.withMessage(message)
        }
    }
}