package Drivers

import Key

class MockKeyboard : Keyboard {
    private val device = Device.INSTANCE
    private var text = ""
    private var lastMathOperation = Key.K0
    private var memory = 0.0

    fun pressKey(key: Key) {
        onKeyPress(key)
    }

    override fun onKeyPress(key: Key) = when (key) {
        Key.K0 -> device.screen.append("0")
        Key.K1 -> device.screen.append("1")
        Key.K2 -> device.screen.append("2")
        Key.K3 -> device.screen.append("3")
        Key.K4 -> device.screen.append("4")
        Key.K5 -> device.screen.append("5")
        Key.K6 -> device.screen.append("6")
        Key.K7 -> device.screen.append("7")
        Key.K8 -> device.screen.append("8")
        Key.K9 -> device.screen.append("9")
        Key.M_PLUS -> memoryPlus()
        Key.M_MINUS -> memoryMinus()
        Key.M_ZERO -> memoryZero()
        Key.COMMA -> TODO("xd")
        Key.PLUS -> getScreenTextToVarAndSetMathOperation(key)
        Key.MINUS -> getScreenTextToVarAndSetMathOperation(key)
        Key.MULTIPLY -> getScreenTextToVarAndSetMathOperation(key)
        Key.DEVIDE -> getScreenTextToVarAndSetMathOperation(key)
        Key.ROOT -> getScreenTextToVarAndSetMathOperation(key)
        Key.RESULT -> result()
        Key.PERCENT -> TODO("Magical matura staff")
        Key.ON -> onKeyON()
        Key.OFF -> if (lastMathOperation != Key.OFF) device.screen.power(false) else device.reset()
    }

    private fun onKeyON() {
        if (lastMathOperation == Key.K0) device.screen.power(true) else device.screen.cls()
        lastMathOperation = Key.ON
    }

    private fun result() {
        val deviceNumber = device.screen.getText().toDoubleOrNull() ?: 0.0
        device.screen.cls()
        when (lastMathOperation) {
            Key.PLUS -> device.screen.print(((text.toDoubleOrNull() ?: 0.0) + deviceNumber).toString())
            Key.MINUS -> device.screen.print(((text.toDoubleOrNull() ?: 0.0) - deviceNumber).toString())
            Key.MULTIPLY -> device.screen.print(((text.toDoubleOrNull() ?: 0.0) * deviceNumber).toString())
            Key.DEVIDE -> device.screen.print(((text.toDoubleOrNull() ?: 0.0) / deviceNumber).toString())
            Key.ROOT -> device.screen.print(Math.pow((text.toDoubleOrNull() ?: 0.0), 0.5).toString())
        }
    }

    private fun memoryMinus() {
        memory -= device.screen.getText().toDoubleOrNull() ?: 0.0
    }

    private fun memoryPlus() {
        memory += device.screen.getText().toDoubleOrNull() ?: 0.0
    }

    private fun memoryZero() {
        device.screen.print((memory).toString())
    }

    fun getScreenTextToVarAndSetMathOperation(key: Key) {
        text = device.screen.getText()
        if (text == "" && key == Key.MINUS) {
            device.screen.print("-")
            //TODO("negative number not yet implemented")
        } else {
            device.screen.cls()
            lastMathOperation = key
        }
    }
}