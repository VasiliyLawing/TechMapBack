FROM gradle:7.2.0-jdk17 AS build

COPY . .

RUN ./gradlew build

RUN openjdk:17-jdk-slim

COPY --from=build build/libs/map-0.0.1-SNAPSHOT.jar map.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "map.jar"]