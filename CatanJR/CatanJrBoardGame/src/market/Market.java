package market;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import boardlayout.GameBoard;
import guiopening.MarketPopUp;

public class Market extends JButton implements ActionListener{
	
	protected static final boolean DEBUG = false;
	
	private static final long serialVersionUID = 2493083623968109035L;
	private int ID;
	private MarketTiles resource;
	private GameBoard gb;
	
	
	public Market (int number, GameBoard gb) {
		this.addActionListener(this);
		this.gb=gb;
		ID = number;
		setBackground(Color.white);
		//setResource(resource);
		
		if (DEBUG) System.out.println("WARNING: DEBUGGING IS ON! 		-Market");
	}
	
//	  Function   : checkValidResource 
//	   
//	  Description: check to make sure the resource being used is a valid one
//	   
//	  Parameters : resource being checked
//	   
//	  Return     : true if resource valid, false if otherwise 	
	public boolean checkValidResource(MarketTiles type){
		if (type.equals(MarketTiles.WOOD) || type.equals(MarketTiles.CUTLASS) || type.equals(MarketTiles.GOLD) || type.equals(MarketTiles.GOATS) || type.equals(MarketTiles.MOLASSES)){
		   	return true;
		}
		else {
			return false;
		}
	}

//	  Function   : setResource 
//	   
//	  Description: sets the resource of the market place slot
//	   
//	  Parameters : resource type
//	   
//	  Return     : n/a 
	public void setResource(MarketTiles type) {
		resource = type;
		if(! checkValidResource(resource)) {
			System.out.println("Sorry Invalid resource!");
		}
		if(!DEBUG) {
			switch(type) {
				case WOOD:
					this.setIcon(gb.Iconscaler(new ImageIcon("resource_bank//wood.png"), this.getWidth(),this.getHeight()));
					break;
				case CUTLASS:
					this.setIcon(gb.Iconscaler(new ImageIcon("resource_bank//cutlass.jpg"), this.getWidth(),this.getHeight()));
					break;
				case GOLD:
					this.setIcon(gb.Iconscaler(new ImageIcon("resource_bank//gold.jpg"), this.getWidth(),this.getHeight()));
					break;
				case GOATS:
					this.setIcon(gb.Iconscaler(new ImageIcon("resource_bank//goat.png"), this.getWidth(),this.getHeight()));
					break;
				case MOLASSES:
					this.setIcon(gb.Iconscaler(new ImageIcon("resource_bank//molasses.jpg"), this.getWidth(),this.getHeight()));
					break;
				default:
					this.setBackground(Color.darkGray);
					this.setOpaque(true);
				break;
			}
		}
	}
	
//	  Function   : getResource 
//	   
//	  Description: gets the resource of the market place slot
//	   
//	  Parameters : n/a
//	   
//	  Return     : the resource type of the market slot
	public MarketTiles getResource() { 
		return	resource;	
	}

//	  Function   : getID 
//	   
//	  Description: gets the ID of the market place slot
//	   
//	  Parameters : n/a
//	   
//	  Return     : the ID of the market slot
	public int getID() {
		return ID;
	}
	
//	  Function   : marketTrade 
//	   
//	  Description: opens the market place options
//	   
//	  Parameters : n/a
//	   
//	  Return     : n/a
	public void marketTrade(){
		MarketPopUp popup = new MarketPopUp(this,gb);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==this && gb.getMarketTrade() == false ) {
			marketTrade();
			gb.setMarketTrade(true);
	}
	
	}

}