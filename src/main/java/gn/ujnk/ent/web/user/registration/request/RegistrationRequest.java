package gn.ujnk.ent.web.user.registration.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RegistrationRequest {
	
	@Email(message = "invalid email")
	@NotNull
	@Size(min = 6, max = 255, message="Emlail must be {min} to {max} characters long")
	private String email;

	@NotNull
	@Size(min = 12, max = 255, message="password must be {min} to {max} characters long")
	private String password;

	@NotNull
	@Size(min = 6, max = 10, message="Username must be {min} to {max} characters long")
	private String username;

	@NotNull
	@Column(name="first_name")
	@Size(min = 1, max = 10, message="First name must be {min} to {max} characters long")
	private String firstName;

	@NotNull
	@Column(name="last_name")
	@Size(min = 1, max = 10, message="Last name must be {min} to {max} characters long")
	private String lastName;

	@Size(min = 9, max = 255, message="Phone must be {min} to {max} characters long")
	private String phone;


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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "RegistrationRequest [email=" + email + ", password=" + password + "]";
	}

	
}
