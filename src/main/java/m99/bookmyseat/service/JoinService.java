package m99.bookmyseat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m99.bookmyseat.repository.TheaterMovieJoinRepository;

@Service
public class JoinService {

	@Autowired
	private TheaterMovieJoinRepository joinRepository;

	public List<Long> getTheaters(Long id){
		
		List<Long> findCustomQuery = (List<Long>) joinRepository.findCustomQuery(id);
		return findCustomQuery;
	}
}
