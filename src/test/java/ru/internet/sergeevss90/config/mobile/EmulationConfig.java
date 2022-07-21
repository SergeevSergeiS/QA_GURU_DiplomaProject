package ru.internet.sergeevss90.config.mobile;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/mobile/emulation.properties"
})
public interface EmulationConfig extends Config {

    @Key("platformName")
    String platformName();

    @Key("deviceName")
    String deviceName();

    @Key("platformVersion")
    String platformVersion();
}
