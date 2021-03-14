FROM adoptopenjdk/openjdk11:jdk-11.0.8_10-alpine-slim
ADD target/*.jar app.jar
ENTRYPOINT exec java -jar /app.jar