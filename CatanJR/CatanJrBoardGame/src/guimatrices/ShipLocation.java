package guimatrices;

public class ShipLocation {
	private int[][] ship_loc = new int[40][2]; 
	public ShipLocation(){
		this.ship_loc[0][0] = 4; 
		this.ship_loc[0][1] = 30;
		
		this.ship_loc[1][0] = 9; 
		this.ship_loc[1][1] = 21;
		
		this.ship_loc[2][0] = 9;  
		this.ship_loc[2][1] = 39;
		
		this.ship_loc[3][0] = 18; 
		this.ship_loc[3][1] = 21;
		
		this.ship_loc[4][0] = 18;  
		this.ship_loc[4][1] = 39;
		
		this.ship_loc[5][0] = 23; 
		this.ship_loc[5][1] = 30;
		
		this.ship_loc[6][0] = 28; 
		this.ship_loc[6][1] = 21;
		
		this.ship_loc[7][0] = 28; 
		this.ship_loc[7][1] = 39;
		
		this.ship_loc[8][0] = 33; 
		this.ship_loc[8][1] = 12;
		
		this.ship_loc[9][0] = 33; 
		this.ship_loc[9][1] = 46;
		
		this.ship_loc[10][0] = 37; 
		this.ship_loc[10][1] = 4;
		
		this.ship_loc[11][0] = 37; 
		this.ship_loc[11][1] = 21;
		
		this.ship_loc[12][0] = 37; 
		this.ship_loc[12][1] = 39;
		
		this.ship_loc[13][0] = 37; 
		this.ship_loc[13][1] = 54;
		
		this.ship_loc[14][0] = 42; 
		this.ship_loc[14][1] = 30;
		
		this.ship_loc[15][0] = 47;
		this.ship_loc[15][1] = 4;
		
		this.ship_loc[16][0] = 47; 
		this.ship_loc[16][1] = 21;
		
		this.ship_loc[17][0] = 47; 
		this.ship_loc[17][1] = 39;
		
		this.ship_loc[18][0] = 47; 
		this.ship_loc[18][1] = 54;
		
		this.ship_loc[19][0] = 52; 
		this.ship_loc[19][1] = 12;
		
		this.ship_loc[20][0] = 52; 
		this.ship_loc[20][1] = 46;
		
		this.ship_loc[21][0] = 57; 
		this.ship_loc[21][1] = 4;
		
		this.ship_loc[22][0] = 57; 
		this.ship_loc[22][1] = 21;
		
		this.ship_loc[23][0] = 57; 
		this.ship_loc[23][1] = 39;
		
		this.ship_loc[24][0] = 57; 
		this.ship_loc[24][1] = 54;
		
		this.ship_loc[25][0] = 62;
		this.ship_loc[25][1] = 30;
		
		this.ship_loc[26][0] = 67; 
		this.ship_loc[26][1] = 4;
		
		this.ship_loc[27][0] = 67; 
		this.ship_loc[27][1] = 21;
		
		this.ship_loc[28][0] = 67; 
		this.ship_loc[28][1] = 39;
		
		this.ship_loc[29][0] = 67; 
		this.ship_loc[29][1] = 54;
		
		this.ship_loc[30][0] = 72; 
		this.ship_loc[30][1] = 12;
		
		this.ship_loc[31][0] = 72; 
		this.ship_loc[31][1] = 46;
		
		this.ship_loc[32][0] = 77; 
		this.ship_loc[32][1] = 21;
		
		this.ship_loc[33][0] = 77; 
		this.ship_loc[33][1] = 39;
		
		this.ship_loc[34][0] = 81; 
		this.ship_loc[34][1] = 30;
		
		this.ship_loc[35][0] = 87;
		this.ship_loc[35][1] = 21;
		
		this.ship_loc[36][0] = 87; 
		this.ship_loc[36][1] = 39;
		
		this.ship_loc[37][0] = 97; 
		this.ship_loc[37][1] = 21;
		
		this.ship_loc[38][0] = 97; 
		this.ship_loc[38][1] = 39;
		
		this.ship_loc[39][0] = 102; 
		this.ship_loc[39][1] = 30;
		
	}
	public int getShipLocX(int x) {
		return ship_loc[x][0];
	}
	public int getShipLocY(int x) {
		return ship_loc[x][1];
	}
}
