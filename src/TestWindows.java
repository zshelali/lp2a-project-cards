

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestWindow extends JFrame implements ActionListener {

	private static final long serialVersionUID = 2L;
	//private static final String[] Deck = {"2C","3C","4C","5C","6C","7C","8C","9C","10C","AC","JC","QC","KC","2S","3S","4S","5S","6S","7S","8S","9S","10S","AS","JS","QS","KS","2D","3D","4D","5D","6D","7D","8D","9D","10D","AD","JD","QD","KD","2H","3H","4H","5H","6H","7H","8H","9H","10H","AH","JH","QH","KH"};

	
	protected JButton button1;
	protected JButton button2;
	protected JButton buttonPioche;

	protected JLabel cardOne;
	protected JLabel cardTwo;
	protected JLabel cardThree;
	protected JLabel cardFour;
	protected JLabel deckTemp;
	
	/**
	 * Constructor
	 */
	public TestWindow() {
		
		//Part written manually (window size, window title, prevent resize, rtc...)
		this.setSize(1200,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Swing Test Window");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		buttonPioche = new JButton("Pioche");
		buttonPioche.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonPioche.setBounds(503, 22, 223, 85);
		getContentPane().add(buttonPioche);


		button1 = new JButton("Button1");
		button1.setFont(new Font("Tahoma", Font.BOLD, 16));
		button1.setBounds(503, 22, 223, 85);
		getContentPane().add(button1);

		button2 = new JButton("Button2");
		//button.setIcon(new ImageIcon(TestWindow.class.getResource("/Cards/2S.png")));
		button2.setFont(new Font("Tahoma", Font.BOLD, 16));
		button2.setBounds(503, 22, 223, 85);
		getContentPane().add(button2);
		
		cardOne = new JLabel("");
		cardOne.setIcon(new ImageIcon(TestWindow.class.getResource("../Cards/"+ nameCardFetch(1)+".png")));
		cardOne.setBounds(310, 200, 200, 328);
		getContentPane().add(cardOne);

		cardTwo = new JLabel("");
		cardTwo.setIcon(new ImageIcon(TestWindow.class.getResource("../Cards/"+ nameCardFetch(2)+".png")));
		cardTwo.setBounds(520, 200, 200, 328);
		getContentPane().add(cardTwo);

		cardThree = new JLabel("");
		cardThree.setIcon(new ImageIcon(TestWindow.class.getResource("../Cards/"+ nameCardFetch(3)+".png")));
		cardThree.setBounds(730, 200, 200, 328);
		getContentPane().add(cardThree);

		cardFour = new JLabel("");
		cardFour.setIcon(new ImageIcon(TestWindow.class.getResource("../Cards/"+ nameCardFetch(4)+".png")));
		cardFour.setBounds(940, 200, 200, 328);
		getContentPane().add(cardFour);

		deckTemp = new JLabel("");
		deckTemp.setIcon(new ImageIcon(TestWindow.class.getResource("../Cards/00.png")));
		deckTemp.setBounds(50, 200, 200, 328);
		getContentPane().add(deckTemp);
		
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		buttonPioche.addActionListener(this);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		GameController.initGameDeck();
		if(GameController.gameCompare() == 1 || GameController.gameCompare() == 2){
			button1.setBounds(310, 200, 200, 328);
			button2.setBounds(940, 200, 200, 328);
		}
	}


		if(e.getSource() == button1 || e.getSource() == button2) { // case 1
			//imagePath = "/resources/KS.png";
			gameDeck.clearDeck(); 
            //refill the gameDeck
            if (!secondaryDeck.isEmpty()) {
                while(gameDeck.deckSize() < 4 && !secondaryDeck.isEmpty()){
                	gameDeck.addCard(secondaryDeck.removeCard(secondaryDeck.deckSize()-1));
             	}
            }
            else {
                while(gameDeck.deckSize() < 4 && !gameStack.isEmpty()) {
                    gameDeck.addCard(gameStack.pop());
                    System.out.println("CASE 1 :🚨🚨🚨🚨🚨🚨🚨");
			    }
            }
		}

		if(e.getSource() == buttonPioche){ //case 0 
			secondaryDeck.addCard(gameDeck.removeCard(0));
            gameDeck.addCard(gameStack.pop());
            break;
		}
		System.out.println("\n Current score : " +GameController.getScore());
        GameController.printDeck();
		button1.setVisible(false);
		button2.setVisible(false);
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
}
