package sprite;

import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import application.GamePanel;
import object.Beer;
import object.Coffee;
import object.Object;
import object.Waffle;

public class KFetMan extends Sprite {
	
	public ArrayList<Object> inventory = new ArrayList<>(); //List of the products sold by the KFet
	
	public KFetMan(GamePanel gamePanel) {
		super(gamePanel, "Nicolas", false, 1);
		direction = "right_stop";
		setDialogue();
		mapX = 11 * gamePanel.TILE_SIZE + gamePanel.TILE_SIZE / 2;
		mapY = 9 * gamePanel.TILE_SIZE;
		
		//Products
		inventory.add(new Waffle(gamePanel));
		inventory.add(new Coffee(gamePanel));
		inventory.add(new Beer(gamePanel));
		
		//Sprite images
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/student_boy/up1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/student_boy/up3.png"));
			up3 = ImageIO.read(getClass().getResourceAsStream("/student_boy/up2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/student_boy/down1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/student_boy/down3.png"));
			down3 = ImageIO.read(getClass().getResourceAsStream("/student_boy/down2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/student_boy/left1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/student_boy/left3.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/student_boy/left2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/student_boy/right1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/student_boy/right3.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/student_boy/right2.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void talk() {
		super.talk();
	}
	
	/*
	 * SETTERS
	 */
	public void setDialogue() {
		dialogues[0] = "Salut, on n'a plus de gaufres au chocolat, mais il en\nreste nature. T'en veux ?";
	}
}
