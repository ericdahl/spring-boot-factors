FROM java:8

ADD build/libs/spring-boot-factors-0.0.1.jar app.jar
CMD ["java", "-jar", "/app.jar"]
EXPOSE 8080
