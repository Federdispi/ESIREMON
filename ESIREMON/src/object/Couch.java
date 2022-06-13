package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import application.GamePanel;

public class Couch extends Object {
	/*
	 * Constructor
	 */
	public Couch(GamePanel gamePanel) {
		super(gamePanel);
		name = "Couch";
		width = 32;
		height = 32;
		collision = false;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/divano.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
