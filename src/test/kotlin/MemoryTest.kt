import org.junit.jupiter.api.AfterEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MemoryTest {

    @AfterEach
    fun tearDown() {
        Device.INSTANCE.reset()
    }

    @Test
    internal fun memoryInsert5GetWhatIsInside() {
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.ON)
            onKeyPress(Key.K5)
            onKeyPress(Key.M_PLUS)
            onKeyPress(Key.ON)
            onKeyPress(Key.M_ZERO)
        }
        assertScreenShow("5")
    }

    @Test
    internal fun memoryInsert5Then5Then5Then5Then5AndGetWhatIsInside() {
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.ON)
            for (i in 1..5){
                onKeyPress(Key.K5)
                onKeyPress(Key.M_PLUS)
                onKeyPress(Key.ON)
            }
            onKeyPress(Key.M_ZERO)
        }
        assertScreenShow("25")
    }

    @Test
    internal fun memoryInsert5ThenMemoryMinus10ThenGetWhatIsInside() {
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.ON)
            onKeyPress(Key.K5)
            onKeyPress(Key.M_PLUS)
            onKeyPress(Key.ON)
            onKeyPress(Key.K1)
            onKeyPress(Key.K0)
            onKeyPress(Key.M_MINUS)
            onKeyPress(Key.ON)
            onKeyPress(Key.M_ZERO)
        }
        assertScreenShow("-5")
    }

    @Test
    internal fun memoryInsert10ThenMemoryMinus5ThenGetWhatIsInside() {
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.ON)
            onKeyPress(Key.K1)
            onKeyPress(Key.K0)
            onKeyPress(Key.M_PLUS)
            onKeyPress(Key.ON)
            onKeyPress(Key.K5)
            onKeyPress(Key.M_MINUS)
            onKeyPress(Key.ON)
            onKeyPress(Key.M_ZERO)
        }
        assertScreenShow("5")
    }

    @Test
    internal fun memoryMinusInsert10ThenMemoryInsert5ThenGetWhatIsInside() {
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.ON)
            onKeyPress(Key.K1)
            onKeyPress(Key.K0)
            onKeyPress(Key.M_MINUS)
            onKeyPress(Key.ON)
            onKeyPress(Key.K5)
            onKeyPress(Key.M_PLUS)
            onKeyPress(Key.ON)
            onKeyPress(Key.M_ZERO)
        }
        assertScreenShow("-5")
    }

    @Test
    internal fun memoryMinusInsert10ThenMinusInsertNegative20ThenGetWhatIsInside() {
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.ON)
            onKeyPress(Key.K1)
            onKeyPress(Key.K0)
            onKeyPress(Key.M_MINUS)
            onKeyPress(Key.ON)
            onKeyPress(Key.MINUS)
            onKeyPress(Key.K2)
            onKeyPress(Key.K0)
            onKeyPress(Key.M_MINUS)
            onKeyPress(Key.ON)
            onKeyPress(Key.M_ZERO)
        }
        assertScreenShow("10")
    }

    @Test
    internal fun memoryInsert5AndHalfThenGetWhatIsInside() {
        Device.INSTANCE.keyboardOperator.run {
            onKeyPress(Key.ON)
            onKeyPress(Key.K5)
            onKeyPress(Key.COMMA)
            onKeyPress(Key.K5)
            onKeyPress(Key.M_PLUS)
            onKeyPress(Key.ON)
            onKeyPress(Key.M_ZERO)
        }
        assertScreenShow("5.5")
    }
}