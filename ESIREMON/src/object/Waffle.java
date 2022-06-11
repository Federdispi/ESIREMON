package object;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.imageio.ImageIO;

import application.GamePanel;

public class Waffle extends Object {
	
	public Waffle(GamePanel gamePanel) {
		super(gamePanel);
		name = "Gaufre";
		price = new BigDecimal(0.40).setScale(1, RoundingMode.HALF_UP);
		description = "Une gaufre d�licieuse et pas ch�re qui te fais gagner 20PV";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/gaufre.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
