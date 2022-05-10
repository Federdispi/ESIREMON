package sprite;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Sprite {
	protected int mapX,mapY,speed;
	
	protected BufferedImage up1, up2, up3, down1, down2, down3, left1, left2, left3, right1, right2, right3;
	protected String direction, previous_direction;
	
	protected int spriteCounter = 0;
	protected boolean firstSprite;
	
	protected Rectangle hitBox;
	protected boolean collision = false;
	protected boolean objectCollision = false;
	
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
}
