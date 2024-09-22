package gn.ujnk.ent.web.user.registration.service;

import gn.ujnk.ent.web.user.registration.repository.UserManagementRepository;
import gn.ujnk.ent.web.user.registration.model.User;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserManagementService implements IUserManagementService {

	@Autowired
	private UserManagementRepository userManagementRepository;
	
	@Override
	public void save(User user) {
		userManagementRepository.save(user);
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return userManagementRepository.findByEmail(email);
	}

	@Override
	public Optional<User> findByUsername(String username) {
		return userManagementRepository.findByUsername(username);
	}

	@Override
	public List<User> findAll() {
		List<User> user = userManagementRepository.findAll();
		System.out.println(user);
		return user;
	}


}
