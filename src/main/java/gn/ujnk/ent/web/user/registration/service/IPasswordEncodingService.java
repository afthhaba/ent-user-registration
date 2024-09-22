package gn.ujnk.ent.web.user.registration.service;

/**
 * Password encoding contract service
 */
public interface IPasswordEncodingService {
    /**
     * Encode password
     * @param password giver password value
     * @return result of encoding
     */
    String encode(String password);

    /**
     * Check if two password matches
     * @param password first password
     * @param newPassword second password
     * @return reslult of matches as boolean
     */
    boolean matches(String password, String newPassword);
}
