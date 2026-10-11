# Build stage
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copy the entire project context to allow access to the api folder
COPY . .

# Build the application using the Maven wrapper in the backend directory
RUN cd backend && ./mvnw clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy the generated jar from the build stage
COPY --from=build /app/backend/target/math-evaluator-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
