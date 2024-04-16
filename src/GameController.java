import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;



public class GameController {


    public static void initDeck(int size) throws IOException {
        CardDeck gameDeck = new CardDeck();

        File file = new File("src/game_cards.txt");

        try {
            RandomAccessFile scanner = new RandomAccessFile(file, "r");            
            // while (scanner.hasNextLine()) {
            //     String line = scanner.nextLine();
            //     Card card = new Card();
            //     gameList.addCard(card);
            // }
            System.out.println("int : "+scanner.read());
            Card card = new Card();
            card.setCardNumber(scanner.readInt());
            card.setTheSuit(scanner.readChar());
            gameDeck.addCard(card);
            
            scanner.close();

            gameDeck.printDeck();

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
            e.printStackTrace();
        }
        
        }

    public static void start() {
        //interface
        System.out.println("Game starts ! ");




        // Scanner sc = new Scanner(System.in);
        // String input = sc.nextLine();

        // Object proposedItem;
        // if (input.length() == 1) {
        //     proposedItem = input.charAt(0);
        // }
        // else {
        //     proposedItem = input;
        // }
        
        

    }

}
