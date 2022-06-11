package sprite;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import application.GamePanel;

public class Sprite {
	protected String name;
	protected boolean sexe; //false man, true woman
	
	protected int mapX, mapY;
	protected int hitBoxX = 0, hitBoxY = 0;
	protected int speed = 2;
	GamePanel gamePanel;
	
	protected BufferedImage up1, up2, up3, down1, down2, down3, left1, left2, left3, right1, right2, right3;
	protected String direction, previous_direction;
	
	protected int spriteCounter = 0;
	protected boolean firstSprite;
	
	protected Rectangle hitBox = new Rectangle(hitBoxX, hitBoxY, 48, 48);
	protected boolean collision = false;
	protected boolean objectCollision = false;
	
	protected boolean moves = false;
	public int movementCounter = 0;
	
	protected int lifePoints;
	
	String dialogues[] = new String[20];
	int dialogueIndex = 0;
	
	public Sprite(GamePanel gamePanel, String name, boolean sexe) {
		this.gamePanel = gamePanel;
		this.name = name;
		this.sexe = sexe;
	}
	
	public void movement() {}
	
	public void talk() {
		if(dialogues[dialogueIndex] == null)
			dialogueIndex = 0;
		gamePanel.hud.setDialogue(dialogues[dialogueIndex]);
		gamePanel.hud.setName(name);
		dialogueIndex++;
		
		switch(gamePanel.player.direction) {
		case "up":
			if(moves)
				direction = "down";
			else
				direction = "down_stop";
			break;
		case "down":
			if(moves)
				direction = "up";
			else
				direction = "up_stop";
			break;
		case "left":
			if(moves)
				direction = "right";
			else
				direction = "right_stop";
			break;
		case "right":
			if(moves)
				direction = "left";
			else
				direction = "left_stop";
			break;
		}
	}
	
	public void update() {
		movement();
		
		collision = false;
		gamePanel.collisionDetector.detectCollision(this);
		gamePanel.collisionDetector.detectSpriteCollision(this, null);
		
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
		spriteCounter++;
		if(spriteCounter > 12) {
			firstSprite = !firstSprite;
			spriteCounter = 0;
		}
	}
	
	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;
		
		int screenX = mapX - gamePanel.player.getX() + gamePanel.player.screenX;
		int screenY = mapY - gamePanel.player.getY() + gamePanel.player.screenY;
		
		if(mapX + 2 * gamePanel.TILE_SIZE > gamePanel.player.getX() - gamePanel.player.screenX 
				&& mapX - 2 * gamePanel.TILE_SIZE < gamePanel.player.getX() + gamePanel.player.screenX 
				&& mapY + 2 * gamePanel.TILE_SIZE > gamePanel.player.getY() - gamePanel.player.screenY 
				&& mapY - 2 * gamePanel.TILE_SIZE < gamePanel.player.getY() + gamePanel.player.screenY) {
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
			
			g2.drawImage(image, screenX, screenY, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
		}
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setX(int x) {
		this.mapX = x;
	}
	
	public void setY(int y) {
		this.mapY = y;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void setCollision(boolean collision) {
		this.collision = collision;
	}
	
	public void setObjectCollision(boolean objectCollision) {
		this.objectCollision = objectCollision;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getX() {
		return this.mapX;
	}
	
	public int getY() {
		return this.mapY;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public boolean getCollision() {
		return this.collision;
	}
	
	public boolean getObjectCollision() {
		return this.objectCollision;
	}
	
	public String getDirection() {
		return this.direction;
	}
	
	public Rectangle getHitBox() {
		return this.hitBox;
	}
	
	public void setMoves(boolean moves) {
		this.moves = moves;
	}
	
	public int getHitBoxDefaultX() {
		return this.hitBoxX;
	}
	
	public int getHitBoxDefaultY() {
		return this.hitBoxY;
	}
	
	public int getLifePoints() {
		return this.lifePoints;
	}
}
