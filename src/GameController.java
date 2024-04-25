import java.io.IOException;
import java.util.Random;
import java.util.HashSet;





public class GameController {
    private static GameStack gameStack = new GameStack();
    private static Random random = new Random();

    private static CardDeck gameDeck = new CardDeck(52);


    public static void initGameStack() throws IOException {
        
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"Ace","2","3","4","5","6","7","8","9","10","Jack", "Queen", "King"};

        HashSet<Card> usedCards = new HashSet<>();

        
        while(gameStack.size() < 52) {
            String randomSuit = suits[random.nextInt(suits.length)];
            String randomRank = ranks[random.nextInt(ranks.length)];
            Card tempCard = new Card(randomSuit, randomRank);

            if(!usedCards.contains(tempCard)) {
                gameStack.push(tempCard);
                usedCards.add(tempCard);

            }
            else {
                //System.out.println("Duplicate card detected: " + tempCard);
            }
            
        }

        //System.out.println(usedCards);
        //System.out.println(gameStack.size()+ " " +gameStack.toString());
        
    }

    public static void initGameDeck() {
        for(int i=0; i<4; i++) {
            gameDeck.addCard(gameStack.peek());
            gameStack.pop();
        }
        System.out.println("-------------------------------\n");
        gameDeck.printDeck();
    }


    public static int gameCompare() {
        if (gameDeck.cardFetch(0).equalsByRank(gameDeck.cardFetch(3))) {
            gameDeck.clearDeck();
            System.out.println("\n-------------------\nSame rank : you score 5 points !!!\n");
            gameDeck.printDeck();
            return 1;
            //same Rank ==> 1
        }
        else if (gameDeck.cardFetch(0).equalsBySuit(gameDeck.cardFetch(3))) {
            gameDeck.removeCard(1);
            gameDeck.removeCard(1);
            System.out.println("\n-------------------\nSame Suit : you score 2 points !\n");
            gameDeck.printDeck();
            return 2;
            //same Suit ==> 2
        }

        else return 0;
        //try again
    }



}
