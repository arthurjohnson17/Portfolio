package player;

import market.MarketTiles;
import resourcebank.ResourceMover;

//import catanjr.String; // Why is this necessary?

public class Player implements ResourceMover {
	//Setting the variable for the class
	private int ID;
	private int wood, cutlass, goat, molasses, gold;
	private int tiles;
	private int lairs = 2;
	
	//class constructor
	
	public Player(int id) {
		this.ID = id;
	};
		
//	  Function   : getID 
//	   
//	  Description: Get the ID of the Asset 
//	   
//	  Parameters : n/a 
//	   
//	  Return     : The assets ID 
	public int getID(){
		return this.ID; 
	}
	
//	  Function   : gainLair 
//	   
//	  Description: Adds a single lair to the player and checks if the player
//					has enough Lairs to win
//	   
//	  Parameters : n/a 
//	   
//	  Return     : n/a 	
	public void gainLair() {
		lairs++;
		System.out.println("Player " + ID);
		System.out.println("Lair:" + lairs);
		if (lairs == 7) {
			Winner winner = new Winner(ID);
		}
	}
	
//	  Function   : loseLair 
//	   
//	  Description: subtracts one lair from the player
//	   
//	  Parameters : n/a 
//	   
//	  Return     : n/a 	
	public void loseLair() {
		lairs--;
	}
	
	public int getResource(MarketTiles resource) {
		switch(resource) {
		case WOOD:
			return wood;
		case GOLD:
			return gold;
		case GOATS:
			return goat;
		case CUTLASS:
			return cutlass;
		case MOLASSES:
			return molasses;
		default:
			return 0;		
		}
	}
	
	public void gainResource(MarketTiles marketTiles, int amount) {
		switch(marketTiles) {
		case WOOD:
			wood += amount;
			break;
		case CUTLASS:
			cutlass += amount;
			break;
		case GOLD:
			gold += amount;
			break;
		case GOATS:
			goat += amount;
			break;
		case MOLASSES:
			molasses += amount;
			break;
		default:
			break;		
		}
	}
	
	public void loseResource(MarketTiles resource, int amount) {
		
		if(amount > getResource(resource)) {
			System.out.println("Error: You do not have enough resources");
			return;
		}
		else {
			switch(resource) {
				case WOOD:
					wood -= amount;
					break;
				case CUTLASS:
					cutlass -= amount;
					break;
				case GOLD:
					gold -= amount;
					break;
				case GOATS:
					goat -= amount;
					break;
				case MOLASSES:
					molasses -= amount;
					break;
				default:
					break;		
			}
		}
			
		
	}
	
//	  Function   : gainTile 
//	   
//	  Description: adds one tile to the player
//	   
//	  Parameters : n/a 
//	   
//	  Return     : The assets ID 
	public void gainTile() {
		tiles++;
	}
	
//	  Function   : getTiles 
//	   
//	  Description: Gets the number of tiles the player owns
//	   
//	  Parameters : n/a 
//	   
//	  Return     : Number of tiles the player owns 
	public int getTiles() { 
		return tiles;
	}
	
	
	public int getLair() { 
		return lairs;
	}
	
	
}