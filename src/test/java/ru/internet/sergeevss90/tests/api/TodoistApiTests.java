package ru.internet.sergeevss90.tests.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.internet.sergeevss90.models.CreateRequestBuilder;
import ru.internet.sergeevss90.models.UpdateRequestBuilder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static ru.internet.sergeevss90.models.Specs.*;
import static ru.internet.sergeevss90.tests.api.TestData.*;

@Tag("API")
@Tag("ALL")
public class TodoistApiTests extends TestBase {

    @Test
    @DisplayName("Get all user's projects")
    void getAllProjectsTest() {

        given()
                .spec(getRequest)
                .when()
                .get("/projects")
                .then()
                .spec(response200);
    }

    @Test
    @DisplayName("Get one user's project")
    void getSingleProjectTest() {
        CreateRequestBuilder ProjectData = given()
                .spec(getRequest)
                .when()
                .get("/projects/" + projectNumber)
                .then()
                .spec(response200)
                .extract().as(CreateRequestBuilder.class);
        assertEquals(projectNumber, ProjectData.getId());
    }

    @Test
    @DisplayName("Adding a new project")
    void createNewProjectTest() {
        CreateRequestBuilder createCredentials = new CreateRequestBuilder();
        createCredentials.setName(projectName);
        CreateRequestBuilder ProjectData = given()
                .spec(creationRequest)
                .body(createCredentials)
                .when()
                .post("/projects")
                .then()
                .spec(response200)
                .extract().as(CreateRequestBuilder.class);
        assertEquals(projectName, ProjectData.getName());
    }

    @Test
    @DisplayName("Updating project name")
    public void updateProjectTest() {
        UpdateRequestBuilder oldCreateCredentials = new UpdateRequestBuilder();
        oldCreateCredentials.setName(outdatedTaskName);

        long id = given()
                .spec(creationRequest)
                .body(oldCreateCredentials)
                .when()
                .post("/projects")
                .then()
                .spec(response200)
                .body("name", is(outdatedTaskName))
                .extract().jsonPath().getLong("id");

        UpdateRequestBuilder newCreateCredentials = new UpdateRequestBuilder();
        newCreateCredentials.setName(updatedTaskName);
        newCreateCredentials.setId(id);

        given()
                .spec(creationRequest)
                .body(newCreateCredentials)
                .when()
                .post("/projects/" + id)
                .then()
                .spec(response204);

        CreateRequestBuilder ProjectData = given()
                .spec(getRequest)
                .when()
                .get("/projects/" + id)
                .then()
                .spec(response200)
                .extract().as(CreateRequestBuilder.class);

        assertNotEquals(outdatedTaskName, ProjectData.getName());
        assertEquals(updatedTaskName, ProjectData.getName());
    }

    @Test
    @DisplayName("Adding a new task")
    void createNewTaskTest() {
        CreateRequestBuilder createCredentials = new CreateRequestBuilder();
        createCredentials.setContent(taskName);
        createCredentials.setProjectId(projectNumber);

        CreateRequestBuilder ProjectData = given()
                .spec(creationRequest)
                .body(createCredentials)
                .when()
                .post("/tasks")
                .then()
                .spec(response200)
                .extract().as(CreateRequestBuilder.class);

        assertEquals(taskName, ProjectData.getContent());
    }

    @Test
    @DisplayName("Delete project")
    void deleteProject() {
        UpdateRequestBuilder credentials = new UpdateRequestBuilder();
        credentials.setName("Delete this");

        String id =
                given()
                        .spec(creationRequest)
                        .body(credentials)
                        .when()
                        .post("/projects")
                        .then()
                        .spec(response200)
                        .extract().jsonPath().getString("id");

        given()
                .spec(getRequest)
                .when()
                .delete("/projects/" + id)
                .then()
                .spec(response204);
    }
}