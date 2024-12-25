package m99.bookmyseat.seeder;

import m99.bookmyseat.model.SignUpModel;
import m99.bookmyseat.service.UserService;

public class UserSeeder {

	public void seedUsers(UserService userService) {
		userService.addUser(new SignUpModel("amankumar.m99@gmail.com", "1234", "Aman", "", "", "9876543210", "user"));
		userService.addUser(new SignUpModel("theateradmin@gmail.com", "1234", "TheaterAdmin", "", "", "9876543210", "theateradmin"));
		userService.addUser(new SignUpModel("superadmin@gmail.com", "1234", "SuperAdmin", "", "", "9876543210", "superadmin"));
	}
}
