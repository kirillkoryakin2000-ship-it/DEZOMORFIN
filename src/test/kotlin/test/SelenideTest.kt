import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selectors.withText
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.Selenide.open
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.selenide.AllureSelenide
import org.junit.jupiter.api.Test
import org.openqa.selenium.By

class SelenideClearTest {

    @Test
    fun testIssueSearch() {
        SelenideLogger.addListener("allure", AllureSelenide())
        open("https://github.com/")
        `$`(".search-input").click()
        `$`("#query-builder-test").sendKeys("eroshenkoam/allure-example")
        `$`("#query-builder-test").pressEnter()
        `$`(By.linkText("eroshenkoam/allure-example")).click()
        `$`("#issues-tab").click()
        `$`(withText("#87")).should(Condition.exist)
    }
}