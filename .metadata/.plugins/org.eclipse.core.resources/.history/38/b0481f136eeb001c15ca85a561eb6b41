package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import application.GamePanel;

public class Desk extends Object{
	public Desk(GamePanel gamePanel) {
		super(gamePanel);
		name = "Desk";
		width = 48;
		height = 96;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/scrivania.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
