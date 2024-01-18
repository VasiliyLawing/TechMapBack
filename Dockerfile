# Stage 1: Build the application
FROM gradle:7.2.0-jdk17 AS build
COPY . .
COPY gradlew .
COPY gradlew.bat .
RUN chmod +x gradlew
RUN ./gradlew build

# Stage 2: Create the final image
FROM openjdk:17-jdk-slim
COPY --from=build build/libs/map-0.0.1-SNAPSHOT.jar map.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "map.jar"]
