//////////////////////////////////////////
/// NAME: Lawrence Chen                ///
/// ASSIGNMENT: phonedir.java (#4)     ///
/// DUE: October 8th 2015              ///
/// PROF: Jaman Bhola                  ///
/// CLASS: CSc 3410                    ///
//////////////////////////////////////////

import java.util.LinkedList;
import java.util.Scanner;

/*
 * Write a program named phonedir.java (using Java Linked List)that maintains a list of records 
 * containing names and phone numbers. The program will prompt the user for a command, execute 
 * the command, then prompt the user for another command. The commands must be chosen from the 
 * following possibilities:
 * 
 * 		[a] - Show all records, [d] - Delete the current record, [f] - Change the first name in the current record,
 * 		[l] - Change the last name in the current record, [n] - Add a new record, [p] - Change the phone number in the current record
 * 		[q] - Quit, [s] - Select a record from the record list to become the current record
 * 
 */

/* @author: Lawrence Chen   

   - The purpose of this program is to gain experience using Java's Linked List Data structure
   - We are to create a Phone directory using Java's linked list
   - To utilize the linked list structure type, adding records, deleting records, editing records,
   - and organizing records is required in order to develop a better idea of Java's Linked List
  
   - The output should look like: 
      -----[ P H O N E   D I R E C T O R Y ]----- 
* Type in letter corresponding to your command * 
[a] - Show all records 

[d] - Delete the current record 

[f] - Change the first name in the current record 

[l] - Change the last name in the current record 

[n] - Add a new record 

[p] - Change the phone number in the current record 

[q] - Quit 

[s] - Select a record from the record list to become the current record 

Enter a command from the list above (q to quit): 

if [a] is input

[MSG]: The phone directory is empty.
[MSG]: Try adding a record. 

or 

Records in current directory is:

Lawrence Chen 777-777-7777

if [d] is input

Deleted: Lawrence Chen 777-777-7777

if [f].... and so on. Run program to see.
  
Solution:       
   - Create an empty Linked List
   - Create a constructor class, getters, setters
   - Create a switch statement for each input command available
   - Call all of the methods to the switch statement accordingly
   - Methods consist of: showRecords(), deleteRecord(), changeFirst(), changeLast()
   	   					 addRecord(), changePhone(), Quit is just System.exit, and selectRecord()
   - Take user input based on selected command and run each method
   - Continually print welcome commands for further user input
 
Data structures to be used: 
      - One linked list
          - One linked list to hold all of the records that are added
          - Also to hold for reference, editing, and deletions
          
Description of how to use program and expected input/output:
      - The program requires user input
      	   - Enter letter corresponding to function requested
      - The program will output lines of text containing:
           - Either a [MSG]: showing there's a problem
           - or the correct print out asking for user input
           - Follow commands in prompt - straight forward
           - Easy user interaction. 
*/

public class phonedir {
		// ** LINKED LIST DECLARATION ** //
		static LinkedList<Record> phoneBook = new LinkedList<Record>();
		static int currentRecord = -2;
		static int tempCurrRecord = -2;
		
	// ** START OF MAIN METHOD ** //
	public static void main(String args[]){
		String listCommand = "";
		while(!listCommand.equals("q")){
			// ** REOCCURING WELCOME MESSAGE ** //
			welcomeOptions();
			
			if(currentRecord > -1){
				System.out.println("[MSG]: Current record is: " 
						+ phoneBook.get(currentRecord).getFirst() + " " 
						+ phoneBook.get(currentRecord).getLast() + " | "
						+ phoneBook.get(currentRecord).getNumber());
				System.out.println();
				currentRecord = -2;
			} else{
				// ** SCANNER INITIALIZATION ** //
				Scanner sc = new Scanner(System.in);
				listCommand = sc.nextLine().toLowerCase();
				
				// ** SWITCH STATEMENT - TAKES USER INPUT AND RUNS ACCORDINGLY TO IT ** //
				switch(listCommand){
				case "a": showRecords(); break;
				case "d": deleteRecord(); break;
				case "f": changeFirst(); break;
				case "l": changeLast(); break;
				case "n": addRecord(); break;
				case "p": changeNumber(); break;
				case "q": System.out.println("[MSG]: Exited program.");
						  System.out.println("[MSG]: Goodbye!");
						  System.exit(-1); break;
				case "s": selectRecord(); break;
				default: System.out.println("[MSG]: Invalid command. Please try again.");
				continue;
				}
				continue;
			}
		}
	}
//--------** WELCOME MESSAGE METHOD **---------------------------------------------------------------------------	
	// - runs everytime previous command list is finished (just prints)
	// - Precondition: Takes in nothing. static void
	// - Postconiditon: Prints out command window for user
	private static void welcomeOptions(){
		//Scanner sc = new Scanner(System.in);
		System.out.println("  -----[ P H O N E   D I R E C T O R Y ]----- ");
		System.out.println("* Type in letter corresponding to your command * ");
		System.out.println("[a] - Show all records \n");
		System.out.println("[d] - Delete the current record \n");
		System.out.println("[f] - Change the first name in the current record \n");
		System.out.println("[l] - Change the last name in the current record \n");
		System.out.println("[n] - Add a new record \n");
		System.out.println("[p] - Change the phone number in the current record \n");
		System.out.println("[q] - Quit \n");
		System.out.println("[s] - Select a record from the record list to become the current record \n");
		System.out.println("Enter a command from the list above (q to quit): \n");
		//String listCommand = sc.nextLine();
	}
//--------** SHOW RECORDS METHOD (a) **--------------------------------------------------------------------------
	// - runs a for loop and gathers first, last, and phone number to print
	// - Precondition: Takes in nothing. static void
	// - Postcondition: Returns nothing - void - but prints out either list
	// 					or error message prompted.
	private static void showRecords(){
		if(phoneBook.size() != 0){
			System.out.println("                *** Records in Phone Directory: ***\n");
			System.out.println("* First Name               Last Name           Phone Number *");
			System.out.println("__________________________________________________________________\n");
			for(int i = 0; i < phoneBook.size(); i++){
				System.out.println(phoneBook.get(i).getFirst() + "                      " 
						+ phoneBook.get(i).getLast() + "               "
						+ phoneBook.get(i).getNumber());
			}
		}else if(phoneBook.size() == 0){
			System.out.println("\n[MSG]: The phone directory is empty.");
			System.out.println("[MSG]: Try adding a record. \n");
		}
		System.out.println("__________________________________________________________________\n");
	}
//--------** DELETE RECORD METHOD (d) **-------------------------------------------------------------------------	
	// - If there is no current record, nothing to delete
	// - Otherwise, it removes the current record from the list
	// - Precondition: Takes in nothing. static void
	// - Postconiditon: Void. No return However prints either Deleted record
	//                     or error message prompted. Also, current record variables are set.
	private static void deleteRecord(){
		if(tempCurrRecord != -2){
		System.out.println("[MSG]: Deleted: " + phoneBook.get(tempCurrRecord).getFirst() + "         "
				+ phoneBook.get(tempCurrRecord).getLast() + "        " 
				+ phoneBook.get(tempCurrRecord).getNumber() +"\n");
		phoneBook.remove(tempCurrRecord);
		tempCurrRecord = -2;
		} else{
			System.out.println("[MSG]: No current record to delete.\n");
		}
	}
//--------** CHANGE FIRST METHOD (f) **--------------------------------------------------------------------------
	// - Takes the current record and changeFirst(String Object) on the current record
	// - Precondition: Takes in nothing. static void
	// - Postcondition: Void. No return. However, prints out request for user input
	//                  or error message prompted. Also, current record variables are set depending if the if statement goes through
	private static void changeFirst(){
		if(phoneBook.size() != 0){
			System.out.println("Enter new first name: ");
			Scanner sc = new Scanner(System.in);
			String newFirst = sc.nextLine();
			int index = 0;
			phoneBook.get(tempCurrRecord).changeFirst(newFirst);
			tempCurrRecord = index;
			currentRecord = index;
		} else{
			System.out.println("[MSG]: The phone directory is empty.");
		}
}
//--------** CHANGE LAST METHOD (l) **---------------------------------------------------------------------------
	// - Takes the current record and changeLast(String Object) on the current record
	// - Precondition: Takes in nothing. static void
	// - Postcondition: Void. No return. However, prints out request for user input
    //				    or error message prompted. Also, current record variables are set.
	private static void changeLast(){
		if(phoneBook.size() != 0){
			System.out.println("Enter new last name: ");
			Scanner sc = new Scanner(System.in);
			String newLast = sc.nextLine();
			int index = 0;
			phoneBook.get(tempCurrRecord).changeLast(newLast);
			for(int i = 0; i < phoneBook.size(); i++){
				String newRecordInfo = phoneBook.get(tempCurrRecord).getLast();
				String oldRecordInfo = phoneBook.get(i).getLast();
				if(oldRecordInfo.toLowerCase().compareTo(newRecordInfo.toLowerCase()) < 0){
					index = i + 1;
				}
			}
			tempCurrRecord = index;
			currentRecord = index;
		} else{
			System.out.println("[MSG]: The phone directory is empty.");
		}
	}
//--------** ADD RECORD METHOD (n) **----------------------------------------------------------------------------
	// - If the record doesn't exist yet, it adds the record to the list
	// - and compares the record to the other existing records to place it in accordingly
	// - Precondition: Takes in nothing. static void
	// - Postcondition: Void. No return. However, prints out request for user input (First,Last, and Phone)
	//                  or error message prompted. Also, current record variables are set.
	private static void addRecord(){
		System.out.println("Enter first name: ");
		Scanner sc = new Scanner(System.in);
		String first = sc.nextLine();
		System.out.println("Enter last name: ");
		String last = sc.nextLine();
		System.out.println("Enter phone number: ");
		String phoneNum = sc.nextLine();
		System.out.println();
		String newUserInfo = first + last + phoneNum;
		int index = 0;
		//if(phoneBook.size() != 0){
			for(int i = 0; i < phoneBook.size(); i++){
				String existLast = phoneBook.get(i).getLast();
				String newUserLast = last;
				if(newUserLast.toLowerCase().equals(existLast.toLowerCase())){
					System.out.println("This phone record already exist.");
					System.out.println("Existing Record: " + existLast);
				} else if(existLast.toLowerCase().compareTo(newUserLast.toLowerCase()) < 0){
					index = i + 1;
				}
			}
			phoneBook.add(index, new Record(first, last, phoneNum));
			currentRecord = index;
			tempCurrRecord = index;
		//}
	}
		
//--------** CHANGE NUMBER METHOD (p) **-------------------------------------------------------------------------
	// - Takes current record and changePhone(String Object) on it
	// - Precondition: Takes in nothing. static void
	// - Postcondition: Void. No return. However, prints out request for user input
	// 					or error message prompted. Also current record variables are set.
	private static void changeNumber(){
		if(phoneBook.size() != 0){
			System.out.println("Enter new phone number: ");
			Scanner sc = new Scanner(System.in);
			String newNumber = sc.nextLine();
			int index = 0;
			phoneBook.get(tempCurrRecord).changePhone(newNumber);
			tempCurrRecord = index;
			currentRecord = index;
		} else{
			System.out.println("[MSG]: The phone directory is empty.");
		}
	}
//--------** SELECT RECORD METHOD (s) **-------------------------------------------------------------------------
	// - Takes in user input and depending if it exist or not, it will set the 
	// - user requested record to be the new current record
	// - Precondition: Takes in nothing. static void
	// - Postcondition: Void. No return. However, prints out request for user input
	//                  or error message is prompted. Also, current record variables are set
	private static void selectRecord(){
		int index = -1;
		System.out.println("Enter first name:");
		Scanner sc = new Scanner(System.in);
		String firstName = sc.nextLine();
		System.out.println("Enter last name: ");
		String lastName = sc.nextLine();
		for(int i = 0; i < phoneBook.size(); i++){
			if(firstName.toLowerCase().equals(phoneBook.get(i).getFirst().toLowerCase()) && 
					lastName.toLowerCase().equals(phoneBook.get(i).getLast().toLowerCase())){
				
				index = i;
			}
		}
		if(index == -1){
			System.out.println("\nNo matching record found.\n");
		}
		currentRecord = index;
		tempCurrRecord = index;
	}
}
