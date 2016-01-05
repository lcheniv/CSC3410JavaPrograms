import java.util.Arrays;

//////////////////////////////////////////
/// NAME: Lawrence Chen                ///
/// ASSIGNMENT: Arraylist.java (#3)    ///
/// DUE: September 24th 2015           ///
/// PROF: Jaman Bhola                  ///
/// CLASS: CSc 3410                    ///
//////////////////////////////////////////

/*
 * Objective : To be able to write and implement the ArrayList Data Structure
 * Description : You are to write a program named Arraylist.java that implements the Arraylist data 
 * structure that exist in the java library. 
 * - The class must be written to accept any type of Objects.
 * 		- [DO NOT IMPORT THEM FROM THE JAVA LIBRARY] -
 * 
 * - 1) One default constructor that will create an Arraylist object with a default size (capacity of 10) - public Arraylist();
 * - 2) Another constructor that accepts a parameter of type int and sets the size to this parameter - public Arraylist(int n);
 * - 3) A method that allows you to place a value at the end of the Arraylist - public void add(Object x);
 * - 4) A method that allows you to place a value at a given location - public void add(int index, Object x);
 * - 5) A method that allows you to retrieve a value from a given location - public Object get(int index);
 * - 6) A method that gives the number of elements in the Arraylist - public int size();
 * - 7) A method would test to see if the Arraylist is empty - public boolean isEmpty();
 * - 8) A method that see if a particular object exist in the Arraylist - public boolean isIn(Object ob);
 * - 9) A method that will return the location of first occurrence of an Object starting from location 0 - public int find(Object n);
 * -10) A method that will remove the first occurrence of an Object starting from location 0 - public void remove (Object n);
 * 
 * - Now, write a driver program (the class with the public static void main(String[] args) method) name testarray.java to test the Arraylist 
 * 	 data structure you just created. That is, you must test all ten (including the default constructor) of the above methods. For those that 
 *   are returning a value, print out the returned value to the screen and for those that are not returning a value, print a message that 
 *   indicate if it successfully completed its task.
 *   
 * * Remember --- the size function should be based upon the actual # of elements you have in the Arraylist.
 */

public class Arraylist {
	private Object[] arrList;
	private int default_Cap = 10;
	private int size = 0; // # of elements in use
	
	// Constructor that creates an Arraylist object with a default capacity of 10
	public Arraylist(){
		arrList = new Object[default_Cap];
	}
	
	// Method that takes in type int and sets the size to the int parameter
	public int setSize(int n){
		arrList = new Object[n];
		return n;
	}
	
	// Precondition: Takes in an object x
    // Postcondition: No return. Places added value at end of array
	// Method that places value at the end of the Arraylist
	public void add(Object x){
		//make room for a new element - increase size
		//actually edit arrList - arrList.length
		//put the new element in place
		if(arrList.length - size <= 5){
			arrList = Arrays.copyOf(arrList, arrList.length*2);
		}
		arrList[size++] = x; //Adds value to where new allocated spot was created
	}
	
	// Precondition: Takes in an object and integer value
    // Postcondition: No return. Places added value at index value of array
	// Method that places value at a given location
	public void add(Object x, int index){
		if(arrList.length - size <= 5){
			arrList = Arrays.copyOf(arrList, arrList.length*2);
		}
		arrList[index] = x; //Adds value to the index input
		size++;
	}
	
	// Precondition: Takes in an integer value
    // Postcondition: Returns value at index of array - print
	// Method that retrieves a value from a given location
	public Object get(int index){
		if(index < arrList.length){
			return arrList[index];
		} else{
			throw new ArrayIndexOutOfBoundsException("Index " + index + " is out of bounds.");
		}
	}
	
	// Precondition: ------ integer
    // Postcondition: Returns size - number of elements in the Arraylist
	// Method that returns the number of elements in the Arraylist
	public int size(){
		return size;
	}
	
	// Precondition: ------ boolean
    // Postcondition: Returns false if array is not empty, true if is empty
	// Method that tests to see if arraylist is empty
	public boolean isEmpty(){
		// OR IF SIZE = 0?
		for(int i = 0; i <= arrList.length; i++){
			if(arrList[i] != null){
				return false;
			}
		}
		return true;
	}
	
	// Precondition: Takes in object 
    // Postcondition: Returns true if Object is in array, false if not
	// Method that checks for a particular object is in the arraylist
	public boolean isIn(Object ob){
		for(int i = 0; i <= arrList.length; i++){
			if(arrList[i] == (ob)){
				return true;
			}
		}
		return false;
	}
	
	// Precondition: Takes in object
    // Postcondition: Returns location of the first occurence of the object, -1 if not found
	// Method that will return location of the first occurence of an Object starting from location 0
	public int find(Object n){
		//boolean done = false;
		//while(done != true){
			for(int i = 0; i < arrList.length; i++){
				if(arrList[i] == (n)){ 
					//done = true;
					return i;
				}
			}	
		//}
		return -1; // Stops it if it can't find the value
	}
	
	// Precondition: Takes in object
    // Postcondition: No return - Removes first occurence of object
	// Method that removes first occurrence of Object starting from location 0
	public void remove(Object n){
			for(int i = 0; i < arrList.length; i++){
				if(arrList[i] == (n)){
					arrList[i] = null;
				}
			}
	}// End of remove
}// End of 
