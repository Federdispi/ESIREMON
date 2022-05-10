package application;

import sprite.Sprite;

public class CollisionDetector {
	
	GamePanel gamePanel;
	
	public CollisionDetector(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	public int detectCollision(Sprite sprite) {
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
				switch(sprite.getDirection()) {
				case "up":
					spriteTopRow = (spriteTop - sprite.getSpeed()) / gamePanel.getTileSize();
					tile1 = gamePanel.tileManager.getMap()[spriteLeftCol][spriteTopRow];
					tile2 = gamePanel.tileManager.getMap()[spriteRightCol][spriteTopRow];
					if(gamePanel.tileManager.tileTypes[tile1].getCollision() || gamePanel.tileManager.tileTypes[tile2].getCollision())
						sprite.setCollision(true);
					if(spriteTop - sprite.getSpeed() < objectBottom && spriteTop - sprite.getSpeed() > objectTop && spriteLeft > objectLeft && objectRight < objectRight)
						sprite.setCollision(true);
					break;
				case "down":
					spriteBottomRow = (spriteBottom + sprite.getSpeed()) / gamePanel.getTileSize();
					tile1 = gamePanel.tileManager.getMap()[spriteLeftCol][spriteBottomRow];
					tile2 = gamePanel.tileManager.getMap()[spriteRightCol][spriteBottomRow];
					if(gamePanel.tileManager.tileTypes[tile1].getCollision() || gamePanel.tileManager.tileTypes[tile2].getCollision())
						sprite.setCollision(true);
					if(spriteBottom + sprite.getSpeed() > objectTop && spriteLeft + sprite.getSpeed() < objectBottom && spriteLeft > objectLeft && spriteRight < objectRight)
						sprite.setCollision(true);
					break;
				case "left":
					spriteLeftCol = (spriteLeft - sprite.getSpeed()) / gamePanel.getTileSize();
					tile1 = gamePanel.tileManager.getMap()[spriteLeftCol][spriteTopRow];
					tile2 = gamePanel.tileManager.getMap()[spriteLeftCol][spriteBottomRow];
					if(gamePanel.tileManager.tileTypes[tile1].getCollision() || gamePanel.tileManager.tileTypes[tile2].getCollision())
						sprite.setCollision(true);
					if(spriteLeft - sprite.getSpeed() < objectRight && spriteLeft - sprite.getSpeed() > objectLeft && spriteTop > objectTop && spriteBottom < objectBottom)
							sprite.setCollision(true);
					break;
				case "right":
					spriteRightCol = (spriteRight + sprite.getSpeed()) / gamePanel.getTileSize();
					tile1 = gamePanel.tileManager.getMap()[spriteRightCol][spriteTopRow];
					tile2 = gamePanel.tileManager.getMap()[spriteRightCol][spriteBottomRow];
					if(gamePanel.tileManager.tileTypes[tile1].getCollision() || gamePanel.tileManager.tileTypes[tile2].getCollision())
						sprite.setCollision(true);
					if(spriteRight + sprite.getSpeed() > objectLeft && spriteRight + sprite.getSpeed() > objectRight && spriteTop > objectTop && spriteBottom < objectBottom)
						sprite.setCollision(true);
					break;
				}
			}
		}
		return -1;
	}
}
