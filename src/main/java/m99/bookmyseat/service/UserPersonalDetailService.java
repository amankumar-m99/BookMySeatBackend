package m99.bookmyseat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m99.bookmyseat.customexception.user.UserNotFoundException;
import m99.bookmyseat.entity.UserPersonalDetail;
import m99.bookmyseat.repository.UserPersonalDetailRepository;

@Service
public class UserPersonalDetailService {

	@Autowired
	private UserPersonalDetailRepository personalDetailsRepository;

	public UserPersonalDetail getByUserId(Long id) {
		UserPersonalDetail userPersonalDetail = personalDetailsRepository.findByUserId(id);
		if(userPersonalDetail == null) {
				throw new UserNotFoundException("No user found with given id!");
		}
		return userPersonalDetail;
	}

	public List<UserPersonalDetail> getAllUsers() {
		return personalDetailsRepository.findAll();
	}
}
