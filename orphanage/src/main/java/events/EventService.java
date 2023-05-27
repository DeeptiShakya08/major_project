package events;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class EventService {
	public static void processEvent(EventBean event) {
		saveImage(event.getImageURL());
		EventsDao.addEvent(event);
	}

	public static void saveImage(MultipartFile image) {
		String folder = "src/main/resources/static/images";
		try {
			byte[] bytes = image.getBytes();
			Path path = Paths.get(folder);
			Path filePath = path.resolve(image.getOriginalFilename());
			Files.write(filePath, bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
