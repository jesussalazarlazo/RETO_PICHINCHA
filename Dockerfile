
FROM openjdk:8-jre-alpine

WORKDIR /

RUN mkdir app
COPY target/challenge-0.0.1-SNAPSHOT.jar /app
WORKDIR /app

#Exponemos el puerto 8080
EXPOSE 8080


CMD ["java","-jar","challenge-0.0.1-SNAPSHOT.jar"]
