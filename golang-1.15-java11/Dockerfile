FROM golang:1.15.15

MAINTAINER Marc Nuri <marc@marcnuri.com>
LABEL MAINTAINER="Marc Nuri <marc@marcnuri.com>"

RUN echo "Installing base packages" \
	&& apt-get update \
	&& apt-get install -y openjdk-11-jdk maven \
	&& echo "Removing cache" \
	&& apt-get clean \
	&& rm -rf /var/lib/apt/lists/*
