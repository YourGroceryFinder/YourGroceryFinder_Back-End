# Use the OpenJDK 17 image as the base image
FROM openjdk:17

# Copy the .jar file from the target and place it paste it into /app/
COPY target/back-end-0.0.1-SNAPSHOT.jar /app/

# Set the working directory for the image to /app
WORKDIR /app

# Specify the command to run when a container is created from the Docker image.
CMD ["java", "-jar", "back-end-0.0.1-SNAPSHOT.jar"]
