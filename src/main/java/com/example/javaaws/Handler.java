package com.example.javaaws;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.joda.time.DateTime;

import java.util.Map;

public class Handler implements RequestHandler<Map<String,String>, String> {
    public String handleRequest(Map<String, String> event, Context context) {
        return DateTime.now().toString();
    }
}
