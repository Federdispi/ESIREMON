package application;

import sprite.Sprite;

public class CollisionDetector {
	
	GamePanel gamePanel;

	/*
	 * Constructor
	 */
	public CollisionDetector(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	/*
	 * Detects if a sprite has a collision with a tile or an object
	 */
	public int detectCollision(Sprite sprite) {
		int objectCode = -1; //Code to return
		
		//get every side of the sprite so that we can check the collision in every direction
		int spriteLeft = sprite.getX() + sprite.getHitBox().x;
		int spriteRight = sprite.getX() + sprite.getHitBox().x + sprite.getHitBox().width;
		int spriteTop = sprite.getY() + sprite.getHitBox().y;
		int spriteBottom = sprite.getY() + sprite.getHitBox().y + sprite.getHitBox().height;
		
		int spriteLeftCol = spriteLeft / gamePanel.TILE_SIZE;
		int spriteRightCol = spriteRight / gamePanel.TILE_SIZE;
		int spriteTopRow = spriteTop / gamePanel.TILE_SIZE;
		int spriteBottomRow = spriteBottom / gamePanel.TILE_SIZE;
		
		int tile1, tile2; //Tiles that we check
		
		/*
		 * Check the collision with a tile or an object and set the sprite collision attribute
		 */
		for(int i = 0; i < gamePanel.object.length; i++) {
			if(gamePanel.object[i][gamePanel.getMap()] != null) {
				int objectLeft = gamePanel.object[i][gamePanel.getMap()].getX();
				int objectRight = gamePanel.object[i][gamePanel.getMap()].getX() + gamePanel.object[i][gamePanel.getMap()].getWidth();
				int objectTop = gamePanel.object[i][gamePanel.getMap()].getY();
				int objectBottom = gamePanel.object[i][gamePanel.getMap()].getY() + gamePanel.object[i][gamePanel.getMap()].getHeight();
				boolean objectCollision = gamePanel.object[i][gamePanel.getMap()].getCollision();
				switch(sprite.getDirection()) {
				case "up":
					try {
						spriteTopRow = (spriteTop - sprite.getSpeed()) / gamePanel.TILE_SIZE;
						tile1 = gamePanel.tileManager.getMap()[spriteLeftCol][spriteTopRow][gamePanel.getMap()];
						tile2 = gamePanel.tileManager.getMap()[spriteRightCol][spriteTopRow][gamePanel.getMap()];
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
						spriteBottomRow = (spriteBottom + sprite.getSpeed()) / gamePanel.TILE_SIZE;
						tile1 = gamePanel.tileManager.getMap()[spriteLeftCol][spriteBottomRow][gamePanel.getMap()];
						tile2 = gamePanel.tileManager.getMap()[spriteRightCol][spriteBottomRow][gamePanel.getMap()];
						if(gamePanel.tileManager.tileTypes[tile1].getCollision() || gamePanel.tileManager.tileTypes[tile2].getCollision() || spriteBottom > gamePanel.MAP_HEIGHT)
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
						spriteLeftCol = (spriteLeft - sprite.getSpeed()) / gamePanel.TILE_SIZE;
						tile1 = gamePanel.tileManager.getMap()[spriteLeftCol][spriteTopRow][gamePanel.getMap()];
						tile2 = gamePanel.tileManager.getMap()[spriteLeftCol][spriteBottomRow][gamePanel.getMap()];
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
						spriteRightCol = (spriteRight + sprite.getSpeed()) / gamePanel.TILE_SIZE;
						tile1 = gamePanel.tileManager.getMap()[spriteRightCol][spriteTopRow][gamePanel.getMap()];
						tile2 = gamePanel.tileManager.getMap()[spriteRightCol][spriteBottomRow][gamePanel.getMap()];
						if(gamePanel.tileManager.tileTypes[tile1].getCollision() || gamePanel.tileManager.tileTypes[tile2].getCollision() || spriteRight > gamePanel.MAP_WIDTH)
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
		return objectCode; //returns the object code or -1 if there is not a collision with an object
	}
	
	/*
	 * Detects a sprite collision with a list of sprites
	 */
	public int detectSpritesCollision(Sprite sprite1, Sprite[][] sprite2) {
		int spriteCode = -1; //Sprite code to return
		
		//Checks the collision depending on which direction we are walking
		for(int i = 0; i < sprite2.length; i++) {
			if(gamePanel.npc[i][gamePanel.getMap()] != null && gamePanel.npc[i][gamePanel.getMap()] != sprite1) {
				sprite1.getHitBox().x = sprite1.getX() + sprite1.getHitBox().x;
				sprite1.getHitBox().y = sprite1.getY() + sprite1.getHitBox().y;
				
				sprite2[i][gamePanel.getMap()].getHitBox().x = sprite2[i][gamePanel.getMap()].getX() + sprite2[i][gamePanel.getMap()].getHitBox().x;
				sprite2[i][gamePanel.getMap()].getHitBox().y = sprite2[i][gamePanel.getMap()].getY() + sprite2[i][gamePanel.getMap()].getHitBox().y;
				
				switch(sprite1.getDirection()) {
				case "up":
					sprite1.getHitBox().y -= sprite1.getSpeed();
					if(sprite1.getHitBox().intersects(sprite2[i][gamePanel.getMap()].getHitBox())) {
						sprite1.setCollision(true);
						spriteCode = i;
					}
					break;
				case "down":
					sprite1.getHitBox().y += sprite1.getSpeed();
					if(sprite1.getHitBox().intersects(sprite2[i][gamePanel.getMap()].getHitBox())) {
						sprite1.setCollision(true);
						spriteCode = i;
					}
					break;
				case "left":
					sprite1.getHitBox().x -= sprite1.getSpeed();
					if(sprite1.getHitBox().intersects(sprite2[i][gamePanel.getMap()].getHitBox())) {
						sprite1.setCollision(true);
						spriteCode = i;
					}
					break;
				case "right":
					sprite1.getHitBox().x += sprite1.getSpeed();
					if(sprite1.getHitBox().intersects(sprite2[i][gamePanel.getMap()].getHitBox())) {
						sprite1.setCollision(true);
						spriteCode = i;
					}
				}
				sprite1.getHitBox().x = 8;
				sprite1.getHitBox().y = 16;
				sprite2[i][gamePanel.getMap()].getHitBox().x = 0;
				sprite2[i][gamePanel.getMap()].getHitBox().y = 0;
			}
		}
		
		return spriteCode; //returns the sprite code or -1 if there is not a collision with a sprite
	}
	
	/*
	 * Detects a collision between a sprite and another specific sprite
	 */
	public void detectSpriteCollision(Sprite sprite1, Sprite sprite2) {
		if(sprite2 == null)
			sprite2 = gamePanel.player;
		sprite1.getHitBox().x = sprite1.getX() + sprite1.getHitBox().x;
		sprite1.getHitBox().y = sprite1.getY() + sprite1.getHitBox().y;
		
		sprite2.getHitBox().x = sprite2.getX() + sprite2.getHitBox().x;
		sprite2.getHitBox().y = sprite2.getY() + sprite2.getHitBox().y;
		
		switch(sprite1.getDirection()) {
		case "up":
			sprite1.getHitBox().y -= sprite1.getSpeed();
			if(sprite1.getHitBox().intersects(sprite2.getHitBox())) {
				sprite1.setCollision(true);
			}
			break;
		case "down":
			sprite1.getHitBox().y += sprite1.getSpeed();
			if(sprite1.getHitBox().intersects(sprite2.getHitBox())) {
				sprite1.setCollision(true);
			}
			break;
		case "left":
			sprite1.getHitBox().x -= sprite1.getSpeed();
			if(sprite1.getHitBox().intersects(sprite2.getHitBox())) {
				sprite1.setCollision(true);
			}
			break;
		case "right":
			sprite1.getHitBox().x += sprite1.getSpeed();
			if(sprite1.getHitBox().intersects(sprite2.getHitBox())) {
				sprite1.setCollision(true);
			}
		}
		sprite1.getHitBox().x = sprite1.getHitBoxDefaultX();
		sprite1.getHitBox().y = sprite1.getHitBoxDefaultY();
		sprite2.getHitBox().x = sprite2.getHitBoxDefaultX();
		sprite2.getHitBox().y = sprite2.getHitBoxDefaultY();
	}
}
