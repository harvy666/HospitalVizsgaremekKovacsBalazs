FROM maven:3.8.5-openjdk-17-slim as builder
WORKDIR /app
COPY ./pom.xml .
RUN mvn dependency:go-offline
COPY ./src ./src
RUN mvn clean package -DskipTest

FROM openjdk:17-alpine
WORKDIR /app
COPY --from=builder /app/target/HospitalVizsgaremek-0.0.1-SNAPSHOT.jar ./app.jar
CMD java -jar ./app.jar