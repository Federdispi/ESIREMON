package application;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import map.TileManager;
import sprite.Player;
import object.Object;

public class GamePanel extends JPanel implements Runnable {
	final private int originalTileSize = 16;
	final private int scale = 3;
	
	final private int tileSize = originalTileSize * scale;
	final private int maxScreenCol = 16;
	final private int maxScreenRow = 12;
	final private int screenWidth = tileSize * maxScreenCol;
	final private int screenHeight = tileSize * maxScreenRow;
	
	final private int maxMapCol = 28;
	final private int maxMapRow = 25;
	final private int mapWidth = tileSize * maxMapCol;
	final private int mapHeight = tileSize * maxMapRow;
	
	KeyHandler keyHandler = new KeyHandler();
	Thread gameThread;
	TileManager tileManager = new TileManager(this);
	public CollisionDetector collisionDetector = new CollisionDetector(this);
	AssetManager assetManager = new AssetManager(this);
	
	public Player player = new Player(this, keyHandler);
	
	public Object object[] = new Object[10];
	
	int FPS = 60;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyHandler);
		this.setFocusable(true);
	}

	public void gameSetup() {
		assetManager.setObject();
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
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
	
	public void update() {
		player.update();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		tileManager.draw(g2);
		for(int i = 0; i < object.length; i++) {
			if(object[i] != null)
				object[i].draw(g2, this);
		}
		player.draw(g2);
		g2.dispose();
	}
	
	public int getTileSize() {
		return this.tileSize;
	}
	
	public int getMaxScreenCol() {
		return this.maxScreenCol;
	}
	
	public int getMaxScreenRow() {
		return this.maxScreenRow;
	}
	
	public int getScreenWidth() {
		return this.screenWidth;
	}
	
	public int getScreenHeight() {
		return this.screenHeight;
	}
	
	public int getMapCol() {
		return this.maxMapCol;
	}
	
	public int getMapRow() {
		return this.maxMapRow;
	}
	
	public int getMapWidth() {
		return this.mapWidth;
	}
	
	public int getMapHeight() {
		return this.mapHeight;
	}
}
