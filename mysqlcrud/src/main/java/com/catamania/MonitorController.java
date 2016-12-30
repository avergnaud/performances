package com.catamania;

import javax.inject.Inject;
import javax.ws.rs.*;
import com.catamania.crud.*;
import java.util.*;

/**
 * A simple REST service for monitoring
 */
@Path("/monitor")
public class MonitorController {
    @Inject
    MonitorService monitorService;

    @GET
    @Path("/count")
    @Produces({ "application/json" })
    public int getPersonnes() {
        return monitorService.getCount();
    }
}
