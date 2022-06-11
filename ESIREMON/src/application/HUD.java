package application;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

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
		else if(gamePanel.getGameState() == gamePanel.BATTLE)
			drawBattle();
		else
			drawLifePoints();
				
		if(gamePanel.getGameState() == gamePanel.PAUSE)
			drawPause();
		
		if(gamePanel.getGameState() == gamePanel.DIALOGUE)
			drawDialogue();
		
		if(gamePanel.getGameState() == gamePanel.BAG)
			drawBag();
		
		if(gamePanel.getGameState() == gamePanel.KFET)
			drawKFet();
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
		this.g2.drawString("PV : ", 25, 40);
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
	
	private void drawBag() {
		//Bag window
		int x = 2 * gamePanel.TILE_SIZE;
		int y = gamePanel.TILE_SIZE;
		int width = 6 * gamePanel.TILE_SIZE;
		int height = 5 * gamePanel.TILE_SIZE;
		drawWindow(x, y, width, height);
		

		
		//Selection

		final int startX = x + gamePanel.TILE_SIZE / 2;
		final int startY = y + gamePanel.TILE_SIZE / 2;
		int selX = startX + bagCol * gamePanel.TILE_SIZE;
		int selY = startY + bagRow * gamePanel.TILE_SIZE;
		int selWidth = gamePanel.TILE_SIZE;
		int selHeight = gamePanel.TILE_SIZE;
		drawWindow(selX, selY, selWidth, selHeight);
		
		//Items
		x = startX + gamePanel.TILE_SIZE / 4;
		y = startY + gamePanel.TILE_SIZE / 4;
		for(int i = 0; i < gamePanel.player.bag.size(); i++) {
			g2.drawImage(gamePanel.player.bag.get(i).getImage(), x, y, gamePanel.TILE_SIZE / 2, gamePanel.TILE_SIZE / 2, null);
			x += gamePanel.TILE_SIZE;
			
			if(i == 4 || i == 9 || i == 14) {
				x = startX + gamePanel.TILE_SIZE / 4;
				y += gamePanel.TILE_SIZE;
			}
		}
		
		//Description window
		x = 2 * gamePanel.TILE_SIZE;
		y = 6 * gamePanel.TILE_SIZE;
		width = 12 * gamePanel.TILE_SIZE;
		height = 2 * gamePanel.TILE_SIZE;
		drawWindow(x, y, width, height);
		
		//Item name
		int itemIndex = bagCol + 5 * bagRow;
		x += 20;
		y += 42;
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 24F));
		if(itemIndex < gamePanel.player.bag.size())
			g2.drawString(gamePanel.player.bag.get(itemIndex).getName(), x, y);
		
		//Item description
		y += gamePanel.TILE_SIZE / 2;
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 16F));
		if(itemIndex < gamePanel.player.bag.size())
			g2.drawString(gamePanel.player.bag.get(itemIndex).getDescription(), x, y);
	}
	
	private void drawKFet() {
		//Inventory window
		int x = 2 * gamePanel.TILE_SIZE;
		int y = gamePanel.TILE_SIZE;
		int width = 6 * gamePanel.TILE_SIZE;
		int height = 5 * gamePanel.TILE_SIZE;
		drawWindow(x, y, width, height);
		
		//Selection
		final int startX = x + gamePanel.TILE_SIZE / 2;
		final int startY = y + gamePanel.TILE_SIZE / 2;
		int selX = startX + bagCol * gamePanel.TILE_SIZE;
		int selY = startY + bagRow * gamePanel.TILE_SIZE;
		int selWidth = gamePanel.TILE_SIZE;
		int selHeight = gamePanel.TILE_SIZE;
		drawWindow(selX, selY, selWidth, selHeight);
		
		//Items
		x = startX + gamePanel.TILE_SIZE / 4;
		y = startY + gamePanel.TILE_SIZE / 4;
		for(int i = 0; i < gamePanel.nicolas.inventory.size(); i++) {
			g2.drawImage(gamePanel.nicolas.inventory.get(i).getImage(), x, y, gamePanel.TILE_SIZE / 2, gamePanel.TILE_SIZE / 2, null);
			x += gamePanel.TILE_SIZE;
			
			if(i == 4 || i == 9 || i == 14) {
				x = startX + gamePanel.TILE_SIZE / 2;
				y += gamePanel.TILE_SIZE;
			}
		}
		
		//Description window
		x = 2 * gamePanel.TILE_SIZE;
		y = 6 * gamePanel.TILE_SIZE;
		width = 12 * gamePanel.TILE_SIZE;
		height = 2 * gamePanel.TILE_SIZE;
		drawWindow(x, y, width, height);
		
		//Item name and price
		int itemIndex = bagCol + 5 * bagRow;
		x += 20;
		y += 42;
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 24F));
		if(itemIndex < gamePanel.nicolas.inventory.size())
			g2.drawString(gamePanel.nicolas.inventory.get(itemIndex).getName() + " : " + gamePanel.nicolas.inventory.get(itemIndex).getPrice() + "0", x, y);
		
		//Item description
		y += gamePanel.TILE_SIZE / 2;
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 16F));
		if(itemIndex < gamePanel.nicolas.inventory.size())
			g2.drawString(gamePanel.nicolas.inventory.get(itemIndex).getDescription(), x, y);
		
		//Money window
		x = 11 * gamePanel.TILE_SIZE;
		y = gamePanel.TILE_SIZE;
		width = 3 * gamePanel.TILE_SIZE;
		height = gamePanel.TILE_SIZE + gamePanel.TILE_SIZE / 2;
		drawWindow(x, y, width, height);
		
		//Money icon
		x += 13;
		y += 13;
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/moneta.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		g2.drawImage(image, x, y, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
		
		//Money amount
		x += gamePanel.TILE_SIZE + gamePanel.TILE_SIZE / 4;
		y += 36;
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 32F));
		g2.drawString(gamePanel.player.getMoney() + "0", x, y);
		
	}
	
	private void drawBattle() {
		g2.setColor(Color.white);
		g2.fillRect(0, 0, gamePanel.SCREEN_WIDTH, gamePanel.SCREEN_HEIGHT);
		
		g2.setColor(Color.black);
		String text = "BATTLE";
		int x = centerTextX(text);
		int y = gamePanel.SCREEN_HEIGHT / 2;
		g2.drawString(text, x, y);
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
