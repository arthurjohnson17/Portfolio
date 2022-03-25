package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import market.MarketTiles;
import player.Player;

class PlayerTest {

	@Test
	void testLairs() {
		Player p = new Player(1);
		
		assertEquals(1,p.getID());
		assertEquals(20, p.getResource(MarketTiles.WOOD));  
		
		p.gainLair();
		assertEquals(3,p.getLair());
		
		p.loseLair();
		assertEquals(2,p.getLair());
		
	}
	
	
	
	@Test //Check the Resource Allocation Methods
	void testResources() {
		Player p = new Player(3);
		
		p.gainResource(MarketTiles.CUTLASS,2);
		assertEquals(22,p.getResource(MarketTiles.CUTLASS));
		
		p.loseResource(MarketTiles.CUTLASS,7);
		assertEquals(15,p.getResource(MarketTiles.CUTLASS));
		
		p.loseResource(MarketTiles.CUTLASS,16); //Check to see if you can remove more resources than the player has
		
		p.loseResource(MarketTiles.CUTLASS,12);
		assertEquals(3,p.getResource(MarketTiles.CUTLASS));
		
	}
	 
	
	@Test
	void testTiles() {
		Player p = new Player(1);
		p.gainTile();
		assertEquals(1,p.getTiles());
		
	}

}
