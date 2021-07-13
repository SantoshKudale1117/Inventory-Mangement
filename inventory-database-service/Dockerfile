FROM openjdk:8-jre-alpine
LABEL maintainer="santosh.kudale96@gmail.com"
ADD target/*.jar app.jar
EXPOSE 9500 9550
ENTRYPOINT [ "java", "-jar", "app.jar" ]
