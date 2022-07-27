package todoist.tests.mobile;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import todoist.drivers.mobile.BrowserStackMobileDriver;
import todoist.drivers.mobile.EmulationMobileDriver;
import todoist.helpers.Attach;
import todoist.tests.mobile.pages.SearchPage;
import todoist.tests.mobile.pages.LoginPage;
import todoist.tests.mobile.pages.MainPage;
import todoist.tests.mobile.pages.ProjectPage;
import todoist.tests.mobile.pages.TaskPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;
import static todoist.helpers.Attach.getSessionId;

public class TestBase {

    static String driver = System.getProperty("mobileDeviceHost", "browserstack");
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    TaskPage taskPage = new TaskPage();
    ProjectPage projectPage = new ProjectPage();
    SearchPage searchPage = new SearchPage();

    @BeforeAll
    public static void setup() {
        if (driver.equals("browserstack")) {
            Configuration.browser = BrowserStackMobileDriver.class.getName();
        } else if (driver.equals("emulation")) {
            Configuration.browser = EmulationMobileDriver.class.getName();
        } else {
            throw new RuntimeException("Incorrect stand name");
        }
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = getSessionId();

        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        step("Close driver", Selenide::closeWebDriver);

        if (driver.equals("browserstack")) {
            Attach.video(sessionId);
        }
    }

}
