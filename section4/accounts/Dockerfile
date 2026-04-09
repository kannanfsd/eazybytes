#Start with a base image containing Java runtime
FROM openjdk:21-ea-21-slim-buster

#Information around who maintains the image
MAINTAINER kannanfsd

#Add the applications jar to the image
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT ["java", "-jar", "accounts-0.0.1-SNAPSHOT.jar"]

