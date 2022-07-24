package ru.internet.sergeevss90.tests.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.internet.sergeevss90.helpers.TestDataGenerator;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TaskPage {

    TestDataGenerator generator = new TestDataGenerator();
    public SelenideElement
            tooltipToaster = $("[data-testid=toaster]"),
            newTaskButton = $("#quick_add_task_holder"),
            taskNameInput = $(".public-DraftEditor-content"),
            taskDescriptionInput = $(".task_editor__description_field"),
            priorityFlagsList = $(".item_actions_priority"),
            priorityFlag = $(byText("Priority " + generator.getPriority())),
            buttonAddTask = $("[data-testid=task-editor-submit-button]").$(byText("Add task"));

    public TaskPage startTaskCreation() {
        newTaskButton.click();
        return this;
    }

    public TaskPage inputTaskName(String taskName) {
        taskNameInput.setValue(taskName);
        return this;
    }

    public TaskPage inputTaskDescription(String taskDescription) {
        taskDescriptionInput.setValue(taskDescription);
        return this;
    }

    public TaskPage openPriorityFlag() {
        priorityFlagsList.click();
        return this;
    }

    public TaskPage setPriority() {
        priorityFlag.click();
        return this;
    }

    public TaskPage addNewTask() {
        buttonAddTask.click();
        return this;
    }

    public TaskPage checkTooltip() {
        tooltipToaster.shouldHave(Condition.text("Task added to Inbox"));
        return this;
    }
}