package hospital.Controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.media.Content;

import hospital.OAS.JadwalPraktekOAS;
import hospital.service.JadwalPraktekService;
import io.vertx.core.json.JsonObject;

@Path("/hospital/jadwalpraktek")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class JadwalPraktekController {
    @Inject
    JadwalPraktekService jadwalPraktekService;

    @POST
    @Operation(summary = "dokter peraktek jadwal")
    @RequestBody(content = @Content(mediaType = MediaType.APPLICATION_JSON,schema = @Schema(implementation = JadwalPraktekOAS.Request.class)))
    @APIResponses( value = {
        @APIResponse(responseCode = "200", description = "OK",content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = JadwalPraktekOAS.Response.class))),
        @APIResponse(responseCode = "400", description = "BAD_REQUEST", content = @Content(mediaType = MediaType.APPLICATION_JSON)),
        @APIResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR", content = @Content(mediaType = MediaType.APPLICATION_JSON))
    })
    public Response add(JsonObject params){
        return jadwalPraktekService.add(params);
    }
    @PUT
    @Path("/{id}")
    @RequestBody(content = @Content(mediaType = MediaType.APPLICATION_JSON,schema = @Schema(implementation = JadwalPraktekOAS.Request.class)))
    @APIResponse(responseCode = "200", description = "OK",content = @Content(mediaType = MediaType.APPLICATION_JSON))
    public Response update(JsonObject params ,@Parameter(name = "id") @PathParam("id") Long id){
        return jadwalPraktekService.update(params, id);
    }
}
