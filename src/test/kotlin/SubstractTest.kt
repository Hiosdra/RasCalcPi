import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

internal class SubstractTest {
    @AfterEach
    internal fun tearDown() {
        Device.INSTANCE.reset()
    }

    @Test
    internal fun substract5from10() {
        Device.INSTANCE.keyboard.run {
            pressKey(Key.ON)
            pressKey(Key.K1)
            pressKey(Key.K0)
            pressKey(Key.MINUS)
            pressKey(Key.K5)
            pressKey(Key.RESULT)
        }
        assertScreenShow("5")
    }

    @Test
    internal fun substract100from100() {
        Device.INSTANCE.keyboard.run {
            pressKey(Key.ON)
            pressKey(Key.K1)
            pressKey(Key.K0)
            pressKey(Key.K0)
            pressKey(Key.MINUS)
            pressKey(Key.K1)
            pressKey(Key.K0)
            pressKey(Key.K0)
            pressKey(Key.RESULT)
        }
        assertScreenShow("0")
    }

    @Test
    internal fun substract150from100() {
        Device.INSTANCE.keyboard.run {
            pressKey(Key.ON)
            pressKey(Key.K1)
            pressKey(Key.K0)
            pressKey(Key.K0)
            pressKey(Key.MINUS)
            pressKey(Key.K1)
            pressKey(Key.K5)
            pressKey(Key.K0)
            pressKey(Key.RESULT)
        }
        assertScreenShow("-50")
    }

    @Test
    internal fun substractMinus150from100() {
        Device.INSTANCE.keyboard.run {
            pressKey(Key.ON)
            pressKey(Key.MINUS)
            pressKey(Key.K1)
            pressKey(Key.K0)
            pressKey(Key.K0)
            pressKey(Key.MINUS)
            pressKey(Key.K1)
            pressKey(Key.K5)
            pressKey(Key.K0)
            pressKey(Key.RESULT)
        }
        assertScreenShow("-250")
    }
}