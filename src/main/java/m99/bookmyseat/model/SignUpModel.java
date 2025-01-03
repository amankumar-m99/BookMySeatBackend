package m99.bookmyseat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpModel {

	private String email;
	private String password;
	private String firstName;
	private String middleName;
	private String lastName;
	private String phoneNumber;
	private String role;

}
