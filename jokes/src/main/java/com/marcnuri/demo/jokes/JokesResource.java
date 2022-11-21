package com.marcnuri.demo.jokes;

import org.jboss.resteasy.reactive.Cache;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public class JokesResource {


  private final JokesService jokesService;

  @Inject
  public JokesResource(JokesService jokesService) {
    this.jokesService = jokesService;
  }

  @GET
  @Produces("text/plain")
  @Cache(noCache = true, noStore = true)
  public String randomJoke() {
    return jokesService.random();
  }
}
