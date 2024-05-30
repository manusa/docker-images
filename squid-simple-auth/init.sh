#!/bin/sh

set -e

htpasswd -bc /opt/squid/passwd "${SQUID_USERNAME}" "${SQUID_PASSWORD}"
tail -f /opt/squid/access.log &
# Create missing cache directories and exit
squid -Nz
squid -f /etc/squid/squid.conf -NYC $*
