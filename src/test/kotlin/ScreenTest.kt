import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ScreenTest {

    @AfterEach
    fun tearDown() {
        Device.INSTANCE.reset()
    }

    @Test
    internal fun screenToStringWhenScreenOn() {
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.ON)
            onKeyPress(Key.K5)
        }
        assertEquals("{powered: true, text: 5}", Device.INSTANCE.screen.toString())
    }

    @Test
    internal fun screenToStringWhenScreenOff() {
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.ON)
            onKeyPress(Key.K5)
            onKeyPress(Key.OFF)
        }
        assertEquals("{powered: false}", Device.INSTANCE.screen.toString())
    }
}