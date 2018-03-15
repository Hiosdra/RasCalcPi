package Drivers

interface Screen {
    fun power(isOn: Boolean)
    fun getText(): String
    fun cls()
    fun print(text: String)
    fun append(text: String)
}