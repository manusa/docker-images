package com.marcnuri.demo.chucknorris;

import org.jboss.resteasy.annotations.cache.Cache;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public class ChuckNorrisResource {

  @GET
  @Produces
  @Cache(noCache = true, noStore = true)
  public String randomQuote() {
    return Quotes.random();
  }
}
