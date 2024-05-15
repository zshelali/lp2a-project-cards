public class Main {
  public static void main(String[] args) throws Exception {
    System.out.println("gameStack size : "+ GameController.getGameStack().size());

    GameController.initGameStack();
    System.out.println("gameStack size : "+ GameController.getGameStack().size());
    GameController.initGameDeck();
    GameController.printDeck();

    System.out.println("gameStack size : "+ GameController.getGameStack().size());
    System.out.println("\n Current score : " +GameController.getScore());
    GameController.printDeck();

    new GUI();
  }
}
