

package tests

import com.github.javafaker.Faker
import com.codeborne.selenide.Condition.appear
import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Selectors.byText
import com.codeborne.selenide.Selenide.*
import org.junit.jupiter.api.Test
import java.util.Locale

class RegistrationWithFakerTests {

    @Test
    fun successfulRegistrationTest() {
        val faker = Faker()
        val firstName = faker.name().firstName()
        val lastName = faker.name().lastName()
        val userEmail = faker.internet().emailAddress()
        val streetAddress = faker.address().streetAddress()


        open("https://demoqa.com/automation-practice-form")
        `$`(".practice-form-wrapper").shouldHave(text("Student Registration Form"))
        executeJavaScript<Any>("document.querySelector('#fixedban')?.remove()")
        executeJavaScript<Any>("document.querySelector('footer')?.remove()")

        `$`("#firstName").setValue(firstName)
        `$`("#lastName").setValue(lastName)
        `$`("#userEmail").setValue(userEmail)
        `$`("#genterWrapper").`$`(byText("Other")).click()
        `$`("#userNumber").setValue("1234567890")

        `$`("#dateOfBirthInput").click()
        `$`(".react-datepicker__month-select").selectOption("July")
        `$`(".react-datepicker__year-select").selectOption("2008")
        `$`(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click()

        `$`("#subjectsInput").setValue("Math").pressEnter()
        `$`("#hobbiesWrapper").`$`(byText("Sports")).click()
        `$`("#uploadPicture").uploadFromClasspath("1.jpg")
        `$`("#currentAddress").setValue(streetAddress)

        `$`("#state").click()
        `$`("#stateCity-wrapper").`$`(byText("NCR")).click()
        `$`("#city").click()
        `$`("#stateCity-wrapper").`$`(byText("Delhi")).click()

        `$`("#submit").click()

        `$`(".modal-dialog").should(appear)
        `$`("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"))
        `$`(".table-responsive").shouldHave(
            text(firstName), text(lastName),
            text(userEmail), text("1234567890"), text(streetAddress)
        )
    }
}