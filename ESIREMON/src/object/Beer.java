package object;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.imageio.ImageIO;

import application.GamePanel;

public class Beer extends Object {
	/*
	 * Constructor
	 */
	public Beer(GamePanel gamePanel) {
		super(gamePanel);
		name = "Grand café";
		price = new BigDecimal(3.00).setScale(1, RoundingMode.HALF_UP);
		description = "Un café d'une couleur bizarre qui te fais récupérer 50PV";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/birra.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
