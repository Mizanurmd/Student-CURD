# Use an official OpenJDK runtime as a parent image
FROM amazoncorretto:17

LABEL version='1.0'

EXPOSE 8081:8081

WORKDIR /app

COPY target/curd-0.0.1-SNAPSHOT.jar /app/curd.jar



# Run the JAR file
ENTRYPOINT ["java", "-jar", "curd.jar"]
