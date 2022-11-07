FROM nginx:1.17.1-alpine

WORKDIR /app
COPY . .
COPY crud-tuto-front/nginx.conf /etc/nginx/nginx.conf
COPY /usr/src/app/dist /usr/share/nginx/html
