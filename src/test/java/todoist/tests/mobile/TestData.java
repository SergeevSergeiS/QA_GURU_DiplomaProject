package todoist.tests.mobile;

import todoist.drivers.web.BrowserWebDriver;
import todoist.helpers.TestDataGenerator;

public class TestData {
    static TestDataGenerator generator = new TestDataGenerator();
    public static final String
            login = BrowserWebDriver.config.todoistLogin(),
            password = BrowserWebDriver.config.todoistPassword(),
            email = generator.getEmail(),
            projectName = generator.getTaskName(),
            taskName = generator.getTaskName(),
            searchQuery = "For Search Test";
}
