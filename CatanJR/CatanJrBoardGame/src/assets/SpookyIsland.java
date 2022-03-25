package assets;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import boardlayout.GameBoard;
import player.Player;
public class SpookyIsland extends Asset {
	

	
	private boolean ghostCaptain;
	//private GameBoard gb;

	public SpookyIsland( GameBoard gb){
		super(0,gb,-1);
		this.addActionListener(this);
		this.gb = gb;
	}
public void setOwner(int new_owner){
	if(ghostCaptain==false) {
		owner_id=new_owner;
		this.hoverEffect();
		if (!DEBUG) {
			switch (owner_id) {
			case 0:
				this.setIcon(gb.Iconscaler(new ImageIcon("resource_bank//CastleBlue.jpg"), this.getWidth(), this.getHeight()));
				this.setOpaque(true);
				break;
			case 1:
				this.setOpaque(true);
				this.setIcon(gb.Iconscaler(new ImageIcon("resource_bank//CastleGold.jpg"), this.getWidth(), this.getHeight()));
				break;
			case 2:
				this.setOpaque(true);
				this.setIcon(gb.Iconscaler(new ImageIcon("resource_bank//CastleRed.jpg"), this.getWidth(), this.getHeight()));
				break;
			case 3:
				this.setOpaque(true);
				this.setIcon(gb.Iconscaler(new ImageIcon("resource_bank//Castle.png"), this.getWidth(), this.getHeight()));
				break;
			default:
				this.setIcon(null);
				this.setOpaque(false);
				break;
			}
		}
	}
}

//Function   : setGhostCaptain 
//
//Description: sets or changes the status of the ghost captain
//
//Parameters : the desired state for this ghost captain 
//
//Return     : The assets ID 
public void setGhostCaptain(boolean ghostCaptain) {
	this.ghostCaptain = ghostCaptain;
	if(ghostCaptain == true) {
		if (!DEBUG) {
			this.setIcon(gb.Iconscaler(new ImageIcon("resource_bank//GhostPirate.png"), this.getWidth(),this.getHeight()));
			this.setOpaque(true);
		}
	}
	else {
		gb.setSpookyLair();
	}
}

//Function   : getGhostCaptain 
//
//Description: gets the state of if the ghost captain is on the spooky Island
//
//Parameters : n/a 
//
//Return     : The state of the ghost Captain 
public boolean getGhostCaptain() {
	return ghostCaptain;
}


@Override
public void Build(Player player) {
	// TODO Auto-generated method stub
	
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}



}