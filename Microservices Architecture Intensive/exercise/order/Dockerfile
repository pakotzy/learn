FROM adoptopenjdk/openjdk11:jdk-11.0.8_10-alpine-slim
VOLUME /tmp
EXPOSE 8080
ENV JAVA_OPTS="-Xmx128m -Dfile.encoding=UTF-8"
ADD target/order-0.0.1.jar app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar /app.jar