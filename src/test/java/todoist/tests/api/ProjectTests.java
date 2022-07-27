package todoist.tests.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import todoist.models.CreateRequestBuilder;
import todoist.models.UpdateRequestBuilder;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static todoist.models.Specs.*;
import static todoist.tests.api.TestData.*;

@Tag("API")
@Tag("ALL")
public class ProjectTests extends TestBase {

    @Test
    @DisplayName("Get all user's projects")
    void getAllProjectsTest() {
        step("Get list of all user's projects", () -> {
            given()
                    .spec(getRequest)
                    .when()
                    .get("/projects")
                    .then()
                    .spec(response200);
        });
    }

    @Test
    @DisplayName("Get one particular user's project")
    void getSingleProjectTest() {
        final CreateRequestBuilder[] projectData = new CreateRequestBuilder[1];

        step("Get user's project", () -> {
            projectData[0] = given()
                    .spec(getRequest)
                    .when()
                    .get("/projects/" + projectNumber)
                    .then()
                    .spec(response200)
                    .extract().as(CreateRequestBuilder.class);
        });
        step("Check project id in response", () ->
                assertEquals(projectNumber, projectData[0].getId()));
    }

    @Test
    @DisplayName("Add project")
    void addNewProjectTest() {
        CreateRequestBuilder createCredentials = new CreateRequestBuilder();
        final CreateRequestBuilder[] projectData = new CreateRequestBuilder[1];
        createCredentials.setName(projectName);

        step("Create project", () -> {
            projectData[0] = given()
                    .spec(creationRequest)
                    .body(createCredentials)
                    .when()
                    .post("/projects")
                    .then()
                    .spec(response200)
                    .extract().as(CreateRequestBuilder.class);
        });
        step("Check project id in response", () ->
                assertEquals(projectName, projectData[0].getName()));
    }

    @Test
    @DisplayName("Update project name")
    public void updateProjectTest() {
        UpdateRequestBuilder oldCreateCredentials = new UpdateRequestBuilder();
        final CreateRequestBuilder[] projectData = new CreateRequestBuilder[1];
        UpdateRequestBuilder newCreateCredentials = new UpdateRequestBuilder();
        final long[] id = new long[1];
        oldCreateCredentials.setName(outdatedTaskName);
        newCreateCredentials.setName(updatedTaskName);

        step("Create project and save its id", () -> {
            id[0] = given()
                    .spec(creationRequest)
                    .body(oldCreateCredentials)
                    .when()
                    .post("/projects")
                    .then()
                    .spec(response200)
                    .body("name", is(outdatedTaskName))
                    .extract().jsonPath().getLong("id");

            newCreateCredentials.setId(id[0]);
        });
        step("Change project's name", () -> {
            given()
                    .spec(creationRequest)
                    .body(newCreateCredentials)
                    .when()
                    .post("/projects/" + id[0])
                    .then()
                    .spec(response204);
        });
        step("Get updated project data", () -> {
            projectData[0] = given()
                    .spec(getRequest)
                    .when()
                    .get("/projects/" + id[0])
                    .then()
                    .spec(response200)
                    .extract().as(CreateRequestBuilder.class);
        });
        step("Check project name", () -> {
            assertNotEquals(outdatedTaskName, projectData[0].getName());
            assertEquals(updatedTaskName, projectData[0].getName());
        });
    }

    @Test
    @DisplayName("Delete project")
    void deleteProject() {
        UpdateRequestBuilder credentials = new UpdateRequestBuilder();
        final long[] id = new long[1];
        credentials.setName(removedProjectName);

        step("Create project and save its id", () -> {
            id[0] = given()
                    .spec(creationRequest)
                    .body(credentials)
                    .when()
                    .post("/projects")
                    .then()
                    .spec(response200)
                    .extract().jsonPath().getLong("id");
        });
        step("Delete project", () -> {
            given()
                    .spec(getRequest)
                    .when()
                    .delete("/projects/" + id[0])
                    .then()
                    .spec(response204);
        });
        step("Check that project was deleted", () -> {
            given()
                    .spec(getRequest)
                    .when()
                    .get("/projects")
                    .then()
                    .spec(response200)
                    .body("findAll{it.name =~/.*/}.name.flatten()",
                            not((hasItem(removedProjectName))));
        });
    }
}