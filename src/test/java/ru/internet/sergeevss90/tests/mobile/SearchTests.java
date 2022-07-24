package ru.internet.sergeevss90.tests.mobile;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static ru.internet.sergeevss90.tests.mobile.TestData.*;

@Tag("MOBILE")
@Tag("ALL")
public class SearchTests extends TestBase {

    @Test
    @DisplayName("Search project")
    void searchProjectTest() {
        step("Authorize", () ->
            loginPage.doLogin(login, password));
        step("Open search page", () ->
            mainPage.openSearchPage());
        step("Enter project name", () ->
            searchPage.enterSearchQuery(searchQuery));
        step("Check search results", () -> {
            searchPage.checkResultsCategory()
                    .checkResultsContent(searchQuery);
        });
    }
}