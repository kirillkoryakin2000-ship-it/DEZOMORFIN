import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.Condition.*
import org.junit.jupiter.api.Test

class SearchTests {

    @Test
    fun successfulSearchTest() {
        open("https://www.google.com/")
        `$`("[name=q]").setValue("selenide").pressEnter()
        `$`("[id=search]").shouldHave(text("https://ru.selenide.org"))
    }
}
