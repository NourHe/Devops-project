## Stage 1: Compile and Build angular codebase
#FROM node:12.18-alpine
#WORKDIR /app
#COPY . .
#RUN npm install --force
#RUN npm run build
## Stage 2: Serve app with nginx servera
#FROM nginx:latest
#COPY --from=build /app/dist/crudtuto-Front /usr/share/nginx/html
#EXPOSE 80
FROM nginx:1.19.7-alpine
COPY /app/dist  /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
