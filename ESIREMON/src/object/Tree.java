package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Tree extends Object{
	public Tree() {
		name = "Tree";
		width = 48;
		height = 96;
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/albero.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
