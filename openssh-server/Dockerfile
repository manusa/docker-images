FROM alpine:3.16

MAINTAINER Marc Nuri <marc@marcnuri.com>
LABEL MAINTAINER="Marc Nuri <marc@marcnuri.com>"

EXPOSE 2222

COPY init.sh /init.sh

RUN \
  echo "Installing base packages"                                                             \
  && apk add --update --no-cache                                                              \
    curl                                                                                      \
    openssh-client                                                                            \
    openssh-server-pam                                                                        \
    openssh-sftp-server                                                                       \
  && echo "Configuring OpenSSH"                                                               \
  && chmod 755 /init.sh                                                                       \
  && chmod -R 775 /etc/ssh/                                                                   \
  && chmod -R 775 /run/                                                                       \
  && sed -i 's/#PasswordAuthentication yes/PasswordAuthentication no/g' /etc/ssh/sshd_config  \
  && sed -i '/^AllowTcpForwarding/c\AllowTcpForwarding yes' /etc/ssh/sshd_config              \
  && sed -i '/^GatewayPorts/c\GatewayPorts clientspecified' /etc/ssh/sshd_config              \
  && echo "StrictModes no" >> /etc/ssh/sshd_config                                            \
  && echo "Adding base image user (1000)"                                                     \
  && adduser --disabled-password --uid 1000 "1000"                                            \
  && mkdir -p /home/1000/.ssh                                                                 \
  && chmod 770 /home/1000/.ssh                                                                \
  && touch /home/1000/.ssh/authorized_keys                                                    \
  && chmod 600 /home/1000/.ssh/authorized_keys                                                \
  && chown -R 1000:1000 /home/1000/.ssh                                                       \
  && addgroup "1000" "root"                                                                   \
  && echo "Removing apk cache"                                                                \
  && rm -rf /var/cache/apk/

USER 1000

CMD ["/init.sh"]
