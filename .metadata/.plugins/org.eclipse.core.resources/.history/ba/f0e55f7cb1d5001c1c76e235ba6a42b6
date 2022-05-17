package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Kfet extends Object{
	public Kfet() {
		name = "Kfet";
		width = 96;
		height = 96;
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/kfet.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
