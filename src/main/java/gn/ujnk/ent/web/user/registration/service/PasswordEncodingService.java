package gn.ujnk.ent.web.user.registration.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncodingService implements IPasswordEncodingService {

	/**
	 * Encode password with bcrypt
	 * @param password password value to encrypt
	 * @return encoded password
	 */
	@Override
	public String encode(String password){
		return new BCryptPasswordEncoder().encode(password);
	}
}
