package m99.bookmyseat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Timeslot extends BaseEntity {

	private int startHH;

	private int startMM;

	@ManyToOne
	private Theater theater;

}
