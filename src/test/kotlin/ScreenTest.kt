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
        Device.INSTANCE.keyboard.run {
            pressKey(Key.ON)
            pressKey(Key.K5)
        }
        assertEquals("{powered: true, text: 5}", Device.INSTANCE.screen.toString())
    }

    @Test
    internal fun screenToStringWhenScreenOff() {
        Device.INSTANCE.keyboard.run {
            pressKey(Key.ON)
            pressKey(Key.K5)
            pressKey(Key.OFF)
        }
        assertEquals("{powered: false}", Device.INSTANCE.screen.toString())
    }
}