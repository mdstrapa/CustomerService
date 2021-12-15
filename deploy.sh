#!/bin/bash
./mvnw clean package
ssh -i /Users/marcosstrapazon/.ssh/awsMarcosAccounnt.pem rm *.jar
scp -i /Users/marcosstrapazon/.ssh/awsMarcosAccounnt.pem target/*.jar ubuntu@ec2-35-173-198-99.compute-1.amazonaws.com:~
ssh -i /Users/marcosstrapazon/.ssh/awsMarcosAccounnt.pem sudo systemctl restart customer-service