package guru.qa.tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Tag("properties")
    @Test
    void someTestProperties1() {
        String browser = System.getProperty("browser");
        System.out.println(browser);
        //  gradlew clean properties_tests
        //  null

        //  gradlew clean properties_tests -Dbrowser=chrome
        //  chrome
    }

    @Test
    @Tag("properties")
    void someTestProperties2() {
        String browser = System.getProperty("browser", "chrome");
        String version = System.getProperty("version", "91");
        String browserSize = System.getProperty("browserSize", "300x300");

        System.out.println(browser);
        System.out.println(version);
        System.out.println(browserSize);
    }


    @Tag("try")
    @Test
    void someTestTry() {
        System.out.println("Ksusha");
        //  gradlew clean try_tests
        //  null

        //  gradlew clean properties_tests -Dbrowser=chrome

    }
}
