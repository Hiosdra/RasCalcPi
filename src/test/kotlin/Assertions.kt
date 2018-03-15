import org.junit.jupiter.api.Assertions

fun assertScreenShow(text: String) {
    Assertions.assertEquals(text, Device.INSTANCE.screen.getText())
}