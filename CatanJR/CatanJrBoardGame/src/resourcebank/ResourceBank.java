package resourcebank;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import boardlayout.GameBoard;
import guiopening.BankPopUp1;
import market.MarketTiles;

public class ResourceBank extends JButton implements ActionListener,ResourceMover{
	private int wood = 18;
	private int gold = 18;
	private int goat = 18;
	private int cutlass = 18;
	private int molasses = 18;
	
	private GameBoard gb;
	
	
	public ResourceBank(GameBoard gb){
		this.gb = gb;
		this.setBackground(Color.cyan);
		this.addActionListener(this);
	
	}
	public int getResource(MarketTiles resource) {
		switch(resource) {
		case WOOD:
			return wood;
		case GOLD:
			return gold;
		case GOATS:
			return goat;
		case CUTLASS:
			return cutlass;
		case MOLASSES:
			return molasses;
		default:
			return 0;		
		}
	}
	
	// TODO Is this added to the project twice?
	
	public void gainResource(MarketTiles type, int amount) {
		switch(type) {
		case WOOD:
			wood += amount;
			break;
		case CUTLASS:
			cutlass += amount;
			break;
		case GOLD:
			gold += amount;
			break;
		case GOATS:
			goat += amount;
			break;
		case MOLASSES:
			molasses += amount;
			break;
		default:
			break;		
		}
	}
	
	public void loseResource(MarketTiles type, int amount) {
		switch(type) {
		case WOOD:
			wood -= amount;
			break;
		case CUTLASS:
			cutlass -= amount;
			break;
		case GOLD:
			gold -= amount;
			break;
		case GOATS:
			goat -= amount;
			break;
		case MOLASSES:
			molasses -= amount;
			break;
		default:
			break;		
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==this ) {
			BankPopUp1 bp1 = new BankPopUp1(this,gb);
	}
	}

}
