package hospital.service;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;
import org.jboss.logging.Logger;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;
import hospital.models.User;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;


@ApplicationScoped
public class InitialSuperAdmin {

    private static String InitialSuperAdmin;
    private static final Logger LOGGER = Logger.getLogger(InitialSuperAdmin);

    @Transactional
    void onStart(@Observes StartupEvent event){
        Set<String>userPermission = new HashSet<>();
        userPermission.add("superadmin");
        User user = new User();
        user.setName("admin");
        user.setUserName("adminsuper");
        user.setEmail("superadmin@mail.com");
        user.setPhoneNumber("087654456654");
        user.setPassword(Base64.getEncoder().encodeToString("superSaiya12".getBytes(StandardCharsets.UTF_8)));
        user.setUserType("SuperAdmin");
        user.setRoles(userPermission);
        user.persist();
        if(user.isPersistent()){
            LOGGER.info("the application start fist add "+ user.getId());
        }else{
            LOGGER.info("the application start not add "+ user.getId());
        }
    }
    void onStop(@Observes ShutdownEvent event){
        LOGGER.info("the application stop...");
    }

}
