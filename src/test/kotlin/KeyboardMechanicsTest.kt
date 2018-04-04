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
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.ON)
            onKeyPress(Key.K5)
            onKeyPress(Key.OFF)
        }
        assertFalse(Device.INSTANCE.screen.powered)
        assertScreenShow("5")
    }

    @Test
    internal fun keyboardTwoOffWhenScreenOn() {
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.ON)
            onKeyPress(Key.OFF)
            onKeyPress(Key.OFF)
        }
        assertFalse(Device.INSTANCE.screen.powered)
        assertScreenShow("")
    }


}