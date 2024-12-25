package m99.bookmyseat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;
import m99.bookmyseat.customexception.BadCredentialsException;
import m99.bookmyseat.entity.User;
import m99.bookmyseat.model.LoginModel;
import m99.bookmyseat.model.SignUpModel;
import m99.bookmyseat.seeder.UserSeeder;
import m99.bookmyseat.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostConstruct
	public void seedUsers() {
		if(userService.getAllUsers().size() != 0) {
			System.out.println("No need to seed users");
			return;
		}
		System.out.println("Seeding users...");
		new UserSeeder().seedUsers(userService);
		System.out.println("Users seeded.");
	}

	@PostMapping("/login")
	public ResponseEntity<User> loginUser(@RequestBody LoginModel model) {
		try {
			return new ResponseEntity<>(userService.login(model), HttpStatus.OK);
		}catch (BadCredentialsException e) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PostMapping("/signup")
	public ResponseEntity<User> SignUpUser(@RequestBody SignUpModel model) {
		try {
			return new ResponseEntity<>(userService.addUser(model), HttpStatus.CREATED);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/get/{name}")
	public ResponseEntity<User> getUserByUserByUserName(@PathVariable("name") String name) {
		try {
			return new ResponseEntity<>(userService.getUserByName(name), HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers() {
		try {
			return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
		}catch (Exception e) {
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	} 
}
