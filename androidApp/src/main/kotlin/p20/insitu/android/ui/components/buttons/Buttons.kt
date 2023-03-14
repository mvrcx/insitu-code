package p20.insitu.android.ui.components.buttons

import androidx.compose.animation.*
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import p20.insitu.android.rememberNavigationState
import p20.insitu.resources.Language
import p20.insitu.resources.strings.ButtonStrings
import p20.insitu.resources.strings.IconContentDescriptions
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.android.ui.components.dimen.ButtonSize
import p20.insitu.android.ui.components.dimen.CardSize
import p20.insitu.android.ui.components.dimen.Padding
import p20.insitu.android.util.drawableResource
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.nav.NavDestination
import p20.insitu.resources.strings.EntityTypeStrings
import p20.insitu.util.TabType

object Buttons {

    @Composable
    fun AddAnnotation(selectedTab: TabType?, language: Language) {
        // Setup navigation change listener
        val navigationState = rememberNavigationState()
        when (selectedTab) {
            TabType.NOTE_ANNOTATIONS -> {
                AddBaseEntity(
                    title = EntityTypeStrings.typeString(EntityType.NOTE, language)
                ) {
                    navigationState.value =
                        NavDestination.getEntityCreationView(EntityType.NOTE).navigate()
                }
            }
            TabType.IMAGE_ANNOTATIONS -> {
                AddBaseEntity(
                    title = EntityTypeStrings.typeString(EntityType.IMAGE, language)
                ) {
                    navigationState.value = NavDestination.Camera.navigate()
                }
            }
            TabType.AUDIO_ANNOTATIONS -> {
                AddBaseEntity(
                    title = EntityTypeStrings.typeString(EntityType.AUDIO, language)
                ) {
                    navigationState.value = NavDestination.AudioRecorder.navigate()
                }
            }
            TabType.VIDEO_ANNOTATIONS -> {
                AddBaseEntity(
                    title = EntityTypeStrings.typeString(EntityType.VIDEO, language)
                ) {
                    navigationState.value = NavDestination.VideoRecorder.navigate()
                }
            }
            else -> {}
        }
    }

    @Composable
    fun AddBaseEntity(modifier: Modifier = Modifier, title: String, onClickAction: () -> Unit) {
        val mod: Modifier = modifier
        ExtendedFloatingActionButton(
            modifier = mod.padding(Padding.screen),
            text = { Text(text = title) },
            icon = { Icon(imageVector = Icons.Filled.Add, contentDescription = null) },
            onClick = { onClickAction() }
        )
    }

    @Composable
    fun ScrollToTop(onClickAction: () -> Unit) {
        FloatingActionButton(
            modifier = Modifier.padding(Padding.screen),
            onClick = { onClickAction() }
        ) { Icon(imageVector = Icons.Filled.ArrowUpward, contentDescription = null) }
    }

    @Composable
    fun ActionButton(caption: String, onClickAction: () -> Unit) {
        Button(
            onClick = { onClickAction() },
            shape = RoundedCornerShape(ButtonSize.corner_default),
            modifier = Modifier
                .height(ButtonSize.height_default)
                .width(ButtonSize.width_default)
        ) {
            Text(caption)
        }
    }

    @Composable
    fun Login(
        username: String,
        password: String,
        sessionHandler: SessionHandler,
        language: Language,
        authResult: (success: Boolean) -> Unit
    ) {
        // Returns a scope that's cancelled when LoginButton is removed from composition
        //val coroutineScope = rememberCoroutineScope()
        Button(
            onClick = {
                // DEV LOGIN -----------------------------------------------------------------------
                authResult(sessionHandler.devMaxHeadroomLogin(username, password))
                //authResult(sessionHandler.randomDevUserLogin(username, password))
                // ---------------------------------------------------------------------------------

                /*
                // Authentication via IAM (or local keycloak server)
                coroutineScope.launch {
                    authResult(sessionHandler.authenticate(username, password))
                }
                 */
            },
            shape = RoundedCornerShape(ButtonSize.corner_default),
            modifier = Modifier
                .height(ButtonSize.height_default)
                .width(ButtonSize.width_small)
        ) {
            Text(text = ButtonStrings.login(language))
        }
    }

    @Composable
    fun NewInvestigation(
        language: Language,
        onClickAction: () -> Unit
    ) {
        OutlinedButton(
            onClick = { onClickAction() },
            shape = RoundedCornerShape(ButtonSize.corner_default),
            modifier = Modifier
                .height(ButtonSize.height_default)
                .width(ButtonSize.width_default)
        ) {
            Icon(
                imageVector = Icons.Filled.Folder,
                contentDescription = IconContentDescriptions.newInvestigation(language),
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(text = ButtonStrings.newInvestigation(language))
        }
    }

    @Composable
    fun SelectInvestigation(
        language: Language,
        onClickAction: () -> Unit
    ) {
        OutlinedButton(
            onClick = { onClickAction() },
            shape = RoundedCornerShape(ButtonSize.corner_default),
            modifier = Modifier
                .height(ButtonSize.height_default)
                .width(ButtonSize.width_default)
        ) {
            Icon(
                imageVector = Icons.Filled.Folder,
                contentDescription = IconContentDescriptions.goToInvestigations(language),
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(text = ButtonStrings.selectInvestigation(language))
        }
    }

    @Composable
    fun QrCodeScanner(
        language: Language,
        onClickAction: () -> Unit
    ) {
        OutlinedButton(
            onClick = { onClickAction() },
            shape = RoundedCornerShape(ButtonSize.corner_default),
            modifier = Modifier
                .height(ButtonSize.height_default)
                .width(ButtonSize.width_default)
        ) {
            Icon(
                imageVector = Icons.Filled.QrCode,
                contentDescription = IconContentDescriptions.qrCodeScanner(language),
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(text = ButtonStrings.scanEvidence(language))
        }
    }

    @Composable
    fun DocuMode(
        language: Language,
        onClickAction: () -> Unit
    ) {
        OutlinedButton(
            onClick = { onClickAction() },
            shape = RoundedCornerShape(ButtonSize.corner_default),
            modifier = Modifier
                .height(ButtonSize.height_default)
                .width(ButtonSize.width_default)
        ) {
            Icon(
                painter = drawableResource(filename = "ic_insitu_logo.svg"),
                contentDescription = IconContentDescriptions.insituLogo(language),
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(text = ButtonStrings.goToDocuMode(language))
        }
    }

    @Composable
    fun SwitchDocuMode(
        language: Language,
        onClickAction: () -> Unit
    ) {
        OutlinedButton(
            onClick = { onClickAction() },
            shape = RoundedCornerShape(ButtonSize.corner_default),
            modifier = Modifier
                .height(ButtonSize.height_default)
                .width(ButtonSize.width_default)
        ) {
            Icon(
                painter = drawableResource(filename = "ic_insitu_logo.svg"),
                contentDescription = IconContentDescriptions.insituLogo(language),
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(text = ButtonStrings.switchDocuMode(language))
        }
    }

    @Composable
    fun AddAddress(
        language: Language,
        onClickAction: () -> Unit
    ) {
        OutlinedButton(
            onClick = { onClickAction() },
            shape = RoundedCornerShape(ButtonSize.corner_default),
            modifier = Modifier
                .height(CardSize.large)
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colors.secondary,
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = IconContentDescriptions.add(language),
                modifier = Modifier.padding(end = 8.dp),
                tint = MaterialTheme.colors.secondary
            )
            Text(text = ButtonStrings.addAddress(language), color = MaterialTheme.colors.secondary)
        }
    }


    @Composable
    fun SelectOrAddSovereignAct(
        language: Language,
        onClickAction: () -> Unit
    ) {
        OutlinedButton(
            onClick = { onClickAction() },
            shape = RoundedCornerShape(ButtonSize.corner_default),
            modifier = Modifier
                .height(CardSize.large)
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colors.secondary,
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = IconContentDescriptions.add(language),
                modifier = Modifier.padding(end = 8.dp),
                tint = MaterialTheme.colors.secondary
            )
            Text(
                text = ButtonStrings.selectOrAddSovereignAct(language),
                color = MaterialTheme.colors.secondary
            )
        }
    }

    @Composable
    fun EmergencyDocu(
        language: Language,
        onClickAction: () -> Unit
    ) {
        OutlinedButton(
            modifier = Modifier
                .height(ButtonSize.height_default)
                .width(ButtonSize.width_default),
            onClick = { onClickAction() }) {
            Icon(
                imageVector = Icons.Filled.LocalPolice,
                contentDescription = IconContentDescriptions.emergencySecuring(language),
                tint = MaterialTheme.colors.secondary,
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = ButtonStrings.emergencySecuring(language),
                color = MaterialTheme.colors.secondary
            )
        }
    }

    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    fun MultiFloatingActionButton(
        modifier: Modifier = Modifier,
        fabIcon: ImageVector = Icons.Filled.Add,
        rotationDegree: Float = 180f,
        fabTitle: String? = null,
        showFabTitle: Boolean = false,
        itemsMultiFab: List<MultiFabItem>,
        fabState: MutableState<MultiFabState> = rememberMultiFabState(),
        fabOption: FabOption = FabOption(),
        stateChanged: (fabState: MultiFabState) -> Unit = {},
        onFabItemClicked: (fabItem: MultiFabItem) -> Unit
    ) {
        val rotation by animateFloatAsState(
            if (fabState.value == MultiFabState.Expanded) rotationDegree else 0f
        )

        Column(
            modifier = modifier.wrapContentSize(),
            horizontalAlignment = Alignment.End,
        ) {
            AnimatedVisibility(
                visible = fabState.value == MultiFabState.Expanded,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut()
            ) {
                LazyColumn(
                    modifier = Modifier.wrapContentSize(),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    itemsIndexed(itemsMultiFab) { _, item ->
                        MiniFabItem(
                            item = item,
                            showLabel = fabOption.showLabels,
                            backgroundColor = fabOption.backgroundTint,
                            tintColor = fabOption.iconTint,
                            onFabItemClicked = { onFabItemClicked(item) })
                    }

                    item {}
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (fabState.value.isExpanded() && showFabTitle && !fabTitle.isNullOrEmpty())
                    Text(text = fabTitle, modifier = Modifier.padding(end = 16.dp), fontSize = 12.sp)
                FloatingActionButton(
                    onClick = {
                        fabState.value = fabState.value.toggleValue()
                        stateChanged(fabState.value)
                    },
                    backgroundColor = fabOption.backgroundTint,
                    contentColor = fabOption.iconTint
                ) {
                    Icon(
                        imageVector = fabIcon,
                        modifier = Modifier.rotate(rotation),
                        contentDescription = null,
                        tint = fabOption.iconTint
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ButtonsPreview() {
    Buttons.AddBaseEntity(title = "Add") {}
}