FROM ubuntu:focal

MAINTAINER Marc Nuri <marc@marcnuri.com>
LABEL MAINTAINER="Marc Nuri <marc@marcnuri.com>"

RUN cp /usr/bin/tar /usr/bin/tar-original
COPY ./tar /usr/bin/tar
RUN chmod +x /usr/bin/tar

ENTRYPOINT ["sleep", "3600"]