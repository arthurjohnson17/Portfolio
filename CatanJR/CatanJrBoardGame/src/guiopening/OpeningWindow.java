package guiopening;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class OpeningWindow extends JPanel
{
	
	public static boolean s = false;
	public OpeningWindow()
	{
		if(s == false){
			
			JFrame window = new JFrame();
			window.add(this);
			
			window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			window.setUndecorated(true);
			window.setVisible(true);
			try {
				Thread.sleep(3000);
				window.dispose();
				Menu m = new Menu();
			}catch(Exception e) {System.out.println(e);}
		}
	}
	
	public void paint(Graphics g)
	{
		ImageIcon background = new ImageIcon("images//junior.jpg");
		
		g.drawImage(background.getImage(),0,0,this.getWidth(), this.getHeight(),null);
	}
}
