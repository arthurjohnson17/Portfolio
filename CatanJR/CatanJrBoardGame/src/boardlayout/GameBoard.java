package boardlayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import assets.Asset;
import assets.Lair;
import assets.ShipLane;
import assets.SpookyIsland;
import dice.Dice;
import functionMatrices.IslandResource;
import functionMatrices.LairToShip;
import functionMatrices.ShipToLair;
import guimatrices.IslandLocation;
import guimatrices.LairLocation;
import guimatrices.ShipLocation;
import initailize.StartingLairs;
import market.Market;
import market.MarketLocation;
import market.MarketTiles;
import player.Player;
import resourcebank.ResourceBank;
import tiles.Tiles;

public class GameBoard extends JPanel implements ActionListener {

	JFrame window = new JFrame();

	private int current_player;
	private boolean markettrade = false;
	private boolean dice_rolled = false;
	private boolean ghost_movable = false;
	private int players;
	private boolean free = false;
	
	private JTextField player_name = new JTextField("Player: BLUE");
	private String[] playerName = new String[4];
	
	private JTextField c_wood = new JTextField("Wood:" + 0);
	private JTextField c_gold = new JTextField("Gold" + 0);
	private JTextField c_goat = new JTextField("Goat:" + 0);
	private JTextField c_cutlass = new JTextField("Cutlass:" + 0);
	private JTextField c_molasses = new JTextField("Molasses:" + 0);
	private JTextField c_tiles = new JTextField("Tiles:" + 0);

	private ButtonGroup group = new ButtonGroup();

	private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	private int width = (int) screen.getWidth();
	private int height = (int) width/2;
	private int unit_w = (int) (width / 128);
	private int unit_h = (int) (height / 64);

	private JButton exitButton = new JButton();
	private JButton endTurn = new JButton("End Turn");
	private Dice diceButton = new Dice(this);
	private ResourceBank bank = new ResourceBank(this);
	private Tiles tiles = new Tiles(this);
	private JButton rules = new JButton("Rules");
	private File rules_file = new File("images//rules-merged.pdf"); 

	//Defining lair and ship buttons.
	private Lair[] lair = new Lair[32];
	private ShipLane[] shiplane = new ShipLane[40];
	private Island[] island = new Island[12];
	private Market[] market = new Market[5];
	private SpookyIsland spooky_isle = new SpookyIsland(this);
	private Player[] player = new Player[4];

	//Defining ship to lair connection matrixes;
	private ShipToLair shiptolair = new ShipToLair();
	private LairToShip lairtoship = new LairToShip();

	//Defining locations on board.
	private LairLocation lairloc = new LairLocation();
	private ShipLocation shiploc = new ShipLocation();
	private IslandLocation islandloc = new IslandLocation();
	private MarketLocation marketloc = new MarketLocation();
	
	//Starting Islands
	private StartingLairs start = new StartingLairs();
	
	// Island and market Resources matrix
	private IslandResource ir = new IslandResource();
	
	private static boolean gbs = false;

	public GameBoard (int players) {
		
		if(gbs == false) {
		
			playerName[0] = "BLUE";
			playerName[1] = "ORANGE";
			playerName[2] = "RED";
			playerName[3] = "WHITE";
			
			this.players = players;
			window.add(this);
			window.setLayout(null);
	
			
			player_name.setBounds(0, 0, 10*unit_w, 3*unit_h);
			player_name.setEditable(false);
			window.add(player_name);
			
			c_wood.setBounds(0, 3*unit_h, 8*unit_w,3*unit_h);
			c_gold.setBounds(0, 6*unit_h, 8*unit_w,3*unit_h);
			c_goat.setBounds(0, 9*unit_h, 8*unit_w,3*unit_h);
			c_cutlass.setBounds(0, 12*unit_h, 8*unit_w,3*unit_h);
			c_molasses.setBounds(0, 15*unit_h, 8*unit_w,3*unit_h);
			
			c_wood.setEditable(false);
			c_gold.setEditable(false);
			c_goat.setEditable(false);
			c_cutlass.setEditable(false);
			c_molasses.setEditable(false);
			
			window.add(c_wood);
			window.add(c_gold);
			window.add(c_goat);
			window.add(c_cutlass);
			window.add(c_molasses);
			
			c_tiles.setBounds(0, 18*unit_h, 8*unit_w,3*unit_h);
			c_tiles.setEditable(false);
			window.add(c_tiles);
			
			
	
			// Creating Market button layout
			for (int i = 0; i <= 4; i++) {
				MarketTiles temp= MarketTiles.WOOD;
				switch (i) {
					case 0:
						temp = MarketTiles.WOOD;
						break;
					case 1:
						temp = MarketTiles.GOATS;
						break;
					case 2:
						temp = MarketTiles.GOLD;
						break;
					case 3:
						temp = MarketTiles.CUTLASS;
						break;
					case 4:
						temp = MarketTiles.MOLASSES;
						break;
					default:
						temp= MarketTiles.WOOD;
				}					
				market[i] = new Market(i, this);
				market[i].setBounds(unit_w * marketloc.getMarketLocX(i), unit_h * marketloc.getMarketLocY(i), 6 * unit_w,
						6 * unit_h);
				market[i].setResource(temp);
				window.add(market[i]);
			}
	
					
			// Creating Coco tiles
			tiles.setIcon(Iconscaler(new ImageIcon("resource_bank//parrot.jpg"), 4*unit_w, 4*unit_h));
			tiles.setBounds(width - 36*unit_w, 0, 4*unit_w, 4*unit_h);
			window.add(tiles);
					
			// Creating Resource bank
			bank.setIcon(Iconscaler(new ImageIcon("images//bank.png"),  4*unit_w, 4*unit_h));
			bank.addActionListener(this);
			bank.setBounds(width - 43*unit_w, 0, 4*unit_w, 4*unit_h);
			window.add(bank);
	
			// Exit button
			exitButton.setBackground(Color.red);
			exitButton.setIcon(Iconscaler(new ImageIcon("images//exit.png"),  4*unit_w, 4*unit_h));
			exitButton.addActionListener(this);
			exitButton.setBounds(width - 4*unit_w, 0, 4*unit_w, 4*unit_h);
			window.add(exitButton);
	
			//Dice button
			diceButton.setBounds(0, height - 10*unit_h, 10*unit_h, 10*unit_h);
			diceButton.setIcon(Iconscaler(new ImageIcon("images//dice-1.png"), 10*unit_h,  10*unit_h));
			window.add(diceButton);
				
			//End turn button
			endTurn.addActionListener(this);
			endTurn.setBounds(width - 55*unit_w, 0, 10*unit_w, 4*unit_h);
			window.add(endTurn);
			
			// Rules button
			rules.addActionListener(this);
			rules.setBounds(20*unit_w, 0, 10*unit_w, 4*unit_h);
			window.add(rules);
	
			
			//Creating Background game board 
			ImageIcon icon = Iconscaler(new
			ImageIcon("images//board.jpg"), width, height); JLabel background = new
			JLabel("", icon, JLabel.CENTER); background.setBounds(0, 0, width, height);
			window.add(background);
			 
			
			
			//Setting up players
			for(int i = 0; i<players; i++) {
				player[i] = new Player(i);
			}
	
			// Creating all the lair location buttons
			for (int i = 0; i <= 31; i++) {
				lair[i] = new Lair(i, -1, lairtoship.getShip(i, 0), lairtoship.getShip(i, 1), lairtoship.getShip(i, 2), this);
				lair[i].setBounds(unit_w * lairloc.getLairLocX(i), unit_h * lairloc.getLairLocY(i), 4 * unit_w, 4 * unit_h);
				window.add(lair[i]);
	
			}
	
			//Creating all the ship location buttons
			for (int i = 0; i <= 39; i++) {
				shiplane[i] = new ShipLane(i, -1, shiptolair.getLair(i, 0), shiptolair.getLair(i, 1), this);
				shiplane[i].setBounds(unit_w * shiploc.getShipLocX(i), unit_h * shiploc.getShipLocY(i), 4 * unit_w, 4 * unit_h);
				window.add(shiplane[i]);
			}
			
			//Setting up players starting Lairs and ShipLane
			for (int i = 0; i<players; i++) {
				lair[start.getLair1(i)].setOwner(i);
				lair[start.getLair2(i)].setOwner(i);
				shiplane[start.getShip1(i)].setOwner(i);
				shiplane[start.getShip2(i)].setOwner(i);
				
				window.add(lair[start.getLair1(i)],0);
				window.add(lair[start.getLair2(i)],0);
				window.add(shiplane[start.getShip1(i)],0);
				window.add(shiplane[start.getShip2(i)],0);
			}
			
			// Creating Island button layout
			for (int i = 0; i <= 11; i++) {
				island[i] = new Island(i, ir.getResource(i), this);
				island[i].setBounds(unit_w * islandloc.getIslandLocX(i), unit_h * islandloc.getIslandLocY(i), 6 * unit_w,
						6 * unit_h);
				window.add(island[i]);
			}	
			
			// Creating Spooky Island
			spooky_isle.setBounds(52*unit_w ,26*unit_h, 6*unit_w, 6*unit_h);
			spooky_isle.setGhostCaptain(true);
			window.add(spooky_isle,0);
			
			
			//Creating Background game board
			
			/*
			 * ImageIcon icon = Iconscaler(new ImageIcon("images//board.png"), width,
			 * height); JLabel background = new JLabel("", icon, JLabel.CENTER);
			 * background.setBounds(0, 0, width, height); window.add(background);
			 */
			 
			
	
			
			window.setSize(width, height);
			window.setUndecorated(true);
			window.setVisible(true);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		
		}
	}

//	  Function   : Iconscaler 
//	   
//	  Description: Scales Icon images to fit certain size
//	   
//	  Parameters : Icon to be scaled, desired width and height 
//	   
//	  Return     : scaled Icon
	public ImageIcon Iconscaler(ImageIcon icon, int w, int h) {
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
		setResourceDisplay();
		return new ImageIcon(newimg);
	}
	
//	  Function   : setResourceDisplay 
//	   
//	  Description: Updates the resource display to the current players resources 
//	   
//	  Parameters : n/a 
//	   
//	  Return     : n/a
	public void setResourceDisplay() {
		if(player[current_player]!=null) {
		c_wood.setText("Wood:" + player[current_player].getResource(MarketTiles.WOOD));
		c_gold.setText("Gold:" + player[current_player].getResource(MarketTiles.GOLD));
		c_goat.setText("Goat:" + player[current_player].getResource(MarketTiles.GOATS));
		c_cutlass.setText("Cutlass:" + player[current_player].getResource(MarketTiles.CUTLASS));
		c_molasses.setText("Molasses:" + player[current_player].getResource(MarketTiles.MOLASSES));
		c_tiles.setText("Tiles:" + player[current_player].getTiles());
		}
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == exitButton)
			window.dispose();
		
		if (ae.getSource() == endTurn && dice_rolled == true && free == false && ghost_movable == false) {
			current_player ++;
			if(current_player > players-1) {
				current_player = 0;
			}
			player_name.setText("Player: " + playerName[current_player]);
			setMarketTrade(false);
			setDiceState(false);
			setResourceDisplay();
			this.resetMarket();
		}
		
		if(ae.getSource() == rules) {
			try {
				Desktop.getDesktop().open(rules_file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
//	  Function   : getPlayer 
//	   
//	  Description: Get the object class of current player
//	   
//	  Parameters : n/a 
//	   
//	  Return     : current player's object class
	public Player getPlayer() {
		return player[current_player];
	}
	
//	  Function   : getPlayer 
//	   
//	  Description: Get the object class of the specified player
//	   
//	  Parameters : Id of specified player
//	   
//	  Return     : specified player's object class
	public Player getPlayer(int x) {
		return player[x];
	}
	
//	  Function   : getMarketTrade 
//	   
//	  Description: Get the state if the current player has traded with the marker
//	   
//	  Parameters : n/a 
//	   
//	  Return     : true if the current player has traded, false if otherwise
	public boolean getMarketTrade() {
		return markettrade;
	}
	
//	  Function   : setMarketTrade 
//	   
//	  Description: set the state of if the current player has traded with the marker
//	   
//	  Parameters : state for if the player has traded or not
//	   
//	  Return     : n/a
	public void setMarketTrade(boolean state) {
		this.markettrade = state;
	}
	
//	  Function   : getLair 
//	   
//	  Description: Get the Lair object class of the specified  Id
//	   
//	  Parameters : n/a 
//	   
//	  Return     : the Lair of the specified ID
	public Lair getLair(int id) {
		return lair[id];
	}
	
//	  Function   : getShip 
//	   
//	  Description: Get the shiplane object class of the specified  Id
//	   
//	  Parameters : n/a 
//	   
//	  Return     : the Shiplane of the specified ID
	public ShipLane getShip(int id) {
		return shiplane[id];
	}
	
//	  Function   : getDiceState 
//	   
//	  Description: Get the state of if the Dice has been rolled or not
//	   
//	  Parameters : n/a 
//	   
//	  Return     : true if dice has been rolled, false if otherwise
	public boolean getDiceState() {
		return dice_rolled;
	}
	
//	  Function   : setDiceState 
//	   
//	  Description: set the state of if the Dice has been rolled or not
//	   
//	  Parameters : desired Dice state 
//	   
//	  Return     : n/a
	public void setDiceState(boolean state) {
		dice_rolled = state;
		if(state == true) {
			diceButton.setBackground(Color.green); 
		}
		else if(state == false) {
			diceButton.setBackground(Color.red); 
		}
	}
	
//	  Function   : diceResource 
//	   
//	  Description: Have the specified island give resources to asjacent lairs
//	   
//	  Parameters : Island Id 
//	   
//	  Return     : n/a
	public void diceResource(int x)
	{
		island[x].giveResource();
	}
	
//	  Function   : getGhostState 
//	   
//	  Description: Get the state of if the ghost captain can be moved or not
//	   
//	  Parameters : n/a 
//	   
//	  Return     : true if ghost captain can be moved, false if otherwise
	public boolean getGhostState() {
		return ghost_movable;
	}
	
//	  Function   : setGhostState 
//	   
//	  Description: set the state of if the ghost captain can be moved or not
//	   
//	  Parameters : desired state
//	   
//	  Return     : n/a
	public void setGhostState(boolean state) {
		ghost_movable = state;
	}
	
//	  Function   : clearGhosts 
//	   
//	  Description: remove ghost captain from all islands and spooky island
//	   
//	  Parameters : n/a 
//	   
//	  Return     : n/a
	public void clearGhosts() {
		for(int i=0; i<12; i++) {
			island[i].setGhostCaptain(false);
		}
		spooky_isle.setGhostCaptain(false);
	}
	
//	  Function   : getBank 
//	   
//	  Description: Get the Bank object class
//	   
//	  Parameters : n/a 
//	   
//	  Return     : returns resource bank
	public ResourceBank getBank() {
		return bank;
	}
	
//	  Function   : getFree 
//	   
//	  Description: get the state of if the current player can build a free asset
//	   
//	  Parameters : n/a 
//	   
//	  Return     : true if they can, false if otherwise
	public boolean getFree() {
		return free;
	}
	
//	  Function   : setFree 
//	   
//	  Description: set the state of if the current player can build a free asset
//	   
//	  Parameters : desired state
//	   
//	  Return     : n/a
	public void setFree(boolean state) {
		free = state;
	}
	
//	  Function   : setSpookyLair 
//	   
//	  Description: set the owner of the spooky lair to the player with the most tiles
//	   
//	  Parameters : n/a 
//	   
//	  Return     : n/a
	public void setSpookyLair() {
		if(spooky_isle.getGhostCaptain()==false) {
			int most_tiles = 0;
			int winner = -1;
			for(int i=0; i<players; i++) {
				if (player[i].getTiles()>most_tiles) {
					winner = i;
					most_tiles = player[i].getTiles();
					}
				else if(player[i].getTiles()==most_tiles) {
					winner = -1;
				}
			}
			if(spooky_isle.getOwner()!= -1 && spooky_isle.getOwner()!=winner) {
				player[spooky_isle.getOwner()].loseLair();
			}
			System.out.println("Winner:" + winner);
			if(winner != -1 && winner != spooky_isle.getOwner() ) {
				player[winner].gainLair();
			}
			spooky_isle.setOwner(winner);
		}
	}
	
//	  Function   : resetMarket 
//	   
//	  Description: Checks if the Market tiles are all the same and resets the market to contain 1 of each resource
//					trades resources with resource bank.
//	   
//	  Parameters : n/a 
//	   
//	  Return     : n/a
	public void resetMarket() {
		if(market[0].getResource() == market[1].getResource()
		&& market[0].getResource() == market[2].getResource()
		&& market[0].getResource() == market[3].getResource()
		&& market[0].getResource() == market[4].getResource()){
			
			bank.gainResource(market[0].getResource(), 5);
			
			market[0].setResource(MarketTiles.WOOD);
			market[1].setResource(MarketTiles.GOATS);
			market[2].setResource(MarketTiles.GOLD);
			market[3].setResource(MarketTiles.CUTLASS);
			market[4].setResource(MarketTiles.MOLASSES);
			
			bank.loseResource(MarketTiles.WOOD, 1);
			bank.loseResource(MarketTiles.GOATS, 1);
			bank.loseResource(MarketTiles.GOLD, 1);
			bank.loseResource(MarketTiles.CUTLASS, 1);
			bank.loseResource(MarketTiles.MOLASSES, 1);
		}
		
	}
		
}