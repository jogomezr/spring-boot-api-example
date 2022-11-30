# spring-boot-api-example
Java application implementing a sample **REST API using Spring MVC** and Swagger annotations to describe the API.

## How to compile the application

Execute the following command:

```
mvn clean compile
```

## How to deploy the application

Execute the following command:

```
mvn spring-boot:run
```

By default, the Spring Boot application runs at the UR **http://localhost:8080**.

## How to generate the API specification file

If you want to generate the API specification from the source code, just execute the following command:

```
mvn clean compile
```

The API specification will be generated within the **generated/swagger-api-spec** folder.

There are also some templates available inside the **templates** folder. Those templates are used during the execution of swagger-maven-plugin to generate a markdown file with the **API documentation** (*generated/documentation.md*)
