package application;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import map.TileManager;
import sprite.KFetMan;
import sprite.Player;
import sprite.Sprite;
import object.Object;

public class GamePanel extends JPanel implements Runnable {	
	/*
	 * Constants
	 */
	public final int TILE_SIZE = 48;
	public final int SCREEN_COL = 16;
	public final int SCREEN_ROW = 12;
	public final int SCREEN_WIDTH = TILE_SIZE * SCREEN_COL;
	public final int SCREEN_HEIGHT = TILE_SIZE * SCREEN_ROW;
	public final int MAP_COL = 30;
	public final int MAP_ROW = 30;
	public final int MAP_WIDTH = TILE_SIZE * MAP_COL;
	public final int MAP_HEIGHT = TILE_SIZE * MAP_COL;
	public final int FPS = 60;
	//Game states
	public final int MAIN_MENU = -1;
	public final int PAUSE = 0;
	public final int PLAY = 1;
	public final int DIALOGUE = 2;
	public final int BATTLE = 3;
	public final int BAG = 4;
	public final int KFET = 5;
	public final int NEW_GAME = 6;
	public final int TOILETS = 7;
	public final int GAME_OVER = 8;
	
	public KeyHandler keyHandler = new KeyHandler(this); //Keyboard inputs
	Thread gameThread; //Game Thread
	TileManager tileManager = new TileManager(this); //Tiles handling
	public CollisionDetector collisionDetector = new CollisionDetector(this); //Collision detection
	AssetManager assetManager = new AssetManager(this); //Objects and npc handling
	public HUD hud = new HUD(this); //HUD
	public Save save = new Save(this); //Saves and restores
	
	public Player player = new Player(this, keyHandler, "?", true); //Player
	
	public Object object[][] = new Object[30][5]; //Object list
	
	public Sprite npc[][] = new Sprite[10][5]; //Npc list
	
	public KFetMan nicolas = new KFetMan(this); //Npc that works at the KFet
	
	private int gameState; //Game state that switches between the constants above
	
	private int map = 0; //First map is Appart.txt
	
	/*
	 * Constructor
	 */
	public GamePanel() {
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyHandler);
		this.setFocusable(true);
	}

	/*
	 * Setup a new game
	 */
	public void gameSetup() {
		assetManager.setNPC();
		nicolas.setBattle(false);
		npc[1][2] = nicolas;
		assetManager.setObject();
		map = 0;
		player = new Player(this, keyHandler, "?", true);
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < npc.length; j++) {
				if(npc[j][i] != null) {
					npc[j][i].setLifePoints(100);
					npc[j][i].setDialogIndex(0);
					for(int k = 0; k < 4; k++) {
						if(npc[j][i].moveSet.size() > 0)
							npc[j][i].moveSet.get(k).setLimit(npc[j][i].moveSet.get(k).getLimitMax());
					}
				}
			}
		}
		hud.setWin(false);
	}
	
	/*
	 * Start the game loop
	 */
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	/*
	 * Game loop
	 */
	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		/*
		 * long timer = 0; int drawCount = 0;
		 */
		
		while(gameThread != null) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			/* timer += (currentTime - lastTime); */
			lastTime = currentTime;
			if(delta >= 1) {
				update();
				repaint();
				delta--;
				/* drawCount++; */
			}
			
			//Show FPS
			/*
			 * if(timer >= 1000000000) { System.out.println("FPS : " + drawCount); drawCount
			 * = 0; timer = 0; }
			 */
		}
	}
	
	/*
	 * Updates player and npc
	 */
	public void update() {
		if(gameState == PLAY) {
			player.update();
		
			for(int i = 0; i < npc.length; i++) {
				if(npc[i][map] != null)
					npc[i][map].update();
			}
		}
	}
	
	/*
	 * Draw
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		if(gameState == MAIN_MENU || gameState == BATTLE || gameState == NEW_GAME)
			hud.draw(g2);
		else {
			tileManager.draw(g2);
			
			for(int i = 0; i < object.length; i++) {
				if(object[i][map] != null)
					object[i][map].draw(g2, this);
			}
			
			for(int i = 0; i < npc.length; i++) {
				if(npc[i][map] != null)
					npc[i][map].draw(g2);
			}
			
			player.draw(g2);
			
			hud.draw(g2);
		}
		
		g2.dispose();
	}
	
	//GETTERS
	public int getGameState() {
		return this.gameState;
	}
	
	public int getMap() {
		return this.map;
	}
	
	//SETTERS
	public void setGameState(int gameState) {
		this.gameState = gameState;
	}
	
	public void setMap(int map) {
		this.map = map;
	}
}
