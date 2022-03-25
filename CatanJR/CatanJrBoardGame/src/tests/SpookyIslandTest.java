package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import assets.SpookyIsland;
import boardlayout.GameBoard;
import guiopening.OpeningWindow;


class SpookyIslandTest {
	
	//Testing the spooky Island Functionality

	@Test
	void test() {
		GameBoard gb = new GameBoard(3);
		SpookyIsland spookis = new SpookyIsland(gb);
		
		assertFalse(spookis.getGhostCaptain());
		spookis.setGhostCaptain(true);
		assertTrue(spookis.getGhostCaptain());
		
		spookis.setGhostCaptain(false);
		spookis.setOwner(1);
		assertEquals(1,spookis.getOwner(),"Owner should be set to 1");
		 
		spookis.setGhostCaptain(true);
		spookis.setOwner(2);
		assertEquals(1,spookis.getOwner(),"Owner should be 1, as ghost captain activt");
	}

}
