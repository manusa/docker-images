#!/bin/sh

set -e

htpasswd -bc /opt/squid/passwd "${SQUID_USERNAME}" "${SQUID_PASSWORD}"
tail -F /opt/squid/access.log /dev/null &
tail -F /opt/squid/cache.log /dev/null &
# Create missing cache directories and exit
squid -Nz
squid -f /etc/squid/squid.conf -NYC $*
