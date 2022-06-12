package application;

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
		gamePanel.npc[0] = new Student(gamePanel, "Lucas", true, "down_stop");
		gamePanel.npc[0].setX(17 * gamePanel.TILE_SIZE);
		gamePanel.npc[0].setY(10 * gamePanel.TILE_SIZE);
		gamePanel.npc[0].setMoves(true);
		gamePanel.npc[0].setBattle(true);
		
		gamePanel.npc[2] = new Student(gamePanel, "Mael", true, "up_stop");
		gamePanel.npc[2].setX(23 * gamePanel.TILE_SIZE);
		gamePanel.npc[2].setY(5 * gamePanel.TILE_SIZE - gamePanel.TILE_SIZE / 2);
		
		gamePanel.npc[3] = new Student(gamePanel, "Benjamin", true, "down_stop");
		gamePanel.npc[3].setX(23 * gamePanel.TILE_SIZE - 10);
		gamePanel.npc[3].setY(9 * gamePanel.TILE_SIZE - 20);
		
		gamePanel.npc[4] = new Student(gamePanel, "Insigam", true, "down_stop");
		gamePanel.npc[4].setX(2 * gamePanel.TILE_SIZE);
		gamePanel.npc[4].setY(15 * gamePanel.TILE_SIZE);
		gamePanel.npc[4].setMoves(true);
	}
	
	public void setObject() {		
		gamePanel.object[0] = new Desk(gamePanel);
		gamePanel.object[0].setX(21 * gamePanel.TILE_SIZE);
		gamePanel.object[0].setY(4 * gamePanel.TILE_SIZE);
		
		gamePanel.object[1] = new Desk(gamePanel);
		gamePanel.object[1].setX(21 * gamePanel.TILE_SIZE);
		gamePanel.object[1].setY(1 * gamePanel.TILE_SIZE);
		
		gamePanel.object[2] = new Desk(gamePanel);
		gamePanel.object[2].setX(21 * gamePanel.TILE_SIZE);
		gamePanel.object[2].setY(6 * gamePanel.TILE_SIZE);
		
		gamePanel.object[3] = new Kfet(gamePanel);
		gamePanel.object[3].setX(11 * gamePanel.TILE_SIZE);
		gamePanel.object[3].setY(9 * gamePanel.TILE_SIZE);
		
		gamePanel.object[4] = new Entrance(gamePanel);
		gamePanel.object[4].setX(20 * gamePanel.TILE_SIZE);
		gamePanel.object[4].setY(17 * gamePanel.TILE_SIZE - 20);
		
		gamePanel.object[5] = new HorizontalDesk(gamePanel);
		gamePanel.object[5].setX(23 * gamePanel.TILE_SIZE);
		gamePanel.object[5].setY(2 * gamePanel.TILE_SIZE);
		
		gamePanel.object[6] = new HorizontalDesk(gamePanel);
		gamePanel.object[6].setX(25 * gamePanel.TILE_SIZE);
		gamePanel.object[6].setY(2 * gamePanel.TILE_SIZE);
		
		gamePanel.object[7] = new HorizontalDesk(gamePanel);
		gamePanel.object[7].setX(23 * gamePanel.TILE_SIZE);
		gamePanel.object[7].setY(4 * gamePanel.TILE_SIZE);
		
		gamePanel.object[8] = new HorizontalDesk(gamePanel);
		gamePanel.object[8].setX(25 * gamePanel.TILE_SIZE);
		gamePanel.object[8].setY(4 * gamePanel.TILE_SIZE);
		
		gamePanel.object[9] = new HorizontalDesk(gamePanel);
		gamePanel.object[9].setX(23 * gamePanel.TILE_SIZE);
		gamePanel.object[9].setY(7 * gamePanel.TILE_SIZE);
		
		gamePanel.object[10] = new HorizontalDesk(gamePanel);
		gamePanel.object[10].setX(25 * gamePanel.TILE_SIZE);
		gamePanel.object[10].setY(7 * gamePanel.TILE_SIZE);
		
		gamePanel.object[11] = new Table(gamePanel);
		gamePanel.object[11].setX(23 * gamePanel.TILE_SIZE);
		gamePanel.object[11].setY(10 * gamePanel.TILE_SIZE);
		
		gamePanel.object[12] = new Couch(gamePanel);
		gamePanel.object[12].setX(23 * gamePanel.TILE_SIZE);
		gamePanel.object[12].setY(9 * gamePanel.TILE_SIZE);
		
		gamePanel.object[13] = new Couch(gamePanel);
		gamePanel.object[13].setX(24 * gamePanel.TILE_SIZE);
		gamePanel.object[13].setY(9 * gamePanel.TILE_SIZE);
		
		gamePanel.object[14] = new Couch(gamePanel);
		gamePanel.object[14].setX(23 * gamePanel.TILE_SIZE);
		gamePanel.object[14].setY(12 * gamePanel.TILE_SIZE);
		
		gamePanel.object[15] = new Couch(gamePanel);
		gamePanel.object[15].setX(24 * gamePanel.TILE_SIZE);
		gamePanel.object[15].setY(12 * gamePanel.TILE_SIZE);
		
		gamePanel.object[16] = new Couch(gamePanel);
		gamePanel.object[16].setX(25 * gamePanel.TILE_SIZE);
		gamePanel.object[16].setY(10 * gamePanel.TILE_SIZE);
		
		gamePanel.object[17] = new Couch(gamePanel);
		gamePanel.object[17].setX(25 * gamePanel.TILE_SIZE);
		gamePanel.object[17].setY(11 * gamePanel.TILE_SIZE);
		
		gamePanel.object[18] = new Entrance(gamePanel);
		gamePanel.object[18].setX(6 * gamePanel.TILE_SIZE);
		gamePanel.object[18].setY(6 * gamePanel.TILE_SIZE - 20);
		
		gamePanel.object[19] = new Entrance(gamePanel);
		gamePanel.object[19].setX(8 * gamePanel.TILE_SIZE);
		gamePanel.object[19].setY(6 * gamePanel.TILE_SIZE - 20);
		
		gamePanel.object[20] = new Entrance(gamePanel);
		gamePanel.object[20].setX(8 * gamePanel.TILE_SIZE);
		gamePanel.object[20].setY(15 * gamePanel.TILE_SIZE);
		
		gamePanel.object[21] = new Entrance(gamePanel);
		gamePanel.object[21].setX(18 * gamePanel.TILE_SIZE);
		gamePanel.object[21].setY(gamePanel.TILE_SIZE);
	}
}
