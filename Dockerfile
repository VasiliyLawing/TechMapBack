# Stage 1: Build the application
FROM gradle:8.5-jdk17 AS build

RUN ./gradlew build

# Stage 2: Create the final image
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/map-0.0.1-SNAPSHOT.jar map.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "map.jar"]
