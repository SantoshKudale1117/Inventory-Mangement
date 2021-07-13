FROM openjdk:8-jre-alpine
LABEL maintainer="santosh.kudale96L̥@gmail.com"
ADD target/*.jar app.jar
EXPOSE 9600
ENTRYPOINT [ "java", "-jar", "app.jar" ]
