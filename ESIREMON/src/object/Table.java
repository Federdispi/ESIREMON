package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import application.GamePanel;

public class Table extends Object {
	/*
	 * Constructor
	 */
	public Table(GamePanel gamePanel) {
		super(gamePanel);
		name = "Table";
		width = 64;
		height = 66;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/tavolo.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
