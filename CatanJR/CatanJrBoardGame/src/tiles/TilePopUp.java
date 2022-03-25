package tiles;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TilePopUp extends JPanel
{
	JFrame window = new JFrame();
	
	JTextField[] tile = new JTextField[4];
	JTextField tile1 = new JTextField("Immediately move the Ghost Captain to a new island as if you had rolled a 6");
	JTextField tile2 = new JTextField("Immediately build a pirates� lair or a ship for free");
	JTextField tile3 = new JTextField("Immediately receive 2 molasses and 2 wood from the stockpile");
	JTextField tile4 = new JTextField("Immediately receive 2 goat and 2 cutlass from the stockpile");
	

	
	TilePopUp(int tile_num)
	{
		tile[0] = new JTextField("Immediately move the Ghost Captain to a new island as if you had rolled a 6");
		tile[1] = new JTextField("Immediately build a pirates� lair or a ship for free");
		tile[2] = new JTextField("Immediately receive 2 molasses and 2 wood from the stockpile");
		tile[3] = new JTextField("Immediately receive 2 goat and 2 cutlass from the stockpile");
		
		
		window.add(this);
		window.add(tile[tile_num]);
		window.setBounds(0, 50,500,100);
		window.setUndecorated(false);
		window.setVisible(true);
	}
	
}