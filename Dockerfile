# USe the OpenJDD 17 image as the base image
FROM openjdk:17

COPY target/back-end-0.0.1-SNAPSHOT.jar /app/

WORKDIR /app

CMD ["java", "-jar", "back-end-0.0.1-SNAPSHOT.jar"]
