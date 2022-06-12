package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import object.Beer;
import object.Coffee;
import object.Waffle;

public class Save {

	GamePanel gamePanel;
	
	public Save(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	public void saveGame() {
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("save.txt"));
			//Player name
			bufferedWriter.write(gamePanel.player.getName());
			bufferedWriter.newLine();
			//Player sex
			bufferedWriter.write(String.valueOf(gamePanel.player.getSex()));
			bufferedWriter.newLine();
			//Player life points
			bufferedWriter.write(String.valueOf(gamePanel.player.getLifePoints()));
			bufferedWriter.newLine();
			//Player level
			bufferedWriter.write(String.valueOf(gamePanel.player.getLevel()));
			bufferedWriter.newLine();
			//Player x
			bufferedWriter.write(String.valueOf(gamePanel.player.getX()));
			bufferedWriter.newLine();
			//Player y
			bufferedWriter.write(String.valueOf(gamePanel.player.getY()));
			bufferedWriter.newLine();
			//Player direction
			bufferedWriter.write(gamePanel.player.getDirection());
			bufferedWriter.newLine();
			//Player bag
			for(int i = 0; i < 20; i++) {
				if(i < gamePanel.player.bag.size())
					bufferedWriter.write(gamePanel.player.bag.get(i).getName());
				bufferedWriter.newLine();
			}			
			//Player moveSet
			for(int i = 0; i < 4; i++) {
				bufferedWriter.write(String.valueOf(gamePanel.player.moveSet.get(i).getLimit()));
				bufferedWriter.newLine();
			}
			//Sprites
			for(int i = 0; i < gamePanel.npc.length; i++) {
				if(gamePanel.npc[i] != null) {
					//Sprite x
					bufferedWriter.write(String.valueOf(gamePanel.npc[i].getX()));
					bufferedWriter.newLine();
					//Sprite y
					bufferedWriter.write(String.valueOf(gamePanel.npc[i].getY()));
					bufferedWriter.newLine();
					//Sprite direction
					bufferedWriter.write(gamePanel.npc[i].getDirection());
					bufferedWriter.newLine();
					//Sprite battle
					bufferedWriter.write(String.valueOf(gamePanel.npc[i].getBattle()));
				}
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadGame() {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("save.txt"));
			
			//Player name
			String line = bufferedReader.readLine();
			if(line != null) {
				gamePanel.player.setName(line);
				//Player sex
				line = bufferedReader.readLine();
				gamePanel.player.setSex(Boolean.parseBoolean(line));
				//Player life points
				line = bufferedReader.readLine();
				gamePanel.player.setLifePoints(Integer.parseInt(line));
				//Player level
				line = bufferedReader.readLine();
				gamePanel.player.setLevel(Integer.parseInt(line));
				//Player x
				line = bufferedReader.readLine();
				gamePanel.player.setX(Integer.parseInt(line));
				//Player y
				line = bufferedReader.readLine();
				gamePanel.player.setY(Integer.parseInt(line));
				//Player direction
				line = bufferedReader.readLine();
				gamePanel.player.setDirection(line);
				//Player bag
				for(int i = 0; i < 20; i++) {
					line = bufferedReader.readLine();
					if(!line.isEmpty()) {
						switch(line) {
						case "Gaufre":
							gamePanel.player.bag.add(new Waffle(gamePanel));
							break;
						case "Caf�":
							gamePanel.player.bag.add(new Coffee(gamePanel));
							break;
						case "Grand caf�":
							gamePanel.player.bag.add(new Beer(gamePanel));
							break;
						}
					}
				}			
				//Player moveSet
				for(int i = 0; i < 4; i++) {
					line = bufferedReader.readLine();
					gamePanel.player.moveSet.get(i).setLimit(Integer.parseInt(line));
				}
				//Sprites
				for(int i = 0; i < gamePanel.npc.length; i++) {
					line = bufferedReader.readLine();
					if(!line.isEmpty()) {
						//Sprite x
						gamePanel.npc[i].setX(Integer.parseInt(line));
						//Sprite y
						line = bufferedReader.readLine();
						gamePanel.npc[i].setY(Integer.parseInt(line));
						//Sprite direction
						line = bufferedReader.readLine();
						gamePanel.npc[i].setDirection(line);
						//Sprite battle
						line = bufferedReader.readLine();
						gamePanel.npc[i].setBattle(Boolean.parseBoolean(line));
					}
				}
				bufferedReader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}