package todoist.tests.web;

import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.BeforeEach;
import todoist.helpers.Attach;
import todoist.drivers.web.BrowserWebDriver;
import todoist.tests.web.pages.LoginPage;
import todoist.tests.web.pages.MainPage;
import todoist.tests.web.pages.ProjectPage;
import todoist.tests.web.pages.TaskPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    static String useRemote = System.getProperty("webPlatform", "remote");
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    TaskPage taskPage = new TaskPage();
    ProjectPage projectPage = new ProjectPage();

    @BeforeAll
    static void setUp() {
        BrowserWebDriver.configure();
    }

    @BeforeEach
    public void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void addAttachments() {
        Attach.screenshotAs();
        Attach.pageSource();
        Attach.browserConsoleLogs();
        if (useRemote.equals("remote")) {
            Attach.addVideo();
        }
        closeWebDriver();
    }
}