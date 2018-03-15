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
        Device.INSTANCE.keyboard.run {
            pressKey(Key.ON)
            pressKey(Key.K5)
            pressKey(Key.M_PLUS)
            pressKey(Key.ON)
            pressKey(Key.M_ZERO)
        }
        assertScreenShow("5")
    }

    @Test
    internal fun memoryInsert5Then5Then5Then5Then5AndGetWhatIsInside() {
        Device.INSTANCE.keyboard.run {
            pressKey(Key.ON)
            for (i in 1..5){
                pressKey(Key.K5)
                pressKey(Key.M_PLUS)
                pressKey(Key.ON)
            }
            pressKey(Key.M_ZERO)
        }
        assertScreenShow("25")
    }

    @Test
    internal fun memoryInsert5ThenMemoryMinus10ThenGetWhatIsInside() {
        Device.INSTANCE.keyboard.run {
            pressKey(Key.ON)
            pressKey(Key.K5)
            pressKey(Key.M_PLUS)
            pressKey(Key.ON)
            pressKey(Key.K1)
            pressKey(Key.K0)
            pressKey(Key.M_MINUS)
            pressKey(Key.ON)
            pressKey(Key.M_ZERO)
        }
        assertScreenShow("-5")
    }

    @Test
    internal fun memoryInsert10ThenMemoryMinus5ThenGetWhatIsInside() {
        Device.INSTANCE.keyboard.run {
            pressKey(Key.ON)
            pressKey(Key.K1)
            pressKey(Key.K0)
            pressKey(Key.M_PLUS)
            pressKey(Key.ON)
            pressKey(Key.K5)
            pressKey(Key.M_MINUS)
            pressKey(Key.ON)
            pressKey(Key.M_ZERO)
        }
        assertScreenShow("5")
    }

    @Test
    internal fun memoryMinusInsert10ThenMemoryInsert5ThenGetWhatIsInside() {
        Device.INSTANCE.keyboard.run {
            pressKey(Key.ON)
            pressKey(Key.K1)
            pressKey(Key.K0)
            pressKey(Key.M_MINUS)
            pressKey(Key.ON)
            pressKey(Key.K5)
            pressKey(Key.M_PLUS)
            pressKey(Key.ON)
            pressKey(Key.M_ZERO)
        }
        assertScreenShow("-5")
    }

    @Test
    internal fun memoryMinusInsert10ThenMinusInsertNegative20ThenGetWhatIsInside() {
        Device.INSTANCE.keyboard.run {
            pressKey(Key.ON)
            pressKey(Key.K1)
            pressKey(Key.K0)
            pressKey(Key.M_MINUS)
            pressKey(Key.ON)
            pressKey(Key.MINUS)
            pressKey(Key.K2)
            pressKey(Key.K0)
            pressKey(Key.M_MINUS)
            pressKey(Key.ON)
            pressKey(Key.M_ZERO)
        }
        assertScreenShow("10")
    }

    @Test
    internal fun memoryInsert5AndHalfThenGetWhatIsInside() {
        Device.INSTANCE.keyboard.run {
            pressKey(Key.ON)
            pressKey(Key.K5)
            pressKey(Key.COMMA)
            pressKey(Key.K5)
            pressKey(Key.M_PLUS)
            pressKey(Key.ON)
            pressKey(Key.M_ZERO)
        }
        assertScreenShow("5.5")
    }
}