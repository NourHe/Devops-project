#
#FROM node:14-alpine
#RUN npm install -g @angular/cli
#USER node
#WORKDIR /app
#EXPOSE 4200:80
#CMD npm start
#



#FROM node:12-slim
#
#COPY package.json /app/package.json
#
#WORKDIR /app
#RUN npm install
#RUN npm install -g @angular/cli@12.2.18
#
#ENV PATH /app/node_modules/.bin:$PATH
#
#RUN apt-get update
#RUN apt-get install -y vim
#RUN apt-get install -y curl
#
#FROM nginx:alpine
#COPY /dist/crudtuto-Front /usr/share/nginx/html
#EXPOSE 4200:80

# Stage 1: Compile and Build angular codebase
FROM node:12.18-alpine
WORKDIR /app
COPY . .
RUN npm ci && npm run build

# Stage 2: Serve app with nginx servera
FROM nginx:alpine
COPY /app/dist/crudtuto-front/ /usr/share/nginx/html
EXPOSE 4200:80
