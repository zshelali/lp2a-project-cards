import java.util.ArrayList;
import java.util.Random;
import java.util.random.*;

public class CardDeck {
    private ArrayList<Card> deck = new ArrayList<Card>();
    private int MAX_SIZE = 4;

    
    public CardDeck() {
        deck = new ArrayList<Card>();
    }


    public boolean isEmpty() {
        return (deck.isEmpty());
    }

    public void addCard(Card c) {
        if (deck.size() < MAX_SIZE) {
            deck.add(c);
        }
        else {
            System.out.println("Unable to add card : Max size exceeded");
        }
    }

    public void removeCard(Card c) {
        if (deck.size() == 0) {
            System.out.println("Unable to remove card from deck : deck is already empty");
        }
        else  {
            deck.remove(c);
        }
    }
//to reprogram (inchallah)

    // public static Card selectAny() {
    //     Random rand = new Random();
    //     int int_random = rand.nextInt(deck.size());
    //     return deck.get(int_random);
    // }

    
    public void printDeck() {
        if (deck.size() == 0) {
            System.out.println("Nothing to see here...");
        }
        else {
            System.out.println("Deck :");
            for (int i=0; i<=deck.size()-1; i++) {
                System.out.println("Card [" + deck.get(i).getTheSuit() + "," + deck.get(i).getCardNumber() + "]");
    
            }
        }
        
    }

}
