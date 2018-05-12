package RecursiveBinarySearch;

/* *
 * Class description
 *
 * This class is the BinarySearch version of the previous class which 
 * was for linear searches. The essential principle of Binary Searches
 * is that you are cutting down the number of "things" you need
 * to check against by 50% each time you DON'T find what you're 
 * looking for. This is done by taking the list, splitting it,
 * checking to find if the value we're looking for is before
 * or after the point we just determined was the middle of the list
 * and then deciding to either check one part of the list or another. 
 *
 * @param wordList @see LinearSearch
 * @param singleWord @see LinearSearch
 * */

public class BinarySearch extends SearchAlgorithm {

	public int search(String[] wordList, String singleWord) throws ItemNotFoundException {

		/*lowIndex keeps track of whatever is on the left
		 * highIndex is always the last in the list of 
		 * whichever new list is being handled. 
		 * In this case, lowIndex will be 0, and 
		 * highIndex will start with a value of 47,657 (number of 
		 * lines (elements) in the list.*/
		int lowIndex = 0;
		int highIndex = wordList.length - 1;

		/*while lowIndex <= highIndex
			set midIndex == (highIndex - lowIndex) /2;
			if singleWord is < midIndex, set highIndex = midIndex-1;
			if singleWord is > midIndex, set lowIndex = midIndex + 1;
			else singleWord matches the word at midIndex, return midIndex;
		if singleWord wasn't found, throw ItemNotFoundException*/

		while(lowIndex < highIndex){

			int midIndex = (highIndex - lowIndex) /2; //first run sets midIndex to 23,828

			/*
			 * The return value of the compareTo method is a negative value
			 * if the Object comes BEFORE the Object it's being compared TO.
			 * This line below checks to find out just that. If the index at
			 * the newly acquired midIndex value is lexicographically (whatever that is)
			 * the same as what I'm telling it to check against, it will return -1*/
			if(wordList[midIndex].compareTo(singleWord) < 0){
				lowIndex = midIndex +1;
			}
			/*Else if the String at the current index, compared to
			 * the word specified is not in the "top" half, set 
			 * the upper boundary of the highIndex to one less than
			 * the midIndex. This basically tells the next iteration
			 * to check the "bottom" half of the array (the first half).*/
			else if(wordList[midIndex].compareTo(singleWord) > 0){
				highIndex = midIndex -1;
			}

			/*If neither of the two above conditions are met, then increment 
			 * the count because it must be a match and return the midIndex 
			 * positioned String. This may not be the exact center, but the center of 
			 * a pair of Strings.*/
			else{
				incrementCount();
				return midIndex;
			}	
		}
		return getCount();
	}

	/* *
	 * This is the recursive form of the method above. It will have a nearly
	 * identical output with some minor differences in the counts. The idea
	 * is to take the list, just like above, and split it but instead of checking
	 * a condition and adjusting the array, this will call the method
	 * against to send back a comparable String value to check
	 * against the specified string. Depending on the condition met, the
	 * places to check over are both in size (array size) and position.
	 *
	 * @param wordList @see LinearSearch
	 * @param wordList @see LinearSearch
	 * */
	public int recSearch(String[] wordList, String singleWord) throws ItemNotFoundException {

		int lowIndex = 0;
		int highIndex = wordList.length -1;
		int midIndex = (highIndex - lowIndex) /2 ;

		if(highIndex < lowIndex){
			return -1;
		}

		/*Check first if the word we're looking for is at the first split
		 * of the array, if it is then that's great because then the work
		 * is done and we just need to return that String at that index*/
		else if(singleWord.equals(wordList[midIndex])){
			incrementCount();
			return midIndex; //found the word!
		}

		/* Similar to the method above, this condition will check
		 * the String at the specified index to check for if when
		 * compared to the value we want, they are the same. If they are,
		 * then using a new String[] set the new list of Strings
		 * equal to the first half of the original list.
		 * The value of this array is returned as the parameter for
		 * wordList and the method runs again with the previous state
		 * suspended.
		 * */
		else if(wordList[midIndex].compareTo(singleWord) < 0){
			String[] comparableString = new String[midIndex - 1];
			for(int i=0;i<midIndex;i++){
				comparableString[i] = wordList[i];
			}
			return recSearch(comparableString, singleWord);
		}

		/*
		 * This method does the opposite of the above method in that
		 * it uses a condition to check if the return value of using
		 * the compareTo method from the String class is positive (>0).
		 * If it is, then we know to create a new list of Strings that
		 * is equal to the latter half of the array - or the position of the
		 * middle going all the way to the end. Then the new list is returned
		 * back to the same method (recursive call) to check again, then again,
		 * and again until all the values have been checked. 
		 * */
		else if(wordList[midIndex].compareTo(singleWord) > 0){
			String[] comparableString = new String[midIndex - 1];
			for(int i=0;i<midIndex-1;i++){
				comparableString[i] = wordList[i];
			}
			return recSearch(comparableString, singleWord);
		}

		/*If none of the above conditions were met, then this else clause
		 * will take care of making sure the method is called again while it's running
		 * by creating a new String list and setting it's size to the value of
		 * the end position, minus the middle position, and then take one off that
		 * to set the position to the first half of the original list. 
		 * Using a for-loop, simply set the new list equal to the values of
		 * the original list. This part here just works as a simple case situation
		 * to make sure the list, if nothing happened, is sent back into the method
		 * to be checked again.
		 * */
		else {
			String[] comparableString = new String[highIndex - midIndex - 1];

			for(int i=0;i<comparableString.length;i++){
				comparableString[i] = wordList[midIndex +i +1];
			}
			return recSearch(comparableString, singleWord);
		}
	}
}
