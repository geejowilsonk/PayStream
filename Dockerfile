FROM openjdk:21-jdk-slim
WORKDIR /app

# Copy the JAR file
COPY target/user-service-0.0.1-SNAPSHOT.jar paystream.jar

# Copy the application.properties file
COPY application.properties /app/application.properties

# Expose port
EXPOSE 8080

# Set the Spring Boot configuration path explicitly
ENTRYPOINT ["java", "-jar", "paystream.jar", "--spring.config.location=/app/application.properties"]
