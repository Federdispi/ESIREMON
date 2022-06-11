package map;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import application.GamePanel;

public class TileManager {
	GamePanel gamePanel;
	public Tile[] tileTypes;
	int map[][];
	
	public TileManager(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		tileTypes = new Tile[12];
		map = new int[gamePanel.MAP_COL][gamePanel.MAP_COL];
		for(int i = 0; i < tileTypes.length; i++) {
			tileTypes[i] = new Tile();
		}
		getTileImage();
		loadMap("/maps/ESIREM.txt");
	}
	
	public void getTileImage() {
		try {
			tileTypes[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Parquet.png"));
			
			tileTypes[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/muro.png"));
			tileTypes[1].setCollision(true);
			
			tileTypes[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Terra.png"));
			
			tileTypes[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Asfalto.png"));
			
			tileTypes[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Strisce.png"));
			
			tileTypes[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Mattonelle.png"));
			
			tileTypes[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/scale_dx_su.png"));
			tileTypes[6].setCollision(true);
			
			tileTypes[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/scale_dx_giu.png"));
			tileTypes[7].setCollision(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		for(int iRow = 0; iRow < gamePanel.MAP_ROW ; iRow++) {
			for(int iCol = 0; iCol < gamePanel.MAP_COL; iCol++) {
				int mapX = iCol * gamePanel.TILE_SIZE;
				int mapY = iRow * gamePanel.TILE_SIZE;
				int screenX = mapX - gamePanel.player.getX() + gamePanel.player.screenX;
				int screenY = mapY - gamePanel.player.getY() + gamePanel.player.screenY;
				if(map[iCol][iRow] != -1 
						&& mapX + gamePanel.TILE_SIZE > gamePanel.player.getX() - gamePanel.player.screenX 
						&& mapX - gamePanel.TILE_SIZE < gamePanel.player.getX() + gamePanel.player.screenX 
						&& mapY + gamePanel.TILE_SIZE > gamePanel.player.getY() - gamePanel.player.screenY 
						&& mapY - gamePanel.TILE_SIZE < gamePanel.player.getY() + gamePanel.player.screenY)
					g2.drawImage(tileTypes[map[iCol][iRow]].image, screenX, screenY, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
			}
		}
	}
	
	public void loadMap(String pathName) {
		try {
			InputStream inputStream = getClass().getResourceAsStream(pathName);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			
			for(int iRow = 0; iRow < gamePanel.MAP_ROW; iRow++) {
				String line = bufferedReader.readLine();
				for(int iCol = 0; iCol < gamePanel.MAP_COL; iCol++) {
					String numbers[] = line.split(" ");
					int num = Integer.parseInt(numbers[iCol]);
					map[iCol][iRow] = num - 1;
				}
			}
			bufferedReader.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int[][] getMap() {
		return this.map;
	}
}
