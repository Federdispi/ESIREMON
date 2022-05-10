package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Desk extends Object{
	public Desk() {
		name = "Desk";
		width = 48;
		height = 96;
		collision = true;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/scrivania.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
