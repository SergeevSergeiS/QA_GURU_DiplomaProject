package todoist.tests.web.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.SetValueOptions.withText;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static todoist.tests.web.TestData.loginUrl;
import static todoist.tests.web.TestData.redirectUrl;

public class LoginPage {

    public SelenideElement
            loginButton = $(byText("Log in")),
            inputUsername = $("#element-0"),
            inputPassword = $("#element-3");

    public void doLogin(String login, String password) {
        open(loginUrl);
        inputUsername.setValue(login);
        inputPassword.setValue(withText(password).sensitive())
                .pressEnter();
    }

    public LoginPage checkCurrentUrl() {
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        String url = redirectUrl;
        assertEquals(url, currentUrl);
        return this;
    }

    public LoginPage checkLoginButton() {
        loginButton.shouldBe(visible);
        return this;
    }
}