import * as cdk from '@aws-cdk/core';
import * as lambda from '@aws-cdk/aws-lambda';

export class JavaCdkStack extends cdk.Stack {
    constructor(scope: cdk.Construct, id: string, props?: cdk.StackProps) {
        super(scope, id, props);

        new lambda.Function(this, 'JavaLambda', {
            runtime: lambda.Runtime.JAVA_8,
            handler: 'com.example.javaaws.Handler::handleRequest',
            memorySize: 512,
            code: lambda.Code.fromAsset('../target/JavaCdk.jar')
        });
    }
}