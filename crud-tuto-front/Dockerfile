#
#FROM node:14-alpine
#RUN npm install -g @angular/cli
#USER node
#WORKDIR /app
#EXPOSE 4200:80
#CMD npm start
#


FROM node:lts
RUN mkdir /home/node/app
RUN mkdir /home/node/app/node_modules
WORKDIR  /home/node/app
USER node
COPY node:node package.json package-lock.json ./
RUN npm ci --quiet
COPY --chown=node:node . .
