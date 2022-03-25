package assets;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import boardlayout.GameBoard;
import market.MarketTiles;
import player.Player;


public class ShipLane extends Asset{
	
	private int lair1;
	private int lair2;

	public ShipLane(int id, int initial_id, int lair1, int lair2, GameBoard gb){
		super(id,gb,initial_id);
		this.lair1 = lair1;
		this.lair2 = lair2;
	}
	
	@Override
	public void Build(Player player){
		Lair l1 = gb.getLair(lair1);
		Lair l2 = gb.getLair(lair2);
		int id = player.getID();
		if ((l1.getOwner()==id || l2.getOwner()==id) && owner_id==-1 ) {
			if (gb.getFree()) {
				this.setOwner(player.getID());
				gb.setFree(false);
			}
			else if (player.getResource(MarketTiles.WOOD)>0 
					&& player.getResource(MarketTiles.GOATS)>0) {
				player.loseResource(MarketTiles.WOOD,1);
				player.loseResource(MarketTiles.GOATS,1);
				this.setOwner(player.getID());
			}
		}
	}
	
	@Override
	public void setOwner(int new_owner_id) {
			owner_id = new_owner_id;
			this.hoverEffect();
			switch (owner_id) {
			case 0:
				this.setIcon(gb.Iconscaler(new ImageIcon("resource_bank//ShipBlue.jpg"), this.getWidth(),this.getHeight()));
				this.setOpaque(true);
				break;
			case 1:
				this.setOpaque(true);
				this.setIcon(gb.Iconscaler(new ImageIcon("resource_bank//ShipGold.jpg"), this.getWidth(),this.getHeight()));
				break;
			case 2:
				this.setOpaque(true);
				this.setIcon(gb.Iconscaler(new ImageIcon("resource_bank//ShipRed.jpg"), this.getWidth(),this.getHeight()));
				break;
			case 3:
				this.setOpaque(true);
				this.setIcon(gb.Iconscaler(new ImageIcon("resource_bank//PirateShip.png"), this.getWidth(),this.getHeight()));
				break;
			default:
				this.setOpaque(false);
				break;
			}
		}

@Override
public void actionPerformed(ActionEvent ae) {
	if(ae.getSource() == this) {
		this.Build(gb.getPlayer());
	}
	
}
}