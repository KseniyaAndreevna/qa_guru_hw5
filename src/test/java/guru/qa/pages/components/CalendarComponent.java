package guru.qa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    //$("#dateOfBirthInput").click();
    SelenideElement
            monthPicker = $(".react-datepicker__month-select"),
            yearPicker = $(".react-datepicker__year-select");

    private SelenideElement day(String day) {
        return $(".react-datepicker__day--0" + day +
                ":not(.react-datepicker__day--outside-month)");
    }

    public StudentRegistrationFormPage selectDate(String year, String month, String day) {
        monthPicker.selectOption(month);
        yearPicker.selectOption(year);
        day(day).click();
        return new StudentRegistrationFormPage();
    }
}
