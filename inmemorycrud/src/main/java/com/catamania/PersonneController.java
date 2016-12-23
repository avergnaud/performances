/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.catamania;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.catamania.crud.*;
import java.util.*;

/**
 * A simple REST service using crudService 
 *
 */

@Path("/")
public class PersonneController {
    @Inject
    CRUDService crudService;

    @GET
    @Path("/personnes")
    @Produces({ "application/json" })
    public List<Personne> getPersonnes() {
        return crudService.getAllCountries();
    }

    @POST
    @Path("/personne")
    @Produces({ "application/json" })
     public Personne ajoute(Personne country)
     {
      return crudService.ajoutePersonne(country);
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
       crudService.SupprimePersonne(id);
     }
}
