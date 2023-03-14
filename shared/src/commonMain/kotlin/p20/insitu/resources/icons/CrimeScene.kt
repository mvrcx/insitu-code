package p20.insitu.resources.icons

import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathParser
import p20.insitu.resources.icons.Icons.makeImageVector

public val Icons.Filled.CrimeScene: ImageVector
    get() {
        if (_electronics != null) {
            return _electronics!!
        }
        _electronics = makeImageVector(name = "CrimeScene", viewportWidth = 60f, viewportHeight = 60f) {
            addPath(
                pathData = PathParser().parsePathString(
                    "m37.7635,44.9591 l11.0772,-34.6118 6.3133,34.7275z"
                ).toNodes(),
                fill = SolidColor(Color.Black)
            )
            addPath(
                pathData = PathParser().parsePathString(
                    "M17.248,10 L4.6113,49.5L36.1953,49.5L48.8398,10ZM30.4355,17.3379h1.7813l-6.7422,21.209h3.1445l-1.0508,3.0293L18.0938,41.5762l0.9707,-3.1445h3.1348,0.1152l5.6191,-17.373h-5.0137l0.6328,-2.0391z"
                ).toNodes(),
                fill = SolidColor(Color.Black)
            )
        }
        return _electronics!!
    }

private var _electronics: ImageVector? = null