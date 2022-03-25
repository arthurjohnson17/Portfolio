package functionMatrices;
// Array For the connections between adjacent Lairs to Ships

public class LairToShip {
	private int[][] lair_ship = new int[32][3];

	// Constructor
	public LairToShip() {
		this.lair_ship[0][0] = 0;
		this.lair_ship[0][1] = 1;
		this.lair_ship[0][2] = -1;

		this.lair_ship[1][0] = 0;
		this.lair_ship[1][1] = 2;
		this.lair_ship[1][2] = -1;

		this.lair_ship[2][0] = 1;
		this.lair_ship[2][1] = 3;
		this.lair_ship[2][2] = -1;

		this.lair_ship[3][0] = 2;
		this.lair_ship[3][1] = 4;
		this.lair_ship[3][2] = -1;

		this.lair_ship[4][0] = 3;
		this.lair_ship[4][1] = 5;
		this.lair_ship[4][2] = 6;

		this.lair_ship[5][0] = 4;
		this.lair_ship[5][1] = 5;
		this.lair_ship[5][2] = 7;

		this.lair_ship[6][0] = 8;
		this.lair_ship[6][1] = 10;
		this.lair_ship[6][2] = -1;

		this.lair_ship[7][0] = 6;
		this.lair_ship[7][1] = 8;
		this.lair_ship[7][2] = 11;

		this.lair_ship[8][0] = 7;
		this.lair_ship[8][1] = 9;
		this.lair_ship[8][2] = 12;

		this.lair_ship[9][0] = 9;
		this.lair_ship[9][1] = 13;
		this.lair_ship[9][2] = -1;

		this.lair_ship[10][0] = 10;
		this.lair_ship[10][1] = 15;
		this.lair_ship[10][2] = -1;

		this.lair_ship[11][0] = 11;
		this.lair_ship[11][1] = 14;
		this.lair_ship[11][2] = 16;

		this.lair_ship[12][0] = 12;
		this.lair_ship[12][1] = 14;
		this.lair_ship[12][2] = 17;

		this.lair_ship[13][0] = 13;
		this.lair_ship[13][1] = 18;
		this.lair_ship[13][2] = -1;

		this.lair_ship[14][0] = 15;
		this.lair_ship[14][1] = 19;
		this.lair_ship[14][2] = 21;

		this.lair_ship[15][0] = 16;
		this.lair_ship[15][1] = 19;
		this.lair_ship[15][2] = 22;

		this.lair_ship[16][0] = 17;
		this.lair_ship[16][1] = 20;
		this.lair_ship[16][2] = 23;

		this.lair_ship[17][0] = 18;
		this.lair_ship[17][1] = 20;
		this.lair_ship[17][2] = 24;

		this.lair_ship[18][0] = 21;
		this.lair_ship[18][1] = 26;
		this.lair_ship[18][2] = -1;

		this.lair_ship[19][0] = 22;
		this.lair_ship[19][1] = 25;
		this.lair_ship[19][2] = 27;

		this.lair_ship[20][0] = 23;
		this.lair_ship[20][1] = 25;
		this.lair_ship[20][2] = 28;

		this.lair_ship[21][0] = 24;
		this.lair_ship[21][1] = 29;
		this.lair_ship[21][2] = -1;

		this.lair_ship[22][0] = 26;
		this.lair_ship[22][1] = 30;
		this.lair_ship[22][2] = -1;

		this.lair_ship[23][0] = 27;
		this.lair_ship[23][1] = 30;
		this.lair_ship[23][2] = 32;

		this.lair_ship[24][0] = 28;
		this.lair_ship[24][1] = 31;
		this.lair_ship[24][2] = 33;

		this.lair_ship[25][0] = 29;
		this.lair_ship[25][1] = 31;
		this.lair_ship[25][2] = -1;

		this.lair_ship[26][0] = 32;
		this.lair_ship[26][1] = 34;
		this.lair_ship[26][2] = 35;

		this.lair_ship[27][0] = 33;
		this.lair_ship[27][1] = 34;
		this.lair_ship[27][2] = 36;

		this.lair_ship[28][0] = 35;
		this.lair_ship[28][1] = 37;
		this.lair_ship[28][1] = -1;

		this.lair_ship[29][0] = 36;
		this.lair_ship[29][1] = 38;
		this.lair_ship[29][2] = -1;

		this.lair_ship[30][0] = 37;
		this.lair_ship[30][1] = 39;
		this.lair_ship[30][2] = -1;

		this.lair_ship[31][0] = 38;
		this.lair_ship[31][1] = 39;
		this.lair_ship[31][2] = -1;

	}

	// Input: X = Lair ID. and Y Adjacent Ship Placeholder, Output: -1 indicates no
	// Ship is adjacent to the lair, otherwise returns the SHip's ID
	public int getShip(int x, int y) {
		return lair_ship[x][y];
	}
}
