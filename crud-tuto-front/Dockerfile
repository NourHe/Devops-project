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


# Stage 1: Compile and Build angular codebase

# Use official node image as the base image
FROM node:12.15

# Set the working directory
WORKDIR /usr/local/app

# Add the source code to app
COPY ./ /usr/local/app/

# Install all the dependencies
RUN npm install

# Generate the build of the application
RUN npm run build


# Stage 2: Serve app with nginx server

# Use official nginx image as the base image
FROM nginx:latest

# Copy the build output to replace the default nginx contents.
COPY  /usr/local/app/dist/crudtuto-front/ /usr/share/nginx/html

# Expose port 80
EXPOSE 80
