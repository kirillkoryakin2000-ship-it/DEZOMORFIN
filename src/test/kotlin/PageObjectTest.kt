package pages

import com.codeborne.selenide.Condition.appear
import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.Selectors.byText
import com.codeborne.selenide.Selenide.*

class RegistrationPage {

    private val firstNameInput = `$`("#firstName")
    private val lastNameInput = `$`("#lastName")
    private val emailInput = `$`("#userEmail")
    private val genderWrapper = `$`("#genterWrapper")
    private val phoneInput = `$`("#userNumber")
    private val dateOfBirthInput = `$`("#dateOfBirthInput")
    private val monthSelect = `$`(".react-datepicker__month-select")
    private val yearSelect = `$`(".react-datepicker__year-select")
    private val subjectsInput = `$`("#subjectsInput")
    private val hobbiesWrapper = `$`("#hobbiesWrapper")
    private val uploadPicture = `$`("#uploadPicture")
    private val currentAddressInput = `$`("#currentAddress")
    private val stateDropdown = `$`("#state")
    private val cityDropdown = `$`("#city")
    private val stateCityWrapper = `$`("#stateCity-wrapper")
    private val submitButton = `$`("#submit")
    private val modalDialog = `$`(".modal-dialog")
    private val modalTitle = `$`("#example-modal-sizes-title-lg")
    private val resultsTable = `$`(".table-responsive")
    private val formWrapper = `$`(".practice-form-wrapper")

    fun openPage(): RegistrationPage {
        open("/automation-practice-form")
        formWrapper.shouldHave(text("Student Registration Form"))
        return this
    }

    fun removeAds(): RegistrationPage {
        executeJavaScript<Any>("$('#fixedban').remove()")
        executeJavaScript<Any>("$('footer').remove()")
        return this
    }

    fun setFirstName(value: String): RegistrationPage {
        firstNameInput.setValue(value)
        return this
    }

    fun setLastName(value: String): RegistrationPage {
        lastNameInput.setValue(value)
        return this
    }

    fun setEmail(value: String): RegistrationPage {
        emailInput.setValue(value)
        return this
    }

    fun selectGender(gender: String): RegistrationPage {
        genderWrapper.`$`(byText(gender)).click()
        return this
    }

    fun setPhoneNumber(value: String): RegistrationPage {
        phoneInput.setValue(value)
        return this
    }

    fun setDateOfBirth(month: String, year: String, day: String): RegistrationPage {
        dateOfBirthInput.click()
        monthSelect.selectOption(month)
        yearSelect.selectOption(year)
        `$`(".react-datepicker__day--$day:not(.react-datepicker__day--outside-month)").click()
        return this
    }

    fun addSubject(subject: String): RegistrationPage {
        subjectsInput.setValue(subject).pressEnter()
        return this
    }

    fun selectHobby(hobby: String): RegistrationPage {
        hobbiesWrapper.`$`(byText(hobby)).click()
        return this
    }

    fun uploadPicture(fileName: String): RegistrationPage {
        uploadPicture.uploadFromClasspath(fileName)
        return this
    }

    fun setCurrentAddress(value: String): RegistrationPage {
        currentAddressInput.setValue(value)
        return this
    }

    fun selectState(state: String): RegistrationPage {
        stateDropdown.click()
        stateCityWrapper.`$`(byText(state)).click()
        return this
    }

    fun selectCity(city: String): RegistrationPage {
        cityDropdown.click()
        stateCityWrapper.`$`(byText(city)).click()
        return this
    }

    fun submit(): RegistrationPage {
        submitButton.click()
        return this
    }

    fun checkModalAppeared(): RegistrationPage {
        modalDialog.should(appear)
        modalTitle.shouldHave(text("Thanks for submitting the form"))
        return this
    }

    fun checkSubmittedData(vararg expectedValues: String): RegistrationPage {
        resultsTable.shouldHave(*expectedValues.map { text(it) }.toTypedArray())
        return this
    }
}