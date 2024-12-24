package m99.bookmyseat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class UserPersonalDetail  extends BaseEntity {

	private String firstName;

	private String middleName;

	private String last_name;

	private String phoneNumber;

	@OneToOne
	private User user;

}
