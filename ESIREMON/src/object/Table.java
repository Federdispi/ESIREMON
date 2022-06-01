package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Table extends Object {
	
	public Table() {
		name = "Table";
		width = 64;
		height = 66;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/tavolo.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
