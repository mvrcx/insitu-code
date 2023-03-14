package p20.insitu.resources.icons

import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathParser
import p20.insitu.resources.icons.Icons.makeImageVector

public val Icons.Filled.Window: ImageVector
    get() {
        if (_icon != null) {
            return _icon!!
        }
        _icon = makeImageVector(
            name = "Window",
            viewportWidth = 53f,
            viewportHeight = 53f
        ) {
            addPath(
                pathData = PathParser().parsePathString(
                    "M50.5,0h-6c-0.552,0-1,0.448-1,1h-30c0-0.552-0.448-1-1-1h-5h-5c-0.552,0-1,0.448-1,1v48.506C1.5,51.433,3.07,53,5,53" +
                            "c0.98,0,1.864-0.407,2.5-1.056C8.136,52.593,9.02,53,10,53c1.93,0,3.5-1.567,3.5-3.494V46h30v3c0,2.206,1.794,4,4,4s4-1.794,4-4V1" +
                            "C51.5,0.448,51.052,0,50.5,0z M13.5,7h30v32h-30V7z M43.5,3v2h-30V3H43.5z M5,51c-0.827,0-1.5-0.67-1.5-1.494V2h3v47.506" +
                            "C6.5,50.33,5.827,51,5,51z M11.5,49.506C11.5,50.33,10.827,51,10,51s-1.5-0.67-1.5-1.494V2h3v1v3v34v5V49.506z M13.5,44v-3h30v3" +
                            "H13.5z M49.5,49c0,1.103-0.897,2-2,2s-2-0.897-2-2v-4v-5V6V3V2h4V49z"
                ).toNodes(),
                fill = SolidColor(Color.Black)
            )
            addPath(
                pathData = PathParser().parsePathString(
                    "M16.5,15c0.256,0,0.512-0.098,0.707-0.293l3-3c0.391-0.391,0.391-1.023,0-1.414s-1.023-0.391-1.414,0l-3,3" +
                            "c-0.391,0.391-0.391,1.023,0,1.414C15.988,14.902,16.244,15,16.5,15z"
                ).toNodes(),
                fill = SolidColor(Color.Black)
            )
            addPath(
                pathData = PathParser().parsePathString(
                    "M23.793,10.293l-8,8c-0.391,0.391-0.391,1.023,0,1.414C15.988,19.902,16.244,20,16.5,20s0.512-0.098,0.707-0.293l8-8" +
                            "c0.391-0.391,0.391-1.023,0-1.414S24.184,9.902,23.793,10.293z"
                ).toNodes(),
                fill = SolidColor(Color.Black)
            )
        }
        return _icon!!
    }

private var _icon: ImageVector? = null