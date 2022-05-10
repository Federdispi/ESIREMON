package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import application.GamePanel;

public class Object {
	protected BufferedImage image;
	protected String name;
	protected boolean collision = false;
	protected int mapX, mapY;
	protected int width, height;
	protected boolean interactable = false;
	
	public void draw(Graphics2D g2, GamePanel gamePanel) {
		int screenX = mapX - gamePanel.player.getX() + gamePanel.player.screenX;
		int screenY = mapY - gamePanel.player.getY() + gamePanel.player.screenY;
		if(mapX + gamePanel.getTileSize() > gamePanel.player.getX() - gamePanel.player.screenX && mapX - gamePanel.getTileSize() < gamePanel.player.getX() + gamePanel.player.screenX && mapY + gamePanel.getTileSize() > gamePanel.player.getY() - gamePanel.player.screenY && mapY - gamePanel.getTileSize() < gamePanel.player.getY() + gamePanel.player.screenY)
			g2.drawImage(image, screenX, screenY, width, height, null);
	}
	
	public void setCollision(boolean collision) {
		this.collision = collision;
	}
	
	public void setX(int x) {
		this.mapX = x;
	}
	
	public void setY(int y) {
		this.mapY = y;
	}
	
	public boolean getCollision() {
		return this.collision;
	}
	
	public int getX() {
		return this.mapX;
	}
	
	public int getY() {
		return this.mapY;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public boolean getInteractable() {
		return this.interactable;
	}
	
	public void Interact() {
		//TODO
	}
} 
