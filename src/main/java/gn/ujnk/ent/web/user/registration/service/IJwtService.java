package gn.ujnk.ent.web.user.registration.service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;
import java.util.function.Function;

/**
 * Jwt token management service
 */
public interface IJwtService {
    /**
     *
     * @param token
     * @return
     */
    String extractUsername(String token);

    /**
     *
     * @param token
     * @param claimsResolver
     * @param <T>
     * @return
     */
    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);

    /**
     *
     * @param userDetails
     * @return
     */
    String generateToken(UserDetails userDetails);

    /**
     *
     * @param extraClaims
     * @param userDetails
     * @return
     */
    String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails
    );

    boolean isTokenValid(String token, UserDetails userDetails);
}
