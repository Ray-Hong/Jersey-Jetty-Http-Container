package example.app;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

public class AppResource {
    
    @GET
    @Produces("text/plain")
    @Path("/hello")
    public Response getHello() {
        return Response.status(200).entity("Hello is called!").build();
    }
    
    @GET
    @Produces("text/plain")
    @Path("/helloworld")
    public Response getHellowWorld() {
        return Response.status(200).entity("Hello world is called!").build();
    }
}
