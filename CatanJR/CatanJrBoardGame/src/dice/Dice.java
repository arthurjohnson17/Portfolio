package dice;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import boardlayout.GameBoard;
public class Dice extends JButton implements ActionListener {
	
	private int dice_num;
	private GameBoard gb;
	public Dice(GameBoard gb){
		this.setBackground(Color.red); 
		this.gb = gb;
		this.dice_num = 1;
		this.addActionListener(this);	
	}

@Override
public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource() == this && gb.getDiceState() == false) {
		gb.setDiceState(true);
		dice_num = (int) ((Math.random() * (7 - 1)) + 1);
		switch(dice_num) {
		case 1:
			this.setIcon(gb.Iconscaler(new ImageIcon("images//dice-1.png"), this.getWidth(),this.getHeight()));
			gb.diceResource(1);
			gb.diceResource(5);
			gb.diceResource(6);
			break;
		case 2:
			this.setIcon(gb.Iconscaler(new ImageIcon("images//dice-2.png"), this.getWidth(),this.getHeight()));
			gb.diceResource(4);
			gb.diceResource(7);
			gb.diceResource(9);
			break;
		case 3:
			this.setIcon(gb.Iconscaler(new ImageIcon("images//dice-3.png"), this.getWidth(),this.getHeight()));
			gb.diceResource(0);
			gb.diceResource(8);
			break;
		case 4:
			this.setIcon(gb.Iconscaler(new ImageIcon("images//dice-4.png"), this.getWidth(),this.getHeight()));
			gb.diceResource(2);
			gb.diceResource(10);
			break;
		case 5:
			this.setIcon(gb.Iconscaler(new ImageIcon("images//dice-5.png"), this.getWidth(),this.getHeight()));
			gb.diceResource(3);
			gb.diceResource(11);
			break;
		case 6:
			this.setIcon(gb.Iconscaler(new ImageIcon("images//dice-6.png"), this.getWidth(),this.getHeight()));
			gb.setGhostState(true);
			break;
		default:
			break;
		}
		gb.setResourceDisplay();
	}

}

}