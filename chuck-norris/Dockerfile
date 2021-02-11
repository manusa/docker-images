## Stage 1: Build Project
FROM quay.io/quarkus/centos-quarkus-maven:21.0.0-java11 AS build
COPY pom.xml /usr/src/app/
RUN mvn -f /usr/src/app/pom.xml -B de.qaware.maven:go-offline-maven-plugin:1.2.5:resolve-dependencies
COPY src /usr/src/app/src
USER root
RUN chown -R quarkus /usr/src/app
USER quarkus
RUN mvn -f /usr/src/app/pom.xml -Pnative clean package

## Stage 2: Create final image
FROM registry.access.redhat.com/ubi8/ubi-minimal
MAINTAINER Marc Nuri <marc@marcnuri.com>
LABEL MAINTAINER="Marc Nuri <marc@marcnuri.com>"

WORKDIR /
COPY --from=build /usr/src/app/target/chucknorris /deployments/

RUN chmod 775 /deployments  \
  && chown -R 1001 /deployments \
  && chmod -R "g+rwX" /deployments \
  && chown -R 1001:root /deployments

EXPOSE 8080
USER 1001

CMD ["/deployments/chucknorris", "-Dquarkus.http.host=0.0.0.0"]