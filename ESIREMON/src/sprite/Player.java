package sprite;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import application.GamePanel;
import application.KeyHandler;
import attack.Attack;
import object.Object;

public class Player extends Sprite {
	private KeyHandler keyHandler;
	
	public final int screenX, screenY;
	public ArrayList<Object> bag = new ArrayList<>(); //List of the products in the player bag
	private Sprite spriteInteract = null; //Sprite who interacts with the player
	private BigDecimal money = new BigDecimal(5.00).setScale(1, RoundingMode.HALF_UP);
	
	/*
	 * Constructor
	 */
	public Player(GamePanel gamePanel, KeyHandler keyHandler, String name, boolean sex) {
		super(gamePanel, name, sex, 5);
		lifePoints = 100;
		hitBoxX = 8;
		hitBoxY = 16;
		this.keyHandler = keyHandler; //Keyboard inputs
		hitBox = new Rectangle(hitBoxX, hitBoxY, gamePanel.TILE_SIZE - gamePanel.TILE_SIZE / 3, gamePanel.TILE_SIZE - gamePanel.TILE_SIZE / 3);
		screenX = gamePanel.SCREEN_WIDTH / 2 - gamePanel.TILE_SIZE / 2;
		screenY = gamePanel.SCREEN_HEIGHT / 2 - gamePanel.TILE_SIZE / 2;
		mapX = gamePanel.TILE_SIZE * 3;
		mapY = gamePanel.TILE_SIZE * 1;
		direction = "down";
		previous_direction = "down";
		
		/*
		 * Attacks
		 */
		Attack att1 = new Attack("Souvenir du Lyc?e", 5, 20);
		Attack att2 = new Attack("R?visions de la veille", 2, 30);
		Attack att3 = new Attack("Annale de 2016", 20, 10);
		Attack att4 = new Attack("Discord avec les Bros", 10, 20);
		moveSet.add(att1);
		moveSet.add(att2);
		moveSet.add(att3);
		moveSet.add(att4);
	}
	
	/*
	 * Updates the player
	 */
	public void update() {
		if(keyHandler.isButtonPressed)
		{
			if(keyHandler.upPressed) {
				direction = "up";
			} else if(keyHandler.downPressed) {
				direction = "down";
			} else if(keyHandler.leftPressed) {
				direction = "left";
			} else if(keyHandler.rightPressed) {
				direction = "right";
			}
			
			collision = false;
			
			int objectIndex = gamePanel.collisionDetector.detectCollision(this);
			if(objectIndex != -1)
			{
				if(gamePanel.object[objectIndex][gamePanel.getMap()].getInteractable())
					gamePanel.object[objectIndex][gamePanel.getMap()].Interact();
			}
			
			int npcIndex = gamePanel.collisionDetector.detectSpritesCollision(this, gamePanel.npc);
			if(npcIndex != -1)
				npcInteract(npcIndex);
			
			if(!collision) {
				switch(direction) {
				case "up":
					mapY -= speed;
					break;
				case "down":
					mapY += speed;
					break;
				case "left":
					mapX -= speed;
					break;
				case "right":
					mapX += speed;
					break;
				}
			}
			
			previous_direction = direction;
			spriteCounter++;
			if(spriteCounter > 12) {
				firstSprite = !firstSprite;
				spriteCounter = 0;
			}
		} else {
			direction = previous_direction.concat("_stop");
		}
	}
	
	/*
	 * Handles interaction with the sprites
	 */
	public void npcInteract(int npcIndex) {
		if(gamePanel.keyHandler.enterPressed) {
			spriteInteract = gamePanel.npc[npcIndex][gamePanel.getMap()];
			gamePanel.setGameState(gamePanel.DIALOGUE);
			gamePanel.npc[npcIndex][gamePanel.getMap()].talk();
		}
		gamePanel.keyHandler.enterPressed = false;
	}
	
	/*
	 * Move the player wherever you want
	 */
	public void teleport(int map, int x, int y) {
		gamePanel.setMap(map);
		mapX = x * gamePanel.TILE_SIZE;
		mapY = y * gamePanel.TILE_SIZE;
	}
	
	/*
	 * Draws the player
	 */
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if(firstSprite)
				image = up1;
			else
				image = up2;
			break;
		case "down":
			if(firstSprite)
				image = down1;
			else
				image = down2;
			break;
		case "left":
			if(firstSprite)
				image = left1;
			else
				image = left2;
			break;
		case "right":
			if(firstSprite)
				image = right1;
			else
				image = right2;
			break;
		case "up_stop":
			image = up3;
			break;
		case "down_stop":
			image = down3;
			break;
		case "left_stop":
			image = left3;
			break;
		case "right_stop":
			image = right3;
			break;
		}
		
		g2.drawImage(image, screenX, screenY, this.gamePanel.TILE_SIZE, this.gamePanel.TILE_SIZE, null);
	}
	
	/*
	 * SETTERS
	 */
	private void setImage() {
		if(sex) {
			try {
				up1 = ImageIO.read(getClass().getResourceAsStream("/player_girl/up1.png"));
				up2 = ImageIO.read(getClass().getResourceAsStream("/player_girl/up3.png"));
				up3 = ImageIO.read(getClass().getResourceAsStream("/player_girl/up2.png"));
				down1 = ImageIO.read(getClass().getResourceAsStream("/player_girl/down1.png"));
				down2 = ImageIO.read(getClass().getResourceAsStream("/player_girl/down3.png"));
				down3 = ImageIO.read(getClass().getResourceAsStream("/player_girl/down2.png"));
				left1 = ImageIO.read(getClass().getResourceAsStream("/player_girl/left1.png"));
				left2 = ImageIO.read(getClass().getResourceAsStream("/player_girl/left3.png"));
				left3 = ImageIO.read(getClass().getResourceAsStream("/player_girl/left2.png"));
				right1 = ImageIO.read(getClass().getResourceAsStream("/player_girl/right1.png"));
				right2 = ImageIO.read(getClass().getResourceAsStream("/player_girl/right3.png"));
				right3 = ImageIO.read(getClass().getResourceAsStream("/player_girl/right2.png"));
			} catch(IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				up1 = ImageIO.read(getClass().getResourceAsStream("/player_boy/up1.png"));
				up2 = ImageIO.read(getClass().getResourceAsStream("/player_boy/up3.png"));
				up3 = ImageIO.read(getClass().getResourceAsStream("/player_boy/up2.png"));
				down1 = ImageIO.read(getClass().getResourceAsStream("/player_boy/down1.png"));
				down2 = ImageIO.read(getClass().getResourceAsStream("/player_boy/down3.png"));
				down3 = ImageIO.read(getClass().getResourceAsStream("/player_boy/down2.png"));
				left1 = ImageIO.read(getClass().getResourceAsStream("/player_boy/left1.png"));
				left2 = ImageIO.read(getClass().getResourceAsStream("/player_boy/left3.png"));
				left3 = ImageIO.read(getClass().getResourceAsStream("/player_boy/left2.png"));
				right1 = ImageIO.read(getClass().getResourceAsStream("/player_boy/right1.png"));
				right2 = ImageIO.read(getClass().getResourceAsStream("/player_boy/right3.png"));
				right3 = ImageIO.read(getClass().getResourceAsStream("/player_boy/right2.png"));
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setSpriteInteract(Sprite sprite) {
		this.spriteInteract = sprite;
	}
	
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	
	public void setSex(boolean sex) {
		super.setSex(sex);
		setImage();
	}
	
	/*
	 * GETTERS
	 */
	public Sprite getSpriteInteract() {
		return this.spriteInteract;
	}
	
	public BigDecimal getMoney() {
		return this.money;
	}
}
