import java.util.ArrayList;

public class CardDeck {
    private ArrayList<Card> deck = new ArrayList<Card>();
    private int maxSize;

    
    public CardDeck() {
        deck = new ArrayList<Card>();
        maxSize = 4;
    }

    public CardDeck(int m) {
        deck = new ArrayList<Card>();
        maxSize = m;
    }

    public Card cardFetch(int index) {
        return this.deck.get(index);
    }

    public int deckSize() {
        return this.deck.size();
    }


    public boolean isEmpty() {
        return (deck.isEmpty());
    }

    public void addCard(Card c) {
        if (deck.size() < maxSize) {
            deck.add(c);
        }
        else {
            System.out.println("Unable to add card : Max size exceeded");
        }
    }

    public Card removeCard(int index) {
        if (deck.size() == 0) {
            System.out.println("Unable to remove card from deck : deck is already empty");
            return null;
        }
        else  {
            
            return deck.remove(index);
        }
    }

    public void clearDeck() {
        if (deck.size() == 0) {
            System.out.println("Unable to empty the deck : deck is already empty");
        }
        else {
            deck.clear();
        }
    }

    public void shiftCards() {
        for (int i = 0; i < this.deckSize(); i++) {

        }
    }

    public void printDeck() {
        if (deck.size() == 0) {
            System.out.println("Nothing to see here...");
        }
        else {
            System.out.println("Deck :");
            for (int i=0; i<=deck.size()-1; i++) {
                System.out.println("Card [" + deck.get(i).getCardSuit() + "," + deck.get(i).getCardRank() + "]");
    
            }
        }
        
    }

}
