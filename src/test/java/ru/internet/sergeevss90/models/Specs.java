package ru.internet.sergeevss90.models;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.aeonbits.owner.ConfigFactory;
import ru.internet.sergeevss90.config.api.ApiConfig;

import static io.restassured.RestAssured.with;

public class Specs {
    static ApiConfig config = ConfigFactory.create(ApiConfig.class);
    static String token = config.token();
    static String baseUrl = config.baseUrl();

    public static RequestSpecification getRequest = with()
            .header("Authorization", "Bearer " + token)
            .baseUri(baseUrl);

    public static ResponseSpecification response200 = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();

    public static ResponseSpecification response204 = new ResponseSpecBuilder()
            .expectStatusCode(204)
            .build();

    public static RequestSpecification creationRequest = with()
            .header("Authorization", "Bearer " + token)
            .header("X-Request-Id", "$(uuidgen)")
            .contentType("application/json")
            .baseUri(baseUrl);
}