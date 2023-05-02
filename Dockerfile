#
# Build stage
#
#FROM gradle:latest AS build
#COPY --chown=gradle:gradle . /home/gradle/src
#WORKDIR /home/gradle/src
#RUN gradle clean
#RUN gradle bootJar

FROM openjdk:11-jdk-slim
ARG JAR_FILE=web/build/libs/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE ${PORT}
ENTRYPOINT ["java", "-jar", "/app.jar"]