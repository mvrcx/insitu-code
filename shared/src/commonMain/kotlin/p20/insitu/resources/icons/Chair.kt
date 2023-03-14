package p20.insitu.resources.icons

import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathParser
import p20.insitu.resources.icons.Icons.makeImageVector

public val Icons.Filled.Chair: ImageVector
    get() {
        if (_icon != null) {
            return _icon!!
        }
        _icon = makeImageVector(name = "Chair", viewportWidth = 100f, viewportHeight = 100f) {
            addPath(
                pathData = PathParser().parsePathString(
                    "M69.9,58.7H75c2.3,0 4.1,-1.8 4.1,-4.1c0,-2.3 -1.8,-4.1 -4.1,-4.1H36.5" +
                            "L29.1,5.9c-0.4,-2.2 -2.5,-3.8 -4.7,-3.4c-2.2,0.4 -3.8,2.5 -3.4,4.7l8.1," +
                            "48c0.3,2 2.1,3.4 4.1,3.4h3.9l-8.3,33.7c-0.5,2.2 0.8,4.4 3,5c0.3,0.1 0.7" +
                            ",0.1 1,0.1c1.8,0 3.5,-1.3 4,-3.1l3.6,-14.5h26.4l3.6,14.5c0.5,1.9 2.1," +
                            "3.1 4,3.1c0.3,0 0.7,0 1,-0.1c2.2,-0.5 3.6,-2.8 3,-5L69.9,58.7zM41.7," +
                            "73.9l3.8,-15.2h15.9l3.8,15.2H41.7z"
                ).toNodes(),
                fill = SolidColor(Color.Black)
            )
        }
        return _icon!!
    }

private var _icon: ImageVector? = null