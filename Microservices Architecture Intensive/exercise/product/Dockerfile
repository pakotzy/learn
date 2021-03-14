FROM adoptopenjdk/openjdk11:jdk-11.0.8_10-alpine-slim
ENV JAVA_OPTS="-Xmx128m -Dfile.encoding=UTF-8"
ADD target/*.jar app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar /app.jar