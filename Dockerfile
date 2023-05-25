ARG BASE_IMAGE
FROM $BASE_IMAGE
# FROM bandwidth-docker.jfrog.io/bwi-spring-boot-template-java-17:1.0.0

ARG ARTIFACT_NAME
ENV ARTIFACT_NAME=${ARTIFACT_NAME}.jar

# ENV ARTIFACT_NAME=demo-0.0.1-SNAPSHOT.jar

COPY /target/${ARTIFACT_NAME} /opt/
#HEALTHCHECK --interval=1m --timeout=20s --start-period=3m --retries=5 CMD curl localhost:8080/actuator/health || exit 1
