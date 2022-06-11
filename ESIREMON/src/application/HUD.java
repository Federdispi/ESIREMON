package application;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class HUD {
	
	GamePanel gamePanel;
	Font arial22;
	Graphics2D g2;
	private String name = "";
	private String dialogue = "";
	private int menuIndex = 0;
	private int bagCol = 0;
	private int bagRow = 0;
	
	public HUD(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		arial22 = new Font("Arial", Font.PLAIN, 22);
	}
	
	public void draw(Graphics2D g2) {
		this.g2 = g2;
		this.g2.setFont(arial22);
		
		if(gamePanel.getGameState() == gamePanel.MAIN_MENU)
			drawMainMenu();
		else
			drawLifePoints();
				
		if(gamePanel.getGameState() == gamePanel.PAUSE)
			drawPause();
		
		if(gamePanel.getGameState() == gamePanel.DIALOGUE)
			drawDialogue();
		
		if(gamePanel.getGameState() == gamePanel.BAG)
			drawBag();
	}
	
	private void drawMainMenu() {
		//TITLE
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 72F));
		g2.setColor(Color.white);
		String text = "ESIREMON";
		int x = centerTextX(text);
		int y = 2 * gamePanel.TILE_SIZE;
		g2.drawString(text, x, y);
		
		//MENU
		//1st OPTION
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32F));
		if(menuIndex == 0)
			g2.setColor(Color.yellow);
		else
			g2.setColor(Color.white);
		text = "NOUVELLE PARTIE";
		x = centerTextX(text);
		y += 4 * gamePanel.TILE_SIZE;
		g2.drawString(text, x, y);
		
		//2nd OPTION
		if(menuIndex == 1)
			g2.setColor(Color.yellow);
		else
			g2.setColor(Color.white);
		text = "CHARGER UNE PARTIE";
		x = centerTextX(text);
		y += gamePanel.TILE_SIZE;
		g2.drawString(text, x, y);
		
		//3rd OPTION
		if(menuIndex == 2)
			g2.setColor(Color.yellow);
		else
			g2.setColor(Color.white);
		text = "QUITTER";
		x = centerTextX(text);
		y += gamePanel.TILE_SIZE;
		g2.drawString(text, x, y);
	}
	
	private void drawLifePoints() {
		this.g2.setColor(Color.white);
		this.g2.drawString("HP: ", 25, 40);
		this.g2.fillRoundRect(25, 50, 300, gamePanel.TILE_SIZE / 2, 20, 20);
		
		if(gamePanel.player.getLifePoints() >= 70)
			this.g2.setColor(Color.green);
		else if(gamePanel.player.getLifePoints() >= 30 && gamePanel.player.getLifePoints() < 70)
			this.g2.setColor(Color.yellow);
		else
			this.g2.setColor(Color.red);
		
		this.g2.fillRect(30, 55, 3 * gamePanel.player.getLifePoints() - 10, gamePanel.TILE_SIZE / 2 - 10);
	}
	
	private void drawPause() {
		//Background
		Color color = new Color(0, 0, 0, 230);
		g2.setColor(color);
		g2.fillRect(0, 0, gamePanel.SCREEN_WIDTH, gamePanel.SCREEN_HEIGHT);
		
		//TITLE		
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 72F));
		String text = "PAUSE";
		int x = centerTextX(text);
		int y = 2 * gamePanel.TILE_SIZE;
		g2.setColor(Color.white);
		g2.drawString(text, x, y);		
		
		//MENU
		//1st OPTION
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32F));
		if(menuIndex == 0)
			g2.setColor(Color.yellow);
		else
			g2.setColor(Color.white);
		text = "REPRENDRE";
		x = centerTextX(text);
		y += 4 * gamePanel.TILE_SIZE;
		g2.drawString(text, x, y);
		
		//2nd OPTION
		if(menuIndex == 1)
			g2.setColor(Color.yellow);
		else
			g2.setColor(Color.white);
		text = "SAC";
		x = centerTextX(text);
		y += gamePanel.TILE_SIZE;
		g2.drawString(text, x, y);
		
		//3rd OPTION
		if(menuIndex == 2)
			g2.setColor(Color.yellow);
		else
			g2.setColor(Color.white);
		text = "MENU PRINCIPAL";
		x = centerTextX(text);
		y += gamePanel.TILE_SIZE;
		g2.drawString(text, x, y);
	}
	
	private void drawDialogue() {
		int x = gamePanel.TILE_SIZE; 
		int y = 8 * gamePanel.TILE_SIZE;
		int width = gamePanel.SCREEN_WIDTH - 2 * gamePanel.TILE_SIZE;
		int height = 3 * gamePanel.TILE_SIZE;
		
		drawWindow(x, y, width, height);
		
		g2.setColor(Color.black);
		g2.fillRoundRect(x + 15, y - 15, width / 5, height / 4, 5, 5);
		
		g2.setColor(Color.white);
		g2.setStroke(new BasicStroke(1));
		g2.drawRoundRect(x + 20, y - 10, width / 5 - 10, height / 4 - 10, 2, 2);
		
		x += gamePanel.TILE_SIZE;
		y += gamePanel.TILE_SIZE;
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 26F));
		g2.setColor(Color.black);
		
		for(String line : dialogue.split("\n")) {
			g2.drawString(line, x, y);
			y += 32;
		}
		
		x = gamePanel.TILE_SIZE + 25;
		y = 8 * gamePanel.TILE_SIZE + 12;
		g2.setColor(Color.white);
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 22F));
		g2.drawString(name, x, y);
	}
	
	public void drawBag() {
		//Window
		int x = gamePanel.TILE_SIZE;
		int y = gamePanel.TILE_SIZE;
		int width = 6 * gamePanel.TILE_SIZE;
		int height = 5 * gamePanel.TILE_SIZE;
		
		drawWindow(x, y, width, height);
		
		//Items
		final int startX = x + 20;
		final int startY = y + 20;
		x = startX;
		y = startY;
		
		//Selection
		int selX = startX + bagCol * gamePanel.TILE_SIZE;
		int selY = startY + bagRow * gamePanel.TILE_SIZE;
		int selWidth = gamePanel.TILE_SIZE;
		int selHeight = gamePanel.TILE_SIZE;
		
		drawWindow(selX, selY, selWidth, selHeight);
	}
	
	public void drawBattle() {
		//TODO
	}
	
	private void drawWindow(int x, int y, int width, int height) {
		Color color = new Color(255, 255, 255, 220);
		g2.setColor(color);
		g2.fillRoundRect(x, y, width, height, 35, 35);
		
		color = Color.black;
		g2.setColor(color);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDialogue(String dialogue) {
		this.dialogue = dialogue;
	}
	
	public void setMenuIndex(int menuIndex) {
		this.menuIndex = menuIndex;
	}
	
	public void setBagCol(int bagCol) {
		this.bagCol = bagCol;
	}
	
	public void setBagRow(int bagRow) {
		this.bagRow = bagRow;
	}
	
	public int getMenuIndex() {
		return this.menuIndex;
	}
	
	public int getBagCol() {
		return this.bagCol;
	}
	
	public int getBagRow() {
		return this.bagRow;
	}
	
	private int centerTextX(String text) {
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gamePanel.SCREEN_WIDTH / 2 - length / 2;
		return x;
	}
}
