//////////////////////////////////////////
/// NAME: Lawrence Chen                ///
/// ASSIGNMENT: Arraylist.java (#3)    ///
/// DUE: September 24th 2015           ///
/// PROF: Jaman Bhola                  ///
/// CLASS: CSc 3410                    ///
//////////////////////////////////////////

/*
 * Driver class that tests all of Arraylist.java
 * methods that implement the Arraylist class.
 */

/* @author: Lawrence Chen      

    - The purpose of this program is to be able to write and implement the ArrayList Data Structure
    - Create methods to implement the normal functions of an Arraylist
    - get, remove, find, isIn, isEmpty, add(at end of arraylist), add(at index)
    - Print values found and show methods work
   
    - The output should look like: 
    "Added (9) values into the Arraylist at the end - Completed.
	 Added value at specific location - Completed (Added 1 value.)
	 Removed 2 from the Arraylist - Completed.
	 
	 Contents of the Array are now:
	 5
	 8
	 9
	 7
	 10
	 11
	 12
 	 7

	 THESE ARE PRINTED VALUES USING ARRAYLIST METHODS
	 10 --- Printed size (elements in the arraylist) - size Method
	 5 --- Value at Arraylist[0] - get method
	 10 --- Value at Arraylist[5] - get method again
	 false --- IF true, arraylist is empty. If False, not empty - isEmpty Method 
	 true --- IF true, value is in Arraylist. If False, not in - isIn Method
	 6 --- Finding 11 from Arraylist - prints index location - find Method " 
   
 Solution: 
    - This should list all of the steps in your algorithm.  Example is below.
    - Suggestion:
        - Do this part first if you want to use it to help create your algorithm
       
    - Create an arraylist implementation using Arrays
    - Create two constructors to set the default cap to 10
    - Create methods - get, remove, find, isIn, isEmpty, add(at end of arraylist), add(at index)
    - Call methods in main class
    - Added values to array to show add method works
    - Call each method created to show it works
    - Print all return values from arraylist implement methods
  
 Data structures to be used: 
       - One array
           - One array to act as an arraylist that has default cap of 10
           - Can except any type object and increases capacity if original size fills up
           
 Description of how to use program and expected input/output:
       - The program does not require any user input.
       		- Can add values to test (if needed)
       - The program will output text containing:
            - Completed statements - Saying that the method used was completed
            - The contents of the Arraylist implementation
            - The return values from the Arraylist method implementation
 */

public class testarray {
	public static void main(String args[]){
		Arraylist aArr = new Arraylist();
		aArr.setSize(50); // Constructor to set size of Arraylist - Works
		aArr.add(5);
		aArr.add(8);
		aArr.add(9);
		aArr.add(2);
		aArr.add(7);
		aArr.add(10);
		aArr.add(11);
		aArr.add(12);
		aArr.add(13);
		aArr.add(7, 9);
		aArr.find(5);
		
		System.out.println("Added (9) values into the Arraylist at the end - Completed.");
		System.out.println("Added value at specific location (Added 1 value.) - Completed. ");
		System.out.println("Set the size of the Arraylist to 50 - Completed.");
		aArr.remove(2);
		
		System.out.println("Removed 2 from the Arraylist - Completed.");
		System.out.println("\nContents of Array are now:");
		for(int i = 0; i < aArr.size(); i++){
			if(aArr.get(i) == null){
				continue;
			}else{
			System.out.println(aArr.get(i));
			}
		}
		
		System.out.println();
		System.out.println("THESE ARE PRINTED VALUES USING ARRAYLIST METHODS");
		System.out.println(aArr.size() + " --- Printed size (ele"
				+ "ments in the arraylist) - size Method");
		System.out.println(aArr.get(0) + " --- Value at Arraylist[0] - get method");
		System.out.println(aArr.get(5) + " --- Value at Arraylist[5] - get method again");
		System.out.println(aArr.isEmpty() + " --- IF true, arraylist is empty. If False, not empty - isEmpty Method ");
		System.out.println(aArr.isIn(10) + " --- IF true, value is in Arraylist. If False, not in - isIn Method");
		System.out.println(aArr.find(11) + " --- Finding 11 from Arraylist - prints index location - find Method");	
	}
}
