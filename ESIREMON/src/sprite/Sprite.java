package sprite;

import java.awt.image.BufferedImage;

public class Sprite {
	protected int x,y,speed;
	
	protected BufferedImage up1, up2, up3, down1, down2, down3, left1, left2, left3, right1, right2, right3;
	protected String direction, previous_direction;
	
	protected int spriteCounter = 0;
	protected boolean firstSprite;
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getSpeed() {
		return this.speed;
	}
}
