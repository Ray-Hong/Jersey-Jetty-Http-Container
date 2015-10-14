package example.app;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/hello")
public class AppResource {
    
    @GET
    @Produces("text/plain")
    public Response getHello() {
        return Response.status(200).entity("Hello is called!").build();
    }
}
