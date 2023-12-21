import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource


@Composable
fun GameComponent() {
    val dinoImage = painterResource("rak.png")

    Image(dinoImage, "dino")
}