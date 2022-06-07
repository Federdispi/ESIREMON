package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import application.GamePanel;

public class Entrance extends Object {
	
	public Entrance(GamePanel gamePanel) {
		super(gamePanel);
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
