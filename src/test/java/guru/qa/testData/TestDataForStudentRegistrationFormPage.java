package guru.qa.testData;

import com.github.javafaker.Faker;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

@Getter
public class TestDataForStudentRegistrationFormPage {
    Faker faker = new Faker();

    @Getter
    String firstName = faker.name().firstName();

    @Getter
    String lastName = faker.name().lastName();

    @Getter
    String userEmail = faker.internet().emailAddress();

    @Getter
    String userGender = Gender.random();

    @Getter
    String phoneNumber = faker.number().digits(10);

    LocalDateTime randomDate = randomDate();

    @Getter
    String yearOfBirth = String.valueOf(randomDate.getYear());

    @Getter
    String monthOfBirth = f(randomDate.getMonth());

    @Getter
    String dateOfBirth = String.valueOf(randomDate.getDayOfMonth());

    @Getter
    String subject1 = "Chemistry";

    @Getter
    String subject2 = "Math";

    @Getter
    String hobby1 = "Sports";//Hobbies.random();

    @Getter
    String hobby2 = "Music";//Hobbies.random();

    @Getter
    String picture = "kitten.png";

    @Getter
    String address = faker.address().fullAddress();

    @Getter
    String state = "Uttar Pradesh";

    @Getter
    String city = "Agra";

    private LocalDateTime randomDate() {
        Date date = faker.date().birthday(10, 80);
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    private static final String[] months = {"January", "February", "March",
            "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    private static String f(Month month) {
        return months[month.ordinal()];
    }
}
