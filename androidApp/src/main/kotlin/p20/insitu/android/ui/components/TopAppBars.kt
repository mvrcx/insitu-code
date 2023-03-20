package p20.insitu.android.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import p20.insitu.android.ui.components.buttons.IconButtons
import p20.insitu.android.ui.components.dialogs.AlertDialogs
import p20.insitu.nav.NavAction
import p20.insitu.nav.NavDestination
import p20.insitu.resources.strings.TitleStrings
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.viewmodels.entities.EntityViewModel
import p20.insitu.android.ui.components.dimen.FontSize
import p20.insitu.stateHandler.SessionHandler

object TopAppBars {

    @Composable
    fun ReleaseNotes(
        navigationState: MutableState<NavAction?>,
        uiStateHandler: UiStateHandler
    ) = TopAppBar(
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
    ) {
        val language = uiStateHandler.language.collectAsState()
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButtons.Back(language.value) {
                navigationState.value = NavDestination.BACK.navigate()
            }
            Text(
                text = TitleStrings.releaseNotes(language.value),
                fontSize = FontSize.medium
            )
            Spacer(modifier = Modifier.weight(1.0f))
        }
    }

    @Composable
    fun Help(
        navigationState: MutableState<NavAction?>,
        uiStateHandler: UiStateHandler
    ) = TopAppBar(
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
    ) {
        val language = uiStateHandler.language.collectAsState()
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButtons.Back(language.value) {
                navigationState.value = NavDestination.BACK.navigate()
            }
            Text(
                text = TitleStrings.help(language.value),
                fontSize = FontSize.medium
            )
            Spacer(modifier = Modifier.weight(1.0f))
        }
    }

    @Composable
    fun Settings(
        navigationState: MutableState<NavAction?>,
        uiStateHandler: UiStateHandler
    ) = TopAppBar(
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
    ) {
        val language = uiStateHandler.language.collectAsState()

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left buttons
            IconButtons.Back(language.value) {
                navigationState.value = NavDestination.BACK.navigate()
            }
            // Title (fills up all remaining space)
            Text.AutoResizeText(
                text = TitleStrings.settings(language.value),
                maxLines = 1,
                fontSizeRange = Text.FontSizeRange(
                    min = FontSize.small,
                    max = FontSize.medium,
                ),
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1.0f)
            )
        }
    }

    @Composable
    fun FilterSettings(
        navigationState: MutableState<NavAction?>,
        uiStateHandler: UiStateHandler
    ) = TopAppBar(
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
    ) {
        val language = uiStateHandler.language.collectAsState()
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButtons.Back(language.value) {
                navigationState.value = NavDestination.BACK.navigate()
            }
            Text(
                text = TitleStrings.filterSettings(language.value),
                fontSize = FontSize.medium
            )
            Spacer(modifier = Modifier.weight(1.0f))
        }
    }

    @Composable
    fun DocuMode(
        navigationState: MutableState<NavAction?>,
        sessionHandler: SessionHandler,
        uiStateHandler: UiStateHandler,
        showEditButton: Boolean = false,
        showFilterButton: Boolean = false,
        filterOn: Boolean = false,
        docuObjectViewModel: EntityViewModel<*>? = null,
        onFilterBtnClick: () -> Unit = {}
    ) = if (uiStateHandler.editMode.collectAsState().value && docuObjectViewModel != null) {
        DocuModeEditMode(
            navigationState,
            sessionHandler,
            uiStateHandler,
            docuObjectViewModel,
        )
    } else {
        DocuModeDefault(
            navigationState = navigationState,
            sessionHandler = sessionHandler,
            uiStateHandler = uiStateHandler,
            showEditButton = showEditButton,
            showFilterButton = showFilterButton,
            filterOn = filterOn,
            onFilterBtnClick = onFilterBtnClick
        )
    }

    @Composable
    fun DocuModeEditMode(
        navigationState: MutableState<NavAction?>,
        sessionHandler: SessionHandler,
        uiStateHandler: UiStateHandler,
        viewModel: EntityViewModel<*>
    ) =
        Column {
            val language = uiStateHandler.language.collectAsState()
            val newEntity = uiStateHandler.newEntity.collectAsState()
            val missingMandatoryValues = uiStateHandler.missingMandatoryValues.collectAsState()
            val docuObject = sessionHandler.docuHandler.docuObject.collectAsState()

            TopAppBar(
                backgroundColor = MaterialTheme.colors.primaryVariant,
                contentColor = MaterialTheme.colors.onPrimary,
            ) {
                // Manage visibility of pending changes dialog
                val showPendingChangesDialog =
                    uiStateHandler.showPendingChangesDialog.collectAsState(false)
                if (showPendingChangesDialog.value) {
                    AlertDialogs.PendingChanges(
                        onDismiss = {
                            uiStateHandler.showPendingChangesDialog(false)
                        },
                        onConfirm = {
                            uiStateHandler.deactivateEditMode()
                            viewModel.discardChangesAndResetEntity()
                        },
                        language = language.value
                    )
                }

                // Manage visibility delete dialog
                val showDeleteDialog =
                    uiStateHandler.showDeleteDialog.collectAsState(false)
                if (showDeleteDialog.value) {
                    AlertDialogs.Delete(
                        onDismiss = {
                            uiStateHandler.showDeleteDialog(false)
                        },
                        onConfirm = {
                            uiStateHandler.deactivateEditMode()
                            viewModel.delete()

                        },
                        language = language.value
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Left buttons
                    IconButtons.Close(language.value) {
                        if (viewModel.checkForPendingChanges()) {
                            uiStateHandler.showPendingChangesDialog(true)
                        } else {
                            navigationState.value = NavDestination.BACK.navigate()
                            uiStateHandler.deactivateEditMode()
                        }
                    }
                    // Spacer fills up remaining space
                    Spacer(modifier = Modifier.weight(1.0f))
                    // Right buttons
                    if (!newEntity.value) {
                        IconButtons.Delete(language.value) {
                            uiStateHandler.showDeleteDialog(true)
                        }

                        IconButtons.Save(
                            language = language.value,
                            enabled = !missingMandatoryValues.value
                        ) {
                            viewModel.save()
                        }
                        //IconButtons.Save(language = language.value, enabled = ) {

                        }
                    }
                }
            }

    @Composable
    fun MySnackbar(
        message: String, actionLabel: String, duration: SnackbarDuration = SnackbarDuration.Short
    ) {
        val snackbarHostState = remember { SnackbarHostState() }

        LaunchedEffect(snackbarHostState) {
            snackbarHostState.showSnackbar(message, actionLabel, duration = duration)
        }
        Box(
            Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter
        ) {
            SnackbarHost(
                hostState = snackbarHostState
            )
        }
    }

    @Composable
    fun DocuModeDefault(
        navigationState: MutableState<NavAction?>,
        sessionHandler: SessionHandler,
        uiStateHandler: UiStateHandler,
        showEditButton: Boolean,
        showFilterButton: Boolean,
        filterOn: Boolean,
        onFilterBtnClick: () -> Unit
    ) = Column {
        val language = uiStateHandler.language.collectAsState()

        TopAppBar(
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.onPrimary,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Icon
                AlertDialogs.InsituInfo(language.value)
                // Title (fills up all remaining space)
                Text.AutoResizeText(
                    text = TitleStrings.insitu(language.value),
                    maxLines = 1,
                    fontSizeRange = Text.FontSizeRange(
                        min = FontSize.small,
                        max = FontSize.medium,
                    ),
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1.0f) // <-- that's the magic
                )
                // Right buttons / menu
                if (showEditButton) {
                    IconButtons.Edit(language.value) {
                        uiStateHandler.activateEditMode()
                    }
                }
                if (showFilterButton) {
                    IconButtons.Filter(
                        language = language.value,
                        filterOn = filterOn
                    ) {
                        onFilterBtnClick()
                    }
                }
                TopBarDropDownMenu(
                    navigationState = navigationState,
                    sessionHandler = sessionHandler,
                    uiStateHandler = uiStateHandler
                )
            }
        }
    }

    @Composable
    fun BaseEntityDetails(
        title: String,
        navigationState: MutableState<NavAction?>,
        sessionHandler: SessionHandler,
        uiStateHandler: UiStateHandler,
        viewModel: EntityViewModel<*>,
        showEditButton: Boolean,
        showFilterButton: Boolean = false,
        filterOn: Boolean = false,
        onFilterBtnClick: () -> Unit = {}
    ) = if (uiStateHandler.editMode.collectAsState().value) {
        BaseEntityEditMode(
            navigationState = navigationState,
            uiStateHandler = uiStateHandler,
            viewModel = viewModel
        )
    } else {
        BaseEntityDefault(
            title = title,
            navigationState = navigationState,
            sessionHandler = sessionHandler,
            uiStateHandler = uiStateHandler,
            showEditButton = showEditButton,
            showFilterButton = showFilterButton,
            filterOn = filterOn,
            onFilterBtnClick = onFilterBtnClick
        )
    }

    @Composable
    fun ImagePager(
        navigationState: MutableState<NavAction?>,
        sessionHandler: SessionHandler,
        uiStateHandler: UiStateHandler,
        onEditButtonClick: () -> Unit
    ) =
        Column {
            val language = uiStateHandler.language.collectAsState()
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.onPrimary,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Left buttons
                    IconButtons.Back(language = language.value) {
                        navigationState.value = NavDestination.BACK.navigate()
                    }
                    // Title (fills up all remaining space)
                    Text.AutoResizeText(
                        text = TitleStrings.imageGallery(language.value),
                        maxLines = 1,
                        fontSizeRange = Text.FontSizeRange(
                            min = FontSize.small,
                            max = FontSize.medium,
                        ),
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1.0f)
                    )
                    // Right buttons / menu
                    IconButtons.Edit(language.value) {
                        onEditButtonClick()
                    }
                    TopBarDropDownMenu(
                        navigationState = navigationState,
                        sessionHandler = sessionHandler,
                        uiStateHandler = uiStateHandler
                    )
                }
            }
        }

    @Composable
    fun Main(
        title: String,
        navigationState: MutableState<NavAction?>,
        sessionHandler: SessionHandler,
        uiStateHandler: UiStateHandler,
        showBackNavigation: Boolean = true
    ) =
        Column {
            val language = uiStateHandler.language.collectAsState()

            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.onPrimary,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Left buttons
                    if (showBackNavigation) {
                        IconButtons.Back(
                            language = language.value,
                        ) {
                            navigationState.value = NavDestination.BACK.navigate()
                        }
                    } else {
                        AlertDialogs.InsituInfo(language.value)
                    }
                    // Title (fills up all remaining space)
                    Text.AutoResizeText(
                        text = title,
                        maxLines = 1,
                        fontSizeRange = Text.FontSizeRange(
                            min = FontSize.small,
                            max = FontSize.medium,
                        ),
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1.0f)
                    )
                    // Right buttons / menu
                    TopBarDropDownMenu(
                        navigationState = navigationState,
                        sessionHandler = sessionHandler,
                        uiStateHandler = uiStateHandler
                    )
                }
            }
        }

    @Composable
    fun Catalog(
        title: String,
        subTitle: String?,
        navigationState: MutableState<NavAction?>,
        sessionHandler: SessionHandler,
        uiStateHandler: UiStateHandler,
        showBackNavigation: Boolean = true
    ) =
        Column {
            val language = uiStateHandler.language.collectAsState()

            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.onPrimary,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Left buttons
                    if (showBackNavigation) {
                        IconButtons.Back(
                            language = language.value,
                        ) {
                            navigationState.value = NavDestination.BACK.navigate()
                        }
                    } else {
                        AlertDialogs.InsituInfo(language.value)
                    }
                    // Title (fills up all remaining space)
                    Column(modifier = Modifier.weight(1.0f)) {
                        Text.AutoResizeText(
                            text = title,
                            maxLines = 1,
                            fontSizeRange = Text.FontSizeRange(
                                min = FontSize.small,
                                max = FontSize.medium,
                            ),
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.h5
                        )
                        subTitle?.let {
                            Text(
                                text = it,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                style = MaterialTheme.typography.caption
                            )
                        }
                    }
                    // Right buttons / menu
                    TopBarDropDownMenu(
                        navigationState = navigationState,
                        sessionHandler = sessionHandler,
                        uiStateHandler = uiStateHandler
                    )
                }
            }
        }

    @Composable
    private fun BaseEntityDefault(
        title: String,
        navigationState: MutableState<NavAction?>,
        sessionHandler: SessionHandler,
        uiStateHandler: UiStateHandler,
        showEditButton: Boolean,
        showFilterButton: Boolean,
        filterOn: Boolean,
        onFilterBtnClick: () -> Unit
    ) =
        Column {
            val language = uiStateHandler.language.collectAsState()

            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.onPrimary,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Left buttons
                    IconButtons.Back(language.value) {
                        navigationState.value = NavDestination.BACK.navigate()
                    }
                    // Title (fills up all remaining space)
                    Text.AutoResizeText(
                        text = title,
                        maxLines = 1,
                        fontSizeRange = Text.FontSizeRange(
                            min = FontSize.small,
                            max = FontSize.medium,
                        ),
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1.0f)
                    )
                    // Right buttons / menu
                    if (showEditButton) {
                        IconButtons.Edit(language.value) {
                            uiStateHandler.activateEditMode()
                        }
                    }
                    if (showFilterButton) {
                        IconButtons.Filter(
                            language = language.value,
                            filterOn = filterOn
                        ) {
                            onFilterBtnClick()
                        }
                    }
                    TopBarDropDownMenu(
                        navigationState = navigationState,
                        sessionHandler = sessionHandler,
                        uiStateHandler = uiStateHandler
                    )
                }
            }
        }

    @Composable
    private fun BaseEntityEditMode(
        navigationState: MutableState<NavAction?>,
        uiStateHandler: UiStateHandler,
        viewModel: EntityViewModel<*>
    ) =
        TopAppBar(
            backgroundColor = MaterialTheme.colors.primaryVariant,
            contentColor = MaterialTheme.colors.onPrimary,
        ) {
            val language = uiStateHandler.language.collectAsState()
            val newEntity = uiStateHandler.newEntity.collectAsState()
            val missingMandatoryValues = uiStateHandler.missingMandatoryValues.collectAsState()

            // Manage visibility of pending changes dialog
            val showPendingChangesDialog = uiStateHandler.showPendingChangesDialog.collectAsState(false)
            if (showPendingChangesDialog.value) {
                AlertDialogs.PendingChanges(
                    onDismiss = {
                        uiStateHandler.showPendingChangesDialog(false)
                    },
                    onConfirm = {
                        uiStateHandler.deactivateEditMode()
                        viewModel.discardChangesAndResetEntity()
                    },
                    language = language.value
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Left buttons
                IconButtons.Close(language.value) {
                    when {
                        viewModel.checkForPendingChanges() -> {
                            uiStateHandler.showPendingChangesDialog(true)
                        }
                        newEntity.value -> {
                            navigationState.value = NavDestination.BACK.navigate()
                            uiStateHandler.deactivateEditMode()
                        }
                        else -> {
                            uiStateHandler.deactivateEditMode()
                        }
                    }
                }
                // Spacer fills up the remaining space
                Spacer(modifier = Modifier.weight(1.0f))
                // Right buttons / menu
                if (!newEntity.value) {
                    IconButtons.Delete(language.value) {
                        viewModel.delete()
                    }
                }
                IconButtons.Save(
                    language = language.value,
                    enabled = !missingMandatoryValues.value
                ) {
                    viewModel.save()
                }
            }
        }
}
