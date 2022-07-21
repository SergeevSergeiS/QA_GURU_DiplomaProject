package ru.internet.sergeevss90.tests.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
import ru.internet.sergeevss90.config.web.WebConfig;
import ru.internet.sergeevss90.helpers.Attach;
import ru.internet.sergeevss90.drivers.web.BrowserWebDriver;
import ru.internet.sergeevss90.tests.web.pages.LoginPage;
import ru.internet.sergeevss90.tests.web.pages.MainPage;
import ru.internet.sergeevss90.tests.web.pages.ProjectPage;
import ru.internet.sergeevss90.tests.web.pages.TaskPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    static WebConfig config = ConfigFactory.create(WebConfig.class);
    static String useRemote = System.getProperty("webPlatform", "local");
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    TaskPage taskPage = new TaskPage();
    ProjectPage projectPage = new ProjectPage();

    @BeforeAll
    static void setUp() {
        BrowserWebDriver.configure();
        if (useRemote.equals("remote")) {
            Configuration.remote = String.format("https://%s:%s@%swd/hub",
                    config.selenoidLogin(), config.selenoidPassword(), config.remoteUrl());
        }
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