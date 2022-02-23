package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.config.CredentialsConfig;
import guru.qa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TestBase {

    private static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

    @BeforeAll
    static void setUp() {
        System.out.println("setUp()");
        //String login = System.getProperty("login");
        String login = config.login();
        //String password = System.getProperty("password");
        String password = config.password();
        System.out.println("login: " + login);
        System.out.println("password: " + password);
        String remoteUrl = System.getProperty("remoteUrl");
        String browserWithVersion = System.getProperty("browserWithVersion", "chrome:90.0");
        String browser = browserWithVersion.split(":")[0];
        String version = browserWithVersion.split(":")[1];
        String browserSize = System.getProperty("browserSize", "1920x1080");

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = browser;
        Configuration.browserVersion = version;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = browserSize;
        Configuration.remote = "https://" + login + ":" + password + "@" + remoteUrl;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        getWebDriver().close();
    }
}
