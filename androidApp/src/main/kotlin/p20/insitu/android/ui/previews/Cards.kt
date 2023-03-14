package p20.insitu.android.ui.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import p20.insitu.model.util.ObjectFactory
import p20.insitu.resources.Language
import p20.insitu.theme.InsituTheme
import p20.insitu.util.getCurrentZonedDateTime

@Preview(showBackground = true)
@Composable
fun InvestigationCardPreview(){
    val investigation = ObjectFactory.createInvestigation("hallo", "123", getCurrentZonedDateTime())
    InsituTheme {
        p20.insitu.android.ui.components.Cards.Investigation(docuModeActive = true, investigation = investigation, language = Language.DE){}
    }
}

@Preview(showBackground = true)
@Composable
fun InvestigationCardPreviewDark(){
    val investigation = ObjectFactory.createInvestigation("hallo", "123", getCurrentZonedDateTime())
    InsituTheme(darkTheme = true) {
        p20.insitu.android.ui.components.Cards.Investigation(docuModeActive = true, investigation = investigation, language = Language.DE){}
    }
}