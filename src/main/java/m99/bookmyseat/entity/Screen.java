package m99.bookmyseat.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import m99.bookmyseat.serializer.TheaterBackReferenceSerializer;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Screen extends BaseEntity {

	private String name;

	@ManyToOne
//	@JsonBackReference
//	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JsonSerialize(using = TheaterBackReferenceSerializer.class)
	private Theater theater;
}
