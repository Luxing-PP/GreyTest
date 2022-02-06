FROM openjdk:8
ARG JAR_FILE
ADD ${JAR_FILE} app.jar
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]
