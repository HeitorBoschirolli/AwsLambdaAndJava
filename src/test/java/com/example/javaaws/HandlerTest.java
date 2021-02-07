package com.example.javaaws;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.DateTime;
import org.junit.Test;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.lambda.LambdaClient;
import software.amazon.awssdk.services.lambda.model.FunctionConfiguration;
import software.amazon.awssdk.services.lambda.model.InvokeRequest;
import software.amazon.awssdk.services.lambda.model.InvokeResponse;
import software.amazon.awssdk.services.lambda.model.ListFunctionsResponse;

import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class HandlerTest
{
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void shouldRespondWithOutput() throws Exception
    {
        // create request
        String arn = fetchArn();
        Input input = new Input("hello", "there");
        String inputString = objectMapper.writeValueAsString(input);
        SdkBytes payload = SdkBytes.fromString(inputString, Charset.defaultCharset());
        InvokeRequest request = InvokeRequest.builder()
                .functionName(arn)
                .payload(payload)
                .build();

        // create Lambda
        LambdaClient awsLambda = LambdaClient.builder()
                .build();
        InvokeResponse response = awsLambda.invoke(request);
        Output objectResponse = objectMapper.readValue(response.payload().asUtf8String(), Output.class);

        assertEquals(objectResponse.getConcatenation(), "hellothere");
        new DateTime(objectResponse.getDateString()).isAfter(new DateTime().minusMinutes(5));
        new DateTime(objectResponse.getDateString()).isBeforeNow();
        awsLambda.close();
    }

    private String fetchArn() {
        LambdaClient lambdaClient = LambdaClient.builder().build();
        ListFunctionsResponse listFunctionsResponse = lambdaClient.listFunctions();
        List<FunctionConfiguration> list = listFunctionsResponse
                .functions()
                .stream()
                .filter(lambda -> lambda.functionName().startsWith("JavaCdkStack-JavaLambda"))
                .collect(Collectors.toList());

        return list.get(0).functionArn();
    }
}
