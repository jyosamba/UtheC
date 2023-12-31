# Stage 1: Build the Spring Boot backend with Maven
FROM maven:3.8.3-openjdk-17 AS backend-build

WORKDIR /app

# Copy the backend source code and the pom.xml
COPY src ./src
COPY pom.xml .

# Build the backend
RUN mvn clean package

# Stage 3: Create the final image with Spring Boot backend and Nginx for frontend
FROM eclipse-temurin:17 AS final

# Copy the Spring Boot JAR file from the backend build stage
COPY --from=backend-build /app/target/*.jar /app/app.jar

CMD ["java", "-jar", "/app/app.jar"]

