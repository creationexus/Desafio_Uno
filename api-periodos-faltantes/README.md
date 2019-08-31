# client-periodos

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>com.previred.client.periodos</groupId>
    <artifactId>client-periodos</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.previred.client.periodos:client-periodos:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/client-periodos-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import com.previred.client.periodos.swagger.*;
import com.previred.client.periodos.swagger.auth.*;
import com.previred.client.periodos.swagger.codegen.model.*;
import com.previred.client.periodos.swagger.codegen.api.PeriodosApi;

import java.io.File;
import java.util.*;

public class PeriodosApiExample {

    public static void main(String[] args) {
        
        PeriodosApi apiInstance = new PeriodosApi();
        try {
            Periodo result = apiInstance.periodos();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PeriodosApi#periodos");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://127.0.0.1:8050/periodos*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*PeriodosApi* | [**periodos**](docs/PeriodosApi.md#periodos) | **GET** /api | Lista de periodos a procesar


## Documentation for Models

 - [Periodo](docs/Periodo.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

mgonzalez@previred.com

