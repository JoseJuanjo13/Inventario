#
# Build stage
#
FROM gradle:7.0.1 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle clean
RUN gradle bootJar

FROM eclipse-temurin:11
ARG JAR_FILE=build/libs/*.jar
COPY --from=build /home/gradle/src/build/libs/*.jar app.jar
EXPOSE ${PORT}
ENTRYPOINT ["java", "-jar", "/app.jar"]