package applications;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadingFile {
	String userPath = System.getenv("UserProfile") + "\\";
	String id;
	public ReadingFile(String string) {

		String text ="";
		Path file = Paths.get(userPath + string);
		
		try {
			text = Files.readString(file);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		id = text;
	}	
}
