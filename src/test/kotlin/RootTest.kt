import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

internal class RootTest {

    @AfterEach
    fun tearDown() {
        Device.INSTANCE.reset()
    }

    @Test
    internal fun root4() {
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.ON)
            onKeyPress(Key.K4)
            onKeyPress(Key.ROOT)
            onKeyPress(Key.RESULT)
        }
        assertScreenShow("2")
    }

    @Test
    internal fun root2() {
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.ON)
            onKeyPress(Key.K2)
            onKeyPress(Key.ROOT)
            onKeyPress(Key.RESULT)
        }
        assertScreenShow("1.4142135623730951")
    }

    @Test
    internal fun rootMinus2() {
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.ON)
            onKeyPress(Key.MINUS)
            onKeyPress(Key.K2)
            onKeyPress(Key.ROOT)
            onKeyPress(Key.RESULT)
        }
        assertScreenShow("NaN")
    }

    @Test
    internal fun root5AndHalf() {
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.ON)
            onKeyPress(Key.K5)
            onKeyPress(Key.COMMA)
            onKeyPress(Key.K5)
            onKeyPress(Key.ROOT)
            onKeyPress(Key.RESULT)
        }
        assertScreenShow("2.345207879911715")
    }
}