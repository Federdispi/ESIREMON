package application;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	public boolean isButtonPressed, upPressed, downPressed, leftPressed, rightPressed;
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		isButtonPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_Z)
			upPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_S)
			downPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_Q)
			leftPressed = true;
		if (e.getKeyCode() == KeyEvent.VK_D)
			rightPressed = true;		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		isButtonPressed = false;
		if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_Z)
			upPressed = false;
		else if(e.getKeyCode() == KeyEvent.VK_S)
			downPressed = false;
		else if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_Q)
			leftPressed = false;
		else if (e.getKeyCode() == KeyEvent.VK_D)
			rightPressed = false;	
	}
}
