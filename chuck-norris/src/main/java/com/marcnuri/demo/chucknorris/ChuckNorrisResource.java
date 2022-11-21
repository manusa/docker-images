package com.marcnuri.demo.chucknorris;

import org.jboss.resteasy.reactive.Cache;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public class ChuckNorrisResource {


  private final QuotesService quotesService;

  @Inject
  public ChuckNorrisResource(QuotesService quotesService) {
    this.quotesService = quotesService;
  }

  @GET
  @Produces("text/plain")
  @Cache(noCache = true, noStore = true)
  public String randomQuote() {
    return quotesService.random();
  }
}
