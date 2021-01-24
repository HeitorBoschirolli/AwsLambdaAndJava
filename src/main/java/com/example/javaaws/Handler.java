package com.example.javaaws;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.joda.time.DateTime;

public class Handler implements RequestHandler<Input, Output> {
    public Output handleRequest(Input input, Context context) {
        Output output = new Output();
        output.setConcatenation(input.getValue1() + input.getValue2());
        output.setDateString(DateTime.now().toString());
        return output;
    }
}
