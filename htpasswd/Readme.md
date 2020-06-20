`htpasswd` from Docker
==========================

Docker image to run [`htpasswd`](https://httpd.apache.org/docs/2.4/programs/htpasswd.html) from Docker.

## Usage
You can run as the program as if you were running htpasswd. To be able to store in a local file
you can use the `-b` (batch mode) or mount a local volume (`-v "$(pwd)":/output`.
```
docker run --rm marcnuri/htpasswd [<options>] [<passwordFile>] <user> <password>
```

## Examples

```
docker run --rm marcnuri/htpasswd -Bbn desiredUser desiredPassword > local-path/htpasswd
docker run --rm -v $(pwd):/output marcnuri/htpasswd /output/htpasswd desiredUser desiredPassword
```

## Docker hub

Docker image hosted at Docker Hub:
https://hub.docker.com/r/marcnuri/htpasswd/
