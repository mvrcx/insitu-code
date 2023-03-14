package p20.insitu.nav

enum class NavRoute {

    APARTMENT,
    AUDIO,
    BUILDING,
    CRIME_SCENE,
    CRIMINAL_OFFENSE,
    DNA_TRACE,
    DOOR,
    FLOOR,
    IMAGE,
    INVESTIGATION,
    NOTE,
    PERSON,
    PHYSICAL_TRACE,
    ROOM,
    SOME_OBJECT,
    SOME_SITE,
    VIDEO,

    DOCU_MODE_HOME,
    DOCU_MODE_LIST,
    DOCU_MODE_DETAILS,

    CATALOG_GROUPS,
    CATALOG_CATEGORIES,
    CATALOG_SUB_CATEGORIES,
    CATALOG_ITEMS,

    AUDIO_FILTER_SETTINGS,
    AUDIO_RECORDER,
    BACK,
    CAMERA,
    HELP,
    IMAGE_FILTER_SETTINGS,
    IMAGE_PAGER,
    INVESTIGATION_LIST,
    LOGIN,
    LOGOUT,
    NOTE_FILTER_SETTINGS,
    QR_CODE_SCANNER,
    RELEASE_NOTES,
    SETTINGS,
    START,
    VIDEO_FILTER_SETTINGS,
    VIDEO_RECORDER,

    DEBUG_VIEW,
    FUNCTION_NOT_AVAILABLE
    ;

    override fun toString(): String {
        return super.toString().lowercase()
    }

    fun getNavDestination(): NavDestination {
        return when (this) {
            APARTMENT -> NavDestination.EntityDetailViews.Apartment()
            AUDIO -> NavDestination.EntityDetailViews.Audio()
            BUILDING -> NavDestination.EntityDetailViews.Building()
            CRIME_SCENE -> NavDestination.EntityDetailViews.CrimeScene()
            CRIMINAL_OFFENSE -> NavDestination.EntityDetailViews.CriminalOffense()
            DNA_TRACE -> NavDestination.EntityDetailViews.DNATrace()
            DOOR -> NavDestination.EntityDetailViews.Door()
            FLOOR -> NavDestination.EntityDetailViews.Floor()
            IMAGE -> NavDestination.EntityDetailViews.Image()
            INVESTIGATION -> NavDestination.EntityDetailViews.Investigation()
            NOTE -> NavDestination.EntityDetailViews.Note()
            PERSON -> NavDestination.EntityDetailViews.Person()
            PHYSICAL_TRACE -> NavDestination.EntityDetailViews.PhysicalTrace()
            ROOM -> NavDestination.EntityDetailViews.Room()
            SOME_OBJECT -> NavDestination.EntityDetailViews.SomeObject()
            SOME_SITE -> NavDestination.EntityDetailViews.SomeSite()
            VIDEO -> NavDestination.EntityDetailViews.Video()

            DOCU_MODE_HOME -> NavDestination.DocuMode.Home
            DOCU_MODE_LIST -> NavDestination.DocuMode.List
            DOCU_MODE_DETAILS -> NavDestination.DocuMode.Details

            CATALOG_GROUPS -> NavDestination.Catalog.Groups
            CATALOG_CATEGORIES -> NavDestination.Catalog.Categories
            CATALOG_SUB_CATEGORIES -> NavDestination.Catalog.SubCategories
            CATALOG_ITEMS -> NavDestination.Catalog.Items

            AUDIO_FILTER_SETTINGS -> NavDestination.AudioFilterSettings
            AUDIO_RECORDER -> NavDestination.AudioRecorder
            BACK -> NavDestination.BACK
            CAMERA -> NavDestination.Camera
            HELP -> NavDestination.Help
            IMAGE_FILTER_SETTINGS -> NavDestination.ImageFilterSettings
            IMAGE_PAGER -> NavDestination.ImagePager
            INVESTIGATION_LIST -> NavDestination.InvestigationList
            LOGIN -> NavDestination.Login
            LOGOUT -> NavDestination.Logout
            NOTE_FILTER_SETTINGS -> NavDestination.NoteFilterSettings
            QR_CODE_SCANNER -> NavDestination.QrCodeScanner
            RELEASE_NOTES -> NavDestination.ReleaseNotes
            SETTINGS -> NavDestination.Settings
            START -> NavDestination.Start
            VIDEO_FILTER_SETTINGS -> NavDestination.VideoFilterSettings
            VIDEO_RECORDER -> NavDestination.VideoRecorder

            DEBUG_VIEW -> NavDestination.DebugView
            FUNCTION_NOT_AVAILABLE -> NavDestination.FunctionNotAvailable
        }
    }
}