import java.util.Objects;

public class Card {
    private char theSuit;
    private int cardNumber;

    public Card() {
        this.theSuit = ' ';
        this.cardNumber = 0;
    }

    public Card(char c) {
        this.theSuit = c;
        this.cardNumber = 0;
    }

    public char getTheSuit() {
        return theSuit;
    }

    public void setTheSuit(char theSuit) {
        this.theSuit = theSuit;
    }

    public int getCardNumber() {
        return cardNumber;
    }


    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        //Auto-generated
        return "\nCard: [theSuit=" + theSuit + ", cardNumber=" + cardNumber + "]";
    }

    public boolean equalsByNumber(Object obj) {
        //checking if they both point to the same memory location (optimisation)
        if (this == obj) {
            return true;
        }
        if(obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Card otherCard = (Card) obj;
        return Objects.equals(this.cardNumber, otherCard.cardNumber);
    }

    public boolean equalsBySuit(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Card otherCard = (Card) obj;
        return theSuit == otherCard.theSuit;
    }
}
    
    



