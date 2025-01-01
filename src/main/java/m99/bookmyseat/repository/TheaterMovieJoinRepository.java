package m99.bookmyseat.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class TheaterMovieJoinRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<?> findCustomQuery(Long movieId) {
		String mySQL = "SELECT e.theaters_id FROM theater_movies e WHERE e.movies_id=" + movieId + ";";
		List<?> resultList = entityManager.createNativeQuery(mySQL, Long.class).getResultList();
//        String jpql = "SELECT e.theaters_id FROM theater_movies e WHERE e.movies_id= :customParam";
//        List<Long> resultList = entityManager.createQuery(jpql, Long.class).setParameter("customParam", movieId).getResultList();
		return resultList;
	}
}
