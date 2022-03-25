package guimatrices;

public class LairLocation {
	private int[][] lair_loc = new int[32][2]; 
	public LairLocation(){
		this.lair_loc[0][0] = 4; 
		this.lair_loc[0][1] = 24;
		
		this.lair_loc[1][0] = 4; 
		this.lair_loc[1][1] = 36;
		
		this.lair_loc[2][0] = 14;  
		this.lair_loc[2][1] = 18;
		
		this.lair_loc[3][0] = 14; 
		this.lair_loc[3][1] = 41;
		
		this.lair_loc[4][0] = 23; 
		this.lair_loc[4][1] = 24;
		
		this.lair_loc[5][0] = 23;
		this.lair_loc[5][1] = 36;
		
		this.lair_loc[6][0] = 33; 
		this.lair_loc[6][1] = 7;
		
		this.lair_loc[7][0] = 33; 
		this.lair_loc[7][1] = 18;
		
		this.lair_loc[8][0] = 33; 
		this.lair_loc[8][1] = 41;
		
		this.lair_loc[9][0] = 33; 
		this.lair_loc[9][1] = 52;
		
		this.lair_loc[10][0] = 42; 
		this.lair_loc[10][1] = 1;
		
		this.lair_loc[11][0] = 43; 
		this.lair_loc[11][1] = 24;
		
		this.lair_loc[12][0] = 43; 
		this.lair_loc[12][1] = 36;
		
		this.lair_loc[13][0] = 43; 
		this.lair_loc[13][1] = 57;
		
		this.lair_loc[14][0] = 52; 
		this.lair_loc[14][1] = 7;
		
		this.lair_loc[15][0] = 52;
		this.lair_loc[15][1] = 18;
		
		this.lair_loc[16][0] = 52; 
		this.lair_loc[16][1] = 40;
		
		this.lair_loc[17][0] = 52; 
		this.lair_loc[17][1] = 52;
		
		this.lair_loc[18][0] = 62; 
		this.lair_loc[18][1] = 1;
		
		this.lair_loc[19][0] = 62; 
		this.lair_loc[19][1] = 24;
		
		this.lair_loc[20][0] = 62; 
		this.lair_loc[20][1] = 36;
		
		this.lair_loc[21][0] = 62; 
		this.lair_loc[21][1] = 57;
		
		this.lair_loc[22][0] = 72; 
		this.lair_loc[22][1] = 7;
		
		this.lair_loc[23][0] = 72; 
		this.lair_loc[23][1] = 18;
		
		this.lair_loc[24][0] = 72; 
		this.lair_loc[24][1] = 40;
		
		this.lair_loc[25][0] = 72;
		this.lair_loc[25][1] = 52;
		
		this.lair_loc[26][0] = 81; 
		this.lair_loc[26][1] = 24;
		
		this.lair_loc[27][0] =81; 
		this.lair_loc[27][1] = 36;
		
		this.lair_loc[28][0] = 91; 
		this.lair_loc[28][1] = 18;
		
		this.lair_loc[29][0] = 91; 
		this.lair_loc[29][1] = 40;
		
		this.lair_loc[30][0] = 102; 
		this.lair_loc[30][1] = 24;
		
		this.lair_loc[31][0] = 102; 
		this.lair_loc[31][1] = 36;
		
		
	}
	public int getLairLocX(int x) {
		return lair_loc[x][0];
	}
	public int getLairLocY(int x) {
		return lair_loc[x][1];
	}
}
