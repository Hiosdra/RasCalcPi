import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

internal class SubstractTest {
    @AfterEach
    internal fun tearDown() {
        Device.INSTANCE.reset()
    }

    @Test
    internal fun substract5from10() {
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.ON)
            onKeyPress(Key.K1)
            onKeyPress(Key.K0)
            onKeyPress(Key.MINUS)
            onKeyPress(Key.K5)
            onKeyPress(Key.RESULT)
        }
        assertScreenShow("5")
    }

    @Test
    internal fun substract100from100() {
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.ON)
            onKeyPress(Key.K1)
            onKeyPress(Key.K0)
            onKeyPress(Key.K0)
            onKeyPress(Key.MINUS)
            onKeyPress(Key.K1)
            onKeyPress(Key.K0)
            onKeyPress(Key.K0)
            onKeyPress(Key.RESULT)
        }
        assertScreenShow("0")
    }

    @Test
    internal fun substract150from100() {
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.ON)
            onKeyPress(Key.K1)
            onKeyPress(Key.K0)
            onKeyPress(Key.K0)
            onKeyPress(Key.MINUS)
            onKeyPress(Key.K1)
            onKeyPress(Key.K5)
            onKeyPress(Key.K0)
            onKeyPress(Key.RESULT)
        }
        assertScreenShow("-50")
    }

    @Test
    internal fun substractMinus150from100() {
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.ON)
            onKeyPress(Key.MINUS)
            onKeyPress(Key.K1)
            onKeyPress(Key.K0)
            onKeyPress(Key.K0)
            onKeyPress(Key.MINUS)
            onKeyPress(Key.K1)
            onKeyPress(Key.K5)
            onKeyPress(Key.K0)
            onKeyPress(Key.RESULT)
        }
        assertScreenShow("-250")
    }

    @Test
    internal fun substract10AndHalfFrom11() {
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.ON)
            onKeyPress(Key.K1)
            onKeyPress(Key.K1)
            onKeyPress(Key.MINUS)
            onKeyPress(Key.K1)
            onKeyPress(Key.K0)
            onKeyPress(Key.COMMA)
            onKeyPress(Key.K5)
            onKeyPress(Key.RESULT)
        }
        assertScreenShow("0.5")
    }
}