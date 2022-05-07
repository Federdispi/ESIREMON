package map;

import java.awt.image.BufferedImage;

public class Tile {
	BufferedImage image;
	boolean collision;
	
	public Tile() {
		this.image = null;
		this.collision = false;
	}
}
