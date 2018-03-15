import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

internal class DevideTest {

    @AfterEach
    fun tearDown() {
        Device.INSTANCE.reset()
    }

    @Test
    internal fun devide6times2() {
        Device.INSTANCE.keyboard.run {
            pressKey(Key.ON)
            pressKey(Key.K6)
            pressKey(Key.DEVIDE)
            pressKey(Key.K2)
            pressKey(Key.RESULT)
        }
        assertScreenShow("3")
    }

    @Test
    internal fun devide5times2() {
        Device.INSTANCE.keyboard.run {
            pressKey(Key.ON)
            pressKey(Key.K5)
            pressKey(Key.DEVIDE)
            pressKey(Key.K2)
            pressKey(Key.RESULT)
        }
        assertScreenShow("2.5")
    }

    @Test
    internal fun devideMinus6times2() {
        Device.INSTANCE.keyboard.run {
            pressKey(Key.ON)
            pressKey(Key.MINUS)
            pressKey(Key.K6)
            pressKey(Key.DEVIDE)
            pressKey(Key.K2)
            pressKey(Key.RESULT)
        }
        assertScreenShow("-3")
    }

    @Test
    internal fun devideMinus5times2() {
        Device.INSTANCE.keyboard.run {
            pressKey(Key.ON)
            pressKey(Key.MINUS)
            pressKey(Key.K5)
            pressKey(Key.DEVIDE)
            pressKey(Key.K2)
            pressKey(Key.RESULT)
        }
        assertScreenShow("-2.5")
    }

    @Test
    internal fun devide5Times2AndHalf() {
        Device.INSTANCE.keyboard.run {
            pressKey(Key.ON)
            pressKey(Key.K5)
            pressKey(Key.DEVIDE)
            pressKey(Key.K2)
            pressKey(Key.COMMA)
            pressKey(Key.K5)
            pressKey(Key.RESULT)
        }
        assertScreenShow("2")
    }
}