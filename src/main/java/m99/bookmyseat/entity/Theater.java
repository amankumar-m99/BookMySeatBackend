package m99.bookmyseat.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Theater extends BaseEntity {

	private String name;

	private String location;

	private String phoneNumber;

	@ManyToOne
	private User owner;

	@ManyToMany
	private List<Movie> movies;

	@OneToMany(mappedBy = "theater")
	private List<Screen> screens;

	@Temporal(TemporalType.DATE)
	private Date createdAt;

}