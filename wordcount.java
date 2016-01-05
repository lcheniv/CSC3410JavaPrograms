///////////////////////////////////////
/// NAME: Lawrence Chen             ///
/// PROF: Jaman Bhola               ///
/// ASSIGNMENT #2: Wordcount.java   ///
/// DUE: September 15th             ///
/// CLASS: CSc 3410                 ///
///////////////////////////////////////

/*
 *			Documentation part excluded; 
 * Write a program called wordcount.java that prompts the user for a user input file name,
 * reads the input words and do the following with those words:
 *		- Count words, a word can end with a --- space/tab, EOLN character or a punc mark
 *		- Count lines, amount of lines in the file
 *		- Count alphanumeric characters in the file
 *		- Count sentences
 *		- Count vowels, only a,e,i,o,u (UPPER & lower case)
 *		- Count punctuation
 *
 * You must output the above information both on the screen as well as in an output file name "output.txt"
 * 
 * Extra Requirement: The program must work even if the input file is empty. If this is the case print a message
 * saying that "the input file is empty" and then terminate the program.
 */

/* @author: Lawrence Chen     
       
    - The purpose of this program is to gain experience using string objects
    - by using generic algorithms to iterate through a vector/array list/ or array
    - as well as learning how file i/o. (Reading in a file, and outputting a new file)
   
    - The output should look like: 
     "Type read-in file here: 
	  C:\Users\Owner\Documents\Georgia State\FALL 2015\CSC 3410\input1.txt
	  File Found. 

	  word word word word
	  asdasd asd aaasd
	  asdsa.
	  asdasd.
	  asdasd?
	  1234 1234
      _____________________________________________ 
 
      Number of WORDS in file: 12
      Number of LINES in file: 6
      Number of ALPHANUMERIC CHARACTERS in file: 55
      Number of SENTENCES in file: 3
      Number of VOWELS in file: 16
      Number of PUNCTUATION MARKS in file: 3"
 
   
 Solution:      
    - Read in with scanner and put the input file into an array list
    - Create a count words, lines, alphanumeric characters, sentences, vowels, and punctuation
    - Print statements - for output file and regular output
    - For several of the counts, need to break down to char array
    - Iterate through character array to find needed keys
    - Try and catch used to throw a message if no input file was entered
    - or the input file could not be found
  
 Data structures to be used: 
       - One array list
           - One array to hold all of the elements from the input file
       - One string array that was created from the array list
       	   - Used to find spaces in words
           
 Description of how to use program and expected input/output:
       - The program requires user input that gives a file location and file to open
       		- EX: Type read-in file here: 
		----> C:\Users\Owner\Documents\Georgia State\FALL 2015\CSC 3410\input1.txt

       - The program will output:
       		- A prompt for a file to be read-in
            - The input file text being read-in
            - Confirmation of the file being used.
            - The contents of the file
            - All of the values from the count methods
            
  PRE AND POST CONDITIONS OF METHODS---------------------------------------------
  	All consist of utilizing the array list
  	and running for-loops and/or if statements 
  	to find requested value
  	
 */

import java.util.ArrayList;
import java.util.Scanner; // Access to scanner
import java.io.File;  // Access to File Objects
import java.io.FileNotFoundException; // Used for throw
import java.io.IOException;
import java.io.PrintWriter;

public class wordcount {
	public static void main(String args[]) throws FileNotFoundException{
		// Scanner to read user input and/or file inputs
		// Creates a File object from input.txt
		// ArrayList is initialized
		ArrayList<String> outList = null;
//--------------------------------------------------------------------------------
		// TRY AND CATCH to print out error message for input file
		try {
			outList = new ArrayList<String>();
			Scanner sc = new Scanner(System.in);
			System.out.println("Type read-in file here: ");
			File in = new File(sc.nextLine());
			String fileDir = in.getParent();
			sc = new Scanner(in);
			File out = new File(fileDir, "output.txt");
			PrintWriter output = new PrintWriter(out);

			System.out.println("File Found. \n" );
			
			// Prints whats in the file for viewing purposes
			// Also stores input file values into an array list
			while (sc.hasNextLine()) {
                String line = sc.nextLine();
                outList.add(line);
            }
//--------------------------------------------------------------------------------			
			// FINDS NUMBER OF LINES IN FILE
			// using for-loop and basic .size()
			int numLines = 0;
			for(int i = 0; i < outList.size(); i++){
				System.out.println(outList.get(i));
				output.println(outList.get(i));
				numLines++;
			}
//--------------------------------------------------------------------------------		
			// FINDS NUMBER OF WORDS IN FILE
			// By taking the arrayList and converting it to a string array
			// and finding every space, but adding one because there is 1 less space than words
			int numWords = numLines + 0;
			for(int i = 0; i < outList.size(); i++){
				String line = outList.get(i);
				for (int c = 0; c < line.length(); c++){
					if(line.charAt(c) == ' '){
						numWords++;
					}
				}
			}
//--------------------------------------------------------------------------------			
			// FINDS ALPHANUMERIC CHARACTERS IN FILE
			// Converts String Arraylist to a Char Array so I can iterate from
			// character/digit - incrementing if the if statement is true
			int numAlphaLetters = 0;
			int numAlphaNums = 0;
			int numAlphasComplete = 0;
			for(String s: outList){
				s.toCharArray();
				//for(String value : outList){
				//System.out.println(value);
					for(int j = 0; j < s.length(); j++){
						if(Character.isLetterOrDigit(s.charAt(j))){
							numAlphaLetters++;
						}
					numAlphasComplete = numAlphaLetters + numAlphaNums;
				}
			} // End of for String loop
//--------------------------------------------------------------------------------
			// FINDS NUMBER OF SENTENCES IN FILE
			// Finds punctuations that are common ending of sentences
			// If its a ?,., or ! its the end of a sentence so it increments one for numSentences
			int numSentences = 0;
			for(String s : outList){
				s.toCharArray();
				for(int i = 0; i < s.length(); i++){
					if(s.charAt(i) == '?' || s.charAt(i) == '.' || s.charAt(i) == '!')
                        numSentences++;
				}
			}
//--------------------------------------------------------------------------------
			// FIND VOWELS IN FILE
			// Breaks it down to individual characters
			// Iterates through and if its upper/lower case vowel
			// Increment the counter +1
			int numVowels = 0;
			String[] vowels = {"a", "e", "i", "o", "u"};
			for(String s: outList){
				s.toCharArray();
					for(int i = 0; i < s.length(); i++){
						if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i'
							|| s.charAt(i) == 'o' || s.charAt(i) == 'u' || s.charAt(i) == 'A' 
							|| s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U'){
							numVowels++;
						}
					}
			}
//--------------------------------------------------------------------------------
			// FIND PUNCTUATION MARKS IN FILE
			// If statements that iterates through characters in arraylist and if it matches
			// it increments numPuncs 
			int numPuncs = 0;
			for(String s: outList){
				s.toCharArray();
					for(int i = 0; i < s.length(); i++){
						if(s.charAt(i) == '.' || s.charAt(i) == '?' || s.charAt(i) == '!'
							|| s.charAt(i) == ':' || s.charAt(i) == ';' || s.charAt(i) == '-' || s.charAt(i) == '_' 
							|| s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == '[' || s.charAt(i) == ']'
							|| s.charAt(i) == '\'' || s.charAt(i) == '"'|| s.charAt(i) == '/' || s.charAt(i) == ','){
							numPuncs++;
						}
					}
			}
//--------------------------------------------------------------------------------	
			// Print-statement for number of lines counter
			System.out.println("_____________________________________________ \n ");
			System.out.println("Number of WORDS in file: " + numWords);
			System.out.println("Number of LINES in file: " + numLines);
			System.out.println("Number of ALPHANUMERIC CHARACTERS in file: " + numAlphasComplete);
			System.out.println("Number of SENTENCES in file: " + numSentences);
			System.out.println("Number of VOWELS in file: " + numVowels);
			System.out.println("Number of PUNCTUATION MARKS in file: " + numPuncs);
			
			// Print-statement for output file
			output.println("\n_____________________________________________ \n ");
			output.println("Number of WORDS in file: " + numWords);
			output.println("Number of LINES in file: " + numLines);
			output.println("Number of ALPHANUMERIC CHARACTERS in file: " + numAlphasComplete);
			output.println("Number of SENTENCES in file: " + numSentences);
			output.println("Number of VOWELS in file: " + numVowels);
			output.println("Number of PUNCTUATION MARKS in file: " + numPuncs);
			output.close();
//--------------------------------------------------------------------------------	
			// Catches errors - prints error message
		} catch(FileNotFoundException e){
			System.out.println("The input file is empty or incorrect. \n" +
			"Please re-run the program and try again.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	} // End of Main	
} // End of Class
