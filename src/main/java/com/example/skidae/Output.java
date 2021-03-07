package com.example.skidae;

public class Output {
    private final String concatenation;
    private final String dateString;

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
