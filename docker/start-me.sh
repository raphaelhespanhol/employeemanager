#!/usr/bin/env bash
echo 'START SETUP'
docker run --rm -dit -e MYSQL_ROOT_PASSWORD=pass --name mysql mysql:5.7