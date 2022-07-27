package todoist.tests.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static todoist.tests.web.TestData.*;

@Tag("WEB")
@Tag("ALL")
public class AuthenticationTests extends TestBase {

    @Test
    @DisplayName("Authentification with e-mail and password")
    void loginTest() {
        step("Authorize", () ->
            loginPage.doLogin(login, password));
        step("Check page content", () -> {
            mainPage.checkFilterContent()
                    .checkCurrentUrl();
        });
    }

    @Test
    @DisplayName("Redirect of unauthentificated user to login page")
    void redirectTest() {
        step("Open 'Today' page without authorization", () ->
            mainPage.openPage());
        step("Check redirection", () -> {
            mainPage.checkFilterAvailability();
            loginPage.checkLoginButton()
                    .checkCurrentUrl();
        });
    }
}