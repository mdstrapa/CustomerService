FROM openjdk:11.0.12-jdk-buster
WORKDIR /app
COPY ./target/customer-service-0.0.1-SNAPSHOT.jar ./
CMD ["java", "-jar", "/app/customer-service-0.0.1-SNAPSHOT.jar"]