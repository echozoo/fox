FROM adoptopenjdk/openjdk11:jdk-11.0.8_10-alpine
ADD target/fox-grpc-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT ["sh","-c","java -jar /app.jar"]
