package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Bookshelf extends Object {
	public Bookshelf() {
		name = "Bookshelf";
		width = 96;
		height = 87;
		collision = true;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/armadio.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
