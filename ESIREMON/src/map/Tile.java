package map;

import java.awt.image.BufferedImage;

public class Tile {
	BufferedImage image;
	private boolean collision;
	
	/*
	 * Constructor
	 */
	public Tile() {
		this.image = null;
		this.collision = false;
	}
	
	/*
	 * SETTERS
	 */
	public void setCollision(boolean collision) {
		this.collision = collision;
	}
	
	/*
	 * GETTERS
	 */
	public boolean getCollision() {
		return this.collision;
	}
}
