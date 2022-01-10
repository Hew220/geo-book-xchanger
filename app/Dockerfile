FROM openjdk:11-jre-slim

WORKDIR app

COPY /target/restapi-test-project.jar .

CMD ["sh","-c", "sleep 60 && java -jar restapi-test-project.jar"]

