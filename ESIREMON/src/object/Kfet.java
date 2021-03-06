package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import application.GamePanel;

public class Kfet extends Object{
	/*
	 * Constructor
	 */
	public Kfet(GamePanel gamePanel) {
		super(gamePanel);
		name = "Kfet";
		width = 96;
		height = 96;
		interactable = true;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/kfet.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
