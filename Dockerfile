FROM scratch

ENV PROFILE=dev

ENV PORT=8080

USER root

RUN mkdir -p /app

WORKDIR /app

RUN echo $(ls)

COPY *.jar ./sample-spring-oc.jar

CMD jar -jar /app/sample-spring-oc.jar --spring.profiles.active=$PROFILE