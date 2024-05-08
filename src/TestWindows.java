package demoswing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestWindow extends JFrame implements ActionListener {

	//JFrame class wants its subclasses to have a "unique ID",
	//and code interfaces force us to do so to avoid a warning
	//Just put whatever "long" int number here.
	private static final long serialVersionUID = 2L;
	private static final String[] Deck = {"2C","3C","4C","5C","6C","7C","8C","9C","10C","AC","JC","QC","KC","2S","3S","4S","5S","6S","7S","8S","9S","10S","AS","JS","QS","KS","2D","3D","4D","5D","6D","7D","8D","9D","10D","AD","JD","QD","KD","2H","3H","4H","5H","6H","7H","8H","9H","10H","AH","JH","QH","KH"};

	
	//Entities in the window that I will need to access outside
	//constructor were modified to be attributes of the class, that way I
	//can access them in any method
	protected JButton buttonSpades;
	protected JLabel cardDisplay;
	protected JLabel cardBuffer;
	
	/**
	 * Constructor
	 */
	public TestWindow() {
		
		//Part written manually (window size, window title, prevent resize, rtc...)
		this.setSize(800,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Swing Test Window");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		//Code created by WindowBuilder Editor. Only mofification
		//was changing some local variables to attributes, so we can access
		//them in other methods
		buttonSpades = new JButton("Change to Spades");
		buttonSpades.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonSpades.setBounds(503, 22, 223, 85);
		getContentPane().add(buttonSpades);
		
		List<JLabel> ImagesList = new ArrayList<>();

		for(String card : Deck){
			JLabel cardBuffer = new JLabel(""); // Création d'une nouvelle instance de JLabel à chaque itération
			cardBuffer.setIcon(new ImageIcon(TestWindow.class.getResource("/resources/"+ card +".png")));
			cardBuffer.setBounds(ImagesList.size() * 10, 62, 200, 328);
			System.out.println("Yo");
			ImagesList.add(cardBuffer);
			getContentPane().add(cardBuffer); // Ajout du composant à la fenêtre principale
		}
			
		cardDisplay = new JLabel("");
		cardDisplay.setIcon(new ImageIcon(TestWindow.class.getResource("/resources/KS.png")));
		cardDisplay.setBounds(138, 62, 200, 328);
		getContentPane().add(cardDisplay);
		
		//Manual input : we create listeners on all 4 buttons
		//When clicked, they will trigger "actionPerformed" method on
		//the object set as parameter (here : "this")
		buttonSpades.addActionListener(this);
		
		//Manual input : window must be set visible, or it won't display
		//This should be done at the end, otherwise some elements might 
		//not properly appear (images in particular)
		this.setVisible(true);
	}

	/**
	 * Buttons can send their "click" event to classes that have
	 * "ActionListener" interface. Why? Because they "know" those classes
	 * will be forced to have an "actionPerformed" method to call.
	 * 
	 * They will call it when they are clicked thanks to listeners set 
	 * above in constructor
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		//All buttons call the same finction, so we have to test
		//for the source of the event, and react accordingly.
		
		//Here, "reaction" is to change the path of the image we'll load afterwards
		String imagePath ="";
		if(e.getSource() == buttonSpades) {
			imagePath = "/resources/KS.png";
			cardDisplay.setBounds(238, 62, 200, 328);
		}
		
		//This line will change the image by fetching in "resources" package
		this.cardDisplay.setIcon(new ImageIcon(TestWindow.class.getResource(imagePath)));
	}
}
