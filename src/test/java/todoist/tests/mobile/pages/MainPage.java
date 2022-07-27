package todoist.tests.mobile.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    public SelenideElement
            addTaskButton = $(AppiumBy.id("com.todoist:id/fab")),
            menuButton = $(AppiumBy.className("android.widget.ImageButton")),
            addProjectButton = $(AppiumBy.id("com.todoist:id/add")),
            searchButton = $(AppiumBy.id("com.todoist:id/menu_content_search")),
            projectsList = $(AppiumBy.id("com.todoist:id/toolbar"))
                    .$(AppiumBy.className("android.widget.TextView"));
    public ElementsCollection tasksList = $$(AppiumBy.id("com.todoist:id/text"));

    public void taskButtonCheck() {
        addTaskButton.shouldBe(Condition.visible);
    }

    public void startTaskCreation() {
        addTaskButton.click();
    }

    public void taskCreationCheck(String name) {
        tasksList.last().shouldHave(Condition.text(name));
    }

    public void openMainMenu() {
        menuButton.click();
    }

    public void startProjectCreation() {
        addProjectButton.click();
    }

    public void projectCreationCheck(String name) {
        projectsList.shouldHave(Condition.text(name));
    }

    public void openSearchPage() {
        searchButton.click();
    }
}