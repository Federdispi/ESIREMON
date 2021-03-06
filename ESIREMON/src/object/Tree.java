package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import application.GamePanel;

public class Tree extends Object{
	/*
	 * Constructor
	 */
	public Tree(GamePanel gamePanel) {
		super(gamePanel);
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
