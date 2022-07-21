package ru.internet.sergeevss90.tests.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import ru.internet.sergeevss90.drivers.web.BrowserWebDriver;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.SetValueOptions.withText;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage {

    public SelenideElement
            loginButton = $(byText("Log in")),
            inputUsername = $("#element-0"),
            inputPassword = $("#element-3");

    public void doLogin() {
        open("/auth/login");
        inputUsername.setValue(BrowserWebDriver.config.todoistLogin());
        inputPassword.setValue(withText(BrowserWebDriver.config.todoistPassword()).sensitive())
                .pressEnter();
    }

    public LoginPage checkCurrentUrl() {
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        String url = Configuration.baseUrl + "auth/login?success_page=%2Fapp%2Ftoday";
        assertEquals(url, currentUrl);
        return this;
    }

    public LoginPage checkLoginButton() {
        loginButton.shouldBe(Condition.visible);
        return this;
    }
}