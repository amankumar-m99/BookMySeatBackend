package m99.bookmyseat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import m99.bookmyseat.entity.ProfilePic;

public interface ProfilePicRepository extends JpaRepository<ProfilePic, Long>{

	ProfilePic findByUserId(Long userId);
}
