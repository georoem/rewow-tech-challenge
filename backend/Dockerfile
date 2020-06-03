### STAGE 1: Build ###
FROM maven:3.5.2-jdk-8-alpine AS build
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package

### STAGE 2: Run ###
FROM openjdk:8-jre-alpine
RUN mkdir backend
COPY --from=build /build/target/*.jar /backend
EXPOSE 8080
WORKDIR /backend
CMD java -jar backend*.jar