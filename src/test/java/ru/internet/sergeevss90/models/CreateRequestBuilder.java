package ru.internet.sergeevss90.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateRequestBuilder {
    private String name;
    private String content;
    @JsonProperty("project_id")
    private String projectId;
}