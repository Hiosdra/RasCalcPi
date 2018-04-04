package Drivers

import com.pi4j.io.i2c.I2CBus

class I2CLCDScreen : Screen {
    val display = I2CLcdDisplay(16, 2, I2CBus.BUS_1, 0x27, 0x08, 0x00, 0x00,
            0x04, 0x00, 0x00, 0x00, 0x00)
    var actualText = ""

    override fun power(willBeOn: Boolean) {
        display.setBacklight(willBeOn)
        if (willBeOn) print(actualText)
        else cls()
    }

    override fun getText() = actualText

    override fun cls() {
        display.clear()
        actualText = ""
    }

    override fun print(text: String) {
        cls()
        display.write(text)
        actualText = text
    }

    override fun append(text: String) {
        display.write(text)
        actualText += text
    }
}

fun main(args: Array<String>) {
    val display = I2CLCDScreen()
    display.print("Hello World")
    println()
}