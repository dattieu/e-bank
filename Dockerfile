FROM adoptopenjdk/openjdk11:jdk-11.0.14.1_1-alpine-slim

LABEL maintainer="tieutruongdat@gmail.com"

VOLUME /banking-service

COPY /target/banking-*.jar /usr/local/lib/banking-service.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/usr/local/lib/banking-service.jar"]