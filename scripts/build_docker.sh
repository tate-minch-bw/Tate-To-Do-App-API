#!/bin/bash
# docker build . -t bandwidth-docker.jfrog.io/todo-app:1.0
docker build . --build-arg BASE_IMAGE=$1 --build-arg ARTIFACT_NAME=$2 -t $3/$4:$5
