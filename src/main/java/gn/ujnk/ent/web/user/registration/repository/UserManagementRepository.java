package gn.ujnk.ent.web.user.registration.repository;

import gn.ujnk.ent.web.user.registration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserManagementRepository extends JpaRepository<User, Long> {

	/**
	 * Retrieve user by email
	 * @param  email information of user
	 * @return user information data {@link User}
	 */
	Optional<User> findByEmail(String email);

	/**
	 * Retrieve user by email
	 * @param  email information of user
	 * @return user information data {@link User}
	 */
	Optional<User> findByUsername(String email);

}
