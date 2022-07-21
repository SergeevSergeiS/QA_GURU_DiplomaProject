package ru.internet.sergeevss90.drivers.web;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import ru.internet.sergeevss90.config.web.WebConfig;


public class BrowserWebDriver {

    public static WebConfig config = ConfigFactory.create(WebConfig.class);

    public static void configure() {
        Configuration.baseUrl = config.baseUrl();
        Configuration.browser = config.browser();
        Configuration.browserVersion = config.browserVersion();
        Configuration.browserSize = config.browserSize();
    }
}