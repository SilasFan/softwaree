FROM openjdk:8

COPY ./target/softwaree-0.0.1-SNAPSHOT.jar /usr/src/myapp/
WORKDIR /usr/src/myapp

CMD java -jar softwaree-0.0.1-SNAPSHOT.jar

EXPOSE 8080