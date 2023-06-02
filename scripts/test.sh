#!/bin/bash
cd ..
mvn compile jib:dockerBuild
docker compose up --build
