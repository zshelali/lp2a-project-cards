

//import java.awt.Color;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.print.attribute.standard.JobKOctetsSupported;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 2L;
	//private static final String[] Deck = {"2C","3C","4C","5C","6C","7C","8C","9C","10C","AC","JC","QC","KC","2S","3S","4S","5S","6S","7S","8S","9S","10S","AS","JS","QS","KS","2D","3D","4D","5D","6D","7D","8D","9D","10D","AD","JD","QD","KD","2H","3H","4H","5H","6H","7H","8H","9H","10H","AH","JH","QH","KH"};

	protected JButton buttonPioche;
	protected JButton buttonRank;
	protected JButton buttonSuit;

	protected JTextField textScore;

	protected JLabel cardOne;
	protected JLabel cardTwo;
	protected JLabel cardThree;
	protected JLabel cardFour;
	protected JLabel deckTemp;
	protected JLabel draw;
	
	/**
	 * Constructor
	 */
	public GUI() {
		
		//Part written manually (window size, window title, prevent resize, rtc...)
		this.setSize(1200,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("One Handed Solitaire");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		Color green = new Color(0,150,0);
		this.getContentPane().setBackground(green);

		buttonPioche = new JButton("Draw");
		buttonPioche.setContentAreaFilled(false);
		buttonPioche.setBorderPainted(false);
		buttonPioche.setFont(new Font("Tahoma", Font.BOLD, 50));
		buttonPioche.setBounds(50, 10, 328, 200);
		getContentPane().add(buttonPioche);

		textScore = new JTextField("0");
		
		textScore.setFont(new Font("Tahoma", Font.BOLD, 16));
		textScore.setBounds(900, 22, 70, 40);
		getContentPane().add(textScore);

		buttonSuit = new JButton("");
		buttonSuit.setContentAreaFilled(false);
		buttonSuit.setBorderPainted(false);
		buttonSuit.setIcon(new ImageIcon(GUI.class.getResource("/Cards/SuitButton.png")));
		buttonSuit.setBounds(310, 213, 830, 305);
		getContentPane().add(buttonSuit);

		buttonRank = new JButton("");
		buttonRank.setContentAreaFilled(false);
		buttonRank.setBorderPainted(false);
		buttonRank.setIcon(new ImageIcon(GUI.class.getResource("/Cards/RankButton.png")));
		buttonRank.setBounds(310, 213, 830, 305);
		getContentPane().add(buttonRank);

		
		cardOne = new JLabel("");
		cardOne.setIcon(new ImageIcon(GUI.class.getResource("/Cards/"+ nameCardFetch(0)+".png")));
		cardOne.setBounds(310, 200, 200, 328);
		getContentPane().add(cardOne);

		cardTwo = new JLabel("");
		cardTwo.setIcon(new ImageIcon(GUI.class.getResource("/Cards/"+ nameCardFetch(1)+".png")));
		cardTwo.setBounds(520, 200, 200, 328);
		getContentPane().add(cardTwo);

		cardThree = new JLabel("");
		cardThree.setIcon(new ImageIcon(GUI.class.getResource("/Cards/"+ nameCardFetch(2)+".png")));
		cardThree.setBounds(730, 200, 200, 328);
		getContentPane().add(cardThree);

		cardFour = new JLabel("");
		cardFour.setIcon(new ImageIcon(GUI.class.getResource("/Cards/"+ nameCardFetch(3)+".png")));
		cardFour.setBounds(940, 200, 200, 328);
		getContentPane().add(cardFour);


		deckTemp = new JLabel("");
		deckTemp.setIcon(new ImageIcon(GUI.class.getResource("/Cards/00.png")));
		deckTemp.setBounds(50, 200, 200, 328);
		getContentPane().add(deckTemp);

		draw = new JLabel("");
		draw.setIcon(new ImageIcon(GUI.class.getResource("/Cards/11.png")));
		draw.setBounds(50, 10, 328, 200);
		
        
		getContentPane().add(draw);
		
		buttonPioche.addActionListener(this);
		buttonSuit.addActionListener(this);
		buttonRank.addActionListener(this);

		this.setVisible(true);
		
		//now the game start
		choiseVisibleButton(buttonRank, buttonSuit, deckTemp, draw);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("///////////////////////////////////////");

		GameController.initGameDeck();
		
		if(e.getSource() == buttonPioche){
			System.out.println("drawCard");
			GameController.drawCard();
		}
		else if(e.getSource() == buttonRank){
			System.out.println("Equal by rank");
			GameController.rankEqual();
		}
		else if(e.getSource() == buttonSuit){
			System.out.println("Equal by suit");
			GameController.suitEqual();
		}

		System.out.println("\n Current score : " + GameController.getScore());
    	GameController.printDeck();
		choiseVisibleButton(buttonRank, buttonSuit, deckTemp, draw);
		if(GameController.gameCompare() == 0 && GameController.getGameStack().size() == 0 ){
			//fin de parti
			buttonPioche.setVisible(false);
			buttonRank.setVisible(false);
			buttonSuit.setVisible(false);
		}
		else{
		//desk updating
		this.cardOne.setIcon(new ImageIcon(GUI.class.getResource("/Cards/"+ nameCardFetch(0)+".png")));
		this.cardTwo.setIcon(new ImageIcon(GUI.class.getResource("/Cards/"+ nameCardFetch(1)+".png")));
		this.cardThree.setIcon(new ImageIcon(GUI.class.getResource("/Cards/"+ nameCardFetch(2)+".png")));
		this.cardFour.setIcon(new ImageIcon(GUI.class.getResource("/Cards/"+ nameCardFetch(3)+".png")));
		textScore.setText("" + GameController.getScore());
		}
	}
	
	public String nameCardFetch(int index){
		Card card;
		String name;
		
		card = GameController.getGameDeck().cardFetch(index);
		switch (card.getCardRank()) {
			case "King":
				name = "K";
				break;
			case "Queen":
				name = "Q";
				break;
			case "Jack":
				name = "J";
				break;
			case "Ace":
				name = "A";
				break;
			default:
				name = card.getCardRank();
				break;
		}

		switch (card.getCardSuit()) {
			case "Diamonds":
				name = name + "D";
				break;
			case "Spades":
				name = name + "S";
				break;
			case "Clubs":
				name = name + "C";
				break;
			default:
				name = name + "H";
				break;
		}
		return name;
	}

	public static void choiseVisibleButton(JButton buttonRank, JButton buttonSuit, JLabel deckTemp, JLabel draw){
		//show or hide the transparent button on the cards
		if(GameController.gameCompare() == 1){
			buttonSuit.setVisible(false);
			buttonRank.setVisible(true);
		}
		else if(GameController.gameCompare() == 2){
			buttonSuit.setVisible(true);
			buttonRank.setVisible(false);
		}
		else{
			buttonSuit.setVisible(false);
			buttonRank.setVisible(false);
		}

		if(GameController.getSecondaryDeck().deckSize() == 0){
			deckTemp.setVisible(false);
		}
		else{
			deckTemp.setVisible(true);
		}

		if(GameController.getGameStack().size() == 0){
			draw.setVisible(false);
		}
		else{
			draw.setVisible(true);
		}
	}
}
