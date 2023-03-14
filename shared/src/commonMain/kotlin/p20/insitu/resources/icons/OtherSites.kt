package p20.insitu.resources.icons

import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathParser
import p20.insitu.resources.icons.Icons.makeImageVector

public val Icons.Filled.OtherSites: ImageVector
    get() {
        if (_icon != null) {
            return _icon!!
        }
        _icon = makeImageVector(name = "OtherSites", viewportWidth = 24f, viewportHeight = 24f) {
            addPath(
                pathData = PathParser().parsePathString(
                    "M3,13h8L11,3L3,3v10zM3,21h8v-6L3,15v6zM13,21h8L21,11h-8v10zM13,3v6h8L21,3h-8z"
                ).toNodes(),
                fill = SolidColor(Color.Black)
            )
        }
        return _icon!!
    }

private var _icon: ImageVector? = null