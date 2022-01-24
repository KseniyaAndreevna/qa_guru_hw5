package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormPage {
    SelenideElement
            firstNameField = $("#firstName"),

            lastNameField = $("#lastName"),

            userEmailField = $("#userEmail"),

            genderRadioButton = $(byText("Male")),

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

    public CalendarComponent calendarComponent = new CalendarComponent();

    public StudentRegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public StudentRegistrationFormPage setFirstName(String value) {
        firstNameField.setValue(value);
        return this;
    }

    public StudentRegistrationFormPage setLastName(String value) {
        lastNameField.setValue(value);
        return this;
    }

    public StudentRegistrationFormPage setUserEmail(String value) {
        userEmailField.setValue(value);
        return this;
    }

    public StudentRegistrationFormPage selectGender(String value) {
        genderRadioButton.click();
        return this;
    }

    public StudentRegistrationFormPage setMobileNumber(String value) {
        mobileNumberField.setValue(value);
        return this;
    }

    private CalendarComponent clickOnDateOfBirthCalendar() {
        dateOfBirthInput.click();
        return new CalendarComponent();
    }

    public StudentRegistrationFormPage setDateOfBirth(String year, String month, String day) {
        clickOnDateOfBirthCalendar().selectDate(year, month, day);
        return this;
    }

    public StudentRegistrationFormPage selectSubject(String subject) {
        subjectField.setValue(subject).pressEnter();
        return this;
    }

    public StudentRegistrationFormPage selectHobby(String hobby) {
        hobbyCheckbox(hobby).click();
        return this;
    }
    public StudentRegistrationFormPage uploadPicture(String filename) {
        selectPictureButton.uploadFromClasspath(filename);
        return this;
    }

    public StudentRegistrationFormPage setCurrentAddress(String value) {
        currentAddressField.setValue(value);
        return this;
    }

    public StudentRegistrationFormPage selectState(String value) {
        stateDropdown.scrollTo();
        stateDropdown.click();
        $x("//div[text()='" + value + "']").click();
        return this;
    }

    public StudentRegistrationFormPage selectCity(String value) {
        cityDropdown.scrollTo();
        cityDropdown.click();
        $x("//div[text()='" + value + "']").click();
        return this;
    }

    public StudentRegistrationFormPage clickSubmitButton() {
        submitButton.click();
        $(".modal-header").shouldBe(visible).shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public StudentRegistrationFormPage checkResultsValue(String key, String value) {
        resultsTable.$(byText(key))
                .parent().shouldHave(text(value));
        return this;
    }
}
