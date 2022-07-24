package ru.internet.sergeevss90.tests.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static ru.internet.sergeevss90.tests.web.TestData.*;

@Tag("WEB")
@Tag("ALL")
public class ProjectAndTaskTests extends TestBase {

    @Test
    @DisplayName("Add project")
    void createProjectTest() {
        step("Authorize", () ->
            loginPage.doLogin(login, password));
        step("Open project creation menu", () ->
            projectPage.startProjectCreation()
        );
        step("Add project name", () ->
            projectPage.inputProjectName(projectName));
        step("Finish project creation", () ->
            projectPage.addNewProject()
        );
        step("Check result", () ->
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
        step("Finish task creation", () ->
                taskPage.addNewTask());
        step("Check result", () ->
                taskPage.checkTooltip()
        );
    }
}