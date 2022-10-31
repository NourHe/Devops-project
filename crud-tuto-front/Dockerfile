#
#FROM node:14-alpine
#RUN npm install -g @angular/cli
#USER node
#WORKDIR /app
#EXPOSE 4200:80
#CMD npm start
#


FROM node:12-slim

COPY package.json /app/package.json

WORKDIR /app
RUN npm install
RUN npm install -g @angular/cli@12.15

ENV PATH /app/node_modules/.bin:$PATH

RUN apt-get update
RUN apt-get install -y vim
RUN apt-get install -y curl
