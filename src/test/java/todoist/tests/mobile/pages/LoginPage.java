package todoist.tests.mobile.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public SelenideElement
            emailButton = $(AppiumBy.id("com.todoist:id/btn_welcome_email")),
            passwordButton = $(AppiumBy.id("com.todoist:id/btn_continue_with_email")),
            loginButton = $(AppiumBy.id("com.todoist:id/btn_log_in")),
            emailInput = $(AppiumBy.id("com.todoist:id/email_exists_input")),
            passwordInput = $(AppiumBy.id("com.todoist:id/log_in_password")),
            errorForm = $(AppiumBy.id("com.todoist:id/textinput_error")),
            signUpForm = $(AppiumBy.id("com.todoist:id/sign_up_container"))
                    .$(AppiumBy.className("android.widget.TextView"));

    public void doLogin(String email, String password) {
        emailButton.click();
        emailInput.sendKeys(email);
        passwordButton.click();
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void doLoginIncorrectEmail(String email) {
        emailButton.click();
        emailInput.sendKeys(email);
        passwordButton.click();
    }

    public void doLoginUnknownEmail(String email) {
        emailButton.click();
        emailInput.sendKeys(email);
        passwordButton.click();
    }

    public void errorCheck() {
        errorForm.shouldHave(Condition.text("Email is invalid"));
    }

    public void signUpFormCheck() {
        signUpForm.shouldHave(Condition.text("Sign up"));
    }
}