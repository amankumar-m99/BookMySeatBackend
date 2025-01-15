package m99.bookmyseat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import m99.bookmyseat.service.ImageService;

@RestController
@CrossOrigin
@RequestMapping("image")
public class ImageController {

	@Autowired
	private ImageService imageService;

	@GetMapping("/profile-pic/{id}")
	public ResponseEntity<InputStreamResource> getProfilePicImage(@PathVariable Long id) {
		InputStreamResource image = imageService.getProfilePicImage(id);
		if (image == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE)
				// or IMAGE_PNG_VALUE, etc., based on the image type
				.body(image);
	}

	@PostMapping("/profile-pic/{id}")
	public ResponseEntity<Boolean> saveUserProfilePic(HttpServletRequest request, @RequestParam("profile-pic") MultipartFile multipartFile, @PathVariable Long id) {
		ResponseEntity<Boolean> response;
//		String type = multipartFile.getContentType().toLowerCase();
		String type = multipartFile.getOriginalFilename().toLowerCase();
		if(!(type.endsWith("jpeg") || type.endsWith("jpg") || type.endsWith("png"))) {
			response = new ResponseEntity<>(false, HttpStatus.CONFLICT);
			return response;
		}
		boolean result = imageService.saveProfilePic(id, multipartFile);
		response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}

}
