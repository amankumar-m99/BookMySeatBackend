package m99.bookmyseat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class ProfilePic extends BaseEntity {

	@OneToOne
	private User user;
	private String path;
	private String localName;
	private String originalName;
}
