package com.catamania;

import javax.inject.Inject;
import javax.ws.rs.*;
import com.catamania.jpa.*;
import java.util.*;

/**
 * A simple REST service using crudService
 */
@Path("/crud")
public class PersonneController {
    @Inject
    CRUDService crudService;

    @GET
    @Path("/personnes")
    @Produces({ "application/json" })
    public List<Personne> getPersonnes() {
        return crudService.getAllPersonnes();
    }

    @POST
    @Path("/personne")
    @Produces({ "application/json" })
     public int ajoute(Personne personne)
     {
      return crudService.ajoutePersonne(personne);
     }

     @PUT
     @Path("/personne")
     @Produces({ "application/json" })
     public Personne metAJour(Personne country)
     {
      return crudService.metAJourPersonne(country);
    }

    @DELETE
    @Path("/personne/{id}")
    @Produces({ "application/json" })
     public void supprime(@PathParam("id") int id)
     {
       crudService.supprimePersonne(id);
     }
}
