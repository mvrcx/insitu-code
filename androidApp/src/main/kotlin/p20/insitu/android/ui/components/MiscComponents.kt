package p20.insitu.android.ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import p20.insitu.model.entities.*
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.resources.Language
import p20.insitu.resources.strings.EntityTypeStrings
import p20.insitu.resources.strings.IconContentDescriptions
import p20.insitu.theme.colors.*
import p20.insitu.android.R
import p20.insitu.android.ui.components.dimen.CardSize
import p20.insitu.android.ui.components.dimen.IconSize
import p20.insitu.android.ui.components.dimen.Padding
import p20.insitu.android.util.drawableResource
import p20.insitu.resources.strings.ButtonStrings
import p20.insitu.resources.strings.MessageStrings

object MiscComponents {
    @Composable
    fun UserImage(
        language: Language,
        defaultImage: Boolean = false
    ) {
        BoxWithConstraints(
            Modifier
                .fillMaxWidth()
                .padding(all = Padding.medium),
            contentAlignment = Alignment.TopCenter
        ) {
            if (defaultImage) {
                Image(
                    painter = drawableResource(filename = R.drawable.img_demo_user_policemen.toString()),
                    contentDescription = IconContentDescriptions.userImage(language),
                    modifier = Modifier
                        .width(maxWidth / 2f)
                        .height(maxWidth / 2f)
                        .clip(CircleShape)
                        .border(4.dp, DarkGrey100, CircleShape)
                        .background(MaterialTheme.colors.surface)
                )
            } else {
                Box(
                    modifier = Modifier
                        .width(maxWidth / 2f)
                        .height(maxWidth / 2f)
                        .clip(CircleShape)
                        .border(4.dp, DarkGrey100, CircleShape)
                        .background(MaterialTheme.colors.surface)
                )
                Icon(
                    imageVector = Icons.Filled.Person,
                    tint = MaterialTheme.colors.onSurface,
                    contentDescription = IconContentDescriptions.userImage(language),
                    modifier = Modifier
                        .width(maxWidth / 2.2f)
                        .height(maxWidth / 2.2f)
                        .clip(CircleShape)
                )
            }
        }
    }

    @Composable
    fun InsituLogo(language: Language) {
        BoxWithConstraints(
            Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 48.dp, bottom = 48.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = drawableResource(filename = R.drawable.img_logo_insitu_text.toString()),
                contentDescription = IconContentDescriptions.insituLogo(language),
                modifier = Modifier
                    .width(maxWidth / 1.1f)
            )
        }
    }

    @Composable
    fun DocuObjectBarGoToCrimeSceneList(language: Language, onClickAction: () -> Unit) {
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
                modifier = Modifier.fillMaxSize().padding(horizontal = Padding.small),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.weight(1f)) {
                    Text(
                        text = ButtonStrings.goToCrimeSceneList(language),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.subtitle1
                    )
                }
                SpacersAndDividers.HorizontalSpacer()
                Icon(
                    imageVector = Icons.Filled.ArrowUpward,
                    contentDescription = IconContentDescriptions.navigateDocuListUp(language),
                    modifier = Modifier.size(IconSize.medium),
                    tint = MaterialTheme.colors.secondary
                )
            }
        }
    }

    @Composable
    fun DocuObjectBar(
        docuObject: DocumentationObject,
        showMoveListUpBtn: Boolean = false,
        onClickAction: () -> Unit = {},
        language: Language
    ) {
        val entityType = EntityType.valueOf(docuObject.entityType)
        val designation = if (!docuObject.designation.isNullOrBlank()) {
            docuObject.designation
        } else {
            EntityTypeStrings.typeString(entityType, language)
        }
        val subtitle = when (docuObject) {
            is DocNumberObject -> docuObject.docNumber?.docNumberString
            is Investigation -> docuObject.number
            is Person -> docuObject.personalDetails.firstOrNull()?.birthday?.getFormattedDateString()
            else -> null
        }
        val icon = p20.insitu.resources.icons.Icons.getEntityTypeIcon(entityType)
        val iconContentDescription = IconContentDescriptions.entityType(entityType, language)
        val color = when {
            docuObject is Investigation -> {
                if (isSystemInDarkTheme()) InvestigationDark else InvestigationLight
            }
            docuObject is CrimeScene -> {
                if (isSystemInDarkTheme()) CrimeSceneDark else CrimeSceneLight
            }
            docuObject is Evidence && (docuObject as? Evidence)?.evidenceData != null -> {
                if (isSystemInDarkTheme()) EvidenceDark else EvidenceLight
            }
            docuObject is Evidence && (docuObject as? Evidence)?.evidenceData == null -> {
                if (isSystemInDarkTheme()) NonEvidenceDark else NonEvidenceLight
            }
            docuObject is Site && docuObject.docNumber != null -> {
                if (isSystemInDarkTheme()) SiteDark else SiteLight
            }
            else -> {
                if (isSystemInDarkTheme()) DefaultEntityDark else DefaultEntityLight
            }
        }
        Column(modifier = Modifier.fillMaxWidth()) {
            Cards.DocuObjectBar(
                color = color,
                designation = designation ?: "",
                subtitle = subtitle,
                iconLeft = icon,
                iconLeftContentDescription = iconContentDescription,
                showMoveListUpBtn = showMoveListUpBtn,
                language = language,
                onClickAction = onClickAction
            )
        }
        Divider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = MaterialTheme.colors.background
        )
    }


}