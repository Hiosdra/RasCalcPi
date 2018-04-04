package Drivers

import Key

interface Keyboard {
    /**
     * Should invoke proper Device KeyboardOperator.onKeyPress()
     */
    fun onKeyPress(key: Key)
}