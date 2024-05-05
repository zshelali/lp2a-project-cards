import java.util.Stack;

public class GameStack extends Stack<Card>{
    private Stack<Card> stack;

    public GameStack() {
        this.stack = new Stack<Card>();
    }
    
    @Override
    public String toString() {
        return stack.toString();
    }
    
}