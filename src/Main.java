public class Main {
    public static void main(String[] args) throws Exception {

        GameController.initGameStack();
        GameController.initGameDeck();
        GameController.gameCompare();
        GameController.gameResume();


        //debug sheiße
        System.out.println("gameStack size : "+ GameController.getGameStack().size());
        System.out.println("\n Current score : " +GameController.getScore());

        // GameController.initGameDeck();
        //     GameController.gameResume();
             

          while(GameController.getGameStack().size()>0) {
            System.out.println("Entering the while loop :\n");
            GameController.initGameDeck();
            GameController.gameCompare();
            GameController.gameResume();
            System.out.println("gameStack size : "+ GameController.getGameStack().size());
            System.out.println("\n Current score : " +GameController.getScore());
            GameController.printDeck();

          }

        
    }
}

