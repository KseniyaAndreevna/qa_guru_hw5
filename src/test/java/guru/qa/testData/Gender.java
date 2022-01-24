package guru.qa.testData;
import java.util.Random;

public class Gender {
    private static final String MALE = "Male";

    private static final String FEMALE = "Female";

    private static final String OTHER = "Other";

    private static final String[] genders = {MALE, FEMALE, OTHER};

    private static final Random random = new Random();

    public static String random() {
        return genders[random.nextInt(genders.length)];
    }
}
