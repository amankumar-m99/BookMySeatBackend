package m99.bookmyseat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShowtimeFormModel {

	private long movieId;
	private long screenId;
	private long theaterId;
	private int startHH;
	private int startMM;
}
