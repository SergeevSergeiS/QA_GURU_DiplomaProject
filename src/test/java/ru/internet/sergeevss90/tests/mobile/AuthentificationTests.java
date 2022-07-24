package ru.internet.sergeevss90.tests.mobile;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static ru.internet.sergeevss90.tests.mobile.TestData.*;

@Tag("MOBILE")
@Tag("ALL")
public class AuthentificationTests extends TestBase {
    @Test
    @DisplayName("Authentification with e-mail and password")
    void loginTest() {
        step("Authorize", () ->
            loginPage.doLogin(login, password));
        step("Check main page content", () -> {
            mainPage.taskButtonCheck();
        });
    }

    @Test
    @DisplayName("Authentification with incorrect e-mail")
    void loginInvalidEmailTest() {
        step("Authorize", () ->
            loginPage.doLoginIncorrectEmail(password));
        step("Check error message", () ->
            loginPage.errorCheck());
    }

    @Test
    @DisplayName("Authentification with unknown e-mail")
    void loginUnEmailTest() {
        step("Authorize", () ->
            loginPage.doLoginUnknownEmail(email));
        step("Check main page content", () ->
            loginPage.signUpFormCheck());
    }
}