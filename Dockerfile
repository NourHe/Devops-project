FROM openjdk:8-jdk-alpine
EXPOSE 8083

FROM alpine/curl
RUN curl -X GET http://192.168.1.10:8081/repository/maven-releases/tn/esprit/rh/achat/1.0/achat-1.0.jar --output achat-1.0.jar
ADD achat-1.0.jar achat-1.0.jar
#ADD target/achat-1.0.jar achat-1.0.jar
ENTRYPOINT ["java","-jar","/achat-1.0.jar"]