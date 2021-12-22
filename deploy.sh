#!/bin/bash
SERVER_NAME=ubuntu@ec2-18-212-52-252.compute-1.amazonaws.com
./mvnw clean package
ssh -i /Users/marcosstrapazon/.ssh/awsMarcosAccounnt.pem $SERVER_NAME rm "~/*.jar"
scp -i /Users/marcosstrapazon/.ssh/awsMarcosAccounnt.pem target/*.jar $SERVER_NAME:~
ssh -i /Users/marcosstrapazon/.ssh/awsMarcosAccounnt.pem $SERVER_NAME "sudo systemctl restart customer-service"