FROM openjdk:11-jdk

WORKDIR /app
COPY target/* ./

ENTRYPOINT ["java","-jar","demo-0.0.1-SNAPSHOT.jar"]
