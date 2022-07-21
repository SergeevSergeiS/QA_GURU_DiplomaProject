package ru.internet.sergeevss90.helpers.api;

import io.qameta.allure.restassured.AllureRestAssured;

public class AllureRestAssuredCustomListener {
    private static final AllureRestAssured FILTER = new AllureRestAssured();

    public static AllureRestAssured withCustomTemplates() {
        FILTER.setRequestTemplate("request.ftl");
        FILTER.setResponseTemplate("response.ftl");
        return FILTER;
    }
}