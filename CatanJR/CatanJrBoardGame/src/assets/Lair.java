package assets;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import boardlayout.GameBoard;
import market.MarketTiles;
import player.Player;
public class Lair extends Asset {
	
	private int ship1;
	private int ship2;
	private int ship3;
	
	// ID => Lair ID No.
	// Initial_id => owner ID

	public Lair(int id, int initial_id, int ship1, int ship2, int ship3, GameBoard gb){
		super(id,gb, initial_id);
		this.ship1 = ship1;
		this.ship2 = ship2;
		this.ship3 = ship3;
	}

	// Implementing the Interface
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == this) {
			this.Build(gb.getPlayer());
		}	
	}
	
	@Override
	public void setOwner(int new_owner_id) {
		owner_id = new_owner_id;
		this.hoverEffect();
		switch (owner_id) {
		case 0:
			this.setIcon(gb.Iconscaler(new ImageIcon("resource_bank//CastleBlue.jpg"), this.getWidth(),this.getHeight()));
			this.setOpaque(true);
			break;
		case 1:
			this.setOpaque(true);
			this.setIcon(gb.Iconscaler(new ImageIcon("resource_bank//CastleGold.jpg"), this.getWidth(),this.getHeight()));
			break;
		case 2:
			this.setOpaque(true);
			this.setIcon(gb.Iconscaler(new ImageIcon("resource_bank//CastleRed.jpg"), this.getWidth(),this.getHeight()));
			break;
		case 3:
			this.setOpaque(true);
			this.setIcon(gb.Iconscaler(new ImageIcon("resource_bank//Castle.png"), this.getWidth(),this.getHeight()));
			break;
		default:
			this.setOpaque(false);
			break;
		}
	}
//	  Function   : Build
//	   
//	  Description: Build a lair if all necessary conditions are met
//	   
//	  Parameters : Player 
//	   
//	  Return     : n/a
	
	@Override
	public void Build(Player player){
		ShipLane s1 = gb.getShip(ship1);
		ShipLane s2 = gb.getShip(ship2);
		int s3 = 5;
		if(ship3 != -1) {
			ShipLane ss3 = gb.getShip(ship3);
			s3 = ss3.getOwner();
		}
		
		// Check if the player has enough resources to build, then check neighboring ships
		int id = player.getID();
		if ((s1.getOwner()==id || s2.getOwner()==id || s3==id ) && owner_id==-1 ) {
			if (gb.getFree()) {
				this.setOwner(player.getID());
				player.gainLair();
				gb.setFree(false);
			}
			else if (player.getResource(MarketTiles.WOOD)>0 && player.getResource(MarketTiles.GOATS)>0 
					&& player.getResource(MarketTiles.CUTLASS)>0 && player.getResource(MarketTiles.MOLASSES)>0) {
				player.loseResource(MarketTiles.WOOD,1);
				player.loseResource(MarketTiles.GOATS,1);
				player.loseResource(MarketTiles.CUTLASS,1);
				player.loseResource(MarketTiles.MOLASSES,1);
				this.setOwner(player.getID());
				player.gainLair();
			}
		}
	}

}