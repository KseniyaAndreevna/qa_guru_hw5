package guru.qa.testData;

import java.util.Random;

public class Hobbies {
    private static final String SPORTS = "Sports";

    private static final String READING = "Reading";

    private static final String MUSIC = "Music";

    private static final String[] hobbies = {SPORTS, READING, MUSIC};

    private static final Random random = new Random();

    public static String random() {
        return hobbies[random.nextInt(hobbies.length)];
    }
}
