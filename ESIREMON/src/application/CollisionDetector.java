package application;

import sprite.Sprite;

public class CollisionDetector {
	
	GamePanel gamePanel;
	
	public CollisionDetector(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	public int detectCollision(Sprite sprite) {
		int objectCode = -1;
		int spriteLeft = sprite.getX() + sprite.getHitBox().x;
		int spriteRight = sprite.getX() + sprite.getHitBox().x + sprite.getHitBox().width;
		int spriteTop = sprite.getY() + sprite.getHitBox().y;
		int spriteBottom = sprite.getY() + sprite.getHitBox().y + sprite.getHitBox().height;
		
		int spriteLeftCol = spriteLeft / gamePanel.getTileSize();
		int spriteRightCol = spriteRight / gamePanel.getTileSize();
		int spriteTopRow = spriteTop / gamePanel.getTileSize();
		int spriteBottomRow = spriteBottom / gamePanel.getTileSize();
		
		int tile1, tile2;
		
		for(int i = 0; i < gamePanel.object.length; i++) {
			if(gamePanel.object[i] != null) {
				int objectLeft = gamePanel.object[i].getX();
				int objectRight = gamePanel.object[i].getX() + gamePanel.object[i].getWidth();
				int objectTop = gamePanel.object[i].getY();
				int objectBottom = gamePanel.object[i].getY() + gamePanel.object[i].getHeight();
				boolean objectCollision = gamePanel.object[i].getCollision();
				switch(sprite.getDirection()) {
				case "up":
					try {
						spriteTopRow = (spriteTop - sprite.getSpeed()) / gamePanel.getTileSize();
						tile1 = gamePanel.tileManager.getMap()[spriteLeftCol][spriteTopRow];
						tile2 = gamePanel.tileManager.getMap()[spriteRightCol][spriteTopRow];
						if(gamePanel.tileManager.tileTypes[tile1].getCollision() || gamePanel.tileManager.tileTypes[tile2].getCollision() || spriteTop < 0)
							sprite.setCollision(true);
					} catch(Exception e) {
						sprite.setCollision(true);
					}
					if(spriteTop - sprite.getSpeed() < objectBottom && spriteTop - sprite.getSpeed() > objectTop && spriteRight > objectLeft && spriteLeft < objectRight) {
						objectCode = i;
						if(objectCollision)
							sprite.setCollision(true);
					}
					break;
				case "down":				
					try {
						spriteBottomRow = (spriteBottom + sprite.getSpeed()) / gamePanel.getTileSize();
						tile1 = gamePanel.tileManager.getMap()[spriteLeftCol][spriteBottomRow];
						tile2 = gamePanel.tileManager.getMap()[spriteRightCol][spriteBottomRow];
						if(gamePanel.tileManager.tileTypes[tile1].getCollision() || gamePanel.tileManager.tileTypes[tile2].getCollision() || spriteBottom > gamePanel.getMapHeight())
							sprite.setCollision(true);
					} catch(Exception e) {
						sprite.setCollision(true);
					}
					if(spriteBottom + sprite.getSpeed() > objectTop && spriteBottom + sprite.getSpeed() < objectBottom && spriteRight > objectLeft && spriteLeft < objectRight) {
						objectCode = i;
						if(objectCollision)
							sprite.setCollision(true);
					}
					break;
				case "left":
					try {
						spriteLeftCol = (spriteLeft - sprite.getSpeed()) / gamePanel.getTileSize();
						tile1 = gamePanel.tileManager.getMap()[spriteLeftCol][spriteTopRow];
						tile2 = gamePanel.tileManager.getMap()[spriteLeftCol][spriteBottomRow];
						if(gamePanel.tileManager.tileTypes[tile1].getCollision() || gamePanel.tileManager.tileTypes[tile2].getCollision() || spriteLeft < 0)
							sprite.setCollision(true);
					} catch(Exception e) {
						sprite.setCollision(true);
					}
					if(spriteLeft - sprite.getSpeed() < objectRight && spriteLeft - sprite.getSpeed() > objectLeft && spriteBottom > objectTop && spriteTop < objectBottom) {
						objectCode = i;
						if(objectCollision)
							sprite.setCollision(true);
					}
					break;
				case "right":
					try {
						spriteRightCol = (spriteRight + sprite.getSpeed()) / gamePanel.getTileSize();
						tile1 = gamePanel.tileManager.getMap()[spriteRightCol][spriteTopRow];
						tile2 = gamePanel.tileManager.getMap()[spriteRightCol][spriteBottomRow];
						if(gamePanel.tileManager.tileTypes[tile1].getCollision() || gamePanel.tileManager.tileTypes[tile2].getCollision() || spriteRight > gamePanel.getMapWidth())
							sprite.setCollision(true);
					} catch(Exception e) {
						sprite.setCollision(true);
					}
					if(spriteRight + sprite.getSpeed() > objectLeft && spriteRight + sprite.getSpeed() < objectRight && spriteBottom > objectTop && spriteTop < objectBottom) {
						objectCode = i;
						if(objectCollision)
							sprite.setCollision(true);
					}
					break;
				}
			}
		}
		return objectCode;
	}
}
