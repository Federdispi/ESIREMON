package application;

import object.Bed;
import object.Bookshelf;
import object.Desk;
import object.Kfet;

public class AssetManager {
	GamePanel gamePanel;
	public AssetManager(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	public void setObject() {		
		gamePanel.object[0] = new Desk();
		gamePanel.object[0].setX(21 * gamePanel.getTileSize());
		gamePanel.object[0].setY(4 * gamePanel.getTileSize());
		
		gamePanel.object[1] = new Desk();
		gamePanel.object[1].setX(21 * gamePanel.getTileSize());
		gamePanel.object[1].setY(1 * gamePanel.getTileSize());
		
		gamePanel.object[2] = new Desk();
		gamePanel.object[2].setX(21 * gamePanel.getTileSize());
		gamePanel.object[2].setY(6 * gamePanel.getTileSize());
		
		gamePanel.object[3] = new Kfet();
		gamePanel.object[3].setX(11 * gamePanel.getTileSize());
		gamePanel.object[3].setY(9 * gamePanel.getTileSize());
	}
}
