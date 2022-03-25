package resourcebank;

import market.MarketTiles;

public interface ResourceMover {
//	  Function   : getResource 
//	   
//	  Description: Get the resource type of inputed resource 
//	   
//	  Parameters : n/a 
//	   
//	  Return     : The resource type 
	public int getResource(MarketTiles resource);
	
//	  Function   : gainResource 
//	   
//	  Description: Adds specified amount of specified resource 
//	   
//	  Parameters : type of resource and amount gained 
//	   
//	  Return     : n/a 
	public void gainResource(MarketTiles type, int amount);
	
//	  Function   : loseResource 
//	   
//	  Description: lose specified amount of specified resource 
//	   
//	  Parameters : type of resource and amount lost 
//	   
//	  Return     : n/a 
	public void loseResource(MarketTiles type, int amount);
}
