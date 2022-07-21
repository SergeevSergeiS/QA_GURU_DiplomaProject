package ru.internet.sergeevss90.helpers;

import com.github.javafaker.Faker;

public class TestDataGenerator {
    Faker faker = new Faker();

    public int getPriority() {
        return faker.number().numberBetween(0, 5);
    }

    public String getTaskName() {
        return faker.funnyName().name();
    }

    public String getTaskDescription() {
        return "Visit " + faker.address().fullAddress();
    }

    public String getStreetName() {
        return "Visit " + faker.address().streetName();
    }
}