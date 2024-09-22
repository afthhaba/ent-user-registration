package gn.ujnk.ent.web.user.registration.message;

public class PasswordChangeNotification {

	private String email;
	private String password;

	public PasswordChangeNotification(String email, String password) {
		super();

		this.email = email;
		this.password = password;
	}

	public PasswordChangeNotification() {
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserRegistrationNotification [ email=" + email + ", password=" + password + "]";
	}

	
}
