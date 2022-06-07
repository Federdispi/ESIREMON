package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Couch extends Object {
	
	public Couch() {
		name = "Couch";
		width = 32;
		height = 32;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/divano.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}