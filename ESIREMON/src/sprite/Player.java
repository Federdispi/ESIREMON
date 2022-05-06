package sprite;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import application.GamePanel;
import application.KeyHandler;

public class Player extends Sprite {
	GamePanel gamePanel;
	KeyHandler keyHandler;
	
	public Player(GamePanel gamePanel, KeyHandler keyHandler) {
		this.gamePanel = gamePanel;
		this.keyHandler = keyHandler;
		x = 100;
		y = 100;
		speed = 4;
		direction = "down";
	}
	
	public void getPlayerImage() {
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
				y -= speed;
			} else if(keyHandler.downPressed) {
				direction = "down";
				y += speed;
			} else if(keyHandler.leftPressed) {
				direction = "left";
				x -= speed;
			} else if(keyHandler.rightPressed) {
				direction = "right";
				x += speed;
			}
		}
	}
	
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			image = up1;
			break;
		case "down":
			image = down1;
			break;
		case "left":
			image = left1;
			break;
		case "right":
			image = right1;
			break;
		}
		g2.drawImage(image, x, y, this.gamePanel.getTileSize(), this.gamePanel.getTileSize(), null);
	}
}
