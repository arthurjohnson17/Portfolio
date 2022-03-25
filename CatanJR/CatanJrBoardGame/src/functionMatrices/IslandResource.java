package functionMatrices;

import market.MarketTiles;

//sets whihch type of resource each island has.

public class IslandResource {
	private MarketTiles[] resource = new MarketTiles[12]; 
	public IslandResource(){
		this.resource[0] = MarketTiles.WOOD; 
		this.resource[1] = MarketTiles.CUTLASS;
		this.resource[2] = MarketTiles.CUTLASS; 
		this.resource[3] = MarketTiles.GOLD;
		this.resource[4] = MarketTiles.WOOD; 
		this.resource[5] = MarketTiles.WOOD;
		this.resource[6] = MarketTiles.GOATS; 
		this.resource[7] = MarketTiles.GOATS;
		this.resource[8] = MarketTiles.GOLD; 
		this.resource[9] = MarketTiles.MOLASSES;
		this.resource[10] = MarketTiles.MOLASSES;
		this.resource[11] = MarketTiles.GOATS;

	}
	public MarketTiles getResource(int x) {
		return resource[x];
	}
}
