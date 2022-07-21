package ru.internet.sergeevss90.helpers.mobile;

import org.aeonbits.owner.ConfigFactory;
import ru.internet.sergeevss90.config.mobile.BrowserstackConfig;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class BrowserStack {
    static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class);
    public static String videoUrl(String sessionId) {

        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(config.loginBS(), config.passwordBS())
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .path("automation_session.video_url");
    }
}
