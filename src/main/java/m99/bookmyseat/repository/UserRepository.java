package m99.bookmyseat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import m99.bookmyseat.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);

	User findByEmail(String email);

	@Query("SELECT count(*) from User u where u.role = 'user'")
	Long getUserCount();

	@Query("SELECT count(*) from User u where u.role = 'theateradmin'")
	Long getTheaterAdminCount();

	@Query("SELECT count(*) from User u where u.role = 'superadmin'")
	Long getSuperAdminCount();
}
