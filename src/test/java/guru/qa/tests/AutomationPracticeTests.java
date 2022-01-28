package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import guru.qa.pages.StudentRegistrationFormPage;
import guru.qa.testData.TestDataForStudentRegistrationFormPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AutomationPracticeTests extends TestBase {

    StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();

    TestDataForStudentRegistrationFormPage testData = new TestDataForStudentRegistrationFormPage();

    @Tag("StudentRegistrationForm")
    @Description("Run with browser {browser}")
    @Test
    void automationPracticeTest() {
        String browser = Configuration.browser;

        studentRegistrationFormPage.openPage()
                .setFirstName(testData.getFirstName())
                .setLastName(testData.getLastName())
                .setUserEmail(testData.getUserEmail())
                .selectGender(testData.getUserGender())
                .setMobileNumber(testData.getPhoneNumber())
                .setDateOfBirth(testData.getYearOfBirth(), testData.getMonthOfBirth(), testData.getDateOfBirth())
                .selectSubject(testData.getSubject1())
                .selectSubject(testData.getSubject2())
                .selectHobby(testData.getHobby1())
                .selectHobby(testData.getHobby2())
                //.uploadPicture(testData.getPicture())
                .setCurrentAddress(testData.getAddress())
                .selectState(testData.getState())
                .selectCity(testData.getCity())
                .clickSubmitButton();

        studentRegistrationFormPage
                .checkResultsValue("Student Name", testData.getFirstName() + " " + testData.getLastName())
                .checkResultsValue("Student Email", testData.getUserEmail())
                .checkResultsValue("Gender", testData.getUserGender())
                .checkResultsValue("Mobile", testData.getPhoneNumber())
                .checkResultsValue("Date of Birth", testData.getDateOfBirth() + " " +
                        testData.getMonthOfBirth() + "," + testData.getYearOfBirth())
                .checkResultsValue("Subjects", testData.getSubject1() + ", " + testData.getSubject2())
                .checkResultsValue("Hobbies", testData.getHobby1() + ", " + testData.getHobby2())
                //.checkResultsValue("Picture", testData.getPicture())
                .checkResultsValue("State and City", testData.getState() + " " + testData.getCity());
    }
}
