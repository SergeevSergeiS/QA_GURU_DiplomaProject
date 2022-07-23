package ru.internet.sergeevss90.drivers.web;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.internet.sergeevss90.config.web.WebConfig;


public class BrowserWebDriver {
    public static WebConfig config = ConfigFactory.create(WebConfig.class);
    static String useRemote = System.getProperty("webPlatform", "remote");

    public static void configure() {
        Configuration.baseUrl = config.baseUrl();
        Configuration.browser = config.browser();
        Configuration.browserVersion = config.browserVersion();
        Configuration.browserSize = config.browserSize();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--lang=en-en");

        if (useRemote.equals("remote")) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.remote = String.format("https://%s:%s@%swd/hub",
                    config.selenoidLogin(), config.selenoidPassword(), config.remoteUrl());
            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            Configuration.browserCapabilities = capabilities;
        }
    }
}