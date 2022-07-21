package ru.internet.sergeevss90.config.web;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config/web/remote.properties",
        "classpath:config/web/local.properties"
})
public interface WebConfig extends Config {

    @DefaultValue("https://todoist.com/")
    String baseUrl();
    @DefaultValue("chrome")
    String browser();
    @DefaultValue("103")
    String browserVersion();
    @DefaultValue("1920x1080")
    String browserSize();
    String todoistLogin();
    String todoistPassword();
    String projectNumber();
    @DefaultValue("")
    String remoteUrl();
    @DefaultValue("")
    String selenoidLogin();
    @DefaultValue("")
    String selenoidPassword();
}