package todoist.tests.web;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static todoist.tests.web.TestData.*;

@Tag("WEB")
@Tag("ALL")
public class ProjectAndTaskTests extends TestBase {

    @Test
    @DisplayName("Add project")
    void addNewProjectTest() {
        step("Authorize", () ->
            loginPage.doLogin(login, password));
        Allure.step("Open project creation menu", () ->
            projectPage.startProjectCreation()
        );
        Allure.step("Add project name", () ->
            projectPage.inputProjectName(projectName));
        Allure.step("Finish project creation", () ->
            projectPage.addNewProject()
        );
        Allure.step("Check result", () ->
            projectPage.checkProjectCreation(projectName));
    }

    @Test
    @DisplayName("Add task")
    void addNewTaskTest() {
        step("Authorize", () ->
                loginPage.doLogin(login, password));
        step("Open task creation menu", () -> {
            taskPage.startTaskCreation();
        });
        step("Add name and description", () -> {
            taskPage.inputTaskName(taskName);
            taskPage.inputTaskDescription(taskDescription);
        });
        step("Choose priority", () -> {
            taskPage.openPriorityFlag();
            taskPage.setPriority();
        });
        Allure.step("Finish task creation", () ->
                taskPage.addNewTask());
        Allure.step("Check result", () ->
                taskPage.checkTooltip()
        );
    }
}