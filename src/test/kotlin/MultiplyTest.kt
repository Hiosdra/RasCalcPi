import org.junit.jupiter.api.AfterEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MultiplyTest {

    @AfterEach
    fun tearDown() {
        Device.INSTANCE.reset()
    }

    @Test
    internal fun multiply2times2() {
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.ON)
            onKeyPress(Key.K2)
            onKeyPress(Key.MULTIPLY)
            onKeyPress(Key.K2)
            onKeyPress(Key.RESULT)
        }
        assertScreenShow("4")
    }

    @Test
    internal fun multiplyMinus2times2() {
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.ON)
            onKeyPress(Key.MINUS)
            onKeyPress(Key.K2)
            onKeyPress(Key.MULTIPLY)
            onKeyPress(Key.K2)
            onKeyPress(Key.RESULT)
        }
        assertScreenShow("-4")
    }

    @Test
    internal fun multiply3times1AndHalf() {
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.ON)
            onKeyPress(Key.K3)
            onKeyPress(Key.MULTIPLY)
            onKeyPress(Key.K1)
            onKeyPress(Key.COMMA)
            onKeyPress(Key.K5)
            onKeyPress(Key.RESULT)
        }
        assertScreenShow("4.5")
    }
}