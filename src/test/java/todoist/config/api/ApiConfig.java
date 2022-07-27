package todoist.config.api;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/api/api.properties")
public interface ApiConfig extends Config {
    String token();

    String baseUrl();

    String projectNumber();
}