# Rewow - Ubits Tech Challenge

## Description
This is a solution for Re Wow company dedicated to providing services for pets.

## Requirements

For building and running the application you need:

- [Docker](https://www.docker.com/get-started)

## Running the application
To build and run the project you need excecute the following command in the root of the project where the file docker-compose.yml is:

```shell
docker-compose up -d --build 
```
This will create the follow containers:

- rewow_frontend: It is an Angular project which contains the pet application implemented
- rewow_backend: It is a Spring Boot microservice with the logic to save all the pet information
- database: It is a Postgres container with the data model implementation
