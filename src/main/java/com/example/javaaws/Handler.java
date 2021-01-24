package com.example.javaaws;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.joda.time.DateTime;

public class Handler implements RequestHandler<Input, Output> {
    public Output handleRequest(Input input, Context context) {
        return new Output(input.getValue1() + input.getValue2(), DateTime.now().toString());
    }
}
