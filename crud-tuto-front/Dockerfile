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

FROM node:14-alpine
RUN mkdir -p /app \
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build --prod
FROM nginx:latest
COPY  /app/dist/crudtuto-Front  /usr/share/nginx/html
EXPOSE 4200:80
