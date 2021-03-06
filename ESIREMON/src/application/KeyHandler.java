package application;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import sprite.KFetMan;

public class KeyHandler implements KeyListener {
	GamePanel gamePanel;
	public boolean isButtonPressed, upPressed, downPressed, leftPressed, rightPressed;
	public boolean enterPressed;
	
	/*
	 * Constructor
	 */
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
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				gamePanel.setGameState(gamePanel.PLAY);
				gamePanel.hud.setMenuIndex(0);
			}
			else if((e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_Z) && gamePanel.hud.getMenuIndex() > 0)
				gamePanel.hud.setMenuIndex(gamePanel.hud.getMenuIndex() - 1);
			else if(e.getKeyCode() == KeyEvent.VK_S && gamePanel.hud.getMenuIndex() < 3)
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
					gamePanel.save.saveGame();
					gamePanel.setGameState(gamePanel.PLAY);
					break;
				case 3:
					gamePanel.setGameState(gamePanel.MAIN_MENU);
					break;
				}
				gamePanel.hud.setMenuIndex(0);
			}
			
		}
		
		//DIALOGUE
		else if(gamePanel.getGameState() == gamePanel.DIALOGUE) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				if(gamePanel.player.getSpriteInteract() == null)
					gamePanel.setGameState(gamePanel.PLAY);
				else if(gamePanel.player.getSpriteInteract().getClass() == KFetMan.class)
					gamePanel.setGameState(gamePanel.KFET);
				else if(gamePanel.player.getSpriteInteract().getBattle()) {
					gamePanel.setGameState(gamePanel.BATTLE);
					gamePanel.hud.setDialogue("");
				}
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
					gamePanel.setGameState(gamePanel.NEW_GAME);
					gamePanel.hud.setName("");
					gamePanel.gameSetup();
					gamePanel.hud.setSubMenu(0);
					break;
				case 1:
					gamePanel.save.loadGame();
					gamePanel.setGameState(gamePanel.PLAY);
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
			else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				if(gamePanel.player.getLifePoints() < 100) {
					switch(gamePanel.player.bag.get(gamePanel.hud.getBagCol() + 5 * gamePanel.hud.getBagRow()).getName()) {
					case "Gaufre":
						gamePanel.player.setLifePoints(gamePanel.player.getLifePoints() + 10);
						break;
					case "Caf?":
						gamePanel.player.setLifePoints(gamePanel.player.getLifePoints() + 20);
						break;
					case "Grand caf?":
						gamePanel.player.setLifePoints(gamePanel.player.getLifePoints() + 50);
						break;
					}
					gamePanel.player.bag.remove(gamePanel.hud.getBagCol() + 5 * gamePanel.hud.getBagRow());
				}
			}
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
				if(itemIndex < gamePanel.nicolas.inventory.size() && gamePanel.player.getMoney().compareTo(gamePanel.nicolas.inventory.get(itemIndex).getPrice()) >= 0 && gamePanel.player.bag.size() < 20) {
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
			else if(gamePanel.hud.getSubMenu() == 2) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					gamePanel.hud.setSubMenu(0);
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
					if(gamePanel.player.getLifePoints() < 100) {
						switch(gamePanel.player.bag.get(gamePanel.hud.getBagCol() + 5 * gamePanel.hud.getBagRow()).getName()) {
						case "Gaufre":
							gamePanel.player.setLifePoints(gamePanel.player.getLifePoints() + 10);
							break;
						case "Caf?":
							gamePanel.player.setLifePoints(gamePanel.player.getLifePoints() + 20);
							break;
						case "Grand caf?":
							gamePanel.player.setLifePoints(gamePanel.player.getLifePoints() + 50);
							break;
						}
						gamePanel.hud.setDialogue(gamePanel.player.getName() + " utilise " + gamePanel.player.bag.get(gamePanel.hud.getBagCol() + 5 * gamePanel.hud.getBagRow()).getName());
						gamePanel.player.bag.remove(gamePanel.hud.getBagCol() + 5 * gamePanel.hud.getBagRow());
						gamePanel.hud.setSubMenu(0);
						gamePanel.hud.setPlayerTurn(false);
					}
				}
			}
			else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				if(gamePanel.hud.getPlayerTurn()) {
					switch(gamePanel.hud.getSubMenu()) {
					case 0:
						switch(gamePanel.hud.getMenuIndex()) {
						case 0:
							gamePanel.hud.setSubMenu(1);
							break;
						case 1:
							gamePanel.hud.setSubMenu(2);
							break;
						}
						gamePanel.hud.setMenuIndex(0);
						break;
					case 1:
						if(gamePanel.player.moveSet.get(gamePanel.hud.getMenuIndex()).getLimit() > 0) {
							gamePanel.player.attack(gamePanel.player.moveSet.get(gamePanel.hud.getMenuIndex()), gamePanel.player.getSpriteInteract());
							gamePanel.hud.setMenuIndex(0);
						}
						break;
					}
				} else {
					Random random = new Random();
					int move = random.nextInt(4);
					if(gamePanel.player.getSpriteInteract().moveSet.get(move).getLimit() > 0) {
						gamePanel.player.getSpriteInteract().attack(gamePanel.player.getSpriteInteract().moveSet.get(move), gamePanel.player);
					}
				}
			}
			else if(e.getKeyCode() == KeyEvent.VK_ESCAPE && gamePanel.hud.getSubMenu() >= 1) {
				gamePanel.hud.setSubMenu(0);
				gamePanel.hud.setMenuIndex(0);
			}
		}
		
		//NEW GAME
		else if(gamePanel.getGameState() == gamePanel.NEW_GAME) {
			if(gamePanel.hud.getSubMenu() == 0) {
				final String POSSIBLE_CHAR = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
				if(POSSIBLE_CHAR.contains(e.getKeyChar() + "") && gamePanel.hud.getName().length() < 10) 
					gamePanel.hud.setName(gamePanel.hud.getName() + e.getKeyChar());
				else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE && gamePanel.hud.getName().length() > 0)
					gamePanel.hud.setName(gamePanel.hud.getName().substring(0, gamePanel.hud.getName().length() - 1));
				else if(e.getKeyCode() == KeyEvent.VK_ENTER && !gamePanel.hud.getName().isEmpty()) {
					gamePanel.player.setName(gamePanel.hud.getName());
					gamePanel.hud.setSubMenu(1);
				}
				else if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
					gamePanel.setGameState(gamePanel.MAIN_MENU);
			} else if(gamePanel.hud.getSubMenu() == 1) {
				if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_Z)
					gamePanel.hud.setMenuIndex(0);
				else if(e.getKeyCode() == KeyEvent.VK_S)
					gamePanel.hud.setMenuIndex(1);
				else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(gamePanel.hud.getMenuIndex() == 0)
						gamePanel.player.setSex(false);
					else
						gamePanel.player.setSex(true);
					gamePanel.hud.setMenuIndex(0);
					gamePanel.hud.setSubMenu(0);
					gamePanel.setGameState(gamePanel.PLAY);
				}
				else if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
					gamePanel.hud.setSubMenu(0);
			}
		}
		
		//GAME OVER
		else if(gamePanel.getGameState() == gamePanel.GAME_OVER) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				gamePanel.setGameState(gamePanel.MAIN_MENU);
				gamePanel.hud.setAlpha(0.0f);
			}
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
