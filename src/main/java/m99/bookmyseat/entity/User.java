package m99.bookmyseat.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
public class User extends BaseEntity {

	@Column(unique = true, nullable = false)
	private String email;

	@Column(unique = true, nullable = false)
	private String username;

	private String password;

	private String role;

	@Temporal(TemporalType.DATE)
	private Date createdAt;

}
