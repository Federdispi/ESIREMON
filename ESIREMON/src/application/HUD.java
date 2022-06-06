package application;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class HUD {
	
	GamePanel gamePanel;
	Font arial32;
	Graphics2D g2;
	private String dialogue = "";
	
	public HUD(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		arial32 = new Font("Arial", Font.PLAIN, 32);
	}
	
	public void draw(Graphics2D g2) {
		this.g2 = g2;
		this.g2.setFont(arial32);
		this.g2.setColor(Color.white);
		this.g2.drawString("HP: " + gamePanel.player.getLifePoints(), 25, 50);
		
		if(gamePanel.getGameState() == gamePanel.pauseState)
			drawPause();
		
		if(gamePanel.getGameState() == gamePanel.dialogueState)
			drawDialogue();
	}
	
	public void drawPause() {
		String text = "PAUSE";
		int x = centerTextX(text);
		int y = gamePanel.getScreenHeight() / 2;
		g2.drawString(text, x, y);			
	}
	
	public void drawDialogue() {
		int x = gamePanel.getTileSize(); 
		int y = 8 * gamePanel.getTileSize();
		int width = gamePanel.getScreenWidth() - 2 * gamePanel.getTileSize();
		int height = 3 * gamePanel.getTileSize();
		
		drawWindow(x, y, width, height);
		
		x += gamePanel.getTileSize();
		y += gamePanel.getTileSize();
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 26F));
		
		for(String line : dialogue.split("\n")) {
			g2.drawString(line, x, y);
			y += 32;
		}
	}
	
	public void drawWindow(int x, int y, int width, int height) {
		Color color = new Color(255, 255, 255, 220);
		g2.setColor(color);
		g2.fillRoundRect(x, y, width, height, 35, 35);
		
		color = Color.black;
		g2.setColor(color);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
	}
	
	public void setDialogue(String dialogue) {
		this.dialogue = dialogue;
	}
	
	private int centerTextX(String text) {
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gamePanel.getScreenWidth() / 2 - length / 2;
		return x;
	}
}
