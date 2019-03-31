#!/usr/bin/env bash
docker rmi $(docker images -qa -f 'dangling=true')
./mvnw clean install -Dmaven.test.skip=true dockerfile:build
docker-compose up