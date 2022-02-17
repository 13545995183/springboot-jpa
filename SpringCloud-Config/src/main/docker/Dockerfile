FROM openjdk:8-jdk-alpine
RUN apk update && apk upgrade && apk add  netcat-openbsd
RUN mkdir -p /use/local/licensingservice/
ADD licensing-service-0.0.1-SNAPSHOT.jar /use/local/licensingservice/
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh