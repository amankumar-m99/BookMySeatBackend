package m99.bookmyseat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import m99.bookmyseat.entity.User;
import m99.bookmyseat.entity.UserPersonalDetails;

public interface UserPersonalDetailsRepository extends JpaRepository<UserPersonalDetails, Long>{

}
