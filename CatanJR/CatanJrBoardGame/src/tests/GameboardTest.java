package tests;


import org.junit.jupiter.api.Test;

import boardlayout.GameBoard;
import player.Player;

class GameboardTest {

	@Test
	void test() {
		GameBoard gb = new GameBoard(3);
		Player p1 = new Player(1);
		
		System.out.println(gb.getPlayer(1));
		
	}

}
