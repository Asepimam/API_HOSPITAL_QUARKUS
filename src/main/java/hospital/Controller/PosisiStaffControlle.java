package hospital.Controller;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.core.Response;
import javax.ws.rs.Path;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;


import hospital.service.PosisiStaffService;
import io.vertx.core.json.JsonObject;
@Path("hospital/posisistaff")
@Produces(MediaType.APPLICATION_JSON)
public class PosisiStaffControlle {
    @Inject
    PosisiStaffService posisiStaffService;

    @GET
    @RequestBody(content = @Content(mediaType = "application/json"))
    @APIResponse(responseCode = "200",description = "ok",content = @Content(mediaType = "application/json"))
    public Response getall(){
        JsonObject result  = new JsonObject();
        result.put("posisi staff", posisiStaffService.getall());
        return Response.ok(result).build();
    }
}
