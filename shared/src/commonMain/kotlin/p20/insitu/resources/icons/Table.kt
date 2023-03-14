package p20.insitu.resources.icons

import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathParser
import p20.insitu.resources.icons.Icons.makeImageVector

public val Icons.Filled.Table: ImageVector
    get() {
        if (_icon != null) {
            return _icon!!
        }
        _icon = makeImageVector(
            name = "Table",
            viewportWidth = 511.986f,
            viewportHeight = 511.986f
        ) {
            addPath(
                pathData = PathParser().parsePathString(
                    "M509.213,190.18l-76.8-85.333c-2.027-2.24-4.907-3.52-7.893-3.52" +
                            "H87.453c-2.987,0-5.867,1.28-7.893,3.52l-76.8,85.333 c-3.947,4.373" +
                            "-3.627,11.093,0.747,15.04c1.92,1.813,4.48,2.773,7.147,2.773h53.333" +
                            "v192c0,5.867,4.8,10.667,10.667,10.667 c5.867,0,10.667-4.8,10.667" +
                            "-10.667v-192h42.667v96c0,5.867,4.8,10.667,10.667,10.667c5.867,0," +
                            "10.667-4.8,10.667-10.667v-96h224v96 c0,5.867,4.8,10.667,10.667," +
                            "10.667c5.867,0,10.667-4.8,10.667-10.667v-96h42.667v192c0,5.867,4.8," +
                            "10.667,10.667,10.667 c5.867,0,10.667-4.8,10.667-10.667v-192h42.667" +
                            "c5.867,0,10.667-4.8,10.667-10.667C511.986,194.66,511.026,192.1," +
                            "509.213,190.18z M34.546,186.66l57.6-64h327.573l57.6,64H34.546z"
                )
                    .toNodes(),
                fill = SolidColor(Color.Black)
            )
        }
        return _icon!!
    }

private var _icon: ImageVector? = null