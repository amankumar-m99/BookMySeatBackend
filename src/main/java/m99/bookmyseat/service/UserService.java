package m99.bookmyseat.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m99.bookmyseat.customexception.BadCredentialsException;
import m99.bookmyseat.customexception.user.UserNotFoundException;
import m99.bookmyseat.entity.User;
import m99.bookmyseat.entity.UserPersonalDetail;
import m99.bookmyseat.model.LoginModel;
import m99.bookmyseat.model.SignUpModel;
import m99.bookmyseat.repository.UserPersonalDetailRepository;
import m99.bookmyseat.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserPersonalDetailRepository personalDetailsRepository;

	public User login(LoginModel loginModel) {
		String username = loginModel.getUsername();
		String password = loginModel.getPassword();
		User user = getUserByName(username);
		if(!user.getPassword().equals(password)) {
			throw new BadCredentialsException("Bad credentials");
		}
		return user;
	}

	public User addUser(SignUpModel model) {
		User user = User.builder()
				.email(model.getEmail())
				.username(model.getEmail())
				.password(model.getPassword())
				.role(model.getRole())
				.createdAt(new Date())
				.build();
		user = userRepository.save(user);
		createUserPersonalDetail(model, user);
		return user;
	}

	private UserPersonalDetail createUserPersonalDetail(SignUpModel model, User user) {
		String firstName = model.getFirstName();
		String middleName = model.getMiddleName();
		String lastName = model.getLastName();
		String phoneNumber = model.getPhoneNumber();
		return personalDetailsRepository.save(new UserPersonalDetail(firstName, middleName, lastName, phoneNumber, user));
	}

	public User getUserById(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(()-> new UserNotFoundException("No user found with given id!"));
		return user;
	}

	public User getUserByName(String name) {
		User user = userRepository.findByUsername(name);
		if(user == null) {
			user = userRepository.findByEmail(name);
		}
		if(user == null) {
			throw new UserNotFoundException("No user found with given id!");
		}
		return user;
	}

	public List<User> getAllUsers() {
		List<User> users = userRepository.findAll();
		return users;
	}
}
