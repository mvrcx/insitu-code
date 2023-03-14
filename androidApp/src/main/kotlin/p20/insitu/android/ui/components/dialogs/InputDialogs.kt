@file:Suppress("UNCHECKED_CAST")

package p20.insitu.android.ui.components.dialogs

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.*
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import p20.insitu.android.ui.components.DropdownField
import p20.insitu.android.ui.components.SpacersAndDividers
import p20.insitu.android.ui.components.TextFields
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.model.components.*
import p20.insitu.model.util.CatalogInfo
import p20.insitu.model.xpolizei.schema.KatalogCode206
import p20.insitu.model.xpolizei.schema.KatalogCode207
import p20.insitu.model.xpolizei.schema.KatalogCode232
import p20.insitu.model.xpolizei.schema.KatalogCode278
import p20.insitu.resources.Language
import p20.insitu.resources.strings.*
import kotlin.math.max

object InputDialogs {
    @Composable
    fun Weight(
        initialValue: Weight?,
        onDismiss: () -> Unit,
        onConfirm: (Weight?) -> Unit,
        language: Language,
        catalogRepo: CatalogRepo
    ) {
        val weight = remember { mutableStateOf(initialValue) }
        val weightValue = remember { mutableStateOf(initialValue?.value) }
        val unit = remember { mutableStateOf(initialValue?.unit) }
        val determinedBy = remember { mutableStateOf(initialValue?.typeOfDetermination) }

        val catalogWeightUnits =
            remember { mutableStateOf<List<CatalogCodeFixed<KatalogCode232>>>(listOf()) }
        val catalogTypeOfDetermination = remember {
            mutableStateOf<List<CatalogCodeFixed<KatalogCode206>>>(
                listOf()
            )
        }

        LaunchedEffect(key1 = Unit, block = {
            catalogWeightUnits.value =
                catalogRepo.getCatalogFixedValues(CatalogInfo.CATALOG_232_MASSEINHEIT_DES_GEWICHTES)
            catalogTypeOfDetermination.value =
                catalogRepo.getCatalogFixedValues(CatalogInfo.CATALOG_206_ART_DER_FESTSTELLUNG)
        })

        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(
                dismissOnClickOutside = false,
                dismissOnBackPress = true,
            )
        ) {
            Surface(
                modifier = Modifier,
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colors.surface,
                contentColor = contentColorFor(MaterialTheme.colors.surface)
            ) {
                Column(modifier = Modifier.padding(all = p20.insitu.android.ui.components.dimen.Padding.dialog)) {
                    InputDialogBaselineLayout(
                        title = {
                            Text(
                                text = TitleStrings.weightInput(language),
                                style = MaterialTheme.typography.subtitle1
                            )
                        },
                        text = {
                            Text(
                                text = MessageStrings.weightInput(language),
                                style = MaterialTheme.typography.body2
                            )
                        }
                    )
                    TextFields.FloatValue(
                        initialValue = weightValue.value?.toString(),
                        label = TextFieldStrings.value(language),
                        enabled = true
                    ) {
                        weightValue.value = it
                        weightValue.value?.let { value ->
                            if (unit.value != null && determinedBy.value != null) {
                                weight.value = Weight(
                                    value = value,
                                    unit = unit.value,
                                    typeOfDetermination = determinedBy.value
                                )
                            }
                        }
                    }

                    SpacersAndDividers.VerticalSpacer()

                    DropdownField.CatalogList(
                        label = TextFieldStrings.unit(language),
                        value = unit.value,
                        list = catalogWeightUnits.value,
                        enabled = true,
                        language = language
                    ) {
                        unit.value = it as? CatalogCodeFixed<KatalogCode232>
                        weightValue.value?.let { value ->
                            if (unit.value != null && determinedBy.value != null) {
                                weight.value = Weight(
                                    value = value,
                                    unit = unit.value,
                                    typeOfDetermination = determinedBy.value
                                )
                            }
                        }
                    }

                    SpacersAndDividers.VerticalSpacer()

                    DropdownField.CatalogList(
                        label = TextFieldStrings.typeOfMeasurementDetermination(language),
                        value = determinedBy.value,
                        list = catalogTypeOfDetermination.value,
                        enabled = true,
                        language = language
                    ) {
                        determinedBy.value = it as? CatalogCodeFixed<KatalogCode206>
                        weightValue.value?.let { value ->
                            if (unit.value != null && determinedBy.value != null) {
                                weight.value = Weight(
                                    value = value,
                                    unit = unit.value,
                                    typeOfDetermination = determinedBy.value
                                )
                            }
                        }
                    }

                    SpacersAndDividers.VerticalSpacer()

                    Box(
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = 2.dp)
                    ) {
                        InputDialogFlowRow(
                            mainAxisSpacing = 8.dp,
                            crossAxisSpacing = 12.dp
                        ) {
                            Button(onClick = { onConfirm(weight.value) }) {
                                Text(ButtonStrings.applyValue(language))
                            }
                            Button(onClick = onDismiss) {
                                Text(ButtonStrings.cancel(language))
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun Volume(
        initialValue: Volume?,
        onDismiss: () -> Unit,
        onConfirm: (Volume?) -> Unit,
        language: Language,
        catalogRepo: CatalogRepo
    ) {
        val volume = remember { mutableStateOf<Volume?>(null) }
        val volumeValue = remember { mutableStateOf<Float?>(null) }
        val unit = remember { mutableStateOf<CatalogCodeFixed<KatalogCode278>?>(null) }
        val determinedBy = remember { mutableStateOf<CatalogCodeFixed<KatalogCode206>?>(null) }

        val catalogVolumeUnits =
            remember { mutableStateOf<List<CatalogCodeFixed<KatalogCode278>>>(listOf()) }
        val catalogTypeOfDetermination = remember {
            mutableStateOf<List<CatalogCodeFixed<KatalogCode206>>>(
                listOf()
            )
        }

        LaunchedEffect(key1 = Unit, block = {
            catalogVolumeUnits.value =
                catalogRepo.getCatalogFixedValues(CatalogInfo.CATALOG_278_MASSEINHEIT_DES_VOLUMENS)
            catalogTypeOfDetermination.value =
                catalogRepo.getCatalogFixedValues(CatalogInfo.CATALOG_206_ART_DER_FESTSTELLUNG)
        })

        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(
                dismissOnClickOutside = false,
                dismissOnBackPress = true,
            )
        ) {
            Surface(
                modifier = Modifier,
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colors.surface,
                contentColor = contentColorFor(MaterialTheme.colors.surface)
            ) {
                Column(modifier = Modifier.padding(all = p20.insitu.android.ui.components.dimen.Padding.dialog)) {
                    InputDialogBaselineLayout(
                        title = {
                            Text(
                                text = TitleStrings.volumeInput(language),
                                style = MaterialTheme.typography.subtitle1
                            )
                        },
                        text = {
                            Text(
                                text = MessageStrings.volumeInput(language),
                                style = MaterialTheme.typography.body2
                            )
                        }
                    )
                    TextFields.FloatValue(
                        initialValue = volumeValue.value?.toString(),
                        label = TextFieldStrings.value(language),
                        enabled = true
                    ) {
                        volumeValue.value = it
                        volumeValue.value?.let { value ->
                            if (unit.value != null && determinedBy.value != null) {
                                volume.value = Volume(
                                    value = value,
                                    unit = unit.value,
                                    typeOfDetermination = determinedBy.value
                                )
                            }
                        }
                    }

                    SpacersAndDividers.VerticalSpacer()

                    DropdownField.CatalogList(
                        label = TextFieldStrings.unit(language),
                        value = unit.value,
                        list = catalogVolumeUnits.value,
                        enabled = true,
                        language = language
                    ) {
                        unit.value = it as? CatalogCodeFixed<KatalogCode278>
                        volumeValue.value?.let { value ->
                            if (unit.value != null && determinedBy.value != null) {
                                volume.value = Volume(
                                    value = value,
                                    unit = unit.value,
                                    typeOfDetermination = determinedBy.value
                                )
                            }
                        }
                    }

                    SpacersAndDividers.VerticalSpacer()

                    DropdownField.CatalogList(
                        label = TextFieldStrings.typeOfMeasurementDetermination(language),
                        value = determinedBy.value,
                        list = catalogTypeOfDetermination.value,
                        enabled = true,
                        language = language
                    ) {
                        determinedBy.value = it as? CatalogCodeFixed<KatalogCode206>
                        volumeValue.value?.let { value ->
                            if (unit.value != null && determinedBy.value != null) {
                                volume.value = Volume(
                                    value = value,
                                    unit = unit.value,
                                    typeOfDetermination = determinedBy.value
                                )
                            }
                        }
                    }

                    SpacersAndDividers.VerticalSpacer()

                    Box(
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = 2.dp)
                    ) {
                        InputDialogFlowRow(
                            mainAxisSpacing = 8.dp,
                            crossAxisSpacing = 12.dp
                        ) {
                            Button(onClick = { onConfirm(volume.value) }) {
                                Text(ButtonStrings.applyValue(language))
                            }
                            Button(onClick = onDismiss) {
                                Text(ButtonStrings.cancel(language))
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun Size(
        title: String?,
        text: String?,
        initialValue: Size?,
        onDismiss: () -> Unit,
        onConfirm: (Size?) -> Unit,
        language: Language,
        catalogRepo: CatalogRepo
    ) {
        val size = remember { mutableStateOf(initialValue) }
        val sizeValue = remember { mutableStateOf(initialValue?.value) }
        val unit = remember { mutableStateOf(initialValue?.unit) }
        val determinedBy = remember { mutableStateOf(initialValue?.typeOfDetermination) }

        val catalogSizeUnits =
            remember { mutableStateOf<List<CatalogCodeFixed<KatalogCode207>>>(listOf()) }
        val catalogTypeOfDetermination = remember {
            mutableStateOf<List<CatalogCodeFixed<KatalogCode206>>>(
                listOf()
            )
        }

        LaunchedEffect(key1 = Unit, block = {
            catalogSizeUnits.value =
                catalogRepo.getCatalogFixedValues(CatalogInfo.CATALOG_207_MASSEINHEIT_DES_AUSMASSES)
            catalogTypeOfDetermination.value =
                catalogRepo.getCatalogFixedValues(CatalogInfo.CATALOG_206_ART_DER_FESTSTELLUNG)
        })

        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(
                dismissOnClickOutside = false,
                dismissOnBackPress = true,
            )
        ) {
            Surface(
                modifier = Modifier,
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colors.surface,
                contentColor = contentColorFor(MaterialTheme.colors.surface)
            ) {
                Column(modifier = Modifier.padding(all = p20.insitu.android.ui.components.dimen.Padding.dialog)) {
                    InputDialogBaselineLayout(
                        title = {
                            Text(
                                text = title ?: TitleStrings.size(language),
                                style = MaterialTheme.typography.subtitle1
                            )
                        },
                        text = {
                            Text(
                                text = text ?: MessageStrings . sizeInput (language),
                                style = MaterialTheme.typography.body2
                            )
                        }
                    )
                    TextFields.FloatValue(
                        initialValue = sizeValue.value?.toString(),
                        label = TextFieldStrings.value(language),
                        enabled = true
                    ) {
                        sizeValue.value = it
                        sizeValue.value?.let { value ->
                            if (unit.value != null && determinedBy.value != null) {
                                size.value = Size(
                                    value = value,
                                    unit = unit.value,
                                    typeOfDetermination = determinedBy.value
                                )
                            }
                        }
                    }

                    SpacersAndDividers.VerticalSpacer()

                    DropdownField.CatalogList(
                        label = TextFieldStrings.unit(language),
                        value = unit.value,
                        list = catalogSizeUnits.value,
                        enabled = true,
                        language = language
                    ) {
                        unit.value = it as? CatalogCodeFixed<KatalogCode207>
                        sizeValue.value?.let { value ->
                            if (unit.value != null && determinedBy.value != null) {
                                size.value = Size(
                                    value = value,
                                    unit = unit.value,
                                    typeOfDetermination = determinedBy.value
                                )
                            }
                        }
                    }

                    SpacersAndDividers.VerticalSpacer()

                    DropdownField.CatalogList(
                        label = TextFieldStrings.typeOfMeasurementDetermination(language),
                        value = determinedBy.value,
                        list = catalogTypeOfDetermination.value,
                        enabled = true,
                        language = language
                    ) {
                        determinedBy.value = it as? CatalogCodeFixed<KatalogCode206>
                        sizeValue.value?.let { value ->
                            if (unit.value != null && determinedBy.value != null) {
                                size.value = Size(
                                    value = value,
                                    unit = unit.value,
                                    typeOfDetermination = determinedBy.value
                                )
                            }
                        }
                    }

                    SpacersAndDividers.VerticalSpacer()

                    Box(
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = 2.dp)
                    ) {
                        InputDialogFlowRow(
                            mainAxisSpacing = 8.dp,
                            crossAxisSpacing = 12.dp
                        ) {
                            Button(onClick = { onConfirm(size.value) }) {
                                Text(ButtonStrings.applyValue(language))
                            }
                            Button(onClick = onDismiss) {
                                Text(ButtonStrings.cancel(language))
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    internal fun ColumnScope.InputDialogBaselineLayout(
        title: @Composable (() -> Unit)?,
        text: @Composable (() -> Unit)?
    ) {
        Layout(
            {
                title?.let { title ->
                    Box(
                        TitlePadding
                            .layoutId("title")
                            .align(Alignment.Start)
                    ) {
                        title()
                    }
                }
                text?.let { text ->
                    Box(
                        TextPadding
                            .layoutId("text")
                            .align(Alignment.Start)
                    ) {
                        text()
                    }
                }
            },
            Modifier.weight(1f, false)
        ) { measurables, constraints ->
            // Measure with loose constraints for height as we don't want the text to take up more
            // space than it needs
            val titlePlaceable = measurables.firstOrNull { it.layoutId == "title" }?.measure(
                constraints.copy(minHeight = 0)
            )
            val textPlaceable = measurables.firstOrNull { it.layoutId == "text" }?.measure(
                constraints.copy(minHeight = 0)
            )

            val layoutWidth = max(titlePlaceable?.width ?: 0, textPlaceable?.width ?: 0)

            val firstTitleBaseline = titlePlaceable?.get(FirstBaseline)?.let { baseline ->
                if (baseline == AlignmentLine.Unspecified) null else baseline
            } ?: 0
            val lastTitleBaseline = titlePlaceable?.get(LastBaseline)?.let { baseline ->
                if (baseline == AlignmentLine.Unspecified) null else baseline
            } ?: 0

            val titleOffset = TitleBaselineDistanceFromTop.roundToPx()

            // Place the title so that its first baseline is titleOffset from the top
            val titlePositionY = titleOffset - firstTitleBaseline

            val firstTextBaseline = textPlaceable?.get(FirstBaseline)?.let { baseline ->
                if (baseline == AlignmentLine.Unspecified) null else baseline
            } ?: 0

            val textOffset = if (titlePlaceable == null) {
                TextBaselineDistanceFromTop.roundToPx()
            } else {
                TextBaselineDistanceFromTitle.roundToPx()
            }

            // Combined height of title and spacing above
            val titleHeightWithSpacing = titlePlaceable?.let { it.height + titlePositionY } ?: 0

            // Align the bottom baseline of the text with the bottom baseline of the title, and then
            // add the offset
            val textPositionY = if (titlePlaceable == null) {
                // If there is no title, just place the text offset from the top of the dialog
                textOffset - firstTextBaseline
            } else {
                if (lastTitleBaseline == 0) {
                    // If `title` has no baseline, just place the text's baseline textOffset from the
                    // bottom of the title
                    titleHeightWithSpacing - firstTextBaseline + textOffset
                } else {
                    // Otherwise place the text's baseline textOffset from the title's last baseline
                    (titlePositionY + lastTitleBaseline) - firstTextBaseline + textOffset
                }
            }

            // Combined height of text and spacing above
            val textHeightWithSpacing = textPlaceable?.let {
                if (lastTitleBaseline == 0) {
                    textPlaceable.height + textOffset - firstTextBaseline
                } else {
                    textPlaceable.height + textOffset - firstTextBaseline -
                            ((titlePlaceable?.height ?: 0) - lastTitleBaseline)
                }
            } ?: 0

            val layoutHeight = titleHeightWithSpacing + textHeightWithSpacing

            layout(layoutWidth, layoutHeight) {
                titlePlaceable?.place(0, titlePositionY)
                textPlaceable?.place(0, textPositionY)
            }
        }
    }

    @Composable
    internal fun InputDialogFlowRow(
        mainAxisSpacing: Dp,
        crossAxisSpacing: Dp,
        content: @Composable () -> Unit
    ) {
        Layout(content) { measurables, constraints ->
            val sequences = mutableListOf<List<Placeable>>()
            val crossAxisSizes = mutableListOf<Int>()
            val crossAxisPositions = mutableListOf<Int>()

            var mainAxisSpace = 0
            var crossAxisSpace = 0

            val currentSequence = mutableListOf<Placeable>()
            var currentMainAxisSize = 0
            var currentCrossAxisSize = 0

            val childConstraints = Constraints(maxWidth = constraints.maxWidth)

            // Return whether the placeable can be added to the current sequence.
            fun canAddToCurrentSequence(placeable: Placeable) =
                currentSequence.isEmpty() || currentMainAxisSize + mainAxisSpacing.roundToPx() +
                        placeable.width <= constraints.maxWidth

            // Store current sequence information and start a new sequence.
            fun startNewSequence() {
                if (sequences.isNotEmpty()) {
                    crossAxisSpace += crossAxisSpacing.roundToPx()
                }
                sequences += currentSequence.toList()
                crossAxisSizes += currentCrossAxisSize
                crossAxisPositions += crossAxisSpace

                crossAxisSpace += currentCrossAxisSize
                mainAxisSpace = max(mainAxisSpace, currentMainAxisSize)

                currentSequence.clear()
                currentMainAxisSize = 0
                currentCrossAxisSize = 0
            }

            for (measurable in measurables) {
                // Ask the child for its preferred size.
                val placeable = measurable.measure(childConstraints)

                // Start a new sequence if there is not enough space.
                if (!canAddToCurrentSequence(placeable)) startNewSequence()

                // Add the child to the current sequence.
                if (currentSequence.isNotEmpty()) {
                    currentMainAxisSize += mainAxisSpacing.roundToPx()
                }
                currentSequence.add(placeable)
                currentMainAxisSize += placeable.width
                currentCrossAxisSize = max(currentCrossAxisSize, placeable.height)
            }

            if (currentSequence.isNotEmpty()) startNewSequence()

            val mainAxisLayoutSize = if (constraints.maxWidth != Constraints.Infinity) {
                constraints.maxWidth
            } else {
                max(mainAxisSpace, constraints.minWidth)
            }
            val crossAxisLayoutSize = max(crossAxisSpace, constraints.minHeight)

            val layoutWidth = mainAxisLayoutSize

            val layoutHeight = crossAxisLayoutSize

            layout(layoutWidth, layoutHeight) {
                sequences.forEachIndexed { i, placeables ->
                    val childrenMainAxisSizes = IntArray(placeables.size) { j ->
                        placeables[j].width +
                                if (j < placeables.lastIndex) mainAxisSpacing.roundToPx() else 0
                    }
                    val arrangement = Arrangement.Bottom
                    // TODO(soboleva): rtl support
                    // Handle vertical direction
                    val mainAxisPositions = IntArray(childrenMainAxisSizes.size) { 0 }
                    with(arrangement) {
                        arrange(mainAxisLayoutSize, childrenMainAxisSizes, mainAxisPositions)
                    }
                    placeables.forEachIndexed { j, placeable ->
                        placeable.place(
                            x = mainAxisPositions[j],
                            y = crossAxisPositions[i]
                        )
                    }
                }
            }
        }
    }

    private val TitlePadding = Modifier.padding(start = 24.dp, end = 24.dp)
    private val TextPadding = Modifier.padding(start = 24.dp, end = 24.dp, bottom = 28.dp)

    // Baseline distance from the first line of the title to the top of the dialog
    private val TitleBaselineDistanceFromTop = 40.sp

    // Baseline distance from the first line of the text to the last line of the title
    private val TextBaselineDistanceFromTitle = 36.sp

    // For dialogs with no title, baseline distance from the first line of the text to the top of the
// dialog
    private val TextBaselineDistanceFromTop = 38.sp

}
