package hospital.Controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;


import hospital.service.CategoryObatService;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

@Path("hospital/categoriobat")
@Produces(MediaType.APPLICATION_JSON)
public class CategoryObatController {
    @Inject
    CategoryObatService categoryObatService;

    @GET
    @RequestBody(content = @Content(mediaType = "application/json"))
    @APIResponse(responseCode = "200",description = "ok",content = @Content(mediaType = "application/json"))
    public Response getall(){
        JsonObject result  = new JsonObject();
        result.put("category obat", categoryObatService.getall());
        return Response.ok(result).build();
    }
}
