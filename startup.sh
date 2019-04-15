#!/bin/bash -e
./mvnw clean install
java -jar -Dspring.profiles.active=prod target/challenge-0.1.0.jar -Xms1G -Xmx1G
