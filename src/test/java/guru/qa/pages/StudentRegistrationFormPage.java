package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormPage {
    SelenideElement
            firstNameField = $("#firstName"),

            lastNameField = $("#lastName"),

            userEmailField = $("#userEmail"),

            mobileNumberField = $("#userNumber"),

            resultsTable = $(".table-responsive"),

            dateOfBirthInput = $("#dateOfBirthInput"),

            subjectField = $("#subjectsInput"),

            selectPictureButton = $("#uploadPicture"),

            currentAddressField = $("#currentAddress"),

            stateDropdown = $("#state"),

            cityDropdown = $("#city"),

            submitButton = $("#submit");

    SelenideElement hobbyCheckbox(String hobby) {
        return $x("//label[contains(text(),'" + hobby + "')]");
    }

    SelenideElement genderRadiobutton(String gender) {
        return $(byText(gender));
    }

    public CalendarComponent calendarComponent = new CalendarComponent();

    public StudentRegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    @Step("Set field First Name = \"{value}\"")
    public StudentRegistrationFormPage setFirstName(String value) {
        firstNameField.setValue(value);
        return this;
    }

    @Step("Set field Last Name = \"{value}\"")
    public StudentRegistrationFormPage setLastName(String value) {
        lastNameField.setValue(value);
        return this;
    }

    @Step("Set field Email = \"{value}\"")
    public StudentRegistrationFormPage setUserEmail(String value) {
        userEmailField.setValue(value);
        return this;
    }

    @Step("Select radio button Gender = \"{value}\"")
    public StudentRegistrationFormPage selectGender(String value) {
        genderRadiobutton(value).click();
        return this;
    }

    @Step("Set field Mobile phone = \"{value}\"")
    public StudentRegistrationFormPage setMobileNumber(String value) {
        mobileNumberField.setValue(value);
        return this;
    }

    private CalendarComponent clickOnDateOfBirthCalendar() {
        dateOfBirthInput.click();
        return new CalendarComponent();
    }

    @Step("Select Date of Birth in calendar = \"{year}\", \"{month}\", \"{day}\"")
    public StudentRegistrationFormPage setDateOfBirth(String year, String month, String day) {
        clickOnDateOfBirthCalendar().selectDate(year, month, day);
        return this;
    }

    @Step("Select Subject in dropdown = \"{subject}\"")
    public StudentRegistrationFormPage selectSubject(String subject) {
        subjectField.setValue(subject).pressEnter();
        return this;
    }

    @Step("Select Hobby in checkbox = \"{hobby}\"")
    public StudentRegistrationFormPage selectHobby(String hobby) {
        hobbyCheckbox(hobby).click();
        return this;
    }

    public StudentRegistrationFormPage uploadPicture(String filename) {
        selectPictureButton.uploadFromClasspath(filename);
        return this;
    }

    @Step("Set field Current Address = \"{value}\"")
    public StudentRegistrationFormPage setCurrentAddress(String value) {
        currentAddressField.setValue(value);
        return this;
    }

    @Step("Select State in dropdown = \"{value}\"")
    public StudentRegistrationFormPage selectState(String value) {
        stateDropdown.scrollTo();
        stateDropdown.click();
        $x("//div[text()='" + value + "']").click();
        return this;
    }

    @Step("Select City in dropdown = \"{value}\"")
    public StudentRegistrationFormPage selectCity(String value) {
        cityDropdown.scrollTo();
        cityDropdown.click();
        $x("//div[text()='" + value + "']").click();
        return this;
    }

    @Step("Click \"Submit\" button")
    public StudentRegistrationFormPage clickSubmitButton() {
        submitButton.click();
        $(".modal-header").shouldBe(visible).shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    @Step("Check that field \"{key}\" has value \"{value}\"")
    public StudentRegistrationFormPage checkResultsValue(String key, String value) {
        resultsTable.$(byText(key))
                .parent().shouldHave(text(value));
        return this;
    }
}
