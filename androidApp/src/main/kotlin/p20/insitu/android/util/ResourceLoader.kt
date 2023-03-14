package p20.insitu.android.util

import androidx.annotation.PluralsRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import java.io.File

@Composable
fun drawableResource(filename: String): Painter {
    return painterResource(id = LocalContext.current.resources.getIdentifier(File(filename).nameWithoutExtension, "drawable", LocalContext.current.packageName))
}

@Composable
fun pluralStringResource(
    @PluralsRes resId: Int,
    quantity: Int,
    vararg formatArgs: Any?
): String {
    return LocalContext.current.resources
        .getQuantityString(resId, quantity, *formatArgs)
}

@Composable
fun stringResource(@StringRes resId: Int): String {
    return LocalContext.current.resources
        .getString(resId)
}