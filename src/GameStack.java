import java.util.Stack;

public class GameStack {
    private Stack<Card> stack;

    public GameStack() {
        this.stack = new Stack<>();
    }
   
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    public void push(Card c) {
        this.stack.push(c);
    }

    public void pop() {
        this.stack.pop();
    }

    public Card peek() {
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
