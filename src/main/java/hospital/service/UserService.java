package hospital.service;

import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import hospital.models.User;
import io.vertx.core.json.JsonObject;

import hospital.utils.TokenUtil;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

@ApplicationScoped
public class UserService {
    
    @Inject
    EntityManager em;
    
    
    
    @Transactional
    public Response register(JsonObject params){
        String name = params.getString("name");
        String userName = params.getString("username");
        String password = Base64.getEncoder().encodeToString(params.getString("password").getBytes(StandardCharsets.UTF_8));
        String email = params.getString("email");
        String phoneNumber = params.getString("phone_number");
        String userType = params.getString("usertype");
        Set<String> userpermissions = new HashSet<>(params.getJsonArray("permission").getList());

        User user = new User();
        user.setName(name);
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setUserType(userType);
        user.setRoles(userpermissions);
        user.persist();
        return Response.ok().entity(user).build();
    }
    
    public Response Login(JsonObject params){
        String username = params.getString("username");
        String password = params.getString("password");
        User user = User.find("user_name=?1", username).firstResult();
        if(user == null || !user.getPassword().equalsIgnoreCase(Base64.getEncoder().encodeToString(password.getBytes(StandardCharsets.UTF_8)))){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        JsonObject result = new JsonObject();
        result.put("token",TokenUtil.generate(user));

        return Response.ok().entity(result).build();
    }

}


