import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selectors.withText
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.Selenide.open
import io.qameta.allure.Allure.ThrowableRunnableVoid
import io.qameta.allure.Allure.step
import org.junit.jupiter.api.Test
import org.openqa.selenium.By

class LambdaTest {

    companion object {
        private const val REPOSITORY = "eroshenkoam/allure-example"
        private const val NUMBER_ISSUE = 87
    }

    @Test
    fun testLambdaTest() {
        step("Открываем главную страницу", ThrowableRunnableVoid {
            open("https://github.com/")
        })
        step("Ищем репозиторий $REPOSITORY", ThrowableRunnableVoid {
            `$`(".search-input").click()
            `$`("#query-builder-test").sendKeys(REPOSITORY)
            `$`("#query-builder-test").pressEnter()
        })
        step("Кликаем по ссылке репозитория $REPOSITORY", ThrowableRunnableVoid {
            `$`(By.linkText(REPOSITORY)).click()
        })
        step("Переходим в Ишью в $REPOSITORY", ThrowableRunnableVoid {
            `$`("#issues-tab").click()
        })
        step("Проверяем что есть ишью с таким номер $NUMBER_ISSUE", ThrowableRunnableVoid {
            `$`(withText("#$NUMBER_ISSUE")).should(Condition.exist)
        })
    }
}