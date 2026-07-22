package StepModelForTest

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selectors.withText
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.Selenide.open
import io.qameta.allure.Step
import org.openqa.selenium.By

class StepModelForWebTest {

    companion object {
        private const val REPOSITORY = "eroshenkoam/allure-example"
        private const val NUMBER_ISSUE = 87
    }

    fun getNumberIssue(): Int = NUMBER_ISSUE

    fun getRepository(): String = REPOSITORY

    @Step("Открываем главную страницу")
    fun openMainPage() {
        open("https://github.com/")
    }

    @Step("Ищем репозиторий {repo}")
    fun searchForRepository(repo: String) {
        `$`(".search-input").click()
        `$`("#query-builder-test").sendKeys(repo)
        `$`("#query-builder-test").pressEnter()
    }

    @Step("Кликаем по ссылке репозитория {repo}")
    fun clickOnLinkRepository(repo: String) {
        `$`(By.linkText(repo)).click()
    }

    @Step("Переходим в Ишью {repo}")
    fun goToIssueTab() {
        `$`("#issues-tab").click()
    }

    @Step("Проверяем что есть ишью с таким номер {issue}")
    fun checkedResults(issue: Int) {
        `$`(withText("#$issue")).should(Condition.exist)
    }
}