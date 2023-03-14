package p20.insitu.resources.icons

import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathParser
import p20.insitu.resources.icons.Icons.makeImageVector

public val Icons.Filled.Room: ImageVector
    get() {
        if (_icon != null) {
            return _icon!!
        }
        _icon = makeImageVector(name = "Room", viewportWidth = 100f, viewportHeight = 100f) {
            addPath(
                pathData = PathParser().parsePathString("M49.69,56.896l-0.075,-0.036l0,32.014l0.075,0.033z")
                    .toNodes(),
                fill = SolidColor(Color.Black)
            )
            addPath(
                pathData = PathParser().parsePathString("M0,34.121l0,32.649l49.615,22.104l0,-32.014z")
                    .toNodes(),
                fill = SolidColor(Color.Black)
            )
            addPath(
                pathData = PathParser().parsePathString("M100,34.121l-49.616,22.739l0,32.014l49.616,-22.104z")
                    .toNodes(),
                fill = SolidColor(Color.Black)
            )
            addPath(
                pathData = PathParser().parsePathString("M100,33.23l-49.691,-22.137l0,32.011l14.115,6.47l35.576,-16.307z")
                    .toNodes(),
                fill = SolidColor(Color.Black)
            )
            addPath(
                pathData = PathParser().parsePathString("M49.69,11.093l-49.69,22.137l0,0.037l35.577,16.307l14.113,-6.47z")
                    .toNodes(),
                fill = SolidColor(Color.Black)
            )
        }
        return _icon!!
    }

private var _icon: ImageVector? = null