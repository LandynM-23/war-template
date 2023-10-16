/**
 * Implement a playing card
 *
 * @author Mr. Jaffe
 * @version 2022-10-18
 */
public class Card
{
    private int rank;
    private String face;
    private String suit;

    /**
     * Constructor for objects of class Card
     */
    public Card(int rank, String face, String suit)        
    {
        this.rank = rank;
        this.face = face;
        this.suit = suit;
    }

    public int getRank() {
        return this.rank;
    }
    
    public String getSuit() {
        return this.suit;
    }

    public String getFace() {
        return this.face;
    }
}
