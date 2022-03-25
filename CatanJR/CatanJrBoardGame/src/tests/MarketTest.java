package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import boardlayout.GameBoard;
import market.Market;
import market.MarketTiles;
import player.Player;

class MarketTest {
	
	@Test
	void testID() {
		GameBoard gb = new GameBoard(3);
		Market m = new Market(1,gb);
		
		assertEquals(1,m.getID(),"Check that the slot is the same as what was requested");
		
	}

	@Test
	void testValidResource() {
		GameBoard gb = new GameBoard(3);
		Market m = new Market(1,gb);
		
		assertTrue(m.checkValidResource(MarketTiles.CUTLASS));
		
	}
	
	@Test
	void testsetResource() {
		GameBoard gb = new GameBoard(3);
		Market m = new Market(1,gb);
		
		m.setResource(MarketTiles.MOLASSES);
		assertEquals(MarketTiles.MOLASSES, m.getResource());
		
	}

	@Test
	void testgetResource() {
		GameBoard gb = new GameBoard(3);
		Market m = new Market(1,gb);
		Player p = new Player(1);
		
		m.setResource(MarketTiles.MOLASSES);
		assertEquals(MarketTiles.MOLASSES, m.getResource());
		
	}
}
