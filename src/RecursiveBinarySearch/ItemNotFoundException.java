package RecursiveBinarySearch;

/* *
/* Custom exception handling class. Very basic
 * Extends the Exception class in order
 * to be thrown from other classes.
 */

public class ItemNotFoundException extends Exception{

	/*
	 * 
	 * @param simply produces a message to the console
	 * for when a condition is met in another class
	 * specified by that class.
	 * */
	public ItemNotFoundException(){getMessage();}
	
	public String getMessage(){return " was not found";}
}
