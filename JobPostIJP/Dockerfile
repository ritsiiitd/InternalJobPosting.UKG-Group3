FROM openjdk:17-jdk-slim
COPY target/JobPostIJP-0.0.1-SNAPSHOT.jar jobposting.jar
EXPOSE 8082
CMD ["java", "-jar", "jobposting.jar"]