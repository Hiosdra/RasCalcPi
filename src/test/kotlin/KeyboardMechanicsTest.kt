import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

internal class KeyboardMechanicsTest {

    @AfterEach
    fun tearDown() {
        Device.INSTANCE.reset()
    }

    @Test
    internal fun keyboardSingleOffWhenScreenOn() {
        Device.INSTANCE.keyboard.run {
            pressKey(Key.ON)
            pressKey(Key.K5)
            pressKey(Key.OFF)
        }
        assertFalse(Device.INSTANCE.screen.powered)
        assertScreenShow("5")
    }

    @Test
    internal fun keyboardTwoOffWhenScreenOn() {
        Device.INSTANCE.keyboard.run {
            pressKey(Key.ON)
            pressKey(Key.OFF)
            pressKey(Key.OFF)
        }
        assertFalse(Device.INSTANCE.screen.powered)
        assertScreenShow("")
    }


}