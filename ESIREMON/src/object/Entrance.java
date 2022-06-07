package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Entrance extends Object {
	
	public Entrance() {
		name = "Entrance";
		width = 46;
		height = 20;
		interactable = true;
		collision = false;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/entrata.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}