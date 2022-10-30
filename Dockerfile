FROM openjdk:8-jdk-alpine
EXPOSE 8083
RUN curl -X GET http://192.168.1.10:8081/#browse/browse:maven-releases:tn%2Fesprit%2Frh%2Fachat%2F1.0%2Fachat-1.0.jar --output achat-1.0.jar
ADD achat-1.0.jar achat-1.0.jar
#ADD target/achat-1.0.jar achat-1.0.jar
ENTRYPOINT ["java","-jar","/achat-1.0.jar"]