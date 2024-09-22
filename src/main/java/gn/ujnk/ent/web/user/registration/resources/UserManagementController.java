package gn.ujnk.ent.web.user.registration.resources;

import gn.ujnk.ent.web.user.registration.config.UserRegistrationConfig;
import gn.ujnk.ent.web.user.registration.exception.CustomResponse;
import gn.ujnk.ent.web.user.registration.message.UserRegistrationNotification;
import gn.ujnk.ent.web.user.registration.model.User;
import gn.ujnk.ent.web.user.registration.request.RegistrationRequest;
import gn.ujnk.ent.web.user.registration.service.IPasswordEncodingService;
import gn.ujnk.ent.web.user.registration.service.IUserManagementService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserManagementController {

	@Autowired
	private IUserManagementService userService;

	@Autowired
	private IPasswordEncodingService passwordEncodingService;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private UserRegistrationConfig userRegistrationConfig;

	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userService.findAll();
	}

	@CrossOrigin
	@PostMapping("/user")
	public ResponseEntity<CustomResponse> registerUser(@Validated @RequestBody RegistrationRequest request) {
		System.out.println(request);
		User registeredUser = getUser(request);

		userService.save(registeredUser);
		rabbitTemplate.convertAndSend(userRegistrationConfig.getExchangeName(), userRegistrationConfig.getRoutingKey(),
				new UserRegistrationNotification(registeredUser.getId().toString(), registeredUser.getEmail(),
						registeredUser.getPassword()));

		CustomResponse success = new CustomResponse();
		success.setTimestamp(LocalDateTime.now());
		success.setMessage("Thanks for signing up. An email has been sent to " + request.getEmail());
		success.setStatus(HttpStatus.CREATED.value());

		return new ResponseEntity<>(success, HttpStatus.CREATED);
	}

	/**
	 * Get user data from request
	 * @param request request from rest call
	 * @return user information {@link User}
	 */
	private User getUser(RegistrationRequest request) {
		User registeredUser = new User(request.getEmail(), passwordEncodingService.encode(request.getPassword()));
		registeredUser.setUsername(request.getUsername());
		registeredUser.setFirstName(request.getFirstName());
		registeredUser.setLastName(request.getLastName());
		registeredUser.setPhone(request.getPhone());
		return registeredUser;
	}

	@ResponseStatus(value = HttpStatus.CONFLICT, reason = "duplicate email address")
	public void duplicateEmailAddress() {
	}

	@ExceptionHandler(value = { MethodArgumentNotValidException.class })
	public ResponseEntity<CustomResponse> invalidInput(MethodArgumentNotValidException e) {

		StringBuffer buffer = new StringBuffer();
		for (ObjectError err : e.getBindingResult().getAllErrors()) {
			buffer.append(err.getDefaultMessage() + " , ");
		}

		CustomResponse errors = new CustomResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setMessage(buffer.substring(0, buffer.length() - 2).toString());
		errors.setStatus(HttpStatus.PRECONDITION_FAILED.value());

		return new ResponseEntity<>(errors, HttpStatus.PRECONDITION_FAILED);
	}

}
