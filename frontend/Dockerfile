### STAGE 1: Build ###
FROM node:12.7-alpine AS build
WORKDIR /usr/src/app
COPY package.json ./
RUN npm install
COPY . .
RUN npm run build

### STAGE 2: Run ###
FROM nginx:latest

COPY --from=build /usr/src/app/dist/frontend /usr/share/nginx/html
COPY default.conf /etc/nginx/conf.d/default.conf.templ
COPY conf-builder.sh /usr/bin/conf-builder.sh

RUN chown -R nginx:nginx /usr/share/nginx/html/
RUN sed -i 's/\r//g' /usr/bin/conf-builder.sh
RUN chmod +x /usr/bin/conf-builder.sh

EXPOSE 80

CMD conf-builder.sh &&\
  nginx -g "daemon off;"