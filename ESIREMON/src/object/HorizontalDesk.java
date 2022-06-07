package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import application.GamePanel;

public class HorizontalDesk extends Object{
	
	public HorizontalDesk(GamePanel gamePanel) {
		super(gamePanel);
		name = "HorizontalDesk";
		width = 87;
		height = 59;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/scrivania orizontale.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
