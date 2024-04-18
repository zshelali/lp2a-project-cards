import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;





public class GameController {
    private static GameStack gameStack = new GameStack();
    private static Random random = new Random();


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
                System.out.println("Duplicate card detected: " + tempCard);
            }
            
        }

        //System.out.println(usedCards);
        System.out.println(gameStack.size()+ " " +gameStack.toString());
        
    }
        

}
