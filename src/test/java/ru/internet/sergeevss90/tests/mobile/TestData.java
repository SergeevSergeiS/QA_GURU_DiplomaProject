package ru.internet.sergeevss90.tests.mobile;

import ru.internet.sergeevss90.drivers.web.BrowserWebDriver;
import ru.internet.sergeevss90.helpers.TestDataGenerator;

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
