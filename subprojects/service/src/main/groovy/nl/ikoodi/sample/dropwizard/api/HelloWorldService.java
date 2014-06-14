package nl.ikoodi.sample.dropwizard.api;

import com.google.common.base.Optional;
import nl.ikoodi.sample.dropwizard.core.Saying;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;

@Path("/hello-world")

@Produces({APPLICATION_XML, APPLICATION_JSON})
//@Produces({APPLICATION_JSON})
//@Produces({APPLICATION_XML})
public interface HelloWorldService {

    @GET
    Saying sayHello(@QueryParam("name") Optional<String> name);
}