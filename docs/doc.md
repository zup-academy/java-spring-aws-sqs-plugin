# **Java Spring AWS SQS Plugin**

Java Spring Plugin AWS SQS is a set of technologies and development methodology that together help to use the Amazon SQS messaging service in Java Spring Boot Applications.

This Plugin has support for projects created with Stack Java Spring Boot REST API. And given that it also supports Java Spring Boot projects that use **Maven** as a dependency manager and have their property settings in the **YAML** pattern.


In the next sections you will find detailed information on how to use Java Spring AWS SQS Plugin to enable the ability to use Amazon SQS as a messaging broker in your projects.

Below is a summary of each section of this documentation.

1. [Plugin Core Technologies](#plugin-core-technologies)
2. [Capabilities Enabled when using the Plugin](#what-are-the-capabilities-enabled)
3. [Benefits of using the Plugin](#what-the-benefits-of-using-java-spring-aws-sqs-plugin)
4. [Applying Java Spring AWS SQS Plugin](#applying-java-spring-aws-sqs-plugin)


## **Plugin core technologies**

The purpose of this session is to inform which technologies are part of the Java Spring AWS SQS Plugin.

By applying this plugin in a Spring Boot Java project, your application can benefit from the entire Amazon SQS infrastructure to handle messaging.

### **Technological Composition**

The definition of this Plugin was designed to facilitate the use of Amazon SQS as a Producer and Consumer of messages in Java applications.

We understand that quality is non-negotiable, and we look to technologies and methodologies as a means to obtain the much-desired software quality. This premise was the guide for choosing each technology detailed below.


- Production environment
    - Spring Cloud AWS Messaging
    - Amazon SDK SQS
- Test environment
    - Spring Clud AWS Test
    - Awaitility
    - JUnit
    - Test Containers
        - LocalStack
- Development environment
    - Docker Compose
        - LocalStack Container


## **What are the capabilities Enabled**

By applying the Java Spring AWS SQS Plugin to your Java Spring Boot project, your project will be able to:

1. Create SQS Producers
2. Create SQS Consumers
3. Create Queues in SQS
4. Design and build software components that use Amazon S3 without connecting to AWS.
5. Create an automated integration test suite with TestContainers and LocalStack
7. Create Tests of an asynchronous nature for Consumers with Awaitility
8. Development environment set up next to Docker with Docker-compose.
9. LocalStack for testing and local development

## **What are the benefits of using Java Spring AWS SQS Plugin**

1. Ease of configuring and using Amazon SQS in your project through the StackSpot CLI.
2. Sample codes of how to Producer for Amazon SQS using good practices.
3. Sample Codes on how to Consumer for Amazon SQS using best practices.
4. Sample Integration Test codes to validate Producer SQS behavior.
5. Sample Integration Test codes to validate Producer SQS behavior.
7. Configuration of the test environment with JUnit and Test Containers.
8. DockerCompose for using Amazon SQS with LocalStack in a development environment.
9. Logs enabled to facilitate troubleshooting


[Watch this video to see the benefits of using Java Spring AWS SQS Plugin in your project](https://youtu.be/mBLcN2dr6Ys)


## **Applying Java Spring AWS SQS Plugin**

To apply the Java Spring AWS SQS Plugin in your projects and enjoy its benefits, you must have the StackSpot CLI installed on your machine. [If not, follow this tutorial to install](https://docs.stackspot.com/docs/stk-cli/installation/).

### 1. Import the Stack on your machine

```sh
stk import stack https://github.com/zup-academy/java-springboot-restapi-stack
```

### 2. Now check if the Stack was successfully imported

```sh
stk list stack | grep java-springboot
```

### 3. Apply the Plugin, in your project directory, execute

```sh
stk apply plugin java-springboot-restapi-stack/java-spring-aws-sqs-plugin
```

### 4. Check the changes in your project

```sh
git status
```



## Support

If you need help, please open an [issue in Stack's Github repository](https://github.com/zup-academy/java-spring-aws-sqs-plugin/issues).