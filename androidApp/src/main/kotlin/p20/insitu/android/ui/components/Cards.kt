package p20.insitu.android.ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import p20.insitu.model.components.ZonedDateTime
import p20.insitu.model.entities.*
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.resources.Language
import p20.insitu.resources.strings.EntityTypeStrings
import p20.insitu.resources.strings.MessageStrings
import p20.insitu.theme.colors.*
import p20.insitu.android.ui.components.Text.AutoResizeText
import p20.insitu.resources.icons.Icons
import p20.insitu.resources.strings.IconContentDescriptions
import p20.insitu.android.ui.components.SpacersAndDividers.HorizontalSpacer
import p20.insitu.android.ui.components.dimen.CardSize
import p20.insitu.android.ui.components.dimen.IconSize
import p20.insitu.android.ui.components.dimen.Padding

object Cards {

    @Composable
    private fun StandardEntityCard(
        docuModeActive: Boolean,
        entityType: EntityType,
        backgroundColor: Color = MaterialTheme.colors.primary,
        iconColor: Color = MaterialTheme.colors.onPrimary,
        designation: String,
        subtitle: String? = null,
        comment: String? = null,
        language: Language,
        onClickAction: () -> Unit
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onClickAction()
                }
        ) {
            Box(
                modifier = Modifier
                    .height(CardSize.large)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp)
                            .background(backgroundColor),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.getEntityTypeIcon(entityType),
                            contentDescription = IconContentDescriptions.entityType(
                                entityType, language
                            ),
                            modifier = Modifier.size(IconSize.medium),
                            tint = iconColor
                        )
                    }
                    if (docuModeActive) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .padding(Padding.small),
                        )
                        {
                            StandardEntityCardText(
                                designation = designation,
                                subtitle = subtitle,
                                comment = comment,
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight()
                            )
                        }
                    } else {
                        StandardEntityCardText(
                            designation = designation,
                            subtitle = subtitle,
                            comment = comment,
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .padding(Padding.small)
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun StandardEntityCardText(
        designation: String,
        subtitle: String? = null,
        comment: String? = null,
        modifier: Modifier
    ) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center
        ) {
            AutoResizeText(
                text = designation,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(),
                fontSizeRange = Text.FontSizeRange(
                    min = MaterialTheme.typography.h6.fontSize,
                    max = MaterialTheme.typography.h4.fontSize,
                ),
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.h5
            )
            subtitle?.let {
                Spacer(modifier = Modifier.weight(1.0f))
                Text(
                    text = it,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.subtitle1
                )
            }
            comment?.let {
                Spacer(modifier = Modifier.weight(1.0f))
                Text(
                    text = it,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.caption
                )
            }
        }
    }

    @Composable
    fun Investigation(
        docuModeActive: Boolean,
        investigation: Investigation, language: Language, onClickAction: () -> Unit
    ) {
        StandardEntityCard(
            docuModeActive = docuModeActive,
            entityType = EntityType.INVESTIGATION,
            backgroundColor = if (isSystemInDarkTheme()) InvestigationDark else InvestigationLight,
            designation = investigation.designation ?: investigation.typeOfProcess?.toString()
            ?: EntityTypeStrings.typeString(EntityType.INVESTIGATION, language),
            subtitle = investigation.number ?: MessageStrings.valueMissing(language),
            comment = investigation.startDate?.getFormattedDateString(ZonedDateTime.DateFormat.DDMMYYYY)
                ?: "",
            language = language,
            onClickAction = onClickAction
        )
    }

    @Composable
    fun CrimeScene(
        docuModeActive: Boolean,
        crimeScene: CrimeScene,
        address: Address?,
        language: Language,
        onClickAction: () -> Unit
    ) {
        StandardEntityCard(
            docuModeActive = docuModeActive,
            entityType = EntityType.CRIME_SCENE,
            backgroundColor = if (isSystemInDarkTheme()) CrimeSceneDark else CrimeSceneLight,
            designation = crimeScene.designation
                ?: EntityTypeStrings.typeString(EntityType.CRIME_SCENE, language),
            subtitle = crimeScene.docNumber?.docNumberString
                ?: MessageStrings.valueMissing(language),
            comment = address?.postalAddress?.toString()
                ?.ifEmpty { crimeScene.locationType?.toString() ?: "" },
            language = language,
            onClickAction = onClickAction
        )
    }

    @Composable
    fun CriminalOffense(
        criminalOffense: CriminalOffense,
        language: Language,
        onClickAction: () -> Unit
    ) {
        StandardEntityCard(
            docuModeActive = false,
            entityType = EntityType.CRIMINAL_OFFENSE,
            backgroundColor = if (isSystemInDarkTheme()) DefaultEntityDark else DefaultEntityLight,
            designation = criminalOffense.designation ?: criminalOffense.typeOfCrime?.toString()
            ?: EntityTypeStrings.typeString(EntityType.CRIMINAL_OFFENSE, language),
            subtitle = if (!criminalOffense.designation.isNullOrBlank()) criminalOffense.typeOfCrime?.toString() else "",
            comment = criminalOffense.timeOfReporting?.toString() ?: "",
            language = language,
            onClickAction = onClickAction
        )
    }

    @Composable
    fun Site(
        docuModeActive: Boolean,
        site: Site, language: Language, onClickAction: () -> Unit
    ) {
        val entityType = EntityType.valueOf(site.entityType)
        StandardEntityCard(
            docuModeActive = docuModeActive,
            entityType = entityType,
            backgroundColor = if (isSystemInDarkTheme()) SiteDark else SiteLight,
            designation = site.designation
                ?: EntityTypeStrings.typeString(EntityType.CRIMINAL_OFFENSE, language),
            subtitle = site.docNumber?.docNumberString ?: MessageStrings.valueMissing(language),
            comment = (site as? Location)?.locationType?.toString() ?: EntityTypeStrings.typeString(
                entityType,
                language
            ),
            language = language,
            onClickAction = onClickAction
        )
    }

    @Composable
    fun SecuredEvidence(
        docuModeActive: Boolean,
        evidence: Evidence, language: Language, onClickAction: () -> Unit
    ) {
        val entityType = EntityType.valueOf(evidence.entityType)
        StandardEntityCard(
            docuModeActive = docuModeActive,
            entityType = entityType,
            backgroundColor = if (isSystemInDarkTheme()) EvidenceDark else EvidenceLight,
            designation = evidence.designation ?: "",
            subtitle = evidence.docNumber?.docNumberString ?: MessageStrings.valueMissing(language),
            comment = EntityTypeStrings.typeString(entityType, language),
            language = language,
            onClickAction = onClickAction
        )
    }

    @Composable
    fun UnsecuredObject(
        docuModeActive: Boolean,
        unsecuredObject: DocNumberObject,
        language: Language,
        onClickAction: () -> Unit
    ) {
        val entityType = EntityType.valueOf(unsecuredObject.entityType)
        StandardEntityCard(
            docuModeActive = docuModeActive,
            entityType = entityType,
            backgroundColor = if (isSystemInDarkTheme()) NonEvidenceDark else NonEvidenceLight,
            designation = unsecuredObject.designation ?: EntityTypeStrings.typeString(
                entityType,
                language
            ),
            subtitle = unsecuredObject.docNumber?.docNumberString ?: MessageStrings.valueMissing(
                language
            ),
            comment = EntityTypeStrings.typeString(entityType, language),
            language = language,
            onClickAction = onClickAction
        )
    }

    @Composable
    fun Person(person: Person, language: Language, onClickAction: () -> Unit) {
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onClickAction()
                }
        ) {
            Box(
                modifier = Modifier
                    .height(CardSize.large)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp)
                            .background(if (isSystemInDarkTheme()) DefaultEntityDark else DefaultEntityLight),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.getEntityTypeIcon(EntityType.PERSON),
                            contentDescription = IconContentDescriptions.entityType(
                                EntityType.PERSON, language
                            ),
                            modifier = Modifier.size(IconSize.medium),
                            tint = MaterialTheme.colors.onPrimary
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(Padding.small),
                        verticalArrangement = Arrangement.Center
                    ) {
                        AutoResizeText(
                            text = person.getShortName()
                                ?: EntityTypeStrings.typeString(EntityType.PERSON, language),
                            maxLines = 1,
                            modifier = Modifier.fillMaxWidth(),
                            fontSizeRange = Text.FontSizeRange(
                                min = MaterialTheme.typography.h6.fontSize,
                                max = MaterialTheme.typography.h4.fontSize,
                            ),
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.h5
                        )
                        Row {
                            Text(modifier = Modifier.weight(1f), text = "")
                            person.types.forEach {
                                TextIcons.PersonTypeIcon(it)
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun Note(
        note: Note, language: Language, onClickAction: () -> Unit
    ) {
        val entityType = EntityType.NOTE
        StandardEntityCard(
            docuModeActive = false,
            entityType = entityType,
            backgroundColor = if (isSystemInDarkTheme()) DefaultEntityDark else DefaultEntityLight,
            designation = note.designation ?: EntityTypeStrings.typeString(entityType, language),
            subtitle = note.creationDate?.getFormattedDateTimeString() ?: "",
            comment = note.text ?: "",
            language = language,
            onClickAction = onClickAction
        )
    }

    @Composable
    fun Audio(audio: Audio, language: Language, onClickAction: () -> Unit) {
        val entityType = EntityType.AUDIO
        StandardEntityCard(
            docuModeActive = false,
            entityType = entityType,
            backgroundColor = if (isSystemInDarkTheme()) DefaultEntityDark else DefaultEntityLight,
            designation = audio.designation ?: EntityTypeStrings.typeString(entityType, language),
            subtitle = audio.creationDate?.getFormattedDateTimeString() ?: "",
            comment = audio.transcription ?: "",
            language = language,
            onClickAction = onClickAction
        )
    }

    @Composable
    fun Image(
        imageBitmap: ImageBitmap,
        language: Language,
        onClickAction: () -> Unit
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    onClickAction()
                }
        ) {
            Box(
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .graphicsLayer(
                            scaleX = 1.2f,
                            scaleY = 1.2f
                        ),
                    bitmap = imageBitmap,
                    contentDescription = IconContentDescriptions.entityType(
                        EntityType.IMAGE,
                        language
                    )
                )
            }
        }
    }

    @Composable
    fun Video(
        video: Video,
        language: Language,
        onClickAction: () -> Unit
    ) {
        val entityType = EntityType.VIDEO
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onClickAction()
                }
        ) {
            Box(
                modifier = Modifier
                    .height(CardSize.large)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.5f)
                            .background(if (isSystemInDarkTheme()) DefaultEntityDark else DefaultEntityLight),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.getEntityTypeIcon(entityType),
                            contentDescription = IconContentDescriptions.entityType(
                                entityType,
                                language
                            ),
                            modifier = Modifier.size(IconSize.large),
                            tint = MaterialTheme.colors.onPrimary
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(Padding.small),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = video.creationDate?.getFormattedDateTimeString() ?: "")
                    }
                }
            }
        }
    }

    @Composable
    fun DocuObjectBar(
        color: Color,
        designation: String,
        subtitle: String?,
        iconLeft: ImageVector? = null,
        iconLeftContentDescription: String? = null,
        showMoveListUpBtn: Boolean = false,
        language: Language,
        onClickAction: () -> Unit = {}
    ) {
        Card(
            shape = RectangleShape,
            modifier = Modifier
                .height(CardSize.docuObjectBar)
                .fillMaxWidth()
                .clickable {
                    onClickAction()
                }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = Padding.small),
                verticalAlignment = Alignment.CenterVertically
            ) {
                iconLeft?.let {
                    Box(
                        modifier = Modifier
                            .width(CardSize.docuObjectBar)
                            .fillMaxHeight()
                            .background(color),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = it,
                            contentDescription = iconLeftContentDescription,
                            modifier = Modifier.size(IconSize.medium),
                            tint = MaterialTheme.colors.onPrimary
                        )
                    }
                    HorizontalSpacer()
                }
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .padding(start = Padding.xsmall)
                ) {
                    Text(
                        text = designation,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 18.sp,
                        style = MaterialTheme.typography.h6
                    )
                    subtitle?.let {
                        Text(
                            text = it,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.subtitle1
                        )
                    }
                }

                if (showMoveListUpBtn) {
                    HorizontalSpacer()
                    Icon(
                        imageVector = androidx.compose.material.icons.Icons.Filled.ArrowUpward,
                        contentDescription = IconContentDescriptions.navigateDocuListUp(language),
                        modifier = Modifier.size(IconSize.medium),
                        tint = MaterialTheme.colors.secondary
                    )
                }
            }
        }
    }

    @Composable
    fun DocuObjectLarge(
        docuModeActive: Boolean,
        docuObject: DocNumberObject,
        address: Address? = null,
        language: Language,
        onClickAction: () -> Unit
    ) {
        when {
            docuObject is CrimeScene -> {
                this.CrimeScene(
                    docuModeActive = docuModeActive,
                    crimeScene = docuObject,
                    address = address,
                    language = language
                ) {
                    onClickAction()
                }
            }
            docuObject is Person -> {
                Person(
                    person = docuObject,
                    language = language
                ) {
                    onClickAction()
                }
            }
            docuObject is Evidence && docuObject.evidenceData == null -> {
                UnsecuredObject(
                    docuModeActive = docuModeActive,
                    unsecuredObject = docuObject,
                    language = language
                ) {
                    onClickAction()
                }
            }
            docuObject is Evidence && docuObject.evidenceData != null -> {
                SecuredEvidence(
                    docuModeActive = docuModeActive,
                    evidence = docuObject,
                    language = language
                ) {
                    onClickAction()
                }
            }
            docuObject is Site -> {
                Site(
                    docuModeActive = docuModeActive,
                    site = docuObject,
                    language = language
                ) {
                    onClickAction()
                }
            }
        }
    }

    @Composable
    private fun DocumentationListItem(
        iconBackground: Color,
        iconTint: Color = MaterialTheme.colors.onPrimary,
        designation: String,
        subtitle: String?,
        icon: ImageVector,
        iconContentDescription: String,
        elevation: Dp = 0.dp,
        onClickAction: () -> Unit
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            elevation = elevation,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onClickAction()
                }
        ) {
            Box(
                modifier = Modifier
                    .height(CardSize.small)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    Box(
                        modifier = Modifier
                            .width(CardSize.small)
                            .fillMaxHeight()
                            .background(iconBackground),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = icon,
                            contentDescription = iconContentDescription,
                            modifier = Modifier.size(IconSize.large),
                            tint = iconTint
                        )
                    }

                    HorizontalSpacer()

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(Padding.xsmall)
                    ) {
                        Text(
                            text = designation,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.h5
                        )
                        subtitle?.let {
                            Spacer(modifier = Modifier.weight(1.0f))
                            Text(
                                text = it,
                                overflow = TextOverflow.Ellipsis,
                                style = MaterialTheme.typography.h6
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun SecuredEvidenceDocItem(
        evidence: Evidence,
        elevation: Dp = 0.dp,
        language: Language,
        onClickAction: () -> Unit
    ) {
        val entityType = EntityType.valueOf(evidence.entityType)
        DocumentationListItem(
            iconBackground = if (isSystemInDarkTheme()) EvidenceDark else EvidenceLight,
            designation = evidence.designation ?: EntityTypeStrings.typeString(
                entityType,
                language
            ),
            subtitle = evidence.docNumber?.docNumberString,
            icon = Icons.getEntityTypeIcon(entityType),
            iconContentDescription = IconContentDescriptions.entityType(entityType, language),
            elevation = elevation,
            onClickAction = onClickAction
        )
    }

    @Composable
    fun SiteDocItem(
        site: Site,
        elevation: Dp = 0.dp,
        language: Language,
        onClickAction: () -> Unit
    ) {
        val entityType = EntityType.valueOf(site.entityType)
        DocumentationListItem(
            iconBackground = if (isSystemInDarkTheme()) SiteDark else SiteLight,
            designation = site.designation ?: EntityTypeStrings.typeString(entityType, language),
            subtitle = site.docNumber?.docNumberString,
            icon = Icons.getEntityTypeIcon(entityType),
            iconContentDescription = IconContentDescriptions.entityType(entityType, language),
            elevation = elevation,
            onClickAction = onClickAction
        )
    }

    @Composable
    fun UnsecuredObjectDocItem(
        obj: DocNumberObject,
        elevation: Dp = 0.dp,
        language: Language,
        onClickAction: () -> Unit
    ) {
        val entityType = EntityType.valueOf(obj.entityType)
        DocumentationListItem(
            iconBackground = if (isSystemInDarkTheme()) NonEvidenceDark else NonEvidenceLight,
            designation = obj.designation ?: EntityTypeStrings.typeString(entityType, language),
            subtitle = obj.docNumber?.docNumberString,
            icon = Icons.getEntityTypeIcon(entityType),
            iconContentDescription = IconContentDescriptions.entityType(entityType, language),
            elevation = elevation,
            onClickAction = onClickAction
        )
    }

    @Composable
    fun AddressCard(
        address: Address,
        language: Language,
        onClickAction: () -> Unit
    ) {
        val color = MaterialTheme.colors.surface
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onClickAction()
                }
        ) {
            Box(
                modifier = Modifier
                    .height(CardSize.large)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp)
                            .background(color),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.getEntityTypeIcon(EntityType.ADDRESS),
                            contentDescription = IconContentDescriptions.entityType(
                                EntityType.ADDRESS, language
                            ),
                            modifier = Modifier.size(IconSize.medium),
                            tint = MaterialTheme.colors.onSurface
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(Padding.small),
                        verticalArrangement = Arrangement.Center
                    ) {
                        address.geolocation?.let {
                            // TODO get/create map image
                        } ?: run {
                            Text(
                                text = MessageStrings.noMapAvailable(language),
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                        Spacer(modifier = Modifier.weight(1.0f))
                        Text(
                            text = address.toString(),
                            style = MaterialTheme.typography.subtitle1,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        address.geolocation?.worldPosition?.let { geoPoint ->
                            Text(
                                text = geoPoint.toString(),
                                style = MaterialTheme.typography.subtitle1,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun CatalogCategoryCard(
        designation: String,
        imageVector: ImageVector,
        contentDescription: String,
        onClickAction: () -> Unit
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onClickAction()
                }
        ) {
            Box(
                modifier = Modifier
                    .height(CardSize.large)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.5f)
                            .background(MaterialTheme.colors.primary),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = imageVector,
                            contentDescription = contentDescription,
                            modifier = Modifier.size(IconSize.large),
                            tint = MaterialTheme.colors.onPrimary
                        )
                    }

                    SpacersAndDividers.VerticalSpacer()

                    AutoResizeText(
                        text = designation,
                        maxLines = 2,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(Padding.small),
                        fontSizeRange = Text.FontSizeRange(
                            min = MaterialTheme.typography.subtitle1.fontSize,
                            max = MaterialTheme.typography.h5.fontSize,
                        ),
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.h5
                    )
                }
            }
        }
    }

    @Composable
    fun CatalogItemCard(
        designation: String,
        subtitle: String? = null,
        imageVector: ImageVector,
        contentDescription: String,
        onClickAction: () -> Unit
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onClickAction()
                }
        ) {
            Box(
                modifier = Modifier
                    .height(CardSize.large)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.5f)
                            .background(MaterialTheme.colors.primary),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = imageVector,
                            contentDescription = contentDescription,
                            modifier = Modifier.size(IconSize.large),
                            tint = MaterialTheme.colors.onPrimary
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(Padding.small),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = designation,
                            maxLines = 2,
                            modifier = Modifier.fillMaxWidth(),
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.subtitle1
                        )
                        subtitle?.let {
                            Spacer(modifier = Modifier.weight(1.0f))
                            Text(
                                text = it,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                                style = MaterialTheme.typography.caption
                            )
                        }
                    }
                }
            }
        }
    }

}