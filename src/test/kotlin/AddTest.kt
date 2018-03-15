import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

internal class AddTest {
    @AfterEach
    internal fun tearDown() {
        Device.INSTANCE.reset()
    }

    @Test
    internal fun add3to8() {
        Device.INSTANCE.keyboard.run {
            pressKey(Key.K8)
            pressKey(Key.PLUS)
            pressKey(Key.K3)
            pressKey(Key.RESULT)
        }
        assertScreenShow("11")
    }

    @Test
    internal fun add50ToMinus97() {
        Device.INSTANCE.keyboard.run {
            pressKey(Key.ON)
            pressKey(Key.MINUS)
            pressKey(Key.K9)
            pressKey(Key.K7)
            pressKey(Key.PLUS)
            pressKey(Key.K5)
            pressKey(Key.K0)
            pressKey(Key.RESULT)
        }
        assertScreenShow("-47")
    }
}