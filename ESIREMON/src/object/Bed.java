package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Bed extends Object {
	public Bed() {
		name = "Bed";
		width = 48;
		height = 65;
		collision = true;	
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/letto.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
