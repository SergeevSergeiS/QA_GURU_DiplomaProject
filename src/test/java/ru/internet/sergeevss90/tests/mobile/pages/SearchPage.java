package ru.internet.sergeevss90.tests.mobile.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    public SelenideElement
            searchInput = $(AppiumBy.id("com.todoist:id/search_edit_text")),
            searchResultsCategory = $(AppiumBy.id("com.todoist:id/search_results"))
                    .$(AppiumBy.id("android:id/title")),
            searchResultsList = $(AppiumBy.id("com.todoist:id/search_results"))
                    .$(AppiumBy.id("com.todoist:id/content"));

    public void enterSearchQuery(String text) {
        searchInput.sendKeys(text);
    }

    public SearchPage checkResultsCategory() {
        searchResultsCategory.shouldHave(Condition.text("Projects"));
        return this;
    }

    public void checkResultsContent(String text) {
        searchResultsList.shouldHave(Condition.text(text));
    }
}