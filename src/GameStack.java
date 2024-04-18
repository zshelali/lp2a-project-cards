import java.util.Stack;

public class GameStack {
    private Stack<Card> stack;

    public GameStack() {
        this.stack = new Stack<>();
    }
   
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    public void pushCard(Card c) {
        this.stack.push(c);
    }

    public void popCard() {
        this.stack.pop();
    }

    public Card peekCard() {
        return this.stack.peek();
    }

    public int size() {
        return stack.size();
    }

    @Override
    public String toString() {
        return stack.toString();
    }
    
}
