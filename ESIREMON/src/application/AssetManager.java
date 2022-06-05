package application;

import object.Bed;
import object.Bookshelf;
import object.Couch;
import object.Desk;
import object.Entrance;
import object.HorizontalDesk;
import object.Kfet;
import object.Table;
import sprite.Student;

public class AssetManager {
	GamePanel gamePanel;
	public AssetManager(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	public void setNPC() {
		gamePanel.npc[0] = new Student(gamePanel);
		gamePanel.npc[0].setX(17 * gamePanel.getTileSize());
		gamePanel.npc[0].setY(10 * gamePanel.getTileSize());
		gamePanel.npc[0].setMoves(true);
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
		
		gamePanel.object[4] = new Entrance();
		gamePanel.object[4].setX(20 * gamePanel.getTileSize());
		gamePanel.object[4].setY(17 * gamePanel.getTileSize() - 20);
		
		gamePanel.object[5] = new HorizontalDesk();
		gamePanel.object[5].setX(23 * gamePanel.getTileSize());
		gamePanel.object[5].setY(2 * gamePanel.getTileSize());
		
		gamePanel.object[6] = new HorizontalDesk();
		gamePanel.object[6].setX(25 * gamePanel.getTileSize());
		gamePanel.object[6].setY(2 * gamePanel.getTileSize());
		
		gamePanel.object[7] = new HorizontalDesk();
		gamePanel.object[7].setX(23 * gamePanel.getTileSize());
		gamePanel.object[7].setY(4 * gamePanel.getTileSize());
		
		gamePanel.object[8] = new HorizontalDesk();
		gamePanel.object[8].setX(25 * gamePanel.getTileSize());
		gamePanel.object[8].setY(4 * gamePanel.getTileSize());
		
		gamePanel.object[9] = new HorizontalDesk();
		gamePanel.object[9].setX(23 * gamePanel.getTileSize());
		gamePanel.object[9].setY(7 * gamePanel.getTileSize());
		
		gamePanel.object[10] = new HorizontalDesk();
		gamePanel.object[10].setX(25 * gamePanel.getTileSize());
		gamePanel.object[10].setY(7 * gamePanel.getTileSize());
		
		gamePanel.object[11] = new Table();
		gamePanel.object[11].setX(23 * gamePanel.getTileSize());
		gamePanel.object[11].setY(10 * gamePanel.getTileSize());
		
		gamePanel.object[12] = new Couch();
		gamePanel.object[12].setX(23 * gamePanel.getTileSize());
		gamePanel.object[12].setY(9 * gamePanel.getTileSize());
		
		gamePanel.object[13] = new Couch();
		gamePanel.object[13].setX(24 * gamePanel.getTileSize());
		gamePanel.object[13].setY(9 * gamePanel.getTileSize());
		
		gamePanel.object[14] = new Couch();
		gamePanel.object[14].setX(23 * gamePanel.getTileSize());
		gamePanel.object[14].setY(12 * gamePanel.getTileSize());
		
		gamePanel.object[15] = new Couch();
		gamePanel.object[15].setX(24 * gamePanel.getTileSize());
		gamePanel.object[15].setY(12 * gamePanel.getTileSize());
		
		gamePanel.object[16] = new Couch();
		gamePanel.object[16].setX(25 * gamePanel.getTileSize());
		gamePanel.object[16].setY(10 * gamePanel.getTileSize());
		
		gamePanel.object[17] = new Couch();
		gamePanel.object[17].setX(25 * gamePanel.getTileSize());
		gamePanel.object[17].setY(11 * gamePanel.getTileSize());
		
		gamePanel.object[18] = new Entrance();
		gamePanel.object[18].setX(6 * gamePanel.getTileSize());
		gamePanel.object[18].setY(6 * gamePanel.getTileSize() - 20);
		
		gamePanel.object[19] = new Entrance();
		gamePanel.object[19].setX(8 * gamePanel.getTileSize());
		gamePanel.object[19].setY(6 * gamePanel.getTileSize() - 20);
	}
}
