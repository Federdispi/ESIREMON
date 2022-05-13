package sprite;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import application.GamePanel;
import application.KeyHandler;

public class Player extends Sprite {
	private GamePanel gamePanel;
	private KeyHandler keyHandler;
	
	public final int screenX, screenY;
	
	public Player(GamePanel gamePanel, KeyHandler keyHandler) {
		this.gamePanel = gamePanel;
		this.keyHandler = keyHandler;
		hitBox = new Rectangle(8, 16, gamePanel.getTileSize() - gamePanel.getTileSize() / 3, gamePanel.getTileSize() - gamePanel.getTileSize() / 3);
		screenX = gamePanel.getScreenWidth() / 2 - gamePanel.getTileSize() / 2;
		screenY = gamePanel.getScreenHeight() / 2 - gamePanel.getTileSize() / 2;
		mapX = gamePanel.getTileSize() * 14;
		mapY = gamePanel.getTileSize() * 20;
		speed = 2;
		direction = "up";
		previous_direction = "up";
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
	}
	
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
				if(gamePanel.object[objectIndex].getInteractable())
					gamePanel.object[objectIndex].Interact();
			}
			
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
		g2.drawImage(image, screenX, screenY, this.gamePanel.getTileSize(), this.gamePanel.getTileSize(), null);
	}
}
