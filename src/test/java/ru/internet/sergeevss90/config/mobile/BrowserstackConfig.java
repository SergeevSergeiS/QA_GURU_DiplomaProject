package ru.internet.sergeevss90.config.mobile;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/mobile/browserstack.properties"
})
public interface BrowserstackConfig extends Config {
    String loginBS();

    String passwordBS();

    String deviceName();

    String androidVersion();

    String url();

    String urlApp();

}