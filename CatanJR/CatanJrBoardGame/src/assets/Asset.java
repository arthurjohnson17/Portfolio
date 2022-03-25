package assets;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;

import boardlayout.GameBoard;
import player.Player;

public abstract class Asset extends JButton implements ActionListener{
	
	protected static final boolean DEBUG = false;
	
	
	protected int ID;
	protected GameBoard gb;
	protected int owner_id;
	
	protected java.awt.event.MouseAdapter ml = new java.awt.event.MouseAdapter() {
	    public void mouseEntered(java.awt.event.MouseEvent evt) {
		       setOpaque(true);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	setOpaque(false);
		    }
		};
	
	public Asset(int id, GameBoard gb, int initial_id) {
		ID = id;
		this.gb = gb;
		owner_id = initial_id;
		this.addActionListener(this);
		this.setOpaque(false);
		this.hoverEffect();
		if (DEBUG) {
			System.out.println("WARNING: DEBUGGING IS ON! 		-Asset");
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
		if(this.getOwner() == -1) {
			this.addMouseListener(ml);
		}
		else {
			this.removeMouseListener(ml);
		}
	}
	
//	  Function   : getID 
//	   
//	  Description: Get the ID of the Asset 
//	   
//	  Parameters : n/a 
//	   
//	  Return     : The assets ID 
	public int getID() {
		return ID;
	}
	
//	  Function   : getOwner 
//	   
//	  Description: Get the owner's ID of the Asset 
//	   
//	  Parameters : n/a 
//	   
//	  Return     : The asset's owner's ID 
	public int getOwner() {
		return owner_id;
	}
	
//	  Function   : setOwner 
//	   
//	  Description: Changes or sets the owner's ID of the Asset' 
//	   
//	  Parameters : ID of the new Owner 
//	   
//	  Return     : n/a
	public abstract void setOwner(int new_owner);
	
//	  Function   : Build 
//	   
//	  Description: Seeing if the player meets the requirements to build 
//					this asset, then removes the resources needed from the player
//	   
//	  Parameters : Player trying to build the asset 
//	   
//	  Return     : The assets ID 
	public abstract void Build(Player player);
	

}
