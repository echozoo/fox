FROM adoptopenjdk/openjdk11:jdk-11.0.8_10-alpine
ADD target/fox-hbase.jar /app.jar

ENTRYPOINT ["sh","-c","java -jar /app.jar"]
