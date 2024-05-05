import java.util.Objects;

public class Card {
    private String cardSuit;
    public String getCardSuit() {return cardSuit;}
    public void setCardSuit(String cardSuit) {this.cardSuit = cardSuit;}

    private String cardRank;
    public String getCardRank() {return cardRank;}
    public void setCardRank(String cardRank) {this.cardRank = cardRank;}

    

    public Card() {
        this.cardSuit = " ";
        this.cardRank = " ";
    }

    public Card(String c, String n) {
        this.cardSuit = c;
        this.cardRank = n;
    }

    @Override
    public String toString() {
        //Auto-generated
        return "\nCard: [cardSuit=" + cardSuit + ", cardRank=" + cardRank + "]";
    }

    public boolean equalsByRank(Object obj) {
        //checking if they both point to the same memory location (optimization)
        if (this == obj) {
            return true;
        }
        if(obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Card otherCard = (Card) obj;
        return Objects.equals(this.cardRank, otherCard.cardRank);
    }

    public boolean equalsBySuit(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Card otherCard = (Card) obj;
        return cardSuit == otherCard.cardSuit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Card other = (Card) obj;
        return Objects.equals(this.cardSuit, other.cardSuit) &&
               Objects.equals(this.cardRank, other.cardRank);
    }

    public int hashCode() {
        return Objects.hash(cardSuit, cardRank);
    }


}


    
    



