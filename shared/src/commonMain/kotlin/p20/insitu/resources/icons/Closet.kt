package p20.insitu.resources.icons

import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathParser
import p20.insitu.resources.icons.Icons.makeImageVector

public val Icons.Filled.Closet: ImageVector
    get() {
        if (_icon != null) {
            return _icon!!
        }
        _icon = makeImageVector(name = "Closet", viewportWidth = 64f, viewportHeight = 64f) {
            addPath(
                pathData = PathParser().parsePathString(
                    "M16,61L20,61L20,64L16,64L16,61ZM10,2.0001L31,2.0001L31,2.0001C31.5523," +
                            "2.0001 32,2.4478 32,3.0001L32,61.0001L10,61.0001C9.4477,61.0001 9," +
                            "60.5523 9,60.0001L9,3.0001L9,3.0001C9,2.4478 9.4477,2.0001 10,2.0001L10," +
                            "2.0001ZM27,24.9999L27,36.9999L29,36.9999L29,24.9999L27,24.9999ZM46," +
                            "61L50,61L50,64L46,64L46,61ZM34,2.0001L55,2.0001L55,2.0001C55.5523,2.0001 " +
                            "56,2.4478 56,3.0001L56,60.0001C56,60.5523 55.5523,61.0001 55,61.0001L33," +
                            "61.0001L33,3.0001L33,3.0001C33,2.4478 33.4477,2.0001 34,2.0001L34,2.0001Z" +
                            "M36,24.9999L36,36.9999L38,36.9999L38,24.9999L36,24.9999Z"
                ).toNodes(),
                fill = SolidColor(Color.Black)
            )
        }
        return _icon!!
    }

private var _icon: ImageVector? = null