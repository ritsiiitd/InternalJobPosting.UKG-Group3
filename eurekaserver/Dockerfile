FROM openjdk:17-jdk-slim
COPY target/eurekaserver-0.0.1-SNAPSHOT.jar eurekaserver.jar
EXPOSE 8070
CMD ["java", "-jar", "eurekaserver.jar"]