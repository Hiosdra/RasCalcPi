import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

internal class AddTest {
    @AfterEach
    internal fun tearDown() {
        Device.INSTANCE.reset()
    }

    @Test
    internal fun add3to8() {
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.K8)
            onKeyPress(Key.PLUS)
            onKeyPress(Key.K3)
            onKeyPress(Key.RESULT)
        }
        assertScreenShow("11")
    }

    @Test
    internal fun add50ToMinus97() {
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.ON)
            onKeyPress(Key.MINUS)
            onKeyPress(Key.K9)
            onKeyPress(Key.K7)
            onKeyPress(Key.PLUS)
            onKeyPress(Key.K5)
            onKeyPress(Key.K0)
            onKeyPress(Key.RESULT)
        }
        assertScreenShow("-47")
    }

    @Test
    internal fun addDecimalToInteger() {
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.ON)
            onKeyPress(Key.K1)
            onKeyPress(Key.COMMA)
            onKeyPress(Key.K5)
            onKeyPress(Key.PLUS)
            onKeyPress(Key.K3)
            onKeyPress(Key.RESULT)
        }
        assertScreenShow("4.5")
    }
}