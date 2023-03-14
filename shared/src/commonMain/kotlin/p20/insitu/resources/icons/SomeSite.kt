package p20.insitu.resources.icons

import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathParser
import p20.insitu.resources.icons.Icons.makeImageVector

public val Icons.Filled.SomeSite: ImageVector
    get() {
        if (_icon != null) {
            return _icon!!
        }
        _icon = makeImageVector(name = "SomeSite", viewportWidth = 82f, viewportHeight = 82f) {
            addPath(
                pathData = PathParser().parsePathString(
                    "M66.2412,10H15.7583L10,15.7583V66.2412L15.7583,72H66.2412L72,66.2412" +
                            "V15.7583ZM70,54.0342 L54.0342,70H42.3794L70,42.3794ZM70,39.5513 " +
                            "L39.5513,70H27.897L70,27.897ZM12,27.9658 L27.9658,12h11.6543L12," +
                            "39.6201ZM12,42.4482 L42.4482,12H54.1035L12,54.1035ZM16.5864,12" +
                            "H25.1377L12,25.1377V16.5864ZM12,56.9316 L56.9316,12h8.4815L66.9993," +
                            "13.5861 13.5864,66.9996 12,65.4131ZM15.0003,68.4138 L68.4135,15.0001 " +
                            "70,16.5864v8.4824L25.0688,70H16.5864ZM65.4131,70H56.8623L70,56.8623" +
                            "v8.5508z"
                ).toNodes(),
                fill = SolidColor(Color.Black)
            )
        }
        return _icon!!
    }

private var _icon: ImageVector? = null