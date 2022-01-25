package guru.qa.pages.components;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.StudentRegistrationFormPage;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    SelenideElement
            monthPicker = $(".react-datepicker__month-select"),
            yearPicker = $(".react-datepicker__year-select");

    private SelenideElement day(String day) {
        switch (day) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                day = "0" + day;
        }
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
