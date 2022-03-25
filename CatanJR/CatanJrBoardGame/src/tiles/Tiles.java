package tiles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import boardlayout.GameBoard;
import market.MarketTiles;
import player.Player;

public class Tiles extends JButton implements ActionListener  {
	
	private GameBoard gb;
	private int tiles = 10;
	
	public Tiles(GameBoard gb){
		this.gb = gb;
		this.addActionListener(this);
	}
//	  Function   : buyTile 
//	   
//	  Description: Buys a tile for the current player. checks if they have
//					enough resources and if so removes those and gives a random tile.
//	   
//	  Parameters : n/a 
//	   
//	  Return     : The assets ID 
	public void buyTile() {
		Player player = gb.getPlayer();
		if(player.getResource(MarketTiles.GOLD)>0 && player.getResource(MarketTiles.CUTLASS)>0  && player.getResource(MarketTiles.MOLASSES)>0) {
			int tile_num = (int) ((Math.random() * (4 - 0)) + 0);
			switch(tile_num) {
			case 0:
				TilePopUp new_tile0 = new TilePopUp(0);
				gb.setGhostState(true);
				break;
			case 1:
				TilePopUp new_tile1 = new TilePopUp(1);
				gb.setFree(true);
				break;
			case 2:
				player.gainResource(MarketTiles.WOOD,2);
				player.gainResource(MarketTiles.MOLASSES,2);
				TilePopUp new_tile2 = new TilePopUp(2);
				break;
			case 3:
				player.gainResource(MarketTiles.GOATS,2);
				player.gainResource(MarketTiles.CUTLASS,2);
				TilePopUp new_tile3 = new TilePopUp(3);
				break;
			default:
				break;	
			}
			player.gainTile();
			player.loseResource(MarketTiles.GOLD,1);
			player.loseResource(MarketTiles.CUTLASS,1);
			player.loseResource(MarketTiles.MOLASSES,1);
			gb.setResourceDisplay();
			gb.setSpookyLair();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == this && tiles>0) {
			buyTile()
;		}
	}

}
