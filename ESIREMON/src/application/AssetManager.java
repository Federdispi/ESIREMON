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
		gamePanel.object[0] = new Bed();
		gamePanel.object[0].setX(0 * gamePanel.getTileSize());
		gamePanel.object[0].setY(1 * gamePanel.getTileSize());
		
//		gamePanel.object[1] = new Desk();
//		gamePanel.object[1].setX(5 * gamePanel.getTileSize());
//		gamePanel.object[1].setY(1 * gamePanel.getTileSize());
		
		gamePanel.object[2] = new Bookshelf();
		gamePanel.object[2].setX(0 * gamePanel.getTileSize());
		gamePanel.object[2].setY(-1 * gamePanel.getTileSize());
	}
}
