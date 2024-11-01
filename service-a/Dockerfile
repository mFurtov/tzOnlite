FROM openjdk:11-jre-slim
COPY target/service-a-0.0.1-SNAPSHOT.jar service-a.jar
ENTRYPOINT ["java", "-jar", "/service-a.jar"]