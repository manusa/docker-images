FROM alpine:3.6

MAINTAINER Marc Nuri <marc@marcnuri.com>
LABEL MAINTAINER "Marc Nuri" <marc@marcnuri.com>

ARG DEF_REMOTE_PORT=80
ARG DEF_LOCAL_PORT=80

ENV REMOTE_PORT=$DEF_REMOTE_PORT
ENV LOCAL_PORT=$DEF_LOCAL_PORT

## By default container listens on $LOCAL_PORT (80)
EXPOSE 80

RUN echo "Installing base packages" \
	&& apk add --update --no-cache \
		socat \
	&& echo "Removing apk cache" \
	&& rm -rf /var/cache/apk/

CMD socat tcp-listen:$LOCAL_PORT,reuseaddr,fork tcp:$REMOTE_HOST:$REMOTE_PORT & pid=$! && trap "kill $pid" SIGINT && \
	echo "Socat started listening on $LOCAL_PORT: Redirecting traffic to $REMOTE_HOST:$REMOTE_PORT ($pid)" && wait $pid
