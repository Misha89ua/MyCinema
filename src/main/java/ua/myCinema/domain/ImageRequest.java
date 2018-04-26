package ua.myCinema.domain;

import org.springframework.web.multipart.MultipartFile;
import lombok.Data;

@Data
public class ImageRequest {
	
	private MultipartFile file;
	private int userId;

}
