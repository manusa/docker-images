FROM golang:1.20.5

MAINTAINER Marc Nuri <marc@marcnuri.com>
LABEL MAINTAINER="Marc Nuri <marc@marcnuri.com>"

RUN echo "Installing base packages" \
	&& apt-get update \
	&& apt-get install -y openjdk-17-jdk maven \
	&& echo "Removing cache" \
	&& apt-get clean \
	&& rm -rf /var/lib/apt/lists/*
