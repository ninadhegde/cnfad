FROM openjdk:17-alphine
WORKDIR /opt
COPY /target/*.jar /opt/app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar