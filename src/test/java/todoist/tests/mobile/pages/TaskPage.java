package todoist.tests.mobile.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.*;

public class TaskPage {
    public SelenideElement taskNameInput = $(AppiumBy.id("android:id/message"));
    public ElementsCollection addTaskButton = $$(AppiumBy.id("android:id/button1"));

    public void addTaskName(String name) {
        taskNameInput.sendKeys(name);
    }

    public TaskPage finishTaskCreation() {
        addTaskButton.last().click();
        return this;
    }

    public void closeTaskPage() {
        back();
    }
}