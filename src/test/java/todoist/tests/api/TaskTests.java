package todoist.tests.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import todoist.models.CreateRequestBuilder;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static todoist.models.Specs.*;
import static todoist.tests.api.TestData.*;

@Tag("API")
@Tag("ALL")
public class TaskTests extends TestBase {

    @Test
    @DisplayName("Add task")
    void addNewTaskTest() {
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