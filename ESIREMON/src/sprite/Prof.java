package sprite;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import application.GamePanel;

public class Prof extends Sprite {
	
	public Prof(GamePanel gamePanel, String name, boolean sexe, String direction) {
		super(gamePanel, name, sexe);
		
		this.direction = direction;
		previous_direction = "down";
		
		setDialogue();
		
		if(sexe) {
			try {
				up1 = ImageIO.read(getClass().getResourceAsStream("/player/up1.png"));
				up2 = ImageIO.read(getClass().getResourceAsStream("/player/up3.png"));
				up3 = ImageIO.read(getClass().getResourceAsStream("/player/up2.png"));
				down1 = ImageIO.read(getClass().getResourceAsStream("/player/down1.png"));
				down2 = ImageIO.read(getClass().getResourceAsStream("/player/down3.png"));
				down3 = ImageIO.read(getClass().getResourceAsStream("/player/down2.png"));
				left1 = ImageIO.read(getClass().getResourceAsStream("/player/left1.png"));
				left2 = ImageIO.read(getClass().getResourceAsStream("/player/left3.png"));
				left3 = ImageIO.read(getClass().getResourceAsStream("/player/left2.png"));
				right1 = ImageIO.read(getClass().getResourceAsStream("/player/right1.png"));
				right2 = ImageIO.read(getClass().getResourceAsStream("/player/right3.png"));
				right3 = ImageIO.read(getClass().getResourceAsStream("/player/right2.png"));
			} catch(IOException e) {
				e.printStackTrace();
			}		
		} else {
			//TODO
		}
	}
	
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
	
	public void setDialogue() {
		dialogues[0] = "Y a pas de pi�ge";
		dialogues[1] = "Wallah y a pas de pi�ge";
		dialogues[2] = "Ah, bah l� si";
		dialogues[3] = "L� t'es tomb� dans le pi�ge";
	}
	
	public void talk() {
		super.talk();
	}

}