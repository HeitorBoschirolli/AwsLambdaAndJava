package com.example.javaaws;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import org.joda.time.DateTime;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.io.OutputStream;

public class Handler implements RequestStreamHandler {
    private ObjectMapper objectMapper = new ObjectMapper();

    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) {
        Input input;
        try {
            input = objectMapper.readValue(inputStream, Input.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Output output = new Output(input.getValue1() + input.getValue2(), DateTime.now().toString());

        try {
            objectMapper.writeValue(outputStream, output);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
