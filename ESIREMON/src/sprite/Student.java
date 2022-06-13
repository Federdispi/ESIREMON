package sprite;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import application.GamePanel;
import attack.Attack;

public class Student extends Sprite {
	

	public Student(GamePanel gamePanel, String name, boolean sexe, String direction, int level) {
		super(gamePanel, name, sexe, level);
		
		this.direction = direction;
		previous_direction = "down";
		
		Attack att1 = new Attack("Souvenir du Lyc�e", 5, 20);
		Attack att2 = new Attack("R�visions de la veille", 2, 30);
		Attack att3 = new Attack("Annale de 2016", 20, 10);
		Attack att4 = new Attack("Discord avec les Bros", 10, 20);
		moveSet.add(att1);
		moveSet.add(att2);
		moveSet.add(att3);
		moveSet.add(att4);
		
		setDialogue();
		
		if(sexe) {
			try {
				up1 = ImageIO.read(getClass().getResourceAsStream("/student_girl/up1.png"));
				up2 = ImageIO.read(getClass().getResourceAsStream("/student_girl/up3.png"));
				up3 = ImageIO.read(getClass().getResourceAsStream("/student_girl/up2.png"));
				down1 = ImageIO.read(getClass().getResourceAsStream("/student_girl/down1.png"));
				down2 = ImageIO.read(getClass().getResourceAsStream("/student_girl/down3.png"));
				down3 = ImageIO.read(getClass().getResourceAsStream("/student_girl/down2.png"));
				left1 = ImageIO.read(getClass().getResourceAsStream("/student_girl/left1.png"));
				left2 = ImageIO.read(getClass().getResourceAsStream("/student_girl/left3.png"));
				left3 = ImageIO.read(getClass().getResourceAsStream("/student_girl/left2.png"));
				right1 = ImageIO.read(getClass().getResourceAsStream("/student_girl/right1.png"));
				right2 = ImageIO.read(getClass().getResourceAsStream("/student_girl/right3.png"));
				right3 = ImageIO.read(getClass().getResourceAsStream("/student_girl/right2.png"));
			} catch(IOException e) {
				e.printStackTrace();
			}		
		} else {
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
	}
	
	public void movement() {
		if(moves) {
			movementCounter++;
			
			if(movementCounter == 30) {
				direction = previous_direction.concat("_stop");
			} else if(movementCounter == 150) {			
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
		switch(name) {
		case "Mael":
			dialogues[0] = "Je viens d'installer un logiciel permettant de faire\ntourner Minecraft � 30 FPS sur Linux avec ma\nGTX 1660";
			break;
		default:
			dialogues[0] = "Je suis " + name;
		}
	}
	
	public void talk() {
		super.talk();
	}
}
