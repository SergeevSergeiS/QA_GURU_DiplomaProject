package todoist.tests.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static todoist.helpers.api.AllureRestAssuredCustomListener.withCustomTemplates;

public class TestBase {

    @BeforeAll
    static void setUp() {
        RestAssured.filters(withCustomTemplates());
    }
}