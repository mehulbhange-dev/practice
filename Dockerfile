#FROM openjdk:21-jdk-slim
FROM bellsoft/liberica-runtime-container:jdk-21-stream-musl AS builder
WORKDIR /app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app/app.jar"]