package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import application.GamePanel;

public class Bed extends Object {
	/*
	 * Constructor
	 */
	public Bed(GamePanel gamePanel) {
		super(gamePanel);
		name = "Bed";
		width = 48;
		height = 65;
		interactable = true;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/letto.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
