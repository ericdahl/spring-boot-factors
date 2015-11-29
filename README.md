spring-boot-factors
===========================

[![Build Status](https://travis-ci.org/ericdahl/spring-boot-factors.png?branch=master)](https://travis-ci.org/ericdahl/spring-boot-factors) [![Coverage Status](https://coveralls.io/repos/ericdahl/spring-boot-factors/badge.png)](https://coveralls.io/r/ericdahl/spring-boot-factors)

Sample web service app using spring-boot, groovy and spock

#### Quick Start
##### Build
```$ gradle build```
##### Run
```$ java -jar build/libs/*jar```
##### Use
```$ curl http://localhost:8080/47```
#### Management
The app uses Spring Boot's Actuator feature to expose [many useful metrics/stats](http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#production-ready-endpoints) for monitoring. They
are available under /manage.

For example:

[![ScreenShot](https://raw.githubusercontent.com/ericdahl/spring-boot-factors/gh-pages/actuator-thumb.png)](https://raw.githubusercontent.com/ericdahl/spring-boot-factors/gh-pages/actuator.png)
