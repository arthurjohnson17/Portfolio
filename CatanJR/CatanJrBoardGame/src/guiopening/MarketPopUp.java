package guiopening;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import boardlayout.GameBoard;
import market.Market;
import market.MarketTiles;
import player.Player;

public class MarketPopUp extends JPanel implements ActionListener {

	JFrame window = new JFrame();
	
	JRadioButton wood = new JRadioButton("Wood");
	JRadioButton gold = new JRadioButton("Gold");
	JRadioButton goat = new JRadioButton("Goat");
	JRadioButton cutlass = new JRadioButton("Cutlass");
	JRadioButton molasses = new JRadioButton("Molasses");

	ButtonGroup group = new ButtonGroup();
	
	JTextField message = new JTextField("Choose resource to trade with:");
	
	private Market market;
	private GameBoard gb;
	
	public MarketPopUp(Market market, GameBoard gb) {
		this.market = market;
		this.gb = gb;
		window.add(this);
		window.setLayout(null);
		window.setBounds(0, 50,500,100);
		
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
		
		message.setBounds(0,0,500,50);
		message.setEditable(false);
		window.add(message);

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
		if(player.getResource(resource)>0) {
			player.gainResource(market.getResource(),1);
			// Then remove the given resource from the player and set it to the market
			player.loseResource(resource,1);
			market.setResource(resource);
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
