FROM openjdk:11-jdk-slim
ARG JAR_FILE=build/libs/*.jar
COPY --from=build /home/gradle/src/build/libs/*.jar app.jar
EXPOSE ${PORT}
ENTRYPOINT ["java", "-jar", "/app.jar"]