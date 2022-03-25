package guiopening;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import boardlayout.GameBoard;
import market.MarketTiles;
import player.Player;
import resourcebank.ResourceBank;

public class BankPopUp2 extends JPanel implements ActionListener {

	JFrame window = new JFrame();
	
	JRadioButton wood = new JRadioButton("Wood");
	JRadioButton gold = new JRadioButton("Gold");
	JRadioButton goat = new JRadioButton("Goat");
	JRadioButton cutlass = new JRadioButton("Cutlass");
	JRadioButton molasses = new JRadioButton("Molasses");


	ButtonGroup group = new ButtonGroup();
	
	JTextField message = new JTextField("Choose resource to trade with:");
	
	private ResourceBank rb;
	private GameBoard gb;
	private MarketTiles resource_wanted;
	
	BankPopUp2(ResourceBank rb, GameBoard gb, MarketTiles resource_wanted) {
		this.rb = rb;
		this.gb = gb;
		this.resource_wanted = resource_wanted;
		window.add(this);
		window.setLayout(null);
		window.setBounds(0, 50,500,100);
		
		message.setBounds(0,0,500,50);
		message.setEditable(false);
		window.add(message);
		
		group.add(wood);
		group.add(gold);
		group.add(goat);
		group.add(cutlass);
		group.add(molasses);

		wood.addActionListener(this);
		gold.addActionListener(this);
		goat.addActionListener(this);
		cutlass.addActionListener(this);
		molasses.addActionListener(this);

		wood.setBounds(0, 50, 100, 50);
		gold.setBounds(100, 50, 100, 50);
		goat.setBounds(200, 50, 100, 50);
		cutlass.setBounds(300, 50, 100, 50);
		molasses.setBounds(400, 50, 100, 50);

		window.add(wood);
		window.add(gold);
		window.add(goat);
		window.add(cutlass);
		window.add(molasses);
		
		window.setUndecorated(true);
		window.setVisible(true);
	}
	
	public void Trade(MarketTiles resource) {
		// First give the player the markets current resource and
		Player player = gb.getPlayer();
		if(player.getResource(resource)>1) {
			player.gainResource(resource_wanted,1);
			// Then remove the given resource from the player and set it to the market
			player.loseResource(resource,2);
			gb.setResourceDisplay();
			window.dispose();
		}
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == wood) {
			Trade(MarketTiles.WOOD);
		}
		if(ae.getSource() == gold) {
			Trade(MarketTiles.GOLD);	
		}
		if(ae.getSource() == goat) {
			Trade(MarketTiles.GOATS);
		}
		if(ae.getSource() == cutlass) {
			Trade(MarketTiles.CUTLASS);
		}
		if(ae.getSource() == molasses) {
			Trade(MarketTiles.MOLASSES);
		}
	}
	
	
}
