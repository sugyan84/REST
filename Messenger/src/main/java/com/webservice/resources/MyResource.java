package com.webservice.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

@Component
@Path("/hello")
public class MyResource {
	
    @GET
    @Path("/world")
    public String test() {
        return "Hello world!";
    }
}
