FROM tomcat:9.0.27

MAINTAINER Marc Nuri <marc@marcnuri.com>
LABEL MAINTAINER="Marc Nuri <marc@marcnuri.com>"

RUN rm -rf /usr/local/tomcat/webapps

ENTRYPOINT ["docker-entrypoint.sh"]

CMD ["catalina.sh", "run"]
