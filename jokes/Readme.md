Jokes as a Service
================================

Simple docker image that will return a Joke for each HTTP request.

Besides the fun, this container image has no real world purpose. I personally use it for
talks and demos.

## Usage

```
$ docker run -d -p 8080:8080 marcnuri/jokes
INFO  [io.quarkus] (main) jokes 1.0-SNAPSHOT native (powered by Quarkus 2.14.1.Final) started in 0.027s. Listening on: http://0.0.0.0:8080
INFO  [io.quarkus] (main) Profile prod activated. 
INFO  [io.quarkus] (main) Installed features: [cdi, resteasy-reactive, resteasy-reactive-jackson, smallrye-context-propagation, vertx]

$ curl localhost:8080
Bugs come in through open Windows.
```
