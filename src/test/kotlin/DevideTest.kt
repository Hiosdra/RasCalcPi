import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

internal class DevideTest {

    @AfterEach
    fun tearDown() {
        Device.INSTANCE.reset()
    }

    @Test
    internal fun devide6times2() {
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.ON)
            onKeyPress(Key.K6)
            onKeyPress(Key.DEVIDE)
            onKeyPress(Key.K2)
            onKeyPress(Key.RESULT)
        }
        assertScreenShow("3")
    }

    @Test
    internal fun devide5times2() {
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.ON)
            onKeyPress(Key.K5)
            onKeyPress(Key.DEVIDE)
            onKeyPress(Key.K2)
            onKeyPress(Key.RESULT)
        }
        assertScreenShow("2.5")
    }

    @Test
    internal fun devideMinus6times2() {
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.ON)
            onKeyPress(Key.MINUS)
            onKeyPress(Key.K6)
            onKeyPress(Key.DEVIDE)
            onKeyPress(Key.K2)
            onKeyPress(Key.RESULT)
        }
        assertScreenShow("-3")
    }

    @Test
    internal fun devideMinus5times2() {
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.ON)
            onKeyPress(Key.MINUS)
            onKeyPress(Key.K5)
            onKeyPress(Key.DEVIDE)
            onKeyPress(Key.K2)
            onKeyPress(Key.RESULT)
        }
        assertScreenShow("-2.5")
    }

    @Test
    internal fun devide5Times2AndHalf() {
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.ON)
            onKeyPress(Key.K5)
            onKeyPress(Key.DEVIDE)
            onKeyPress(Key.K2)
            onKeyPress(Key.COMMA)
            onKeyPress(Key.K5)
            onKeyPress(Key.RESULT)
        }
        assertScreenShow("2")
    }
}