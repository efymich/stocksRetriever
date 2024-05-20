FROM openjdk:19-alpine
WORKDIR /app
COPY /build/libs/*.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar"]
EXPOSE 8080
