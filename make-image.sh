#!/usr/bin/env bash
docker rmi $(docker images -qa -f 'dangling=true')
./mvnw clean install dockerfile:build