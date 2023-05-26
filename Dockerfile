# ARG BASE_IMAGE
# FROM $BASE_IMAGE

FROM openjdk:17

# ARG ARTIFACT_NAME
# ENV ARTIFACT_NAME=${ARTIFACT_NAME}.jar

# COPY /target/${ARTIFACT_NAME} /opt/
COPY /target/todo-app-0.0.1-SNAPSHOT.jar /opt/

ENTRYPOINT ["java", "-jar", "/opt/todo-app-0.0.1-SNAPSHOT.jar"]

