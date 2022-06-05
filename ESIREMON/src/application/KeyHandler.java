package application;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	public boolean isButtonPressed, upPressed, downPressed, leftPressed, rightPressed;
	public boolean interact;
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
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
	}

	@Override
	public void keyReleased(KeyEvent e) {
		isButtonPressed = false;
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
		else if (e.getKeyCode() == KeyEvent.VK_D) {
			rightPressed = false;	
			isButtonPressed = false;
		}
	}
}
