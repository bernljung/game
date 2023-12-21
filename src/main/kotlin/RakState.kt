import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class RakState(currentPosY: Int = 0) {
    var currentPosY = mutableStateOf(currentPosY)
    var velocity = -40
    var gravity = 2
    var ground = 0
    val image = "rak.png"
    var isJumping = false
    lateinit var onReachingGround: () -> Unit

    fun jump(onReachingGround: () -> Unit) {
        isJumping = true
        this.onReachingGround = onReachingGround
    }

    fun update() {
        if (isJumping) {
            currentPosY.value += velocity
            velocity += gravity
            println("Velocity; $velocity")
            println("Current Pos; ${currentPosY.value}")

            if (currentPosY.value > ground) {
                currentPosY.value = 0
                velocity = -40000
                gravity = 2
                onReachingGround()
            }
        }
    }
}

@Composable
fun Raka(state: MutableState<RakState>) {
    Image(
        painterResource(state.value.image), "räka", modifier = Modifier
            .offset(y = (state.value.currentPosY.value).dp)
    )
}