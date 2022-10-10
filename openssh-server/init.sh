#!/bin/sh

set -e

# Specific for OpenShift or environments where container user is random
mkdir -p ~/.ssh
chmod 770 ~/.ssh
touch ~/.ssh/authorized_keys
chmod 600 ~/.ssh/authorized_keys

echo "Current container user is: $(whoami)"

if [ -z "$PUBLIC_KEY" ]; then
  echo "PUBLIC_KEY is required"
  exit 1
fi

echo "$PUBLIC_KEY" >> ~/.ssh/authorized_keys

ssh-keygen -A

/usr/sbin/sshd.pam -D -e -p 2222

