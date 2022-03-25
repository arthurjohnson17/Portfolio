package functionMatrices;

public class IslandToLair {
	private int[][] lairs = new int[12][6]; 
	public IslandToLair(){
		this.lairs[0][0] = 0; 
		this.lairs[0][1] = 1;
		this.lairs[0][2] = 2; 
		this.lairs[0][3] = 3;
		this.lairs[0][4] = 4; 
		this.lairs[0][5] = 5;
		
		this.lairs[1][0] = 2; 
		this.lairs[1][1] = 4;
		this.lairs[1][2] = 6; 
		this.lairs[1][3] = 7;
		this.lairs[1][4] = -1; 
		this.lairs[1][5] = -1;

		this.lairs[2][0] = 3; 
		this.lairs[2][1] = 5;
		this.lairs[2][2] = 8; 
		this.lairs[2][3] = 9;
		this.lairs[2][4] = -1; 
		this.lairs[2][5] = -1;

		this.lairs[3][0] = 4; 
		this.lairs[3][1] = 5;
		this.lairs[3][2] = 7; 
		this.lairs[3][3] = 8;
		this.lairs[3][4] = 11; 
		this.lairs[3][5] = 12;
		
		this.lairs[4][0] = 6; 
		this.lairs[4][1] = 7;
		this.lairs[4][2] = 10; 
		this.lairs[4][3] = 11;
		this.lairs[4][4] = 14; 
		this.lairs[4][5] = 15;
		
		this.lairs[5][0] = 8; 
		this.lairs[5][1] = 9;
		this.lairs[5][2] = 12; 
		this.lairs[5][3] = 13;
		this.lairs[5][4] = 16; 
		this.lairs[5][5] = 17;
		
		this.lairs[6][0] = 14; 
		this.lairs[6][1] = 15;
		this.lairs[6][2] = 18; 
		this.lairs[6][3] = 19;
		this.lairs[6][4] = 22; 
		this.lairs[6][5] = 23;
		
		this.lairs[7][0] = 16; 
		this.lairs[7][1] = 17;
		this.lairs[7][2] = 20; 
		this.lairs[7][3] = 21;
		this.lairs[7][4] = 24; 
		this.lairs[7][5] = 25;
		
		this.lairs[8][0] = 19; 
		this.lairs[8][1] = 20;
		this.lairs[8][2] = 23; 
		this.lairs[8][3] = 24;
		this.lairs[8][4] = 26; 
		this.lairs[8][5] = 27;
		
		this.lairs[9][0] = 22; 
		this.lairs[9][1] = 23;
		this.lairs[9][2] = 26; 
		this.lairs[9][3] = 28;
		this.lairs[9][4] = -1; 
		this.lairs[9][5] = -1;
		
		this.lairs[10][0] = 24; 
		this.lairs[10][1] = 25;
		this.lairs[10][2] = 27; 
		this.lairs[10][3] = 29;
		this.lairs[10][4] = -1; 
		this.lairs[10][5] = -1;
		
		this.lairs[11][0] = 26; 
		this.lairs[11][1] = 27;
		this.lairs[11][2] = 28; 
		this.lairs[11][3] = 29;
		this.lairs[11][4] = 30; 
		this.lairs[11][5] = 31;
		
	}
	public int getLair(int x, int y) {
		return lairs[x][y];
	}
}
