package m99.bookmyseat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import m99.bookmyseat.entity.UserPersonalDetail;
import m99.bookmyseat.service.UserPersonalDetailService;

@RestController
@CrossOrigin
@RequestMapping("user-personal-details")
public class UserPersonalDetailsController {

	@Autowired
	private UserPersonalDetailService userService;

	@GetMapping("/get/{id}")
	public ResponseEntity<UserPersonalDetail> getUserByUserId(@PathVariable String id) {
		try {
			return new ResponseEntity<>(userService.getByUserId(Long.parseLong(id)), HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/all")
	public ResponseEntity<List<UserPersonalDetail>> getAllUsers() {
		try {
			return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
		}catch (Exception e) {
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	} 
}
