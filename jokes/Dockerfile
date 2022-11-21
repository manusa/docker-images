## Stage 1: Provision Maven wrapper
FROM maven:3.8-eclipse-temurin-17-alpine AS wrapper

COPY pom.xml /tmp/

RUN cd /tmp \
    && touch pom.xml \
    && mvn -N wrapper:wrapper

## Stage 2: Build Project
FROM quay.io/quarkus/ubi-quarkus-graalvmce-builder-image:22.3-java17 AS build
COPY --from=wrapper --chown=quarkus:quarkus /tmp/mvnw /code/mvnw
COPY --from=wrapper --chown=quarkus:quarkus /tmp/.mvn /code/.mvn
COPY --chown=quarkus:quarkus pom.xml /code/
USER quarkus
WORKDIR /code
RUN ./mvnw -B org.apache.maven.plugins:maven-dependency-plugin:3.1.2:go-offline
COPY src /code/src
RUN ./mvnw package -Pnative

## Stage 3: Create final image
FROM registry.access.redhat.com/ubi8/ubi-minimal
MAINTAINER Marc Nuri <marc@marcnuri.com>
LABEL MAINTAINER="Marc Nuri <marc@marcnuri.com>"

WORKDIR /
COPY --from=build /code/target/jokes /deployments/

RUN chmod 775 /deployments  \
  && chown -R 1001 /deployments \
  && chmod -R "g+rwX" /deployments \
  && chown -R 1001:root /deployments

EXPOSE 8080
USER 1001

CMD ["/deployments/jokes", "-Dquarkus.http.host=0.0.0.0"]
