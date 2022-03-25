package market;

public class MarketLocation {
	private int[][] market_loc = new int[5][2]; 
	public MarketLocation(){
		this.market_loc[0][0] = 105; 
		this.market_loc[0][1] = 3;
		
		this.market_loc[1][0] = 112; 
		this.market_loc[1][1] = 17;
		
		this.market_loc[2][0] = 114;  
		this.market_loc[2][1] = 30;
		
		this.market_loc[3][0] = 112; 
		this.market_loc[3][1] = 46;
		
		this.market_loc[4][0] = 105; 
		this.market_loc[4][1] = 53;
		
		
		
	}
	public int getMarketLocX(int ID) {
		return market_loc[ID][0];
	}
	public int getMarketLocY(int ID) {
		return market_loc[ID][1];
	}
}
