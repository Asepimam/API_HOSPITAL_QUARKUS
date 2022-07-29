package hospital.Controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;

import hospital.OAS.AddDokterOAS;
import hospital.service.DokterService;
import io.vertx.core.json.JsonObject;

@Path("/hospital/dokter")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DokterController {
    
    @Inject
    DokterService dokterService;

    @GET
    @RequestBody(content = @Content(mediaType = MediaType.APPLICATION_JSON))
    @APIResponse(responseCode = "200",description = "Ok",content = @Content(mediaType = MediaType.APPLICATION_JSON))
    public Response get(){
        return dokterService.get();
    }
    @POST
    @Path("/filter")
    @RequestBody(content = @Content(mediaType = MediaType.APPLICATION_JSON))
    @APIResponse(responseCode = "200",description = "Ok",content = @Content(mediaType = MediaType.APPLICATION_JSON))
    public Response getfilter(@HeaderParam("maxResult") Integer maxResult,
    @QueryParam("page") Integer page,
    @QueryParam("spesialis") String spesialis,
    @QueryParam("nama") String nama,
    @QueryParam("email") String email,
    @QueryParam("phoneNumber") String phoneNumber) {
        return dokterService.getfilter(maxResult,page,spesialis,nama,email,phoneNumber);
    }

    @POST
    @Operation(summary = "Menanbahkan data dokter")
    @RequestBody(content = @Content(mediaType = MediaType.APPLICATION_JSON,schema = @Schema(implementation = AddDokterOAS.Request.class)))
    @APIResponses( value = {
        @APIResponse(responseCode = "200", description = "OK",content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = AddDokterOAS.Response.class))),
        @APIResponse(responseCode = "400", description = "BAD_REQUEST", content = @Content(mediaType = MediaType.APPLICATION_JSON)),
        @APIResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR", content = @Content(mediaType = MediaType.APPLICATION_JSON))
    })
    public Response add(JsonObject params){
        return dokterService.add(params);
    }
    
    @PUT
    @Path("/{id}")
    @RequestBody(content = @Content(mediaType = MediaType.APPLICATION_JSON))
    @APIResponse(responseCode = "200",description = "ok",content = @Content(mediaType = MediaType.APPLICATION_JSON))
    public Response update(JsonObject params, @Parameter(name = "id") @PathParam("id") Long id){
        return dokterService.update(params, id);
    }

    @DELETE
    @Path("/{id}")
    @RequestBody(content = @Content(mediaType = MediaType.APPLICATION_JSON))
    @APIResponse(responseCode = "200",description = "ok",content = @Content(mediaType = MediaType.APPLICATION_JSON))
    public Response delete(@Parameter(name = "id") @PathParam("id") Long id){
        return dokterService.delete(id);
    }


}
