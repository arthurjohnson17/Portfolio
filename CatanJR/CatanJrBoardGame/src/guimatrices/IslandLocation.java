package guimatrices;

public class IslandLocation {
	private int[][] island_loc = new int[12][2]; 
	public IslandLocation(){
		this.island_loc[0][0] = 11; 
		this.island_loc[0][1] = 29;
		
		this.island_loc[1][0] = 20; 
		this.island_loc[1][1] = 10;
		
		this.island_loc[2][0] = 21;  
		this.island_loc[2][1] = 43;
		
		this.island_loc[3][0] = 33; 
		this.island_loc[3][1] = 27;
		
		this.island_loc[4][0] = 42; 
		this.island_loc[4][1] = 10;
		
		this.island_loc[5][0] = 41;
		this.island_loc[5][1] = 46;
		
		this.island_loc[6][0] = 61; 
		this.island_loc[6][1] = 10;
		
		this.island_loc[7][0] = 61; 
		this.island_loc[7][1] = 46;
		
		this.island_loc[8][0] = 71; 
		this.island_loc[8][1] = 29;
		
		this.island_loc[9][0] = 81; 
		this.island_loc[9][1] = 12;
		
		this.island_loc[10][0] = 81; 
		this.island_loc[10][1] = 46;
		
		this.island_loc[11][0] = 91; 
		this.island_loc[11][1] = 27;
		
	}
	//	Input: Island ID, Output: Int - X Co-Ordinates of the Island 
	public int getIslandLocX(int ID) {
		return island_loc[ID][0];
	}
	//	Input: Island ID, Output: Int - Y Co-Ordinates of the Island 
	public int getIslandLocY(int ID) {
		return island_loc[ID][1];
	}
}
