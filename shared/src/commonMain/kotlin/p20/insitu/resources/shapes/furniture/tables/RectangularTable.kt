package p20.insitu.resources.shapes.furniture.tables

import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.PathParser
import p20.insitu.resources.icons.Icons.makeImageVector
import p20.insitu.resources.shapes.ShapeType
import p20.insitu.resources.shapes.Shapes

public val Shapes.Furniture.Tables.RectangularTable: ShapeType
    get() {
        if (_shape != null) {
            return _shape!!
        }
        _shape = ShapeType(
            name = "RectangularTable",
            top = makeImageVector(
                name = "RectangularTable.Top",
                viewportWidth = 1.64f,
                viewportHeight = 1.64f
            ) {
                addPath(
                    pathData = PathParser().parsePathString(
                        "h1.6 v0.8 h-1.6 v-0.8 Z"
                    ).toNodes(),
                    fill = SolidColor(Color.Black)
                )
            },
            bottom = null,
            left = null,
            right = null,
            front = null,
            back = null
        )
        return _shape!!
    }

private var _shape: ShapeType? = null