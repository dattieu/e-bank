FROM adoptopenjdk/openjdk11:jdk-11.0.14.1_1-alpine-slim
 
EXPOSE 8080
 
COPY /target/banking-*.jar /usr/local/lib/banking-service.jar
 
ENTRYPOINT ["java","-jar","/usr/local/lib/banking-service.jar"]