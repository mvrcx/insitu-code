//package p20.insitu.views.components
//
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.layout.Row
//import androidx.compose.material.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.graphics.Color
//import p20.insitu.resources.Language
//import androidx.compose.material.Chip
//
//object Chips {
//
//    @OptIn(ExperimentalMaterialApi::class)
//    @Composable
//    fun Keyword(
//        text: String,
//        editMode: Boolean,
//        language: Language,
//        onDelete: () -> Unit
//    ) {
//        Chip(
//            onClick = { /* Do nothing! */ },
//            border = BorderStroke(
//                ChipDefaults.OutlinedBorderSize,
//                Color.Red
//            ),
//            colors = ChipDefaults.outlinedChipColors()
//        ) {
//            Row {
//                Text(text)
//                if (editMode) {
//                    SpacersAndDividers.HorizontalSpacer()
//                    IconButtons.Close(
//                        language = language
//                    ) {
//                        onDelete()
//                    }
//                }
//            }
//        }
//    }
//}