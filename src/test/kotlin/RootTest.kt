import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

internal class RootTest {

    @AfterEach
    fun tearDown() {
        Device.INSTANCE.reset()
    }

    @Test
    internal fun root4() {
        Device.INSTANCE.keyboard.run {
            pressKey(Key.ON)
            pressKey(Key.K4)
            pressKey(Key.ROOT)
            pressKey(Key.RESULT)
        }
        assertScreenShow("2")
    }

    @Test
    internal fun root2() {
        Device.INSTANCE.keyboard.run {
            pressKey(Key.ON)
            pressKey(Key.K2)
            pressKey(Key.ROOT)
            pressKey(Key.RESULT)
        }
        assertScreenShow("1.4142135623730951")
    }

    @Test
    internal fun rootMinus2() {
        Device.INSTANCE.keyboard.run {
            pressKey(Key.ON)
            pressKey(Key.MINUS)
            pressKey(Key.K2)
            pressKey(Key.ROOT)
            pressKey(Key.RESULT)
        }
        assertScreenShow("NaN")
    }

    @Test
    internal fun root5AndHalf() {
        Device.INSTANCE.keyboard.run {
            pressKey(Key.ON)
            pressKey(Key.K5)
            pressKey(Key.COMMA)
            pressKey(Key.K5)
            pressKey(Key.ROOT)
            pressKey(Key.RESULT)
        }
        assertScreenShow("2.345207879911715")
    }
}