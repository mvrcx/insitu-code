package p20.insitu.resources.icons

import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathParser
import p20.insitu.resources.icons.Icons.makeImageVector

public val Icons.Filled.Floor: ImageVector
    get() {
        if (_icon != null) {
            return _icon!!
        }
        _icon = makeImageVector(
            name = "Floor",
            viewportWidth = 1000f,
            viewportHeight = 1000f
        ) {
            addPath(
                pathData = PathParser().parsePathString(
                    "M500.1,574.3c-23,0-45.1-3.7-62.1-10.5L49.3,410C15.1,396.5,10,374.9,10,363.2c0-11.7,5.1-33.3,39.3-46.8l388.6-153.6c34.1-13.5,90.1-13.5,124.2,0l388.6,153.8c34.2,13.5,39.3,35.1,39.3,46.8c0,11.7-5.1,33.3-39.3,46.8L562.1,563.8C545.1,570.6,523,574.3,500.1,574.3z M85.2,363.3l373.6,147.8c20.8,8.2,61.6,8.2,82.4,0l373.5-147.7L541.2,215.6c-20.8-8.2-61.6-8.2-82.4,0L85.2,363.3z"
                ).toNodes(),
                fill = SolidColor(Color.Black)
            )
            addPath(
                pathData = PathParser().parsePathString(
                    "M500.1,719.6c-23,0-45.1-3.7-62.1-10.5L49.3,555.4C15.1,541.9,10,520.3,10,508.6c0-11.7,5.1-33.3,39.3-46.8l142.6-56.4l266.9,105.6c20.8,8.2,61.6,8.2,82.4,0l266.8-105.5L950.7,462c34.2,13.5,39.3,35.1,39.3,46.8c0,11.7-5.1,33.3-39.3,46.8L562.1,709.2C545.1,715.9,523,719.6,500.1,719.6z M85.2,508.6l373.6,147.8c20.8,8.2,61.6,8.2,82.4,0l373.5-147.7l-106.7-42.2l-246,97.2c-34.1,13.5-90.1,13.5-124.1,0l-246-97.3L85.2,508.6z"
                ).toNodes(),
                fill = SolidColor(Color.Black)
            )
            addPath(
                pathData = PathParser().parsePathString(
                    "M500.1,847.3c-23,0-45.1-3.7-62.1-10.5L49.3,683.1C15.1,669.5,10,647.9,10,636.3c0-11.7,5.1-33.3,39.3-46.8L169.5,542l289.3,114.5c20.8,8.2,61.6,8.2,82.4,0l289.3-114.4l120.2,47.5c34.2,13.5,39.3,35.2,39.3,46.8s-5.1,33.3-39.3,46.8L562.1,836.8C545.1,843.6,523,847.3,500.1,847.3z M85.2,636.3l373.6,147.8c20.8,8.2,61.6,8.2,82.4,0l373.5-147.7l-84.2-33.3L562.1,709.2c-34.1,13.5-90.1,13.5-124.1,0L169.5,603L85.2,636.3z"
                ).toNodes(),
                fill = SolidColor(Color.Black)
            )
        }
        return _icon!!
    }

private var _icon: ImageVector? = null