package application;

import object.Bed;
import object.Bookshelf;
import object.Desk;

public class AssetManager {
	GamePanel gamePanel;
	public AssetManager(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	public void setObject() {		
		gamePanel.object[0] = new Desk();
		gamePanel.object[0].setX(21 * gamePanel.getTileSize());
		gamePanel.object[0].setY(3 * gamePanel.getTileSize());
		
		gamePanel.object[1] = new Desk();
		gamePanel.object[1].setX(21 * gamePanel.getTileSize());
		gamePanel.object[1].setY(0 * gamePanel.getTileSize());
	}
}
