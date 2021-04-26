FROM openjdk:8-jre-alpine

ENV PROFILE=dev

ENV PORT=8080

RUN mkdir -p /app

WORKDIR /app

COPY *.jar ./sample-spring-oc.jar

RUN echo $(ls)

CMD java -jar /app/sample-spring-oc.jar --spring.profiles.active=$PROFILE