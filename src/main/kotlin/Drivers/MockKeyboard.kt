package Drivers

import Device
import Key

class MockKeyboard : Keyboard {
    override fun onKeyPress(key: Key) {
        Device.INSTANCE.keyboardOperator.onKeyPress(key)
    }
}