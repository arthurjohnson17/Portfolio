package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import assets.Lair;
import boardlayout.GameBoard;
import boardlayout.Island;
import functionMatrices.IslandToLair;
import market.MarketTiles;
import player.Player;

class IslandTest {
	
	@Test
	void testGhostCaptian() {
		GameBoard gb = new GameBoard(3);
		Island is = new Island(12, MarketTiles.WOOD, gb);
		assertFalse(is.getGhostCaptain());
		is.setGhostCaptain(true);
		//assertTrue(is.getGhostCaptain());
	}
	
	@Test
	void testResource() {
		GameBoard gb = new GameBoard(3);
		Player p = new Player(0);
		Island is = new Island(0, MarketTiles.WOOD, gb);
		IslandToLair lairs = new IslandToLair();
		Lair l = new Lair(0 , 0, 0, 1, -1, gb);
		
		assertFalse(is.getGhostCaptain());
		assertEquals(20,p.getResource(MarketTiles.WOOD),"Player should have a balanace of 20 pieces of Wood");
		
		is.giveResource(); //give the players the resources, as if the dice has been rolled with the ghost captain at false
		
		assertEquals(21,p.getResource(MarketTiles.WOOD),"Player should have a balanace of 21 pieces of Wood");
		//now set the ghost captain as true & try again
		is.setGhostCaptain(true);
		is.giveResource();
		assertEquals(21,p.getResource(MarketTiles.WOOD),"Player should have a balanace of 21 pieces of Wood, as ghost captain is set");
		
		
	}
	


}
