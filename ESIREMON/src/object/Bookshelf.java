package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import application.GamePanel;

public class Bookshelf extends Object {
	public Bookshelf(GamePanel gamePanel) {
		super(gamePanel);
		name = "Bookshelf";
		width = 96;
		height = 87;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/armadio.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
