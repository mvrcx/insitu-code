package p20.insitu.nav

sealed class NavOptions {
    class Navigate(
        val launchSingleTop: Boolean
    ) : NavOptions()

    class PopUpTo(
        val popUpDestination: NavDestination,
        val inclusive: Boolean,
        val launchSingleTop: Boolean,
        val saveState: Boolean,
        val restoreState: Boolean
    ) : NavOptions()
}
