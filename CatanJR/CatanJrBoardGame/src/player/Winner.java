package player;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Winner extends JPanel
{
	JFrame window = new JFrame();
	
	JTextField win = new JTextField();

	

	
	Winner(int player)
	{	
		int winner = player+1;
		win.setText("Congratulations Player " + winner +" is the WINNER!");
		win.setEditable(false);
		
		window.add(this);
		window.add(win);
		window.setBounds(0, 50,800,500);
		window.setUndecorated(true);
		window.setVisible(true);
	}
	
}