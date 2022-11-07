FROM nginx:1.17.1-alpine

WORKDIR /app
COPY crud-tuto-front/nginx.conf /etc/nginx/nginx.conf
COPY /dist /usr/share/nginx/html
EXPOSE 4200:80
