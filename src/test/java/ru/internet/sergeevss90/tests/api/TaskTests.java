package ru.internet.sergeevss90.tests.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.internet.sergeevss90.models.CreateRequestBuilder;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.internet.sergeevss90.models.Specs.*;
import static ru.internet.sergeevss90.tests.api.TestData.*;

@Tag("API")
@Tag("ALL")
public class TaskTests extends TestBase {

    @Test
    @DisplayName("Add a new task")
    void createNewTaskTest() {
        CreateRequestBuilder createCredentials = new CreateRequestBuilder();
        final CreateRequestBuilder[] projectData = new CreateRequestBuilder[1];
        createCredentials.setContent(taskName);
        createCredentials.setProjectId(projectNumber);

        step("Create task", () -> {
            projectData[0] = given()
                    .spec(creationRequest)
                    .body(createCredentials)
                    .when()
                    .post("/tasks")
                    .then()
                    .spec(response200)
                    .extract().as(CreateRequestBuilder.class);
        });
        step("Check task name", () ->
                assertEquals(taskName, projectData[0].getContent()));
    }
}