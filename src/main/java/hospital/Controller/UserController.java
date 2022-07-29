package hospital.Controller;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import hospital.service.UserService;

// import com.fasterxml.jackson.core.JsonToken;

import io.vertx.core.json.JsonObject;

@Path("hospital/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {
    @Inject
    UserService userService;

    // @Inject
    // JsonToken jwt;

    @POST
    @Path("/register")
    @RolesAllowed({"SuperAdmin","superadmin"})
    public Response register(JsonObject params){
        return userService.register(params);
    }

    @POST
    @Path("/login")
    public Response login(JsonObject params){
        return userService.Login(params);
    }
}
