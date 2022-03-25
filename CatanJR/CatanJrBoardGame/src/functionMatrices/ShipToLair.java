package functionMatrices;

public class ShipToLair {
	private int[][] ship_lair = new int[40][2]; 
	public ShipToLair(){
		this.ship_lair[0][0] = 0; 
		this.ship_lair[0][1] = 1;
		
		this.ship_lair[1][0] = 0; 
		this.ship_lair[1][1] = 2;
		
		this.ship_lair[2][0] = 1;  
		this.ship_lair[2][1] = 3;
		
		this.ship_lair[3][0] = 2; 
		this.ship_lair[3][1] = 4;
		
		this.ship_lair[4][0] = 3; 
		this.ship_lair[4][1] = 5;
		
		this.ship_lair[5][0] = 4;
		this.ship_lair[5][1] = 5;
		
		this.ship_lair[6][0] = 4; 
		this.ship_lair[6][1] = 7;
		
		this.ship_lair[7][0] = 5; 
		this.ship_lair[7][1] = 8;
		
		this.ship_lair[8][0] = 6; 
		this.ship_lair[8][1] = 7;
		
		this.ship_lair[9][0] = 8; 
		this.ship_lair[9][1] = 9;
		
		this.ship_lair[10][0] = 6; 
		this.ship_lair[10][1] = 10;
		
		this.ship_lair[11][0] = 7; 
		this.ship_lair[11][1] = 11;
		
		this.ship_lair[12][0] = 8; 
		this.ship_lair[12][1] = 12;
		
		this.ship_lair[13][0] = 9; 
		this.ship_lair[13][1] = 13;
		
		this.ship_lair[14][0] = 11; 
		this.ship_lair[14][1] = 12;
		
		this.ship_lair[15][0] = 10;
		this.ship_lair[15][1] = 14;
		
		this.ship_lair[16][0] = 11; 
		this.ship_lair[16][1] = 15;
		
		this.ship_lair[17][0] = 12; 
		this.ship_lair[17][1] = 16;
		
		this.ship_lair[18][0] = 13; 
		this.ship_lair[18][1] = 17;
		
		this.ship_lair[19][0] = 14; 
		this.ship_lair[19][1] = 15;
		
		this.ship_lair[20][0] = 16; 
		this.ship_lair[20][1] = 17;
		
		this.ship_lair[21][0] = 14; 
		this.ship_lair[21][1] = 18;
		
		this.ship_lair[22][0] = 15; 
		this.ship_lair[22][1] = 19;
		
		this.ship_lair[23][0] = 16; 
		this.ship_lair[23][1] = 20;
		
		this.ship_lair[24][0] = 17; 
		this.ship_lair[24][1] = 21;
		
		this.ship_lair[25][0] = 19;
		this.ship_lair[25][1] = 20;
		
		this.ship_lair[26][0] = 18; 
		this.ship_lair[26][1] = 22;
		
		this.ship_lair[27][0] = 19; 
		this.ship_lair[27][1] = 23;
		
		this.ship_lair[28][0] = 20; 
		this.ship_lair[28][1] = 24;
		
		this.ship_lair[29][0] = 21; 
		this.ship_lair[29][1] = 25;
		
		this.ship_lair[30][0] = 22; 
		this.ship_lair[30][1] = 23;
		
		this.ship_lair[31][0] = 24; 
		this.ship_lair[31][1] = 25;
		
		this.ship_lair[32][0] = 23; 
		this.ship_lair[32][1] = 26;
		
		this.ship_lair[33][0] = 24; 
		this.ship_lair[33][1] = 27;
		
		this.ship_lair[34][0] = 26; 
		this.ship_lair[34][1] = 27;
		
		this.ship_lair[35][0] = 26;
		this.ship_lair[35][1] = 28;
		
		this.ship_lair[36][0] = 27; 
		this.ship_lair[36][1] = 29;
		
		this.ship_lair[37][0] = 28; 
		this.ship_lair[37][1] = 30;
		
		this.ship_lair[38][0] = 29; 
		this.ship_lair[38][1] = 31;
		
		this.ship_lair[39][0] = 30; 
		this.ship_lair[39][1] = 31;
		
	}
	public int getLair(int x, int y) {
		return ship_lair[x][y];
	}
}
