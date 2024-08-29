FROM openjdk:17
EXPOSE 9090
ADD ./target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
