package todoist.tests.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ProjectPage {
        public SelenideElement
            plusButton = $("[aria-label='Add Project']"),
            addProjectButton = $(byText("Add")),
            nameProject = $("#edit_project_modal_field_name"),
            checkProjectList = $("#projects_list");

    public ProjectPage startProjectCreation() {
        plusButton.hover().click();
        return this;
    }

    public ProjectPage inputProjectName(String projectName) {
        nameProject.setValue(projectName);
        return this;
    }

    public ProjectPage addNewProject() {
        addProjectButton.click();
        return this;
    }

    public ProjectPage checkProjectCreation(String projectName) {
        checkProjectList.shouldHave(Condition.text(projectName));
        return this;
    }
}