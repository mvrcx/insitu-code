package p20.insitu.resources.icons

import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathParser
import p20.insitu.resources.icons.Icons.makeImageVector

public val Icons.Filled.Apartment: ImageVector
    get() {
        if (_icon != null) {
            return _icon!!
        }
        _icon = makeImageVector(
            name = "Apartment",
            viewportWidth = 511.986f,
            viewportHeight = 511.986f
        ) {
            addPath(
                pathData = PathParser().parsePathString(
                    "M445.5,0L0,0v427.8h372.9L372.9,500h83.8c23.9,0 43.3,-19.4 43.3,-43.2L" +
                            "500,54.4C500,24.4 475.5,0 445.5,0zM14.2,413.6L14.2,14.2h431.3c22.2,0 " +
                            "40.3,18 40.3,40.2v370.4c-7.1,-6.5 -16.4,-10.6 -26.8,-11.1h-0.2h-16.4v" +
                            "-0.1h-69.5v0.1L14.2,413.6L14.2,413.6zM456.7,485.8h-69.6v-58h71.3c14.5," +
                            "0.9 26,12.2 27.2,26.5l0,0c0,0.1 0,0.2 0,0.2c0.1,0.8 0.1,1.5 0.1,2.3C" +
                            "485.8,472.8 472.7,485.8 456.7,485.8z"
                ).toNodes(),
                fill = SolidColor(Color.Black)
            )
            addPath(
                pathData = PathParser().parsePathString(
                    "M431.8,85.8l-45.2,0l0,14.2l31,0l0,227.8l-107.5,0l0,-41.9l-14.2,0l0," +
                            "41.9l-202.3,0l0,-106.8l202.3,0l0,27.1l14.2,0l0,-41.3l-61.6,0l0,-39.2l" +
                            "-14.3,0l0,39.2l-140.6,0l0,-106.8l140.6,0l0,32.6l14.3,0l0,-32.6l83.9," +
                            "0l0,-14.2l-253,0l0,256.2l352.4,0z"
                ).toNodes(),
                fill = SolidColor(Color.Black)
            )
        }
        return _icon!!
    }

private var _icon: ImageVector? = null