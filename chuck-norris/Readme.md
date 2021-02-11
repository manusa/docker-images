Chuck Norris Quotes as a Service
================================

Simple docker image that will print a Chuck Norris quote for each request.

Besides the fun, this container image has no real world purpose. I personally use it for
talks and demos.

## Usage

```
$ docker run -d -p 8080:8080 marcnuri/chuck-norris
INFO  [io.quarkus] (main) chuck-norris 1.0-SNAPSHOT native (powered by Quarkus 1.11.1.Final) started in 0.010s. Listening on: http://0.0.0.0:8080
INFO  [io.quarkus] (main) Profile prod activated. 
INFO  [io.quarkus] (main) Installed features: [cdi, resteasy, resteasy-jackson]
$ curl localhost:8080
If Chuck Norris wants your opinion, he'll beat it into you.
```
