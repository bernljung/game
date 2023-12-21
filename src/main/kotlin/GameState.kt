import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf

class GameState {

    val rakState = RakState()
    val mutableRakState = mutableStateOf(rakState)

    fun update(l: Long) {
        rakState.update()
    }
}