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
        Device.INSTANCE.keyboard.run {
            pressKey(Key.ON)
            pressKey(Key.K2)
            pressKey(Key.MULTIPLY)
            pressKey(Key.K2)
            pressKey(Key.RESULT)
        }
        assertScreenShow("4")
    }

    @Test
    internal fun multiplyMinus2times2() {
        Device.INSTANCE.keyboard.run {
            pressKey(Key.ON)
            pressKey(Key.MINUS)
            pressKey(Key.K2)
            pressKey(Key.MULTIPLY)
            pressKey(Key.K2)
            pressKey(Key.RESULT)
        }
        assertScreenShow("-4")
    }
}