FROM openjdk:17-jdk-slim
COPY target/gatewayserver-0.0.1-SNAPSHOT.jar gatewayserver.jar
EXPOSE 8072
CMD ["java", "-jar", "gatewayserver.jar"]