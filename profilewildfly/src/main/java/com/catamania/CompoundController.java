package com.catamania;

import javax.inject.Inject;
import javax.ws.rs.*;
import com.catamania.jpa.*;
import java.util.*;

/**
 * A simple REST service using crudService
 */
@Path("/compound")
public class CompoundController {

    @Inject
    CompoundService compoundService;

    @GET
    @Path("/something/{name}")
    @Produces({ "application/json" })
     public String get(@PathParam("name") String name)
     {
       return compoundService.get(name);
     }

     @GET
     @Path("/getfaster/{name}")
     @Produces({ "application/json" })
      public String getfaster(@PathParam("name") String name)
      {
        for(int i=0;i<5_000;i++) {
          //simulation de bug - appels inutiles
          String tmp = compoundService.getfaster(name);
        }
        return compoundService.getfaster(name);
      }
}
