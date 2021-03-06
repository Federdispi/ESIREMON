package sprite;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import application.GamePanel;
import attack.Attack;

public class Prof extends Sprite {
	/*
	 * Constructor
	 */
	public Prof(GamePanel gamePanel, String name, String direction, int level) {
		super(gamePanel, name, false, level);
		
		this.direction = direction;
		previous_direction = "down";
		
		/*
		 * Attacks
		 */
		Attack att1 = new Attack("Acknowledgement Numb", 5, 20);
		Attack att2 = new Attack("Pas de pi?ge", 2, 30);
		Attack att3 = new Attack("Control applikesh", 20, 10);
		Attack att4 = new Attack("ICMPv6", 10, 20);
		moveSet.add(att1);
		moveSet.add(att2);
		moveSet.add(att3);
		moveSet.add(att4);
		
		setDialogue();
		
		//Sprite images
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/prof/up1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/prof/up3.png"));
			up3 = ImageIO.read(getClass().getResourceAsStream("/prof/up2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/prof/down1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/prof/down3.png"));
			down3 = ImageIO.read(getClass().getResourceAsStream("/prof/down2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/prof/left1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/prof/left3.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/prof/left2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/prof/right1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/prof/right3.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/prof/right2.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Simple AI which moves the sprite randomly
	 */
	public void movement() {
		if(moves) {
			movementCounter++;
			
			if(movementCounter == 30)
				direction = previous_direction.concat("_stop");
			else if(movementCounter == 150) {
				Random random = new Random();
				int randomDirection = random.nextInt(4);
				
				switch(randomDirection) {
				case 0:
					direction = "up";
					break;
				case 1:
					direction = "down";
					break;
				case 2:
					direction = "left";
					break;
				case 3:
					direction = "right";
					break;
				}
				previous_direction = direction;
				
				movementCounter = 0;
			}
		}
	}
	
	public void talk() {
		super.talk();
	}
	
	/*
	 * SETTERS
	 */
	public void setDialogue() {
		dialogues[0] = "Y a pas de pi?ge";
		dialogues[1] = "Ah, bah l? si";
		dialogues[2] = "L? t'es tomb? dans le pi?ge";
	}
}
