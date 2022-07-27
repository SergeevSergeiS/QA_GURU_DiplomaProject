package todoist.tests.mobile;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static todoist.tests.mobile.TestData.*;

@Tag("MOBILE")
@Tag("ALL")
public class ProjectAndTaskTests extends TestBase {

    @Test
    @DisplayName("Add task")
    void addNewTaskTest() {
        step("Authorize", () ->
            loginPage.doLogin(login, password));
        step("Open task creation page", () ->
            mainPage.startTaskCreation());
        step("Set task name", () ->
            taskPage.addTaskName(taskName));
        step("Finish task creation", () -> {
            taskPage.finishTaskCreation()
                    .closeTaskPage();
        });
        step("Check task name", () ->
            mainPage.taskCreationCheck(taskName));
    }

    @Test
    @DisplayName("Add project")
    void addNewProjectTest() {
        step("Authorize", () ->
            loginPage.doLogin(login, password));
        step("Open project creation page", () ->
            mainPage.openMainMenu());
        step("Start project creation", () ->
            mainPage.startProjectCreation());
        step("Set project name", () ->
            projectPage.addProjectName(projectName));
        step("Finish project creation", () ->
            projectPage.finishProjectCreation());
        step("Check project name", () ->
            mainPage.projectCreationCheck(projectName));
    }
}