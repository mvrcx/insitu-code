package p20.insitu.stateHandler

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.RememberObserver
import androidx.compose.runtime.mutableStateOf
import co.touchlab.kermit.Logger
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.koin.core.component.KoinComponent
import p20.insitu.nav.NavAction
import p20.insitu.resources.Language
import p20.insitu.util.ListSortStyle
import p20.insitu.util.SnackbarType
import p20.insitu.util.TabType
import p20.insitu.util.userMessages.UserMessage

class UiStateHandler(
    private val log: Logger
) : KoinComponent {

    private val _isExpanded = MutableStateFlow<Boolean>(
        false
    )
    val isExpanded: StateFlow<Boolean> = _isExpanded
    fun isExpanded(value: Boolean) {
        _isExpanded.value = value
    }

    var specificBackNavDestination: NavAction? = null

    private val selectedTab: MutableMap<String, TabType?> = mutableMapOf()
    fun setSelectedTab(screen: String, tab: TabType?) {
        selectedTab[screen] = tab
    }
    fun getSelectedTab(screen: String): TabType? {
        return selectedTab[screen]
    }
    fun clearSelectedTab(){
        selectedTab.clear()
    }

    private val _language = MutableStateFlow<Language>(
        Language.DE
    )
    val language: StateFlow<Language> = _language
    fun setLanguage(language: Language) {
        _language.value = language
    }

    private val _docuMode = MutableStateFlow<Boolean>(
        false
    )
    val docuMode: StateFlow<Boolean> = _docuMode
    fun activateDocuMode() {
        _docuMode.value = true
    }

    fun deactivateDocuMode() {
        _docuMode.value = false
        _showLeaveDocuModeDialog.value = false
    }

    private val _editMode = MutableStateFlow<Boolean>(
        false
    )
    val editMode: StateFlow<Boolean> = _editMode
    fun activateEditMode() {
        _editMode.value = true
    }

    fun activateEditModeForNewEntity() {
        _editMode.value = true
        _newEntity.value = true
    }

    fun deactivateEditMode() {
        _editMode.value = false
        _newEntity.value = false
        _pendingChanges.value = false
        _showPendingChangesDialog.value = false
        _remotePendingChanges.value = false
        _missingMandatoryValues.value = false
    }

    fun deletedEntry() {

    }

    // TODO this needs refactoring, we are using two different ways to determine if we are in the
    //  process of creating a new entity: see entity screens -> most of them check if
    //  constructor parameter entityId == null -> entityCreation = true
    private val _newEntity = MutableStateFlow<Boolean>(
        false
    )
    val newEntity: StateFlow<Boolean> = _newEntity

    private val _pendingChanges = MutableStateFlow<Boolean>(
        false
    )
    val pendingChanges: StateFlow<Boolean> = _pendingChanges
    fun setPendingChanges(value: Boolean) {
        _pendingChanges.value = value
    }

    private val _remotePendingChanges = MutableStateFlow<Boolean>(
        false
    )
    val remotePendingChanges: StateFlow<Boolean> = _remotePendingChanges
    fun setRemotePendingChanges(value: Boolean) {
        _remotePendingChanges.value = value
    }

    private val _missingMandatoryValues = MutableStateFlow<Boolean>(
        false
    )
    val missingMandatoryValues: StateFlow<Boolean> = _missingMandatoryValues
    fun setMissingMandatoryValues(value: Boolean) {
        _missingMandatoryValues.value = value
    }

    private val _userMessage = MutableStateFlow<UserMessage?>(
        null
    )
    val userMessage: StateFlow<UserMessage?> = _userMessage
    fun setUserMessage(userMessage: UserMessage) {
        _userMessage.value = userMessage
    }
    fun clearUserMessage() {
        _userMessage.value = null
    }

    private val _listSortStyle = MutableStateFlow<ListSortStyle>(
        ListSortStyle.NAME_DOWN
    )
    val listSortStyle: StateFlow<ListSortStyle> = _listSortStyle
    fun setListSortStyle(listSortStyle: ListSortStyle) {
        _listSortStyle.value = listSortStyle
    }

    // Dialogs
    private val _showPendingChangesDialog = MutableStateFlow<Boolean>(
        false
    )
    val showPendingChangesDialog: StateFlow<Boolean> = _showPendingChangesDialog
    fun showPendingChangesDialog(value: Boolean) {
        _showPendingChangesDialog.value = value
    }

    //Display SnackBar
    private val _showSnackBar = MutableStateFlow<Boolean>(false)
    val showSnackBar: StateFlow<Boolean> = _showSnackBar
    fun showSnackBar(value: Boolean) {
        _showSnackBar.value = value
    }

    private val _snackbarType =MutableStateFlow<SnackbarType>(SnackbarType.NONE)
    val snackbarType: StateFlow<SnackbarType> = _snackbarType
    fun snackbarType(value: SnackbarType) {
        _snackbarType.value = value
    }

    // Delete Dialog
    private val _showDeleteDialog = MutableStateFlow<Boolean>(
        false
    )
    val showDeleteDialog: StateFlow<Boolean> = _showDeleteDialog
    fun showDeleteDialog(value: Boolean) {
        _showDeleteDialog.value = value
    }

    // Leave Dialog
    private val _showLeaveDocuModeDialog = MutableStateFlow<Boolean>(
        false
    )
    val showLeaveDocuModeDialog: StateFlow<Boolean> = _showLeaveDocuModeDialog
    fun showLeaveDocuModeDialog(value: Boolean) {
        _showLeaveDocuModeDialog.value = value
    }

    // Annotation filter settings
    private val _showNestedAnnotations = MutableStateFlow<Boolean>(false)
    val showNestedAnnotations: StateFlow<Boolean> = _showNestedAnnotations
    fun setShowNestedAnnotations(value: Boolean) {
        _showNestedAnnotations.value = value
    }

    private val _showUserAnnotationsOnly = MutableStateFlow<Boolean>(false)
    val showUserAnnotationsOnly: StateFlow<Boolean> = _showUserAnnotationsOnly
    fun setShowUserAnnotationsOnly(value: Boolean) {
        _showUserAnnotationsOnly.value = value
    }

    fun annotationFiltersSet(tabType: TabType):Boolean{
        return when (tabType) {
            TabType.NOTE_ANNOTATIONS -> {
                showNestedAnnotations.value || showUserAnnotationsOnly.value
            }
            TabType.IMAGE_ANNOTATIONS -> {
                showNestedAnnotations.value || showUserAnnotationsOnly.value
            }
            TabType.AUDIO_ANNOTATIONS -> {
                showNestedAnnotations.value || showUserAnnotationsOnly.value
            }
            TabType.VIDEO_ANNOTATIONS -> {
                showNestedAnnotations.value || showUserAnnotationsOnly.value
            }
            else -> false
        }
    }
}