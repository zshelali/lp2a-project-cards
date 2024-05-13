

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

	
	protected JButton button;
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
		

		button = new JButton("Pioche");
		//button.setIcon(new ImageIcon(TestWindow.class.getResource("/Cards/2S.png")));
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBounds(503, 22, 223, 85);
		getContentPane().add(button);
		
		cardOne = new JLabel("");
		cardOne.setIcon(new ImageIcon(TestWindow.class.getResource("/Cards/"+ nameCardFletch(1)+".png")));
		cardOne.setBounds(310, 200, 200, 328);
		getContentPane().add(cardOne);

		cardTwo = new JLabel("");
		cardTwo.setIcon(new ImageIcon(TestWindow.class.getResource("/Cards/"+ nameCardFletch(2)+".png")));
		cardTwo.setBounds(520, 200, 200, 328);
		getContentPane().add(cardTwo);

		cardThree = new JLabel("");
		cardThree.setIcon(new ImageIcon(TestWindow.class.getResource("/Cards/"+ nameCardFletch(3)+".png")));
		cardThree.setBounds(730, 200, 200, 328);
		getContentPane().add(cardThree);

		cardFour = new JLabel("");
		cardFour.setIcon(new ImageIcon(TestWindow.class.getResource("/Cards/"+ nameCardFletch(4)+".png")));
		cardFour.setBounds(940, 200, 200, 328);
		getContentPane().add(cardFour);

		deckTemp = new JLabel("");
		deckTemp.setIcon(new ImageIcon(TestWindow.class.getResource("/Cards/00.png")));
		deckTemp.setBounds(50, 200, 200, 328);
		getContentPane().add(deckTemp);
		
		
		button.addActionListener(this);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			//imagePath = "/resources/KS.png";
			//cardDisplay.setBounds(238, 62, 200, 328);
		}
	}

	public String nameCardFletch(int index){
		Card card;
		String name;

		card = deck.cardFetch(index);
		switch (card[1]) {
			case "King":
				name = "k";
				break;
			case "Queen":
				name = "Q";
				break;
			case "Jack":
				name = "J";
				break;
			case "1":
				name = "A";
				break;
			default:
				name = card[1];
				break;
		}

		switch (card[0]) {
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
