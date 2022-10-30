### Stage 1: Compile and Build angular codebase
##FROM node:12.18-alpine as build
##WORKDIR /app
##COPY . .
##RUN npm install --force
##RUN npm run build
### Stage 2: Serve app with nginx servera
##FROM nginx:latest
##COPY --from=build /app/dist/crudtuto-Front /usr/share/nginx/html
##EXPOSE 80
#

#FROM node:14-alpine
#RUN npm install -g @angular/cli
#USER node
#WORKDIR /app
#EXPOSE 4200 49153
#CMD npm start


FROM node:12.7-alpine AS build
WORKDIR /app
COPY / ./
COPY package*.json ./

RUN npm install -g @angular/cli@12.15 && \
    npm install && \
    ng build
COPY . .

FROM nginx:1.17.1-alpine
WORKDIR /app
COPY --from=build /app/dist/ui /usr/share/nginx/html
