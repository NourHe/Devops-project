FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD target/achat-1.0.jar achat-1.0.jar
ENTRYPOINT ["java","-jar","/achat-1.0.jar"]

# FROM node:12-slim
#
# COPY package.json /crud-tuto-front/package.json
#
# WORKDIR /crud-tuto-front
# COPY --from=0 /app ./
# RUN npm install
# RUN npm install -g @angular/cli@12.2.18
#
# ENV PATH /crud-tuto-front/node_modules/.bin:$PATH
#
# RUN apt-get update
# RUN apt-get install -y vim
# RUN apt-get install -y curl