package p20.insitu.resources.shapes

import androidx.compose.ui.graphics.vector.ImageVector

class ShapeType(
    val name: String,
    var top: ImageVector? = null,
    var bottom: ImageVector? = null,
    var left: ImageVector? = null,
    var right: ImageVector? = null,
    var front: ImageVector? = null,
    var back: ImageVector? = null,
)