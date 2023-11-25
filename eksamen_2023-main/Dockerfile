# Stage 1: Build
FROM maven:3.8.1-openjdk-11-slim AS build
WORKDIR /app
COPY . /app
RUN mvn clean install

# Stage 2: Run
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
