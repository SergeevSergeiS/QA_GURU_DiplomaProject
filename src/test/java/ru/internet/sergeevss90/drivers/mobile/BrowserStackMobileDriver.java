package ru.internet.sergeevss90.drivers.mobile;

import com.codeborne.selenide.WebDriverProvider;
import ru.internet.sergeevss90.config.mobile.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackMobileDriver implements WebDriverProvider {
    static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class);

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        mutableCapabilities.setCapability("browserstack.user", config.loginBS());
        mutableCapabilities.setCapability("browserstack.key", config.passwordBS());
        mutableCapabilities.setCapability("app", config.urlApp());
        mutableCapabilities.setCapability("device", config.deviceName());
        mutableCapabilities.setCapability("os_version", config.androidVersion());
        mutableCapabilities.setCapability("project", "QA GURU DiplomaProject SergeevSS");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "selenide android tests");
        mutableCapabilities.setCapability("unicodeKeyboard", true);
        mutableCapabilities.setCapability("resetKeyboard", true);

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(config.url());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}