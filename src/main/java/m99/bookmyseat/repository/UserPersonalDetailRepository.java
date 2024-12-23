package m99.bookmyseat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import m99.bookmyseat.entity.User;
import m99.bookmyseat.entity.UserPersonalDetail;

public interface UserPersonalDetailRepository extends JpaRepository<UserPersonalDetail, Long>{

	public UserPersonalDetail findByUser(User user);

	public UserPersonalDetail findByUserId(Long userId);
}
