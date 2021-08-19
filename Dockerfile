FROM openjdk:8-jdk-alpine
LABEL maintainer="eng.yowoo@gmail.com"
VOLUME /tmp
ARG JAR_FILE=./build/libs/*.jar
ADD ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://118.47.187.228/test", "-Djava.seucrity.egd=file:/dev/./urandom", "-jar", "/app.jar"]