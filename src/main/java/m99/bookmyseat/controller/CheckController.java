package m99.bookmyseat.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckController {

	@GetMapping("/hello")
	public ResponseEntity<String> sayHello(){
		return new ResponseEntity<>("Hello! I am BookMySeat Server.", HttpStatus.OK);
	}
}
