FROM alpine:3.6

MAINTAINER Marc Nuri <marc@marcnuri.com>
LABEL MAINTAINER "Marc Nuri" <marc@marcnuri.com>

EXPOSE 80

ENV REMOTE_HOST \
	REMOTE_PORT

RUN echo "Installing base packages" \
	&& apk add --update --no-cache \
		socat \
	&& echo "Removing apk cache" \
	&& rm -rf /var/cache/apk/

CMD socat tcp-listen:80,reuseaddr,fork tcp:$REMOTE_HOST:$REMOTE_PORT
