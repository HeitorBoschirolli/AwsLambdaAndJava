#!/bin/bash
echo "Building jar"
mvn clean install

echo "Deploying jar file"
pushd cdk || (echo "pushd failed" && exit)
cdk bootstrap

echo "Updating Lambda function"
cdk deploy
popd || (echo "popd failed" && exit)
