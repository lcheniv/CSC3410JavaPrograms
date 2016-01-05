package deck;
import java.util.Vector;
import java.util.Random;
import java.util.Collections;
/*
 * This is for get-methods
 * in order to get suits and ranks
 * for the cards
 * 
 * Getter, setters, also toString
 * 
 * Suit: Hearts, Clubs, Spades, Diamonds
 * Rank: Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, JACK, QUEEN, KING
 * Value: 1 -----------------------------, 11,  12,   13
 */

public class card{
	private String suit;
	private String rank;
	int value; 
	private static Vector<String> new_deck;
	private static Random r = new Random();
	//card c1 = new card(suit, rank);
	
	public card(String suit, String rank){
		this.suit = suit;
		this.rank = rank;
	}
	
	public void setSuit(String new_suit){
		this.suit = new_suit;
	}
	
	public void setRank(String new_rank){
		this.rank = new_rank;
	}
	// Method to only change needed values - 1,11,12,13 - Ace,Jack,Queen,King
	public void setValue(int v1){
		if(v1 == 1){
			rank = ("Ace");
		}
		else if(v1 == 11){
			rank = ("Jack");
		}
		else if(v1 == 12){
			rank = ("Queen");
		}
		else if(v1 == 13){
			rank = ("King");
		}
		else {
			rank = Integer.toString(value); // Don't need since theres a built-in toString method for vectors
		}
	}
	
//	public String toString(){
//	    return (suit + " " + rank);
//	}
	
} // End of Class

