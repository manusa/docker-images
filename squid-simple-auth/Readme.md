Squid with Basic Authentication
===============================

Squid Docker Image based on Alpine that provides a Squid proxy server with basic authentication.

## About Squid

Squid is a caching proxy for the Web supporting HTTP, HTTPS, FTP, and more.
It reduces bandwidth and improves response times by caching and reusing frequently-requested web pages.
Squid has extensive access controls and makes a great server accelerator.


## About this Image

Pre-configured Squid proxy server with basic authentication.

### Usage

Define the following environment variables to configure the authentication credentials:

| Variable       | Description                       |
|----------------|-----------------------------------|
| SQUID_USERNAME | Username for basic authentication |
| SQUID_PASSWORD | Password for basic authentication |

The default port for the Squid proxy server is `3128`.

```shell
docker run -e SQUID_USERNAME=<username> -e SQUID_PASSWORD=<password> -p 3128:3128 marcnuri/squid-simple-auth
```

## Docker hub

Docker image hosted at Docker Hub:
https://hub.docker.com/r/marcnuri/squid-simple-auth
