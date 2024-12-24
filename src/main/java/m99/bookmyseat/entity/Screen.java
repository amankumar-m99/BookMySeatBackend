package m99.bookmyseat.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Screen extends BaseEntity {

	private String name;

	@OneToMany(mappedBy = "screen")
	private List<Showcase> showcases;

	@ManyToOne
	private Theater theater;

}
