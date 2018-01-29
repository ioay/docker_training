FROM gradle:jdk8-alpine as builder
COPY ./src /home/gradle/src/
COPY ./gradle /home/gradle/gradle/
COPY build.gradle /home/gradle/

#target image
FROM openjdk:8-jre-alpine as recipes
COPY --from=builder /home/gradle/build/lubs/*.jar /app.jar
RUN sh -c 'touch /app.jar'
VOLUME /tmp
EXPOSE 8080
RUN adduser -D user
USER user
CMD java -Djava.security.egd=file:/dev/./urandom -jar /app.jar