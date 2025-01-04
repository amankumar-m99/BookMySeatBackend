package m99.bookmyseat.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShowtimeFormModel {

	private long theaterId;
	private long screenId;
	private long movieId;
	private long timeslotId;
	private Date date;
}
