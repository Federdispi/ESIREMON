package application;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigDecimal;

import javax.imageio.ImageIO;

import sprite.Prof;
import sprite.Student;

public class HUD {
	
	GamePanel gamePanel;
	Font arial22;
	Graphics2D g2;
	
	private String name = ""; //Name of the npc who speaks
	private String dialogue = ""; //Dialogue of the npc
	
	//Menu
	private int menuIndex = 0;
	private int submenu = 0;
	
	//Bag
	private int bagCol = 0;
	private int bagRow = 0;	
	
	//Battle
	private boolean playerTurn = true;
	private boolean win = false;
	
	//Darkness
	private float alpha = 0.0f;
	
	/*
	 * Constructor
	 */
	public HUD(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		arial22 = new Font("Arial", Font.PLAIN, 22);
	}
	
	/*
	 * Draws depending on the game state
	 */
	public void draw(Graphics2D g2) {
		this.g2 = g2;
		this.g2.setFont(arial22);
		
		if(gamePanel.getGameState() == gamePanel.MAIN_MENU)
			drawMainMenu();
		else if(gamePanel.getGameState() == gamePanel.BATTLE)
			drawBattle();
		else if(gamePanel.getGameState() == gamePanel.NEW_GAME)
			drawNewGame();
		else if(gamePanel.getGameState() == gamePanel.TOILETS)
			drawToilets();
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
		
		if(gamePanel.getGameState() == gamePanel.GAME_OVER)
			drawGameOver();
		
		if(gamePanel.getMap() == 3)
			drawDark();
	}
	
	/*
	 * Applies a dark filter
	 */
	private void drawDark() {
		Color color = new Color(0, 0, 0, 100);
		g2.setColor(color);
		g2.fillRect(0, 0, gamePanel.SCREEN_WIDTH, gamePanel.SCREEN_HEIGHT);
	}
	
	/*
	 * Game over or You won screen
	 */
	private void drawGameOver() {
		Color color = new Color(0, 0, 0, alpha);
		g2.setColor(color);
		g2.fillRect(0, 0, gamePanel.SCREEN_WIDTH, gamePanel.SCREEN_HEIGHT);
		alpha += 0.01f;
		if(alpha >= 1.0f)
			alpha = 1.0f;
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 100F));
		String text = "";
		if(win) {
			text = "YOU WIN";
			g2.setColor(Color.green);
		}
		else {
			text = "GAME OVER";
			g2.setColor(Color.red);
		}
		int x = centerTextX(text);
		int y = gamePanel.SCREEN_HEIGHT / 2;
		g2.drawString(text, x, y);
	}
	
	/*
	 * Healing animation
	 */
	private void drawToilets() {
		Color color = new Color(0, 0, 0, alpha);
		g2.setColor(color);
		g2.fillRect(0, 0, gamePanel.SCREEN_WIDTH, gamePanel.SCREEN_HEIGHT);
		if(submenu == 0) {
			alpha += 0.01f;
			if(alpha > 1.0f)
				alpha = 1.0f;
			if(alpha == 1.0f)
				submenu = 1;
		} else {
			alpha -= 0.01f;
			if(alpha < 0.0f)
				alpha = 0.0f;
			if(alpha == 0.0f) {
				gamePanel.player.setLifePoints(100);
				for(int i = 0; i < 4; i++)
					gamePanel.player.moveSet.get(i).setLimit(gamePanel.player.moveSet.get(i).getLimitMax());
				gamePanel.setGameState(gamePanel.PLAY);
				submenu = 0;
				alpha = 0.0f;
			}
		}
	}
	
	/*
	 * New Game menu
	 */
	private void drawNewGame() {
		if(submenu == 0) {
			g2.setFont(g2.getFont().deriveFont(Font.BOLD, 72F));
			g2.setColor(Color.white);
			String text = "NOM";
			int x = centerTextX(text);
			int y = gamePanel.SCREEN_HEIGHT / 2 - gamePanel.TILE_SIZE;
			g2.drawString(text, x, y);
			
			g2.setFont(g2.getFont().deriveFont(Font.PLAIN));
			if(name.length() < 10)
				text = name + "_";
			else
				text = name;
			x = centerTextX(text);
			y += 2 * gamePanel.TILE_SIZE;
			g2.drawString(text, x, y);
		} else if(submenu == 1) {
			g2.setFont(g2.getFont().deriveFont(Font.BOLD, 72F));
			g2.setColor(Color.white);
			String text = "SEXE";
			int x = centerTextX(text);
			int y = gamePanel.SCREEN_HEIGHT / 2 - gamePanel.TILE_SIZE;
			g2.drawString(text, x, y);
			
			g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 48F));
			if(menuIndex == 0)
				g2.setColor(Color.yellow);
			else
				g2.setColor(Color.white);
			text = "GAR?ON";
			x = centerTextX(text);
			y += 2 * gamePanel.TILE_SIZE;
			g2.drawString(text, x, y);
			
			g2.setFont(g2.getFont().deriveFont(Font.PLAIN));
			if(menuIndex == 1)
				g2.setColor(Color.yellow);
			else
				g2.setColor(Color.white);
			text = "FILLE";
			x = centerTextX(text);
			y += gamePanel.TILE_SIZE;
			g2.drawString(text, x, y);
		}
	}
	
	/*
	 * Main menu
	 */
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
		text = "CONTINUER LA PARTIE";
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
	
	/*
	 * Life Points bar
	 */
	private void drawLifePoints() {
		g2.setColor(Color.white);
		g2.drawString("PV :                        LV : " + gamePanel.player.getLevel(), 25, 40);
		g2.fillRoundRect(25, 50, 300, gamePanel.TILE_SIZE / 2, 20, 20);
		
		if(gamePanel.player.getLifePoints() >= 70)
			g2.setColor(Color.green);
		else if(gamePanel.player.getLifePoints() >= 30 && gamePanel.player.getLifePoints() < 70)
			g2.setColor(Color.yellow);
		else
			g2.setColor(Color.red);
		
		g2.fillRect(30, 55, 3 * gamePanel.player.getLifePoints() - 10, gamePanel.TILE_SIZE / 2 - 10);
	}
	
	/*
	 * Pause menu
	 */
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
		text = "SAUVEGARDER";
		x = centerTextX(text);
		y += gamePanel.TILE_SIZE;
		g2.drawString(text, x, y);
		
		//4th OPTION
		if(menuIndex == 3)
			g2.setColor(Color.yellow);
		else
			g2.setColor(Color.white);
		text = "MENU PRINCIPAL";
		x = centerTextX(text);
		y += gamePanel.TILE_SIZE;
		g2.drawString(text, x, y);
	}
	
	/*
	 * Dialogues
	 */
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
	
	/*
	 * Player bag
	 */
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
		
		//Money window
		x = 10 * gamePanel.TILE_SIZE;
		y = gamePanel.TILE_SIZE;
		width = 4 * gamePanel.TILE_SIZE;
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
	
	/*
	 * Exchange menu with the KFet
	 */
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
		x = 10 * gamePanel.TILE_SIZE;
		y = gamePanel.TILE_SIZE;
		width = 4 * gamePanel.TILE_SIZE;
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
	
	/*
	 * Battle screen/mechanics
	 */
	private void drawBattle() {
		//Background
		g2.setColor(Color.gray);
		g2.fillRect(0, 0, gamePanel.SCREEN_WIDTH, gamePanel.SCREEN_HEIGHT);
		
		//Enemy info window
		int x = 2 * gamePanel.TILE_SIZE;
		int y = gamePanel.TILE_SIZE;
		int width = 6 * gamePanel.TILE_SIZE;
		int height = 2 * gamePanel.TILE_SIZE;
		drawWindow(x, y, width, height);
		
		//Enemy name window
		g2.setColor(Color.black);
		g2.fillRoundRect(x + 15, y - 10, width / 2, height / 3, 5, 5);
		g2.setColor(Color.white);
		g2.setStroke(new BasicStroke(1));
		g2.drawRoundRect(x + 20, y - 5, width / 2 - 10, height / 3 - 10, 2, 2);
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 22F));
		g2.drawString(name, x + 25, y + 15);
		
		x += gamePanel.TILE_SIZE / 2;
		y += gamePanel.TILE_SIZE ;

		//Enemy HP
		g2.setColor(Color.black);
		g2.drawString("PV :                        LV : " + gamePanel.player.getSpriteInteract().getLevel(), x, y);
		y += gamePanel.TILE_SIZE / 4;
		if(gamePanel.player.getSpriteInteract().getLifePoints() >= 70)
			g2.setColor(Color.green);
		else if(gamePanel.player.getSpriteInteract().getLifePoints() >= 30 && gamePanel.player.getSpriteInteract().getLifePoints() < 70)
			g2.setColor(Color.yellow);
		else
			g2.setColor(Color.red);
		
		g2.fillRect(x, y, 2 * gamePanel.player.getSpriteInteract().getLifePoints() + gamePanel.player.getSpriteInteract().getLifePoints() / 2, gamePanel.TILE_SIZE / 2 - 10);
		
		//Enemy image
		x = 9 * gamePanel.TILE_SIZE;
		y = gamePanel.TILE_SIZE;
		BufferedImage image = null;
		try {
			if(gamePanel.player.getSpriteInteract().getClass() == Student.class) {
				if(gamePanel.player.getSex())
					image = ImageIO.read(getClass().getResourceAsStream("/student_girl/down2.png"));
				else
					image = ImageIO.read(getClass().getResourceAsStream("/student_boy/down2.png"));
			}
			else
				image = ImageIO.read(getClass().getResourceAsStream("/prof/down2.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		g2.drawImage(image, x, y, 150, 150, null);
		
		//Player info window
		x = 7 * gamePanel.TILE_SIZE;
		y = 6 * gamePanel.TILE_SIZE;
		drawWindow(x, y, width, height);
		
		//Player name window
		g2.setColor(Color.black);
		g2.fillRoundRect(x + 15, y - 10, width / 2, height / 3, 5, 5);
		g2.setColor(Color.white);
		g2.setStroke(new BasicStroke(1));
		g2.drawRoundRect(x + 20, y - 5, width / 2 - 10, height / 3 - 10, 2, 2);
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 22F));
		g2.drawString(gamePanel.player.getName(), x + 25, y + 15);
		
		x += gamePanel.TILE_SIZE / 2;
		y += gamePanel.TILE_SIZE ;
		
		//Player HP
		g2.setColor(Color.black);
		g2.drawString("PV :                       LV : " + gamePanel.player.getLevel(), x, y);
		y += gamePanel.TILE_SIZE / 4;
		if(gamePanel.player.getLifePoints() >= 70)
			g2.setColor(Color.green);
		else if(gamePanel.player.getLifePoints() >= 30 && gamePanel.player.getLifePoints() < 70)
			g2.setColor(Color.yellow);
		else
			g2.setColor(Color.red);
		
		g2.fillRect(x, y, 2 * gamePanel.player.getLifePoints() + gamePanel.player.getLifePoints() / 2, gamePanel.TILE_SIZE / 2 - 10);
		
		//Player image
		x = 3 * gamePanel.TILE_SIZE;
		y = 5 * gamePanel.TILE_SIZE;
		try {
			if(gamePanel.player.getSex())
				image = ImageIO.read(getClass().getResourceAsStream("/player_girl/up2.png"));
			else
				image = ImageIO.read(getClass().getResourceAsStream("/player_boy/up2.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		g2.drawImage(image, x, y, 150, 150, null);
		
		//Menu window
		x = 0;
		y = 7 * gamePanel.TILE_SIZE;
		width = 6 * gamePanel.TILE_SIZE;
		height = 5 * gamePanel.TILE_SIZE;
		drawWindow(x, y, width, height);
		
		//Description window
		x = 6 * gamePanel.TILE_SIZE;
		y = 10 * gamePanel.TILE_SIZE;
		width = 10 * gamePanel.TILE_SIZE;
		height = 2 * gamePanel.TILE_SIZE;
		drawWindow(x, y, width, height);
		
		x = 6 * gamePanel.TILE_SIZE + 20;
		y = 10 * gamePanel.TILE_SIZE + 42;
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 24F));
		g2.drawString(dialogue, x, y);
		
		if(playerTurn) {
			//MENU
			if(submenu == 0) {
				//1st OPTION
				g2.setFont(g2.getFont().deriveFont(Font.BOLD, 28F));
				if(menuIndex == 0)
					g2.setColor(Color.red);
				else
					g2.setColor(Color.black);
				String text = "ATTAQUES";
				x = gamePanel.TILE_SIZE;
				y = 9 * gamePanel.TILE_SIZE;
				g2.drawString(text, x, y);
				
				//2nd OPTION
				if(menuIndex == 1)
					g2.setColor(Color.red);
				else
					g2.setColor(Color.black);
				text = "SAC";
				x = gamePanel.TILE_SIZE;
				y += gamePanel.TILE_SIZE;
				g2.drawString(text, x, y);
			} else if(submenu == 1) {
				//1st OPTION
				g2.setFont(g2.getFont().deriveFont(Font.BOLD, 16F));
				if(menuIndex == 0)
					g2.setColor(Color.red);
				else
					g2.setColor(Color.black);
				x = gamePanel.TILE_SIZE /2;
				y = 8 * gamePanel.TILE_SIZE;
				g2.drawString(gamePanel.player.moveSet.get(0).getName() + "   " + gamePanel.player.moveSet.get(0).getPower() + "   " + gamePanel.player.moveSet.get(0).getLimit() + "/" + gamePanel.player.moveSet.get(0).getLimitMax(), x, y);
				
				//2nd OPTION
				if(menuIndex == 1)
					g2.setColor(Color.red);
				else
					g2.setColor(Color.black);
				y += gamePanel.TILE_SIZE - gamePanel.TILE_SIZE / 4;
				g2.drawString(gamePanel.player.moveSet.get(1).getName() + "   " + gamePanel.player.moveSet.get(1).getPower() + "   " + gamePanel.player.moveSet.get(1).getLimit() + "/" + gamePanel.player.moveSet.get(1).getLimitMax(), x, y);
				
				//3rd OPTION
				if(menuIndex == 2)
					g2.setColor(Color.red);
				else
					g2.setColor(Color.black);
				y += gamePanel.TILE_SIZE - gamePanel.TILE_SIZE / 4;
				g2.drawString(gamePanel.player.moveSet.get(2).getName() + "   " + gamePanel.player.moveSet.get(2).getPower() + "   " + gamePanel.player.moveSet.get(2).getLimit() + "/" + gamePanel.player.moveSet.get(2).getLimitMax(), x, y);
				
				//4th OPTION
				if(menuIndex == 3)
					g2.setColor(Color.red);
				else
					g2.setColor(Color.black);
				y += gamePanel.TILE_SIZE - gamePanel.TILE_SIZE / 4;
				g2.drawString(gamePanel.player.moveSet.get(3).getName() + "   " + gamePanel.player.moveSet.get(3).getPower() + "   " + gamePanel.player.moveSet.get(3).getLimit() + "/" + gamePanel.player.moveSet.get(3).getLimitMax(), x, y);
			} else if (submenu == 2) {
				dialogue = "";
				final int startX = gamePanel.TILE_SIZE / 2;
				final int startY = 7 * gamePanel.TILE_SIZE + gamePanel.TILE_SIZE / 2;
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
				
				//Item name
				int itemIndex = bagCol + 5 * bagRow;
				x = 6 * gamePanel.TILE_SIZE + 20;
				y = 10 * gamePanel.TILE_SIZE + 42;
				g2.setFont(g2.getFont().deriveFont(Font.BOLD, 24F));
				if(itemIndex < gamePanel.player.bag.size())
					g2.drawString(gamePanel.player.bag.get(itemIndex).getName(), x, y);
				
				//Item description
				y += gamePanel.TILE_SIZE / 2;
				g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 16F));
				if(itemIndex < gamePanel.player.bag.size())
					g2.drawString(gamePanel.player.bag.get(itemIndex).getDescription(), x, y);
			}
		}
		if(gamePanel.player.getLifePoints() == 0) //If we lose
			gamePanel.setGameState(gamePanel.GAME_OVER);
		else if(gamePanel.player.getSpriteInteract().getLifePoints() == 0) { //If we win the battle
			playerTurn = true;
			gamePanel.player.getSpriteInteract().setBattle(false);
			gamePanel.player.setMoney(gamePanel.player.getMoney().add(new BigDecimal(2.00)));
			gamePanel.player.setLevel(gamePanel.player.getLevel() + 2);
			if(gamePanel.player.getSpriteInteract().getClass() == Prof.class) { //If we win
				gamePanel.setGameState(gamePanel.GAME_OVER);
				win = true;
			}
			else
				gamePanel.setGameState(gamePanel.PLAY);
		}
	}
	
	/*
	 * Creates a window
	 */
	private void drawWindow(int x, int y, int width, int height) {
		Color color = new Color(255, 255, 255, 220);
		g2.setColor(color);
		g2.fillRoundRect(x, y, width, height, 35, 35);
		
		color = Color.black;
		g2.setColor(color);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
	}
	
	/*
	 * SETTERS
	 */
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

	public void setSubMenu(int submenu) {
		this.submenu = submenu;
	}
	
	public void setPlayerTurn(boolean playerTurn) {
		this.playerTurn = playerTurn;
	}
	
	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}
	
	public void setWin(boolean win) {
		this.win = win;
	}
	
	/*
	 * GETTERS
	 */
	public int getMenuIndex() {
		return this.menuIndex;
	}
	
	public int getBagCol() {
		return this.bagCol;
	}
	
	public int getBagRow() {
		return this.bagRow;
	}
	
	public int getSubMenu() {
		return this.submenu;
	}
	
	public boolean getPlayerTurn() {
		return this.playerTurn;
	}
	
	public String getName() {
		return this.name;
	}
	
	//Return x to center a text on the screen
	private int centerTextX(String text) {
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gamePanel.SCREEN_WIDTH / 2 - length / 2;
		return x;
	}
}
