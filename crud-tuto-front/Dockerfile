FROM nginx:1.17.1-alpine

WORKDIR /app
COPY . .
RUN npm install
RUN npm run build

FROM nginx:alpine
COPY crud-tuto-front/nginx.conf /etc/nginx/nginx.conf
COPY /usr/src/app/dist /usr/share/nginx/html
