package ru.internet.sergeevss90.tests.api;

import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import ru.internet.sergeevss90.config.api.ApiConfig;
import ru.internet.sergeevss90.helpers.TestDataGenerator;

import static ru.internet.sergeevss90.helpers.api.AllureRestAssuredCustomListener.withCustomTemplates;

public class TestBase {
    static ApiConfig config = ConfigFactory.create(ApiConfig.class);
    static TestDataGenerator generator = new TestDataGenerator();

    static String
            projectNumber,
            projectName,
            taskName,
            outdatedTaskName,
            updatedTaskName;


    @BeforeAll
    static void setUp() {
        RestAssured.filters(withCustomTemplates());
        projectNumber = config.projectNumber();
        projectName = generator.getTaskName();
        taskName = generator.getTaskDescription();
        outdatedTaskName = generator.getStreetName();
        updatedTaskName = generator.getStreetName();
    }
}