FROM amazoncorretto:11-alpine-jdk
MAINTAINER guillekopacek
COPY target/gk-0.0.1-SNAPSHOT.jar gk-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/gk-0.0.1-SNAPSHOT.jar"]