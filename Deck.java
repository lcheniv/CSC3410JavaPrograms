package deck;
import java.util.Vector; // Enables vector usage
import java.util.Collections;
import java.util.Random; // Used for Shuffle method

////////////////////////////
/// NAME: Lawrence Chen  ///
/// PROF: Jaman Bhola    ///
/// CLASS: CSc 3410      ///
/// ASSIGN: Deck.java    ///
/// DUE: September 3rd   ///
////////////////////////////

/*
 * Objective: To gain experience with vectors and generic algorithms.
 * Description: Write a program named Deck.java that creates a deck of cards.
 * 52 Cards - 4 suits (Spades, Clubs, Diamonds, Hearts)
 * 13 cards - Ace, King, Queen, Jack, 10 through 2
 * Note: Ace acts as 1, so therefore a class named Card.java needs to be
 * created so that each card can be created
 * 
 * Place the deck of cards in a vector in sorted order with all 13 hearts, 
 * then 13 clubs, then 13 spades, then 13 diamonds
 * 
 * Then randomly shuffle deck of cards (at least 20 times) and display new 
 * randomly shuffled deck of cards.
 * 
 * 1) Display contents of Vector
 * 2) Generate all 13 spades, clubs, diamonds, hearts
 * 3) Randomly shuffle 20 times
 * 4) Display new shuffled cards
 * [DO NOT USE EMBEDDED SHUFFLE] - USE VECTOR, NOT ARRAY
 */

public class Deck {
	public static void main(String args[]){
		
		// Initialized the vector with a capacity of 52
		Vector <String>vec = new Vector<String>(52);
		
		// For-loops for each 13 cards - creates each suit with each rank creating 52 cards
		int i,j;
		for(String suit : new String[]{" of Hearts"," of Clubs"," of Spades"," of Diamonds"} ) {
			//System.out.println( "suit = " + suit ); Debugging - checking if it ran through String array
			for(i = 14; i > 1; i--){
				if(i == 14){
					vec.add("Ace" + suit);
				} else if (i == 11){
					vec.add("Jack" + suit);
				} else if (i == 12){
					vec.add("Queen" + suit);
				} else if (i == 13){
					vec.add("King" + suit);
				} else{
					vec.add(i + suit);
				}
			}
		}
		
		// Print-statement for all 52 cards created
		for(String s : vec) {
			System.out.println(s);
		}
		
		// Shuffle method to rearrange all the cards without a clue of where each card is
		// Pick a card at random and pick another spot
		// Can't put it in another spot because the other spot is already filled.
		// Remove that card. And put it in another spot.
		// Perfect shuffle - no idea of the order
		// If you change every card - you have an idea of what happened
		// This runs a nested for-loop that swaps out cards from the vector at random by using
		// the built-in swap method that takes a list and asks for 2 positions that will swap
		
		// SHUFFLE - METHOD --- Using Swap method which takes in a list and swaps out 2 given positions
		for(i = 0; i <= vec.size(); i++ ){
			for(j = 0; j <= vec.size(); j++){
				Collections.swap(vec,(int)(i * Math.random()), (int)(j * Math.random()));
			}
		}
		System.out.println();
		System.out.println("START OF SHUFFLED CARDS:");
		for(i = 0; i <= vec.size() - 1; i++){
			System.out.println(vec.elementAt(i));
		}
								
	} // End of Main
} // End of Class

