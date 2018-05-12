package RecursiveBinarySearch;

/* *
* This class, LinearSearch contains two methods. One for 
* a linear search for files by name within a list
* and the other recursively.  
* */

public class LinearSearch extends SearchAlgorithm {

	private int i = 0;

	/* *
	* This method is the iterative, linear search for
	* text that matches other text. The list is passed in
	* along with a key word to check against for each new
	* iteration of the array. 
	*
	* @param wordList is a populated with values from a text file.
	* 
	* @param singleWord used to check against. Is a single String
	* value that is compared to for each iteration of the array.
	* 
	* @see PATH_TO_FILE for details on location of String list.
	*
	* */
	public int search(String[] wordList, String singleWord) throws ItemNotFoundException{
		for(int i=0;i<wordList.length;i++){
			if(wordList[i].equals(singleWord)){
				//incrementCount();
				return i;
			}else{
				incrementCount();
			}
		}
		if(getCount() <= 0){
			/*If there were no matches, throw an exception*/
			throw new ItemNotFoundException();
		}
		return getCount();
	}


	/* *
	* This is the recursive version of the method above. Or at least an attempt at one.  
	* The list and single word to look for are passed in through the parameters
	* wordList and singleWord respectively. If the index, i, is less than the 
	* length of the list, check to see if the String at that index is equal
	* to the String we're looking for. If they match, return the index. If not,
	* increment the index by one and increment the count variable of the super()
	* class by one. Then return the call to the same method to perform the same
	* operation at the next index.
	*
	* @see wordList
	* @see singleWord
	* */
	public int recSearch(String[] wordList, String singleWord) throws ItemNotFoundException{

		if(i < wordList.length){
			if(wordList[i].equalsIgnoreCase(singleWord)){
				return i;
			}
			i++;
		}else{
			i++;
			incrementCount();
			return recSearch(wordList,singleWord);
		}
		return getCount();
	}
}