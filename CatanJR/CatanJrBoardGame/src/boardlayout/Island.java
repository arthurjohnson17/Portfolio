package boardlayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import assets.Lair;
import functionMatrices.IslandToLair;
import market.MarketTiles;
import player.Player;
import resourcebank.ResourceBank;

public class Island extends JButton implements ActionListener{
	
	protected static final boolean DEBUG = false;
	
	private int ID;
	private boolean ghostCaptain;
	private MarketTiles resource;
	private GameBoard gb;
	
	private IslandToLair lairs = new IslandToLair();
	
	private java.awt.event.MouseAdapter ml = new java.awt.event.MouseAdapter() {
	    public void mouseEntered(java.awt.event.MouseEvent evt) {
		       setOpaque(true);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	setOpaque(false);
		    }
		};
	
	
	public Island (int number, MarketTiles type, GameBoard gb) {
		this.addActionListener(this);
		this.gb=gb;
		this.setOpaque(false);
		ID = number;
		setGhostCaptain(false);
		resource = type;
		this.hoverEffect();
		if(! checkValidResource(resource)) {
			System.out.println("Sorry Invalid resource!");
		}
		
		
		if(DEBUG) System.out.println("WARNING:DEBUGGING IS ON! 		-Island");
	}
	
//	  Function   : checkValidResource 
//	   
//	  Description: check to make sure the resource being used is a valid one
//	   
//	  Parameters : resource being checked
//	   
//	  Return     : true if resource valid, false if otherwise 
	boolean checkValidResource(MarketTiles resource2){
		if (resource2.equals(MarketTiles.WOOD) || resource2.equals(MarketTiles.CUTLASS) || resource2.equals(MarketTiles.GOLD) || resource2.equals(MarketTiles.GOATS) || resource2.equals(MarketTiles.MOLASSES)){
		   	return true;
		}
		else {
			return false;
		}
	}

//	  Function   : getID 
//	   
//	  Description: Get the ID of the Island 
//	   
//	  Parameters : n/a 
//	   
//	  Return     : The Islands ID 
	public int getID() {
		return ID;
	}

//	  Function   : getGhostCaptain 
//	   
//	  Description: Finds if the ghost captain is on this Island 
//	   
//	  Parameters : n/a 
//	   
//	  Return     : True if the ghost captain is on this Island, false if otherwise 
	public boolean getGhostCaptain() {
		return ghostCaptain;
	}

//	  Function   : setGhostCaptain 
//	   
//	  Description: changes the state of the ghost captain, i.e either moves it
//					it to or from the island
//	   
//	  Parameters : Desired state of the ghost captain
//	   
//	  Return     : n/a
	public void setGhostCaptain(boolean ghostCaptain) {
		this.ghostCaptain = ghostCaptain;
		this.hoverEffect();
		if(ghostCaptain == true) {
			if (!DEBUG) {
				this.setIcon(gb.Iconscaler(new ImageIcon("resource_bank//GhostPirate.png"), this.getWidth(),this.getHeight()));
				this.setOpaque(true);
			}
			Player player = gb.getPlayer();
			player.gainResource(resource, 2);
			ResourceBank rb = gb.getBank();
			rb.loseResource(resource,2);
		}
		else {
			this.setIcon(null);
			this.setOpaque(false);
		}
	}
	
//	  Function   : giveResource 
//	   
//	  Description: Gives the islands resource to the adjacent Lairs
//	   
//	  Parameters : n/a 
//	   
//	  Return     : The assets ID 
	public void giveResource() {
		if(ghostCaptain == false) {
			for(int i=0; i<6; i++) {
				int l_id = lairs.getLair(ID, i);
				if(l_id != -1) {				
					Lair l = gb.getLair(l_id);
					if(l.getOwner() != -1) {
						Player player = gb.getPlayer(l.getOwner());
						player.gainResource(resource, 1);
						ResourceBank rb = gb.getBank();
						rb.loseResource(resource,1);
					}
				}
			}
		}
	}
	
//	  Function   : hoverEffect 
//	   
//	  Description: makes the Asset visible when the mouse hovers over it
//	   
//	  Parameters : component the effect is being added to
//	   
//	  Return     : n/a
	public void hoverEffect() {
		if(this.getGhostCaptain() == false) {
			this.addMouseListener(ml);
		}
		else {
			this.removeMouseListener(ml);
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == this && gb.getGhostState() == true ) {
			if(ghostCaptain == false) {
				gb.clearGhosts();
				this.setGhostCaptain(true);
				gb.setGhostState(false);
				gb.setResourceDisplay();
			}
		}
	}
	


}