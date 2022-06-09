package application;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	GamePanel gamePanel;
	public boolean isButtonPressed, upPressed, downPressed, leftPressed, rightPressed;
	public boolean enterPressed;
	
	public KeyHandler(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if(gamePanel.getGameState() == gamePanel.playState) {
			if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_Z) {
				upPressed = true;
				isButtonPressed = true;
			}
			if(e.getKeyCode() == KeyEvent.VK_S) {
				downPressed = true;
				isButtonPressed = true;
			}
			if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_Q) {
				leftPressed = true;
				isButtonPressed = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_D) {
				rightPressed = true;		
				isButtonPressed = true;
			}
			
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
				gamePanel.setGameState(gamePanel.pauseState);
			if(e.getKeyCode() == KeyEvent.VK_ENTER)
				enterPressed = true;
		}
		
		else if(gamePanel.getGameState() == gamePanel.pauseState) {
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
				gamePanel.setGameState(gamePanel.playState);
		}
		
		else if(gamePanel.getGameState() == gamePanel.dialogueState) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER)
				gamePanel.setGameState(gamePanel.playState);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_Z) {
			upPressed = false;
			isButtonPressed = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_S) {
			downPressed = false;
			isButtonPressed = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_Q) {
			leftPressed = false;
			isButtonPressed = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			rightPressed = false;	
			isButtonPressed = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_ENTER)
			enterPressed = false;
	}
}
