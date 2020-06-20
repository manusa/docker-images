FROM alpine:3.12

MAINTAINER Marc Nuri <marc@marcnuri.com>
LABEL MAINTAINER="Marc Nuri <marc@marcnuri.com>"

RUN echo "Installing base packages" \
	&& apk add --update --no-cache \
		apache2-utils \
	&& echo "Removing apk cache" \
	&& rm -rf /var/cache/apk/

ENTRYPOINT ["htpasswd"]
