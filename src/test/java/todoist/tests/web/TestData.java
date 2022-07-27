package todoist.tests.web;

import com.codeborne.selenide.Configuration;
import todoist.drivers.web.BrowserWebDriver;
import todoist.helpers.web.PartialLinks;
import todoist.helpers.TestDataGenerator;

public class TestData {
    static TestDataGenerator generator = new TestDataGenerator();
    public static final String
            login = BrowserWebDriver.config.todoistLogin(),
            password = BrowserWebDriver.config.todoistPassword(),
            loginUrl = PartialLinks.LOGIN.getLink(),
            redirectUrl = Configuration.baseUrl + PartialLinks.REDIRECTEDLOGIN.getLink(),
            inboxUrl = Configuration.baseUrl + PartialLinks.INBOXFILTER.getLink()
                    + BrowserWebDriver.config.projectNumber(),
            todayUrl = Configuration.baseUrl + PartialLinks.TODAYFILTER.getLink(),
            labelsUrl = Configuration.baseUrl + PartialLinks.LABELSFILTER.getLink(),
            projectName = generator.getTaskName(),
            taskName = generator.getTaskName(),
            taskDescription = generator.getTaskDescription();
}