package guru.qa.tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Tag("properties")
    @Test
    void someTestProperties() {
        String browser = System.getProperty("browser");
        System.out.println(browser);
        //  gradlew clean properties_tests
        //  null

        //  gradlew clean properties_tests -Dbrowser=chrome
        //  chrome
    }

    @Tag("try")
    @Test
    void someTestTry() {
        System.out.println("Ksusha");
        //  gradlew clean try_tests
        //  null

        //  gradlew clean properties_tests -Dbrowser=chrome
        //  chrome
    }


}
