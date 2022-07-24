package ru.internet.sergeevss90.tests.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static ru.internet.sergeevss90.tests.web.TestData.*;

@Tag("WEB")
@Tag("ALL")
public class FilterTests extends TestBase {

    @Test
    @DisplayName("Main filters availability")
    void checkMainPAgeFiltersTest() {
        step("Authorize", () ->
            loginPage.doLogin(login, password));
        step("Check 'Inbox' filter", () -> {
            mainPage.openFilterInbox()
                    .checkCurrentUrl();
        });
        step("Check 'Today' filter", () -> {
            mainPage.openFilterToday()
                    .checkCurrentUrl();
        });
        step("Check 'Labels' filter", () -> {
            mainPage.openFilterLabels()
                    .checkCurrentUrl();
        });
        step("Check 'Upcoming' filter", () -> {
            mainPage.openFilterUpcoming()
                    .checkFilterUpcoming();
        });
    }

    @Test
    @DisplayName("'Upcoming' filter shows today's date")
    void dateComparisonTest() {
        step("Authorize", () ->
            loginPage.doLogin(login, password));
        step("Open upcoming filter", () ->
            mainPage.openFilterUpcoming());
        step("Check displayed date", () ->
            mainPage.checkUpcomingDate());
    }
}