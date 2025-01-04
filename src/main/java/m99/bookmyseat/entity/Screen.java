package m99.bookmyseat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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

	@Column( nullable = false)
	private String name;

	private Integer maximumRows;

	private Integer maximumCols;

	@ManyToOne
	@JsonIgnore
	private Theater theater;
}
