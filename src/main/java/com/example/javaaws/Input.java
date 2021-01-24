package com.example.javaaws;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Input {
    private String value1;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Input(@JsonProperty("value1") String value1, @JsonProperty("value2") String value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    private String value2;

    public String getValue1() {
        return this.value1;
    }

    public String getValue2() {
        return this.value2;
    }
}
