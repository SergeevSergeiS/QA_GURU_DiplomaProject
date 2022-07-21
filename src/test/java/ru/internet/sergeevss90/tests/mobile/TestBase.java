package ru.internet.sergeevss90.tests.mobile;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.internet.sergeevss90.drivers.mobile.BrowserStackMobileDriver;
import ru.internet.sergeevss90.drivers.mobile.EmulationMobileDriver;
import ru.internet.sergeevss90.helpers.Attach;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;
import static ru.internet.sergeevss90.helpers.Attach.getSessionId;

public class TestBase {
    static String driver = System.getProperty("mobileDeviceHost", "browserstack");

    @BeforeAll
    public static void setup() {
        if (driver.equals("browserstack")) {
            Configuration.browser = BrowserStackMobileDriver.class.getName();
        } else if (driver.equals("emulation")) {
            Configuration.browser = EmulationMobileDriver.class.getName();
        }  else {
            System.out.println("Incorrect stand name");
        }
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());
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
