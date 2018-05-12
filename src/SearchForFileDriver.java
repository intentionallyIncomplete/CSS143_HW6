import java.io.File;

/* SearchForFileDriver class (base class)
 *
 * This class is the driver for the FindFile class
 * the uses its main method to create a new object
 * from that class with the String values
 * of a file name and a directory.
 * 
 * @author Ian Bryan
 * @version 1.0

 * */

public class SearchForFileDriver {

	
	public static void main(String[] args) {
		/*
		 * @see maxFiles
		 * */
		FindFile finder = new FindFile(5);

		String targetFile = "FILE_NAME_HERE(INCLUDING_TYPE_EXTENSION)";
		String pathToSearch = "STARTING_PATH_HERE";

		/* try-catch block for catching
		 * the exception that is thrown from
		 * the FindFile class when the directory
		 * is null. 
		 * 
		 * @throws
		 * */
		try{
			finder.directorySearch(targetFile,pathToSearch);
		}catch(IllegalArgumentException iae){
			/*@exception 
			 *@see FindFile
			 *@see searchDirectory
			 *@see else clause
			 */
			System.out.println(iae + " was thrown from the program and caught during runetime");
		}
	}
}