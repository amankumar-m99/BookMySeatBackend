package m99.bookmyseat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import m99.bookmyseat.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User findByUsername(String username);

	public User findByEmail(String email);
}
