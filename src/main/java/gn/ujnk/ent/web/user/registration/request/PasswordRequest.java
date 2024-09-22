package gn.ujnk.ent.web.user.registration.request;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PasswordRequest {
	@NotNull
	@Size(min = 12, max = 255, message="old password must be {min} to {max} characters long")
	private String oldPassword;

	@NotNull
	@Size(min = 12, max = 255, message="new password must be {min} to {max} characters long")
	private String newPassword;

	@NotNull
	@Size(min = 6, max = 10, message="Username must be {min} to {max} characters long")
	private String username;

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
