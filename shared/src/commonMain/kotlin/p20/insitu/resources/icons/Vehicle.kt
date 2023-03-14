package p20.insitu.resources.icons

import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathParser
import p20.insitu.resources.icons.Icons.makeImageVector

public val Icons.Filled.Vehicle: ImageVector
    get() {
        if (_icon != null) {
            return _icon!!
        }
        _icon = makeImageVector(name = "Vehicle", viewportWidth = 24f, viewportHeight = 24f) {
            addPath(
                pathData = PathParser().parsePathString(
                    "M18.92,6.01C18.72,5.42 18.16,5 17.5,5h-11c-0.66,0 -1.21,0.42 -1.42," +
                            "1.01L3,12v8c0,0.55 0.45,1 1,1h1c0.55,0 1,-0.45 1,-1v-1h12v1c0,0.55 " +
                            "0.45,1 1,1h1c0.55,0 1,-0.45 1,-1v-8l-2.08,-5.99zM6.5,16c-0.83,0 -1.5," +
                            "-0.67 -1.5,-1.5S5.67,13 6.5,13s1.5,0.67 1.5,1.5S7.33,16 6.5,16zM17.5,16" +
                            "c-0.83,0 -1.5,-0.67 -1.5,-1.5s0.67,-1.5 1.5,-1.5 1.5,0.67 1.5,1.5 -0.67" +
                            ",1.5 -1.5,1.5zM5,11l1.5,-4.5h11L19,11L5,11z"
                ).toNodes(),
                fill = SolidColor(Color.Black)
            )
        }
        return _icon!!
    }

private var _icon: ImageVector? = null