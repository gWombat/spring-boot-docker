#!/usr/bin/env bash

DOCKER_IMAGE=gfabbi/spring-boot-docker

#mvn clean verify -Pintegration-tests sonar:sonar \
#  -Dsonar.projectKey=spring-boot-docker \
#  -Dsonar.host.url=http://localhost:9000 \
#  -Dsonar.login=f0ef3108c34027b2e6fef874c2f368ee0a220590
mvn clean install

docker build -t $DOCKER_IMAGE:latest .