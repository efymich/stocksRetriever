FROM gradle:8.7-jdk21-alpine as build
WORKDIR /app
COPY build.gradle.kts settings.gradle.kts /app/
COPY gradle /app/
COPY src /app/src
RUN gradle build --no-daemon

FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar", "app.jar"]