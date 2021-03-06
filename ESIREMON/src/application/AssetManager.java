package application;

import object.Bed;
import object.Bookshelf;
import object.Couch;
import object.Desk;
import object.Entrance;
import object.HorizontalDesk;
import object.Kfet;
import object.Table;
import object.Tree;
import sprite.Prof;
import sprite.Student;

public class AssetManager {
	GamePanel gamePanel;
	
	/*
	 * Constructor
	 */
	public AssetManager(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	/*
	 * Creates the non playable characters and places them in the maps
	 */
	public void setNPC() {
		/*
		 * Map 1 : Route
		 */
		gamePanel.npc[0][1] = new Student(gamePanel, "Justin", false, "left_stop", 3);
		gamePanel.npc[0][1].setX(26 * gamePanel.TILE_SIZE);
		gamePanel.npc[0][1].setY(10 * gamePanel.TILE_SIZE);
		gamePanel.npc[0][1].setMoves(true);
		
		gamePanel.npc[1][1] = new Student(gamePanel, "Pierre", false, "right_stop", 3);
		gamePanel.npc[1][1].setX(20 * gamePanel.TILE_SIZE);
		gamePanel.npc[1][1].setY(5 * gamePanel.TILE_SIZE);
		gamePanel.npc[1][1].setMoves(true);
		
		gamePanel.npc[2][1] = new Student(gamePanel, "Laurine", true, "up_stop", 5);
		gamePanel.npc[2][1].setX(8 * gamePanel.TILE_SIZE);
		gamePanel.npc[2][1].setY(4 * gamePanel.TILE_SIZE);
		
		gamePanel.npc[3][1] = new Student(gamePanel, "Tom", false, "up_stop", 5);
		gamePanel.npc[3][1].setX(9 * gamePanel.TILE_SIZE);
		gamePanel.npc[3][1].setY(4 * gamePanel.TILE_SIZE);
		gamePanel.npc[3][1].setBattle(false);
		
		gamePanel.npc[4][1] = new Student(gamePanel, "Aya", false, "up_stop", 5);
		gamePanel.npc[4][1].setX(2 * gamePanel.TILE_SIZE);
		gamePanel.npc[4][1].setY(10 * gamePanel.TILE_SIZE);
		gamePanel.npc[4][1].setMoves(true);
		gamePanel.npc[4][1].setBattle(false);
		/*
		 * Map 2 : ESIREM
		 */
		gamePanel.npc[0][2] = new Student(gamePanel, "Lucas", false, "down_stop", 10);
		gamePanel.npc[0][2].setX(17 * gamePanel.TILE_SIZE);
		gamePanel.npc[0][2].setY(10 * gamePanel.TILE_SIZE);
		gamePanel.npc[0][2].setMoves(true);
		
		gamePanel.npc[2][2] = new Student(gamePanel, "Mael", false, "up_stop", 20);
		gamePanel.npc[2][2].setX(23 * gamePanel.TILE_SIZE);
		gamePanel.npc[2][2].setY(5 * gamePanel.TILE_SIZE - gamePanel.TILE_SIZE / 2);
		
		gamePanel.npc[3][2] = new Student(gamePanel, "Benjamin", false, "down_stop", 14);
		gamePanel.npc[3][2].setX(23 * gamePanel.TILE_SIZE - 10);
		gamePanel.npc[3][2].setY(9 * gamePanel.TILE_SIZE - 20);
		
		gamePanel.npc[4][2] = new Student(gamePanel, "Insigam", true, "down_stop", 12);
		gamePanel.npc[4][2].setX(2 * gamePanel.TILE_SIZE);
		gamePanel.npc[4][2].setY(15 * gamePanel.TILE_SIZE);
		gamePanel.npc[4][2].setMoves(true);
		/*
		 * Map 3 : Steinbrunn
		 */		
		gamePanel.npc[0][3] = new Prof(gamePanel, "Nader", "up_stop", 25);
		gamePanel.npc[0][3].setX(9 * gamePanel.TILE_SIZE + gamePanel.TILE_SIZE / 2);
		gamePanel.npc[0][3].setY(17 * gamePanel.TILE_SIZE);
	}
	
	/*
	 * Creates the objects and places them in the maps
	 */
	public void setObject() {	
		/*
		 * Map 0 : Appart
		 */
		gamePanel.object[0][0] = new Entrance(gamePanel, "Route");
		gamePanel.object[0][0].setX(3 * gamePanel.TILE_SIZE);
		gamePanel.object[0][0].setY(4 * gamePanel.TILE_SIZE - 20);
		
		gamePanel.object[1][0] = new Bed(gamePanel);
		gamePanel.object[1][0].setX(0);
		gamePanel.object[1][0].setY(2 * gamePanel.TILE_SIZE);
		
		gamePanel.object[2][0] = new Bookshelf(gamePanel);
		gamePanel.object[2][0].setX(0);
		gamePanel.object[2][0].setY(0);
		
		gamePanel.object[3][0] = new Table(gamePanel);
		gamePanel.object[3][0].setX(5 * gamePanel.TILE_SIZE);
		gamePanel.object[3][0].setY(gamePanel.TILE_SIZE);
		/*
		 * Map 1 : Route
		 */
		gamePanel.object[0][1] = new Entrance(gamePanel, "Appart");
		gamePanel.object[0][1].setX(26 * gamePanel.TILE_SIZE);
		gamePanel.object[0][1].setY(gamePanel.TILE_SIZE - 20);
		
		gamePanel.object[1][1] = new Entrance(gamePanel, "ESIREM");
		gamePanel.object[1][1].setX(2 * gamePanel.TILE_SIZE);
		gamePanel.object[1][1].setY(gamePanel.TILE_SIZE - 20);
		
		gamePanel.object[2][1] = new Tree(gamePanel);
		gamePanel.object[2][1].setX(28 * gamePanel.TILE_SIZE);
		gamePanel.object[2][1].setY(5 * gamePanel.TILE_SIZE);
		
		gamePanel.object[3][1] = new Tree(gamePanel);
		gamePanel.object[3][1].setX(24 * gamePanel.TILE_SIZE);
		gamePanel.object[3][1].setY(4 * gamePanel.TILE_SIZE);
		
		gamePanel.object[4][1] = new Tree(gamePanel);
		gamePanel.object[4][1].setX(20 * gamePanel.TILE_SIZE);
		gamePanel.object[4][1].setY(10 * gamePanel.TILE_SIZE);
		
		gamePanel.object[5][1] = new Tree(gamePanel);
		gamePanel.object[5][1].setX(16 * gamePanel.TILE_SIZE);
		gamePanel.object[5][1].setY(2 * gamePanel.TILE_SIZE);

		gamePanel.object[6][1] = new Tree(gamePanel);
		gamePanel.object[6][1].setX(8 * gamePanel.TILE_SIZE);
		gamePanel.object[6][1].setY(8 * gamePanel.TILE_SIZE);
		
		gamePanel.object[7][1] = new Tree(gamePanel);
		gamePanel.object[7][1].setX(12 * gamePanel.TILE_SIZE);
		gamePanel.object[7][1].setY(3 * gamePanel.TILE_SIZE);
		/*
		 * Map 2 : ESIREM
		 */
		gamePanel.object[0][2] = new Desk(gamePanel);
		gamePanel.object[0][2].setX(21 * gamePanel.TILE_SIZE);
		gamePanel.object[0][2].setY(4 * gamePanel.TILE_SIZE);
		
		gamePanel.object[1][2] = new Desk(gamePanel);
		gamePanel.object[1][2].setX(21 * gamePanel.TILE_SIZE);
		gamePanel.object[1][2].setY(1 * gamePanel.TILE_SIZE);
		
		gamePanel.object[2][2] = new Desk(gamePanel);
		gamePanel.object[2][2].setX(21 * gamePanel.TILE_SIZE);
		gamePanel.object[2][2].setY(6 * gamePanel.TILE_SIZE);
		
		gamePanel.object[3][2] = new Kfet(gamePanel);
		gamePanel.object[3][2].setX(11 * gamePanel.TILE_SIZE);
		gamePanel.object[3][2].setY(9 * gamePanel.TILE_SIZE);
		
		gamePanel.object[4][2] = new Entrance(gamePanel, "Steinbrunn_Left");
		gamePanel.object[4][2].setX(20 * gamePanel.TILE_SIZE);
		gamePanel.object[4][2].setY(17 * gamePanel.TILE_SIZE - 20);
		
		gamePanel.object[5][2] = new HorizontalDesk(gamePanel);
		gamePanel.object[5][2].setX(23 * gamePanel.TILE_SIZE);
		gamePanel.object[5][2].setY(2 * gamePanel.TILE_SIZE);
		
		gamePanel.object[6][2] = new HorizontalDesk(gamePanel);
		gamePanel.object[6][2].setX(25 * gamePanel.TILE_SIZE);
		gamePanel.object[6][2].setY(2 * gamePanel.TILE_SIZE);
		
		gamePanel.object[7][2] = new HorizontalDesk(gamePanel);
		gamePanel.object[7][2].setX(23 * gamePanel.TILE_SIZE);
		gamePanel.object[7][2].setY(4 * gamePanel.TILE_SIZE);
		
		gamePanel.object[8][2] = new HorizontalDesk(gamePanel);
		gamePanel.object[8][2].setX(25 * gamePanel.TILE_SIZE);
		gamePanel.object[8][2].setY(4 * gamePanel.TILE_SIZE);
		
		gamePanel.object[9][2] = new HorizontalDesk(gamePanel);
		gamePanel.object[9][2].setX(23 * gamePanel.TILE_SIZE);
		gamePanel.object[9][2].setY(7 * gamePanel.TILE_SIZE);
		
		gamePanel.object[10][2] = new HorizontalDesk(gamePanel);
		gamePanel.object[10][2].setX(25 * gamePanel.TILE_SIZE);
		gamePanel.object[10][2].setY(7 * gamePanel.TILE_SIZE);
		
		gamePanel.object[11][2] = new Table(gamePanel);
		gamePanel.object[11][2].setX(23 * gamePanel.TILE_SIZE);
		gamePanel.object[11][2].setY(10 * gamePanel.TILE_SIZE);
		
		gamePanel.object[12][2] = new Couch(gamePanel);
		gamePanel.object[12][2].setX(23 * gamePanel.TILE_SIZE);
		gamePanel.object[12][2].setY(9 * gamePanel.TILE_SIZE);
		
		gamePanel.object[13][2] = new Couch(gamePanel);
		gamePanel.object[13][2].setX(24 * gamePanel.TILE_SIZE);
		gamePanel.object[13][2].setY(9 * gamePanel.TILE_SIZE);
		
		gamePanel.object[14][2] = new Couch(gamePanel);
		gamePanel.object[14][2].setX(23 * gamePanel.TILE_SIZE);
		gamePanel.object[14][2].setY(12 * gamePanel.TILE_SIZE);
		
		gamePanel.object[15][2] = new Couch(gamePanel);
		gamePanel.object[15][2].setX(24 * gamePanel.TILE_SIZE);
		gamePanel.object[15][2].setY(12 * gamePanel.TILE_SIZE);
		
		gamePanel.object[16][2] = new Couch(gamePanel);
		gamePanel.object[16][2].setX(25 * gamePanel.TILE_SIZE);
		gamePanel.object[16][2].setY(10 * gamePanel.TILE_SIZE);
		
		gamePanel.object[17][2] = new Couch(gamePanel);
		gamePanel.object[17][2].setX(25 * gamePanel.TILE_SIZE);
		gamePanel.object[17][2].setY(11 * gamePanel.TILE_SIZE);
		
		gamePanel.object[18][2] = new Entrance(gamePanel, "Bas");
		gamePanel.object[18][2].setX(6 * gamePanel.TILE_SIZE);
		gamePanel.object[18][2].setY(6 * gamePanel.TILE_SIZE - 20);
		
		gamePanel.object[19][2] = new Entrance(gamePanel, "Haut");
		gamePanel.object[19][2].setX(8 * gamePanel.TILE_SIZE);
		gamePanel.object[19][2].setY(6 * gamePanel.TILE_SIZE - 20);
		
		gamePanel.object[20][2] = new Entrance(gamePanel, "Toilettes");
		gamePanel.object[20][2].setX(8 * gamePanel.TILE_SIZE);
		gamePanel.object[20][2].setY(15 * gamePanel.TILE_SIZE - 20);
		
		gamePanel.object[21][2] = new Entrance(gamePanel, "Salles");
		gamePanel.object[21][2].setX(18 * gamePanel.TILE_SIZE);
		gamePanel.object[21][2].setY(gamePanel.TILE_SIZE);
		
		gamePanel.object[22][2] = new Entrance(gamePanel, "Steinbrunn_Right");
		gamePanel.object[22][2].setX(25 * gamePanel.TILE_SIZE);
		gamePanel.object[22][2].setY(17 * gamePanel.TILE_SIZE - 20);
		
		gamePanel.object[23][2] = new Entrance(gamePanel, "Haut");
		gamePanel.object[23][2].setX(6 * gamePanel.TILE_SIZE);
		gamePanel.object[23][2].setY(18 * gamePanel.TILE_SIZE - 20);
		
		gamePanel.object[24][2] = new Entrance(gamePanel, "Bas");
		gamePanel.object[24][2].setX(8 * gamePanel.TILE_SIZE);
		gamePanel.object[24][2].setY(18 * gamePanel.TILE_SIZE - 20);
		
		gamePanel.object[25][2] = new Entrance(gamePanel, "Exit");
		gamePanel.object[25][2].setX(14 * gamePanel.TILE_SIZE);
		gamePanel.object[25][2].setY(25 * gamePanel.TILE_SIZE - 20);
		/*
		 * Map 3 : Steinbrunn
		 */
		gamePanel.object[0][3] = new Entrance(gamePanel, "Steinbrunn_LeftExit");
		gamePanel.object[0][3].setX(3 * gamePanel.TILE_SIZE);
		gamePanel.object[0][3].setY(0);
		
		gamePanel.object[1][3] = new Entrance(gamePanel, "Steinbrunn_RightExit");
		gamePanel.object[1][3].setX(16 * gamePanel.TILE_SIZE);
		gamePanel.object[1][3].setY(0);
		
		gamePanel.object[2][3] = new HorizontalDesk(gamePanel);
		gamePanel.object[2][3].setX(4 * gamePanel.TILE_SIZE);
		gamePanel.object[2][3].setY(4 * gamePanel.TILE_SIZE);
		
		gamePanel.object[3][3] = new HorizontalDesk(gamePanel);
		gamePanel.object[3][3].setX(6 * gamePanel.TILE_SIZE);
		gamePanel.object[3][3].setY(4 * gamePanel.TILE_SIZE);
		
		gamePanel.object[4][3] = new HorizontalDesk(gamePanel);
		gamePanel.object[4][3].setX(8 * gamePanel.TILE_SIZE);
		gamePanel.object[4][3].setY(4 * gamePanel.TILE_SIZE);
		
		gamePanel.object[5][3] = new HorizontalDesk(gamePanel);
		gamePanel.object[5][3].setX(10 * gamePanel.TILE_SIZE);
		gamePanel.object[5][3].setY(4 * gamePanel.TILE_SIZE);
		
		gamePanel.object[6][3] = new HorizontalDesk(gamePanel);
		gamePanel.object[6][3].setX(12 * gamePanel.TILE_SIZE);
		gamePanel.object[6][3].setY(4 * gamePanel.TILE_SIZE);
		
		gamePanel.object[7][3] = new HorizontalDesk(gamePanel);
		gamePanel.object[7][3].setX(14 * gamePanel.TILE_SIZE);
		gamePanel.object[7][3].setY(4 * gamePanel.TILE_SIZE);
		
		gamePanel.object[8][3] = new HorizontalDesk(gamePanel);
		gamePanel.object[8][3].setX(4 * gamePanel.TILE_SIZE);
		gamePanel.object[8][3].setY(8 * gamePanel.TILE_SIZE);
		
		gamePanel.object[9][3] = new HorizontalDesk(gamePanel);
		gamePanel.object[9][3].setX(6 * gamePanel.TILE_SIZE);
		gamePanel.object[9][3].setY(8 * gamePanel.TILE_SIZE);
		
		gamePanel.object[10][3] = new HorizontalDesk(gamePanel);
		gamePanel.object[10][3].setX(8 * gamePanel.TILE_SIZE);
		gamePanel.object[10][3].setY(8 * gamePanel.TILE_SIZE);
		
		gamePanel.object[11][3] = new HorizontalDesk(gamePanel);
		gamePanel.object[11][3].setX(10 * gamePanel.TILE_SIZE);
		gamePanel.object[11][3].setY(8 * gamePanel.TILE_SIZE);
		
		gamePanel.object[12][3] = new HorizontalDesk(gamePanel);
		gamePanel.object[12][3].setX(12 * gamePanel.TILE_SIZE);
		gamePanel.object[12][3].setY(8 * gamePanel.TILE_SIZE);
		
		gamePanel.object[13][3] = new HorizontalDesk(gamePanel);
		gamePanel.object[13][3].setX(14 * gamePanel.TILE_SIZE);
		gamePanel.object[13][3].setY(8 * gamePanel.TILE_SIZE);
		
		gamePanel.object[14][3] = new HorizontalDesk(gamePanel);
		gamePanel.object[14][3].setX(4 * gamePanel.TILE_SIZE);
		gamePanel.object[14][3].setY(12 * gamePanel.TILE_SIZE);
		
		gamePanel.object[15][3] = new HorizontalDesk(gamePanel);
		gamePanel.object[15][3].setX(6 * gamePanel.TILE_SIZE);
		gamePanel.object[15][3].setY(12 * gamePanel.TILE_SIZE);
		
		gamePanel.object[16][3] = new HorizontalDesk(gamePanel);
		gamePanel.object[16][3].setX(8 * gamePanel.TILE_SIZE);
		gamePanel.object[16][3].setY(12 * gamePanel.TILE_SIZE);
		
		gamePanel.object[17][3] = new HorizontalDesk(gamePanel);
		gamePanel.object[17][3].setX(10 * gamePanel.TILE_SIZE);
		gamePanel.object[17][3].setY(12 * gamePanel.TILE_SIZE);
		
		gamePanel.object[18][3] = new HorizontalDesk(gamePanel);
		gamePanel.object[18][3].setX(12 * gamePanel.TILE_SIZE);
		gamePanel.object[18][3].setY(12 * gamePanel.TILE_SIZE);
		
		gamePanel.object[19][3] = new HorizontalDesk(gamePanel);
		gamePanel.object[19][3].setX(14 * gamePanel.TILE_SIZE);
		gamePanel.object[19][3].setY(12 * gamePanel.TILE_SIZE);
		
		gamePanel.object[20][3] = new HorizontalDesk(gamePanel);
		gamePanel.object[20][3].setX(9 * gamePanel.TILE_SIZE);
		gamePanel.object[20][3].setY(16 * gamePanel.TILE_SIZE);
	}
}
