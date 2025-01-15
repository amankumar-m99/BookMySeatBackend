package m99.bookmyseat.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import m99.bookmyseat.data.AppData;
import m99.bookmyseat.entity.ProfilePic;
import m99.bookmyseat.entity.User;
import m99.bookmyseat.repository.ProfilePicRepository;
import m99.bookmyseat.repository.UserRepository;

@Service
public class ImageService {

	@Autowired
	private ProfilePicRepository profilePicRepository;

	@Autowired
	private UserRepository userRepository;

	private InputStreamResource getFileResource(String source) {
		File imageFile = new File(source);
		if (!imageFile.exists()) {
			return null;
		}
		// Return the image as an InputStreamResource
		try {
			FileInputStream fileInputStream = new FileInputStream(imageFile);
			return new InputStreamResource(fileInputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public InputStreamResource getProfilePicImage(Long id) {
		ProfilePic profilePic = profilePicRepository.findByUserId(id);
		String dir = profilePic.getPath() + File.separator + profilePic.getLocalName();
		return getFileResource(dir);
	}

	public InputStreamResource getPersonPlaceHolderImage() {
		String dir = AppData.STATIC_DATA_MAP.get(AppData.PERSON_PLACEHOLDER_PATH);
		return getFileResource(dir);
	}

	public boolean saveProfilePic(Long id, MultipartFile multipartFile) {
		String profilePicsDirectory = AppData.STATIC_DATA_MAP.get(AppData.PERSON_PROFILE_PIC_PATH);
		File file = new File(profilePicsDirectory);
		if (!file.exists())
			file.mkdirs();
		try {
			ProfilePic profilePic = profilePicRepository.findByUserId(id);
			if (profilePic == null) {
				User user = userRepository.findById(id).orElse(null);
				if (user == null) {
					return false;
				}
				profilePic = ProfilePic.builder().user(user).build();
			}
			String targetFileName = id + "_" + multipartFile.getOriginalFilename();
			InputStream inputStream = multipartFile.getInputStream();
			byte data[] = new byte[inputStream.available()];
			inputStream.read(data);
			FileOutputStream fileOutputStream = new FileOutputStream(
					profilePicsDirectory + File.separator + targetFileName);
			fileOutputStream.write(data);
			fileOutputStream.flush();
			fileOutputStream.close();
			inputStream.close();
			profilePic.setPath(profilePicsDirectory);
			profilePic.setLocalName(targetFileName);
			profilePic.setOriginalName(multipartFile.getOriginalFilename());
			profilePicRepository.save(profilePic);
		} catch (IOException e) {
			return false;
		}
		return true;
	}

}
