package p20.insitu.resources.icons

import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathParser
import p20.insitu.resources.icons.Icons.makeImageVector

public val Icons.Filled.Sofa: ImageVector
    get() {
        if (_icon != null) {
            return _icon!!
        }
        _icon = makeImageVector(name = "Sofa", viewportWidth = 24f, viewportHeight = 24f) {
            addPath(
                pathData = PathParser().parsePathString(
                    "M21,10c-1.1,0 -2,0.9 -2,2v3L5,15v-3c0,-1.1 -0.9,-2 -2,-2s-2,0.9 " +
                            "-2,2v5c0,1.1 0.9,2 2,2h18c1.1,0 2,-0.9 2,-2v-5c0,-1.1 -0.9,-2 -2," +
                            "-2zM18,5L6,5c-1.1,0 -2,0.9 -2,2v2.15c1.16,0.41 2,1.51 2,2.82L6,14h12" +
                            "v-2.03c0,-1.3 0.84,-2.4 2,-2.82L20,7c0,-1.1 -0.9,-2 -2,-2z"
                ).toNodes(),
                fill = SolidColor(Color.Black)
            )
        }
        return _icon!!
    }

private var _icon: ImageVector? = null