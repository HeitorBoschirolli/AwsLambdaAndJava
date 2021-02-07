package com.example.javaaws;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Output {
    private String concatenation;
    private String dateString;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Output(@JsonProperty("concatenation") String concatenation, @JsonProperty("dateString") String dateString) {
        this.concatenation = concatenation;
        this.dateString = dateString;
    }

    public String getConcatenation() {
        return concatenation;
    }

    public String getDateString() {
        return dateString;
    }
}
