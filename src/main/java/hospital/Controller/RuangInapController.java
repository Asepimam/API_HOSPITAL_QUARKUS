package hospital.Controller;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import hospital.OAS.AddRuangInapOAS;
import hospital.service.RuangInapService;
import io.vertx.core.json.JsonObject;

@Path("/hospital/ruanginap")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RuangInapController {
    
    @Inject
    RuangInapService ruangInapService;

    @GET
    @PermitAll
    @RequestBody(content = @Content(mediaType = MediaType.APPLICATION_JSON))
    @APIResponse(responseCode = "200",description = "Ok",content = @Content(mediaType = MediaType.APPLICATION_JSON) )
    public Response get(){
        return ruangInapService.get();
    }

    @POST
    @PermitAll
    //@RolesAllowed({"admin","superadmin"})
    @Operation(summary = "Menanbahkan data ruanginap")
    @RequestBody(content = @Content(mediaType = MediaType.APPLICATION_JSON,schema = @Schema(implementation = AddRuangInapOAS.Request.class)))
    @APIResponses(value = {
        @APIResponse(
            responseCode = "200",
            description = "Ok",
            content = @Content(mediaType = MediaType.APPLICATION_JSON,schema = @Schema(implementation = AddRuangInapOAS.Response.class))),
        @APIResponse(
            responseCode = "400",
            description = "BAD_REQUEST",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
        ),
        @APIResponse(
            responseCode = "500",
            description = "INTERNAL_SERVER_ERROR",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
        )
    })
    public Response add(JsonObject params){
        return ruangInapService.add(params);
    }
    @PUT
    @Path("/{id}")
    @PermitAll
    //@RolesAllowed({"admin","superadmin"})
    @RequestBody(content = @Content(mediaType = MediaType.APPLICATION_JSON))
    @APIResponse(responseCode = "200",description = "ok",content = @Content(mediaType = MediaType.APPLICATION_JSON))
    public Response update(JsonObject params,@Parameter(name = "id") @PathParam("id") long id){
        return ruangInapService.update(params, id);
    }

    @DELETE
    @Path("/{id}")
    
    //@RolesAllowed({"admin","superadmin"})
    @RequestBody(content = @Content(mediaType = MediaType.APPLICATION_JSON))
    @APIResponse(responseCode = "200",description = "Ok",content = @Content(mediaType = MediaType.APPLICATION_JSON))
    public Response delete(@Parameter(name = "id") @PathParam("id") long id){
        return ruangInapService.delete(id);
    }

}
