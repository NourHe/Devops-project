FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD http://172.10.0.140:8081/repository/maven-releases/tn/esprit/rh/achat/1.0/achat-1.0.jar achat-1.0.jar
ENTRYPOINT ["java","-jar","/achat-1.0.jar"]
CMD mvn spring-boot:run
