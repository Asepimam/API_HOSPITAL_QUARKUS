package hospital.utils;

import hospital.models.User;
import io.smallrye.jwt.build.Jwt;

/**
 * TokenUtil
 */
public class TokenUtil {
    public static String generate(User user) {
        return Jwt.issuer("http://try/issuer")
                    .expiresIn(600L)
                    .upn(user.getUserName())
                    .groups(user.getUserType())
                    .claim("email",user.getEmail())
                    .sign();
    }

}
