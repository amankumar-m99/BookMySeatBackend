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

import m99.bookmyseat.service.JoinService;

@RestController
@CrossOrigin
@RequestMapping("join")
public class JoinController {

	@Autowired
	private JoinService joinService;

	@GetMapping("/get/{id}")
	public ResponseEntity<List<Long>> getUserByUserByUserName(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(joinService.getTheaters(id), HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
