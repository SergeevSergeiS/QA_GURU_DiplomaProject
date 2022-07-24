package ru.internet.sergeevss90.tests.api;

import org.aeonbits.owner.ConfigFactory;
import ru.internet.sergeevss90.config.api.ApiConfig;
import ru.internet.sergeevss90.helpers.TestDataGenerator;

public class TestData {
    static TestDataGenerator generator = new TestDataGenerator();
    static ApiConfig config = ConfigFactory.create(ApiConfig.class);

    public static final String
            projectNumber = config.projectNumber(),
            projectName = generator.getTaskName(),
            taskName = generator.getTaskDescription(),
            outdatedTaskName = generator.getStreetName(),
            updatedTaskName = generator.getStreetName(),
            removedProjectName = "Delete this";
}