package m99.bookmyseat.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class TheaterMovieJoinRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Long> findCustomQuery(Long movieId) {
		String jpql = "SELECT e.theaters_id FROM theater_movies e WHERE e.movies_id=" + movieId + ";";
		List<Long> resultList = entityManager.createNativeQuery(jpql, Long.class).getResultList();
		// Custom JPQL or native query logic
//        String jpql = "SELECT e.theaters_id FROM theater_movies e WHERE e.movies_id= :customParam";
//        List<Long> resultList = entityManager.createQuery(jpql, Long.class)
//                            .setParameter("customParam", movieId)
//                            .getResultList();
		return resultList;
	}
}
