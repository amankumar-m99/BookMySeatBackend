package m99.bookmyseat.entity;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public static List<Long> getIdsFromList(List<? extends BaseEntity> entities){
		if(entities == null || entities.size() == 0) {
			return Collections.emptyList();
		}
		return entities.stream().map(e -> e.getId()).collect(Collectors.toList());
	}
}
