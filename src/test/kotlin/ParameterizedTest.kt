package tests

import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.Selenide.open
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import test.TestBase


class DemoQaTests() : TestBase() {

    @ValueSource(strings = ["Alex", "Mike", "Fred"])
    @DisplayName("Тест поля Full Name")
    @ParameterizedTest(name = "Тест поля Full Name на примере {0}")
    fun textBoxFullNameFieldTest(value: String) {
        open("https://demoqa.com/text-box")
        `$`("#userName").setValue(value)
        `$`("#submit").scrollIntoView(true).click()
        `$`("#output").shouldHave(text("Name:$value"))
    }
}