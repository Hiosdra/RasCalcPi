package Drivers

class MockScreen : Screen {
    var powered = false
    private var text = ""

    override fun power(isOn: Boolean) {
        powered = isOn
    }

    override fun getText() = text

    override fun cls() {
        print("")
    }

    override fun print(text: String) {
        val number = text.toDoubleOrNull()
        if (number != null && number.toLong().toDouble() == number)
            this.text = number.toLong().toString()
        else this.text = text
    }

    override fun append(text: String) {
        this.text += text
    }

    override fun toString(): String {
        return if (powered == true) "{powered: $powered, text: $text}"
        else "{powered: $powered}"
    }
}