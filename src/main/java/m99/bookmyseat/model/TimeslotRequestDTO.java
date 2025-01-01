package m99.bookmyseat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TimeslotRequestDTO {

	private int startHH;

	private int startMM;

	private long theaterId;
}
