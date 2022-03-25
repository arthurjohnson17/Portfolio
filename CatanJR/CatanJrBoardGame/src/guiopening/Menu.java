package guiopening;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import boardlayout.GameBoard;

public class Menu extends JPanel implements ActionListener, KeyListener {
	private JFrame window = new JFrame();
	
	private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	private int width = (int)screen.getWidth();
	private int height = (int)screen.getHeight();

	private JButton playButton = new JButton();
	private JButton exitButton = new JButton();
	
	private JRadioButton p3 = new JRadioButton("3 Players");
	private JRadioButton p4 = new JRadioButton("4 Players");
	
	private ButtonGroup group = new ButtonGroup();
	
	private JTextField choose_players = new JTextField("Choose number of players:");
	
	private JTextField player_blue = new JTextField("Player 1 : BLUE");
	private JTextField player_orange = new JTextField("Player 2 : ORANGE");
	private JTextField player_red = new JTextField("Player 3 : RED");
	private JTextField player_white = new JTextField("Player 4 : WHITE");
	private int players = 4;
	
    
	Menu() {
		window.add(this);
		window.setLayout(null);
		
		group.add(p3);
		p3.addActionListener(this);
		p3.setBounds(width*1/2-width/10, height/4, width/10, width/50);
		window.add(p3);
		
		group.add(p4);
		p4.addActionListener(this);
		p4.setBounds(width*1/2, height/4, width/10, width/50);
		window.add(p4);
		
		choose_players.setBounds(width*1/2-width/10, height/4-width/50, width/5, width/50);
		choose_players.setEditable(false);
		window.add(choose_players);
		
		player_blue.setBounds(width*1/2-width/10, height/4+width/50, width/5, width/50);
		player_blue.setEditable(false);
		window.add(player_blue);
		
		player_orange.setBounds(width*1/2-width/10, height/4+(width*2)/50, width/5, width/50);
		player_orange.setEditable(false);
		window.add(player_orange);
		
		player_red.setBounds(width*1/2-width/10, height/4+(width*3)/50, width/5, width/50);
		player_red.setEditable(false);
		window.add(player_red);
		
		player_white.setBounds(width*1/2-width/10, height/4+(width*4)/50, width/5, width/50);
		player_white.setEditable(false);
		window.add(player_white);
		
		playButton.setBackground(Color.cyan); 
		playButton.setIcon(new ImageIcon("images//play.png")); 
		playButton.addActionListener(this);
		playButton.addKeyListener(this); 
		playButton.setBounds(width*1/5, height/2, width/5, width/5);
		playButton.setForeground(Color.BLUE);
		window.add(playButton);
		  
		exitButton.setBackground(Color.cyan); 
		exitButton.setForeground(Color.yellow);
		exitButton.setIcon(new ImageIcon("images//exit.png")); 
		exitButton.addActionListener(this);
		exitButton.addKeyListener(this); 
		exitButton.setBounds(width*3/5, height/2, width/5, width/5);
		exitButton.setBorderPainted(true);
		exitButton.setBorder(new LineBorder(Color.BLUE));
		window.add(exitButton);
				 
		ImageIcon icon = Iconscaler(new ImageIcon("images//board_num.jpg"),width,height);
		JLabel background = new JLabel("",icon,JLabel.CENTER);
		background.setBounds(0,0,width,height);
		window.add(background);

		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setUndecorated(true);
		window.setVisible(true);
	}
	public ImageIcon Iconscaler(ImageIcon icon, int w, int h) {
		Image img = icon.getImage() ;  
		Image newimg = img.getScaledInstance( w, h,  java.awt.Image.SCALE_SMOOTH ) ;  
		return new ImageIcon( newimg );
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent kp) {
		if(kp.getKeyCode()==KeyEvent.VK_ESCAPE) {
			window.dispose();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == exitButton)
			window.dispose();
		if(ae.getSource() == playButton) {
			try {
				window.dispose();
				GameBoard m = new GameBoard(players);
			}catch(Exception e) {System.out.println(e);}
		}
		if(ae.getSource() == p3) {
			players = 3;
		}
		if(ae.getSource() == p4) {
			players = 4;
		}

	}
	
}
