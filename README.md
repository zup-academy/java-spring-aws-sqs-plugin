## Java Spring AWS SQS Plugin

The **java-spring-aws-sqs-plugin** is a plugin to enable and configure Spring Cloud AWS SQS in Spring Boot Java application.

Applying this plugin into a Spring Boot project will prepare and configure it for all those features:

1. Enables and configures Spring Cloud AWS Messaging for SQS;
2. Configures Spring Cloud AWS SQS following good practices for better performance, throughput and resilience;
3. Configures application to run Spring Boot integration tests using TestContainers with Localstack so that you can write good tests to validate properly your messaging layer and any code that integrates with SQS;
4. Configures Docker Compose with Localstack so that you can run your application locally;
5. Generates production and test sample code so that you have a starting point for writing good production integration tests for SQS producers and consumers;


## How to use

The following steps show how to apply the plugin to an existing Java Spring Boot application.

1. First, import our stack if you haven't done it yet:
```sh
stk import stack https://github.com/zup-academy/java-springboot-restapi-stack
```

2. Now, in the project directory, apply the plugin and answer all the questions:
```sh
stk apply plugin java-springboot-restapi-stack/java-spring-aws-sqs-plugin
```

3. Still inside the project directory, you can verify whether the plugin was applied or not by checking the updated and created files:
```sh
git status
```

Nice! You're ready for production I guess 🥳

[See here the benefits and how you can get the most out of the Java Spring AWS SQS Plugin](http://video-will-be-published.soon/)

## Support

If you need any help, please open an [issue on Plugin's Github repository](https://github.com/zup-academy/java-spring-aws-sqs-plugin). 
