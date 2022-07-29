package hospital.Controller;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;

import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import hospital.OAS.DaftarShifOAS;

import hospital.service.DaftarShiftService;
import io.vertx.core.json.JsonObject;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
@Path("hospital/daftarshif")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DaftarShiftController {
    @Inject
    DaftarShiftService daftarShiftService;

    @Path("/staff")
    @POST
    @PermitAll
    //@RolesAllowed({"admin","superadmin"})
    @Operation(summary = "Menanbahkan data ruanginap")
    @RequestBody(content = @Content(mediaType = MediaType.APPLICATION_JSON,schema = @Schema(implementation = DaftarShifOAS.Request.class)))
    @APIResponses(value = {
        @APIResponse(
            responseCode = "200",
            description = "Ok",
            content = @Content(mediaType = MediaType.APPLICATION_JSON,schema = @Schema(implementation = DaftarShifOAS.Response.class))),
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
    public Response addShifStaff(JsonObject params){
        return daftarShiftService.addShifStaff(params);
    }

    @Path("/perawat")
    @POST
    @PermitAll
    //@RolesAllowed({"admin","superadmin"})
    @Operation(summary = "Menanbahkan data ruanginap")
    @RequestBody(content = @Content(mediaType = MediaType.APPLICATION_JSON,schema = @Schema(implementation = DaftarShifOAS.Request.class)))
    @APIResponses(value = {
        @APIResponse(
            responseCode = "200",
            description = "Ok",
            content = @Content(mediaType = MediaType.APPLICATION_JSON,schema = @Schema(implementation = DaftarShifOAS.Response.class))),
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
    public Response addShifPerwat(JsonObject params){
        return daftarShiftService.addShifPerawat(params);
    }

    @Path("/perawat/{id}")
    @PUT
    @RequestBody(content = @Content(mediaType = MediaType.APPLICATION_JSON))
    @APIResponse(
            responseCode = "200",
            description = "Ok",
            content = @Content(mediaType = MediaType.APPLICATION_JSON,schema = @Schema(implementation = DaftarShifOAS.Response.class)))
    public Response updateshifperawat(@Parameter(name = "id") @PathParam("id") long id,JsonObject params){
        return daftarShiftService.updateShifPerawat(params, id);
    
    }
    @Path("/staff/{id}")
    @PUT
    @RequestBody(content = @Content(mediaType = MediaType.APPLICATION_JSON))
    @APIResponse(
            responseCode = "200",
            description = "Ok",
            content = @Content(mediaType = MediaType.APPLICATION_JSON,schema = @Schema(implementation = DaftarShifOAS.Response.class)))
    public Response updateshifstaff(@Parameter(name = "id") @PathParam("id") long id,JsonObject params){
        return daftarShiftService.updateShifStaff(params, id);
    }
}
