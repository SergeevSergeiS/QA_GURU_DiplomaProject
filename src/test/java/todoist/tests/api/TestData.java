package todoist.tests.api;

import org.aeonbits.owner.ConfigFactory;
import todoist.config.api.ApiConfig;
import todoist.helpers.TestDataGenerator;

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