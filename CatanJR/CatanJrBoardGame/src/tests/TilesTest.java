package tests;

import org.junit.jupiter.api.Test;

import boardlayout.GameBoard;
import player.Player;
import tiles.Tiles;

class TilesTest {

	@Test
	void test() {
		GameBoard gb = new GameBoard(3);
		Tiles t = new Tiles(gb);
		Player p = new Player(1);
		
		t.buyTile();
		
		
	}

}
