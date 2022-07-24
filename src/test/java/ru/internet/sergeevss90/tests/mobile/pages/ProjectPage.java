package ru.internet.sergeevss90.tests.mobile.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class ProjectPage {
    public SelenideElement
            projectNameInput = $(AppiumBy.id("com.todoist:id/name")),
            favouriteChecker = $(AppiumBy.id("com.todoist:id/favorite")),
            createProjectButton = $(AppiumBy.id("com.todoist:id/menu_form_submit"));

    public void addProjectName(String name) {
        projectNameInput.sendKeys(name);
    }

    public void setAsFavourite() {
        favouriteChecker.click();
    }

    public void finishProjectCreation() {
        createProjectButton.click();
    }
}