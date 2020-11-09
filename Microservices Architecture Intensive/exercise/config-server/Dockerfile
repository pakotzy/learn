FROM adoptopenjdk/openjdk11:jdk-11.0.8_10-alpine-slim
EXPOSE 8888
ENV JAVA_OPTS="-Xmx128m"
ADD target/config-server-0.0.1.jar app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar /app.jar