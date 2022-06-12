package application;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import sprite.KFetMan;

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
		
		//PLAY
		if(gamePanel.getGameState() == gamePanel.PLAY) {
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
				gamePanel.setGameState(gamePanel.PAUSE);
			if(e.getKeyCode() == KeyEvent.VK_ENTER)
				enterPressed = true;
		}
		
		//PAUSE
		else if(gamePanel.getGameState() == gamePanel.PAUSE) {
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
				gamePanel.setGameState(gamePanel.PLAY);
			else if((e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_Z) && gamePanel.hud.getMenuIndex() > 0)
				gamePanel.hud.setMenuIndex(gamePanel.hud.getMenuIndex() - 1);
			else if(e.getKeyCode() == KeyEvent.VK_S && gamePanel.hud.getMenuIndex() < 2)
				gamePanel.hud.setMenuIndex(gamePanel.hud.getMenuIndex() + 1);
			else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				switch(gamePanel.hud.getMenuIndex()) {
				case 0:
					gamePanel.setGameState(gamePanel.PLAY);
					break;
				case 1:
					gamePanel.setGameState(gamePanel.BAG);
					break;
				case 2:
					gamePanel.setGameState(gamePanel.MAIN_MENU);
					break;
				}
				gamePanel.hud.setMenuIndex(0);
			}
			
		}
		
		//DIALOGUE
		else if(gamePanel.getGameState() == gamePanel.DIALOGUE) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				if(gamePanel.player.getSpriteInteract().getClass() == KFetMan.class)
					gamePanel.setGameState(gamePanel.KFET);
				else if(gamePanel.player.getSpriteInteract().getBattle())
					gamePanel.setGameState(gamePanel.BATTLE);
				else
					gamePanel.setGameState(gamePanel.PLAY);
			}
		}
		
		//MAIN MENU
		else if(gamePanel.getGameState() == gamePanel.MAIN_MENU) {
			if((e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_Z) && gamePanel.hud.getMenuIndex() > 0)
				gamePanel.hud.setMenuIndex(gamePanel.hud.getMenuIndex() - 1);
			else if(e.getKeyCode() == KeyEvent.VK_S && gamePanel.hud.getMenuIndex() < 2)
				gamePanel.hud.setMenuIndex(gamePanel.hud.getMenuIndex() + 1);
			else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				switch(gamePanel.hud.getMenuIndex()) {
				case 0:
					gamePanel.setGameState(gamePanel.PLAY);
					break;
				case 1:
					//TODO
					break;
				case 2:
					System.exit(0);
					break;
				}
				gamePanel.hud.setMenuIndex(0);
			}
		}
		
		//BAG
		else if(gamePanel.getGameState() == gamePanel.BAG) {
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				gamePanel.setGameState(gamePanel.PLAY);
				gamePanel.hud.setBagCol(0);
				gamePanel.hud.setBagRow(0);
			}
			else if((e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_Z) && gamePanel.hud.getBagRow() > 0)
				gamePanel.hud.setBagRow(gamePanel.hud.getBagRow() - 1);
			else if(e.getKeyCode() == KeyEvent.VK_S && gamePanel.hud.getBagRow() < 3)
				gamePanel.hud.setBagRow(gamePanel.hud.getBagRow() + 1);
			else if((e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_Q) && gamePanel.hud.getBagCol() > 0)
				gamePanel.hud.setBagCol(gamePanel.hud.getBagCol() - 1);
			else if(e.getKeyCode() == KeyEvent.VK_D && gamePanel.hud.getBagCol() < 4)
				gamePanel.hud.setBagCol(gamePanel.hud.getBagCol() + 1);
		}
		
		//KFET
		else if(gamePanel.getGameState() == gamePanel.KFET) {
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				gamePanel.setGameState(gamePanel.PLAY);
				gamePanel.hud.setBagCol(0);
				gamePanel.hud.setBagRow(0);
			}
			else if((e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_Z) && gamePanel.hud.getBagRow() > 0)
				gamePanel.hud.setBagRow(gamePanel.hud.getBagRow() - 1);
			else if(e.getKeyCode() == KeyEvent.VK_S && gamePanel.hud.getBagRow() < 3)
				gamePanel.hud.setBagRow(gamePanel.hud.getBagRow() + 1);
			else if((e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_Q) && gamePanel.hud.getBagCol() > 0)
				gamePanel.hud.setBagCol(gamePanel.hud.getBagCol() - 1);
			else if(e.getKeyCode() == KeyEvent.VK_D && gamePanel.hud.getBagCol() < 4)
				gamePanel.hud.setBagCol(gamePanel.hud.getBagCol() + 1);
			else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				int itemIndex = gamePanel.hud.getBagCol() + 5 * gamePanel.hud.getBagRow();
				if(itemIndex < gamePanel.nicolas.inventory.size() && gamePanel.player.getMoney().compareTo(gamePanel.nicolas.inventory.get(itemIndex).getPrice()) >= 0) {
					gamePanel.player.bag.add(gamePanel.nicolas.inventory.get(itemIndex));
					gamePanel.player.setMoney(gamePanel.player.getMoney().subtract(gamePanel.nicolas.inventory.get(itemIndex).getPrice()));
				}
			}
		}
		
		//BATTLE
		else if(gamePanel.getGameState() == gamePanel.BATTLE) {
			if((e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_Z) && gamePanel.hud.getMenuIndex() > 0)
				gamePanel.hud.setMenuIndex(gamePanel.hud.getMenuIndex() - 1);
			else if(e.getKeyCode() == KeyEvent.VK_S && (gamePanel.hud.getMenuIndex() < 1 && gamePanel.hud.getSubMenu() == 0 || gamePanel.hud.getMenuIndex() < 3 && gamePanel.hud.getSubMenu() == 1))
				gamePanel.hud.setMenuIndex(gamePanel.hud.getMenuIndex() + 1);
			else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				switch(gamePanel.hud.getSubMenu()) {
				case 0:
					switch(gamePanel.hud.getMenuIndex()) {
					case 0:
						gamePanel.hud.setSubMenu(1);
						break;
					case 1:
						gamePanel.setGameState(gamePanel.BAG);
						break;
					}
					break;
				case 1:
					switch(gamePanel.hud.getMenuIndex()) {
					case 0:
						break;
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					}
					break;
				}
				gamePanel.hud.setMenuIndex(0);
			}
			else if(e.getKeyCode() == KeyEvent.VK_ESCAPE && gamePanel.hud.getSubMenu() == 1)
				gamePanel.hud.setSubMenu(0);
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
