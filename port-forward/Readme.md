Port Forwarding for Docker
==========================

Simple docker image to forward ports using socat.

## Usage

Define the following environment variables to configure port-forwarding.

Variable | Description | Optional
-------- | ----------- | --------
REMOTE_HOST | IP or address of the host you want to forward traffic to | no
REMOTE_PORT | Port on remote host to forward traffic to | yes (80)
LOCAL_PORT | Port where container listens | yes (80)

The `socat` process within the container will listen by default to port 80, use `-p`docker
flag to map the port of the local machine where it will listen to traffic to be forwarded.

```
docker run -e REMOTE_HOST=<remote_host> -e REMOTE_PORT=<remote_port> -e LOCAL_PORT=<local_port> -p <exposed_local_port>:<local_port> marcnuri/port-forward
```



## Examples

The following commands will all forward 8080 traffic to a remote machine located at www.marcnuri.com
in the http port

```
docker run -e REMOTE_HOST=www.marcnuri.com -e REMOTE_PORT=80 -e LOCAL_PORT=80 -p 8080:80 marcnuri/port-forward

docker run -e REMOTE_HOST=www.marcnuri.com -e REMOTE_PORT=80 -p 8080:80 marcnuri/port-forward

docker run -e REMOTE_HOST=www.marcnuri.com -p 8080:80 marcnuri/port-forward
```

## Docker hub

Docker image hosted at Docker Hub:
https://hub.docker.com/r/marcnuri/port-forward/
