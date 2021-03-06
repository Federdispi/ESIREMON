package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;

import application.GamePanel;

public class Object {
	GamePanel gamePanel;
	protected BufferedImage image;
	protected String name;
	protected boolean collision = true;
	protected int mapX, mapY;
	protected int width, height;
	protected boolean interactable = false;
	protected String description;
	protected BigDecimal price;
	
	/*
	 * Constructor
	 */
	public Object(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	/*
	 * Draws the object
	 */
	public void draw(Graphics2D g2, GamePanel gamePanel) {
		int screenX = mapX - gamePanel.player.getX() + gamePanel.player.screenX;
		int screenY = mapY - gamePanel.player.getY() + gamePanel.player.screenY;
		if(mapX + 2 * gamePanel.TILE_SIZE > gamePanel.player.getX() - gamePanel.player.screenX 
				&& mapX - 2 * gamePanel.TILE_SIZE < gamePanel.player.getX() + gamePanel.player.screenX 
				&& mapY + 2 * gamePanel.TILE_SIZE > gamePanel.player.getY() - gamePanel.player.screenY 
				&& mapY - 2 * gamePanel.TILE_SIZE < gamePanel.player.getY() + gamePanel.player.screenY)
			g2.drawImage(image, screenX, screenY, width, height, null);
	}
	
	/*
	 * Handles interaction with the player
	 */
	public void Interact() {
		switch(name) {
		case "Entrance":
			switch(description) {
			case "Toilettes":
				gamePanel.setGameState(gamePanel.TOILETS);
				break;
			case "Route":
				gamePanel.player.teleport(1, 26, 0);
				break;
			case "ESIREM":
				gamePanel.player.teleport(2, 14, 24);
				break;
			case "Appart":
				gamePanel.player.teleport(0, 3, 3);
				break;
			case "Steinbrunn_Left":
				gamePanel.player.teleport(3, 3, 0);
				break;
			case "Steinbrunn_Right":
				gamePanel.player.teleport(3, 16, 0);
				break;
			case "Steinbrunn_LeftExit":
				gamePanel.player.teleport(2, 20, 16);
				break;
			case "Steinbrunn_RightExit":
				gamePanel.player.teleport(2, 25, 16);
				break;
			case "Exit":
				gamePanel.player.teleport(1, 2, 0);
				break;
			default:
				gamePanel.player.setSpriteInteract(null);
				gamePanel.hud.setName("M. Digrizzly");
				gamePanel.hud.setDialogue("TRAVAUX EN COURS : Il n'est pas possible\nd'acc?der ? cette zone");
				gamePanel.setGameState(gamePanel.DIALOGUE);
				break;
			}
			break;
		case "Kfet":
			gamePanel.player.npcInteract(1);
			break;
		case "Bed":
			gamePanel.setGameState(gamePanel.TOILETS);
			break;
		}
	}
	
	/*
	 * SETTERS
	 */
	public void setCollision(boolean collision) {
		this.collision = collision;
	}
	
	public void setX(int x) {
		this.mapX = x;
	}
	
	public void setY(int y) {
		this.mapY = y;
	}
	
	/*
	 * GETTERS
	 */
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
	
	public BufferedImage getImage() {
		return this.image;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getName() {
		return this.name;
	}
	
	public BigDecimal getPrice() {
		return this.price;
	}
} 
