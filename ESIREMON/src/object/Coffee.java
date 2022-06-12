package object;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.imageio.ImageIO;

import application.GamePanel;

public class Coffee extends Object {
	
	public Coffee(GamePanel gamePanel) {
		super(gamePanel);
		name = "Caf�";
		price = new BigDecimal(1.00).setScale(1, RoundingMode.HALF_UP);
		description = "Caf� fait avec une nouvelle machine qui te fais r�cup�rer 20PV";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/caffe.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
