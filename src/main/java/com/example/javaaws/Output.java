package com.example.javaaws;

public class Output {
    private String concatenation;
    private String dateString;

    public Output(String concatenation, String dateString) {
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
