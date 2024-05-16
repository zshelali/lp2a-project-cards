import java.io.IOException;
import java.util.Random;
import java.util.HashSet;





public class GameController {
    private static GameStack gameStack = new GameStack();
    public static GameStack getGameStack() { return gameStack; }

    private static Random random = new Random();

    private static CardDeck gameDeck = new CardDeck(); //default size = 4
    public static CardDeck getGameDeck() { return gameDeck;}

    private static int score = 0;
    public static int getScore() {return score;}

    private static CardDeck secondaryDeck = new CardDeck(52);
    public static CardDeck getSecondaryDeck() {return secondaryDeck;}

    private static int jokerUsage = 2;
    public static int getJokerUsage() {return jokerUsage;}


    public static void initGameStack() throws IOException {
        //Card values initialisation 
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"Ace","2","3","4","5","6","7","8","9","10","Jack", "Queen", "King"};

        HashSet<Card> usedCards = new HashSet<>();

        
        while(gameStack.size() < 52) {
            String randomSuit = suits[random.nextInt(suits.length)];
            String randomRank = ranks[random.nextInt(ranks.length)];
            Card tempCard = new Card(randomSuit, randomRank);

            if(!usedCards.contains(tempCard)) {
                gameStack.push(tempCard);
                //used cards management
                usedCards.add(tempCard);

            }
            
        }

        //System.out.println(usedCards);
        //System.out.println(gameStack.size()+ " " +gameStack.toString());
        
    }

    public static void initGameDeck() {
        while (gameDeck.deckSize()<4 && !gameStack.isEmpty()) {
            gameDeck.addCard(gameStack.pop());
            //System.out.println("Card removed");
        }
        //System.out.println("-------------------------------\n");
    }


    public static int gameCompare() {
        if (gameDeck.deckSize() == 4) {
            if (gameDeck.cardFetch(0).equalsByRank(gameDeck.cardFetch(3))) {
                return 1;
                //same Rank ==> 1
            }
            else if (gameDeck.cardFetch(0).equalsBySuit(gameDeck.cardFetch(3))) {
                return 2;
                //same Suit ==> 2
            }
        }

        return 0;
        //try again
    }

    public static void gameResume() {
        if (!gameStack.isEmpty()) {
            switch (gameCompare()) {
                
                case 0: //nothing equal, draw a card
                    drawCard();
                    break;

                case 1: //equal by Rank, score +=5, remove all cards
                    rankEqual();
                    break;

                case 2:  //equal by Suit, score +=2
                    suitEqual();
                    break;

                default :
                    System.out.println("gameResume : case error, value isn't 0, 1 or 2");

                }

        } 

    }

    public static void drawCard(){
        secondaryDeck.addCard(gameDeck.removeCard(0));
        if (!gameStack.isEmpty())
            gameDeck.addCard(gameStack.pop());
    }

    public static void rankEqual(){
        gameDeck.clearDeck();
        //refill the gameDeck
        if (!secondaryDeck.isEmpty()) {
            while(gameDeck.deckSize() < 4 && !secondaryDeck.isEmpty()) {
                gameDeck.addCard(secondaryDeck.removeCard(secondaryDeck.deckSize()-1));
            }
        }

        if (secondaryDeck.isEmpty()) {
            while(gameDeck.deckSize() < 4 && !gameStack.isEmpty()) {
                gameDeck.addCard(gameStack.pop());
                System.out.println("CASE 1 :🚨🚨🚨🚨🚨🚨🚨");
            }
        }
        score+=5;
    }

    public static void suitEqual(){
        gameDeck.removeCard(1);
        gameDeck.removeCard(1);
        if (!secondaryDeck.isEmpty()) {
            while(gameDeck.deckSize() < 4 && !secondaryDeck.isEmpty()) {
                gameDeck.addCard(0,secondaryDeck.removeCard(secondaryDeck.deckSize()-1));
            }
        }
        if (secondaryDeck.isEmpty()) {
            while(gameDeck.deckSize() < 4 && !gameStack.isEmpty()) {
                gameDeck.addCard(gameStack.pop());
                    System.out.println("CASE 2 :🥶🥶🥶🥶🥶🥶🥶");
            }
        }
        score+=2;
    }

    public static void jokerPressed() {
        if (jokerUsage > 0) {
            gameDeck.removeCard(1);
            gameDeck.removeCard(1);
            if (!secondaryDeck.isEmpty()) {
                while(gameDeck.deckSize() < 4 && !secondaryDeck.isEmpty()) {
                    gameDeck.addCard(0,secondaryDeck.removeCard(secondaryDeck.deckSize()-1));
                }
            }
            if (secondaryDeck.isEmpty()) {
                while(gameDeck.deckSize() < 4 && !gameStack.isEmpty()) {
                    gameDeck.addCard(gameStack.pop());
                        System.out.println("JOKER : 🃏🃏🃏🃏🃏🃏🃏🃏");
                        System.out.println("Joker Usage : "+getJokerUsage());
                }
            }
            jokerUsage-=1;
        }
        else {
        System.out.println("No more jokers buddy");
        } 

    }

    //🥶
    public static void printDeck() {
        System.out.println("Primary deck : 🥇");
        gameDeck.printDeck();
        System.out.println("Secondary deck : 🥈");
        secondaryDeck.printDeck();
    }



}
