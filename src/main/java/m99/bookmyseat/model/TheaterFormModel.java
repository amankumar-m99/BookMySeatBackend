package m99.bookmyseat.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TheaterFormModel {

	private Long ownerId;

	private String name;

	private String location;

	private String phoneNumber;

	private List<Integer> screensCapacities;

}
