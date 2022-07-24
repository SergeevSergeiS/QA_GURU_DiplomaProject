package ru.internet.sergeevss90.helpers;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class TestDataGenerator {
    Faker faker = new Faker();

    public int getPriority() {
        return faker.number().numberBetween(1, 5);
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

    public String getEmail() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        return fakeValuesService.bothify("???????????###@gmail.com");
    }
}