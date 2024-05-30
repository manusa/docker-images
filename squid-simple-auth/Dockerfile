FROM alpine:3.19

MAINTAINER Marc Nuri <marc@marcnuri.com>
LABEL MAINTAINER="Marc Nuri <marc@marcnuri.com>"

ENV SQUID_DIR=/opt/squid
ENV CACHE_DIR=$SQUID_DIR/cache
ENV CACHE_LOG_FILE=$SQUID_DIR/cache.log
ENV PASSWORD_FILE=$SQUID_DIR/passwd
ENV PID_FILE=$SQUID_DIR/squid.pid
ENV ACCESS_LOG_FILE=$SQUID_DIR/access.log

COPY init.sh /init.sh

RUN echo "Installing base packages" \
  && apk add --update --no-cache \
     apache2-utils \
     squid \
  && echo "Removing apk cache" \
  && rm -rf /var/cache/apk/

RUN echo "Configuring Squid for simple auth" \
  && echo "auth_param basic program /usr/lib/squid/basic_ncsa_auth $PASSWORD_FILE" >> /etc/squid/squid.conf \
  && echo "auth_param basic realm proxy" >> /etc/squid/squid.conf \
  && echo "acl ncsa_users proxy_auth REQUIRED" >> /etc/squid/squid.conf \
  && sed -i '/^http_access/c\#' /etc/squid/squid.conf \
  && echo "http_access allow ncsa_users" >> /etc/squid/squid.conf \
#  && echo "http_access allow localnet" >> /etc/squid/squid.conf \
  && echo "http_access deny all" >> /etc/squid/squid.conf \
  && echo "pid_filename $PID_FILE" >> /etc/squid/squid.conf \
  && echo "pid_filename $PID_FILE" >> /etc/squid/squid.conf \
  && echo "max_filedescriptors 1024" >> /etc/squid/squid.conf \
  && echo "cache_log stdio:$CACHE_LOG_FILE" >> /etc/squid/squid.conf \
  && sed -i '/^coredump_dir/c\#' /etc/squid/squid.conf \
  && echo "coredump_dir $CACHE_DIR" >> /etc/squid/squid.conf \
  && echo "access_log stdio:$ACCESS_LOG_FILE squid" >> /etc/squid/squid.conf
#  && echo "debug_options ALL,9" >> /etc/squid/squid.conf

RUN mkdir -p $SQUID_DIR \
  && mkdir -p $CACHE_DIR \
  && touch $PASSWORD_FILE \
  && touch $ACCESS_LOG_FILE \
  && chown -R 1000:1000 $SQUID_DIR

EXPOSE 3128

VOLUME $SQUID_DIR

USER 1000

CMD ["/init.sh"]
