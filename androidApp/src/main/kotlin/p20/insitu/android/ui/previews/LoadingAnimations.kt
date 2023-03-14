package p20.insitu.android.ui.previews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class LoadingAnimations {

    @Preview(showBackground = true)
    @Composable
    fun DotsPreview() = MaterialTheme {
        Column(modifier = Modifier.padding(4.dp)) {
            val spaceSize = 16.dp

            Text(
                text = "Dots pulsing",
                style = MaterialTheme.typography.h5
            )
            p20.insitu.android.ui.components.LoadingAnimations.DotsPulsing()

            Spacer(Modifier.height(spaceSize))

            Text(
                text = "Dots elastic",
                style = MaterialTheme.typography.h5
            )
            p20.insitu.android.ui.components.LoadingAnimations.DotsElastic()

            Spacer(Modifier.height(spaceSize))

            Text(
                text = "Dots flashing",
                style = MaterialTheme.typography.h5
            )
            p20.insitu.android.ui.components.LoadingAnimations.DotsFlashing()

            Spacer(Modifier.height(spaceSize))

            Text(
                text = "Dots typing",
                style = MaterialTheme.typography.h5
            )
            p20.insitu.android.ui.components.LoadingAnimations.DotsTyping()

            Spacer(Modifier.height(spaceSize))

            Text(
                text = "Dots collision",
                style = MaterialTheme.typography.h5
            )
            p20.insitu.android.ui.components.LoadingAnimations.DotsCollision()
        }
    }
}