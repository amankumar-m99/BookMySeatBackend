package m99.bookmyseat.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignUpModel {

	private String email;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	
}
