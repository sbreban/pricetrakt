FROM openjdk:8-jdk-alpine
COPY ./target/pricetrakt-0.0.1.jar /usr/src/pricetrakt/
WORKDIR /usr/src/pricetrakt
EXPOSE 8080
CMD ["java", "-jar", "pricetrakt-0.0.1.jar"]