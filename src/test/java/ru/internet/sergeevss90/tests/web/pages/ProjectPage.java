package ru.internet.sergeevss90.tests.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.internet.sergeevss90.helpers.TestDataGenerator;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ProjectPage {

    TestDataGenerator generator = new TestDataGenerator();
    String projectName = generator.getTaskName();
    public SelenideElement
            plusButton = $(byXpath("(//button[@type='button'])[9]")),
            addProjectButton = $(byText("Add")),
            nameProject = $("#edit_project_modal_field_name"),
            checkProjectList = $("#projects_list");

    public ProjectPage startProjectCreation() {
        plusButton.click();
        return this;
    }

    public ProjectPage inputProjectName() {
        nameProject.setValue(projectName);
        return this;
    }

    public ProjectPage addNewProject() {
        addProjectButton.click();
        return this;
    }

    public ProjectPage checkProjectCreation() {
        checkProjectList.shouldHave(Condition.text(projectName));
        return this;
    }
}