import java.util.List;
import java.util.ArrayList;

/**
 * War game class
 *
 * @author Mr. Jaffe
 * @version 2022-10-19
 */
public class War
{
    /**
     * Constructor for the game
     * Include your initialization here -- card decks, shuffling, etc
     * Run the event loop after you've done the initializations
     */
    public Deck p1Deck;
    public Deck p2Deck;
    public War()
    {
        Deck mainDeck = new Deck();
        mainDeck.initializeNewDeck();
        mainDeck.shuffle();
        
        Deck[] splitDecks = mainDeck.dealDeck();
        p1Deck = splitDecks[0];
        p2Deck = splitDecks[1];
        
        this.runEventLoop();
    }
    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop() {
        int i = 0;
        while (i < 300 && p1Deck.getDeckSize() > 0 && p2Deck.getDeckSize() > 0) {
            Card p1Card = p1Deck.dealCardFromDeck();
            Card p2Card = p2Deck.dealCardFromDeck();
            System.out.println("Player 1 played: " + p1Card.getFace() + " of " + p1Card.getSuit());
            System.out.println("Player 2 played: " + p2Card.getFace() + " of " + p2Card.getSuit());
            List<Card> middlePile = new ArrayList<>();
            if (p1Card.getRank() > p2Card.getRank()) {
                p1Deck.addCardToDeck(p1Card);
                p1Deck.addCardToDeck(p2Card);
                System.out.println("Player 1 wins this round");
            } else if (p1Card.getRank() < p2Card.getRank()) {
                p2Deck.addCardToDeck(p1Card);
                p2Deck.addCardToDeck(p2Card);
                System.out.println("Player 2 wins this round");
            } else {
                System.out.println("Time for war");
                middlePile.add(p1Card);
                middlePile.add(p2Card);
                while (true) {
                    if (p1Deck.getDeckSize() < 4 || p2Deck.getDeckSize() < 4) {
                        System.out.println("One player does not have sufficient cards for war");
                        if (p1Deck.getDeckSize() < 4) {
                            System.out.println("Player 2 wins");
                        } else {
                            System.out.println("Player 1 wins");
                        }
                        return;
                    }
                    for (int k = 0; i < 3; k++) {
                        middlePile.add(p1Deck.dealCardFromDeck());
                        middlePile.add(p2Deck.dealCardFromDeck());
                    }
                    p1Card = p1Deck.dealCardFromDeck();
                    p2Card = p2Deck.dealCardFromDeck();
                    System.out.println("Player 1's war card: " + p1Card.getFace() + " of " + p1Card.getSuit());
                    System.out.println("Player 2's war card: " + p2Card.getFace() + " of " + p2Card.getSuit());
                    middlePile.add(p1Card);
                    middlePile.add(p2Card);
                    if (p1Card.getRank() > p2Card.getRank()) {
                        p1Deck.addCardsToDeck(middlePile);
                        System.out.println("Player 1 wins the war");
                        break;
                    } else if (p1Card.getRank() < p2Card.getRank()) {
                        p2Deck.addCardsToDeck(middlePile);
                        System.out.println("Player 2 wins the war");
                        break;
                    } else {
                        System.out.println("Time for war, again");
                    }
                }
            }
            i++;
        }
        if (p1Deck.getDeckSize() > p2Deck.getDeckSize()) {
            System.out.println("Player 1 wins the game!");
        } else if (p1Deck.getDeckSize() < p2Deck.getDeckSize()) {
            System.out.println("Player 2 wins the game!");
        } else {
            System.out.println("It's a draw!");
        }
    }
    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }
}
