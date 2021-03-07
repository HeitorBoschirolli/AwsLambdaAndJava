package com.example.skidae;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.joda.time.DateTime;

import java.util.Map;

public class Handler implements RequestHandler<Map<String, String>, Map<String, String>>  {
    public Map<String, String> handleRequest(Map<String, String> input, Context context) {
        return Map.of("Time", DateTime.now().toString());
    }
}
