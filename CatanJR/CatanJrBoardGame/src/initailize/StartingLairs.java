package initailize;

public class StartingLairs {
	private int[][] start = new int[32][4]; 
	public StartingLairs(){
		//Player 1 starting Lairs
		this.start[0][0] = 9; 
		this.start[0][1] = 28;
		//Player 1 starting Ships
		this.start[0][2] = 9;
		this.start[0][3] = 35;
		
		//Player 2 starting Lairs
		this.start[1][0] = 3; 
		this.start[1][1] = 22;
		//Player 2 starting Ships
		this.start[1][2] = 4;
		this.start[1][3] = 30;
		
		//Player 3 starting Lairs
		this.start[2][0] = 6; 
		this.start[2][1] = 29;
		//Player 3 starting Ships
		this.start[2][2] = 8;
		this.start[2][3] = 36;
		
		//Player 4 starting Lairs
		this.start[3][0] = 2; 
		this.start[3][1] = 25;
		//Player 4 starting Ships
		this.start[3][2] = 3;
		this.start[3][3] = 31;
	}
	public int getLair1(int x) {
		return start[x][0];
	}
	public int getLair2(int x) {
		return start[x][1];
	}
	public int getShip1(int x) {
		return start[x][2];
	}
	public int getShip2(int x) {
		return start[x][3];
	}

}
