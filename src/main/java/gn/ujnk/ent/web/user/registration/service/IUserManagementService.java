package gn.ujnk.ent.web.user.registration.service;

import gn.ujnk.ent.web.user.registration.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

/**
 * User manamgement service
 */
public interface IUserManagementService {

    /**
     * Save user
     *
     * @param user user information {@link User}
     */
    void save(User user);

    /**
     * Update password
     * @param username login of user
     * @param oldPassword old password
     * @param  newPassword
     * @return user information {@link User}
     */
    User updatePassword(String username, String oldPassword, String newPassword) ;

    /**
     * Retriever user by email
     *
     * @param email
     * @return user information data {@link User}
     */
    Optional<User> findByEmail(String email);

    /**
     * Retriever user by username
     *
     * @param username login of user
     * @return user information data {@link User}
     */
    Optional<User> findByUsername(String username);

    /**
     * Get list of all users
     *
     * @return collection of {@link User}
     */
    List<User> findAll();

}
