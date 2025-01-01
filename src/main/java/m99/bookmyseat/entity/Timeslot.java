package m99.bookmyseat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
	private Theater theater;

}
