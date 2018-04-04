import Drivers.MockKeyboard
import Drivers.MockScreen

class Device private constructor() {
    companion object {
        var INSTANCE = Device()
        private set
    }
    val keyboardOperator by lazy { KeyboardOperator() }
    val keyboard by lazy { MockKeyboard() }
    val screen by lazy { MockScreen() }

    fun reset() {
        INSTANCE = Device()
    }
}