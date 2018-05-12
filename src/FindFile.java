import java.io.File;

/****************************************************/
/*						DESCRIPTION					*/
/* This class will search for a file by name in a	*/
/* given directory.	Below is some pseudocode of the */
/* class.*/
/****************************************************/

/****************************************************/
/*						PSEUDOCODE					*/
/* class FindFile {
 * 
 *	> Take in a number that represents the maximum number
 *	of files requested to be found during the search.
 *	
 *	> Get a file name to look for as well as a directory
 *	to start looking in/over. 
 *
 *		> Make sure the directory is actually a directory
 *		and if it's not, do something useful.
 *			> if it is actually a directory, then check to see
 *			if it has the same name as the file name, if it does,
 *			then it's a file. Also add the name of the path to
 *			a list to keep track of where that file was found
 *	> Get the number of files that were found during the program's run.
 *
 *	> Get the list of paths where the files were found.
 * }
 * */
/****************************************************/
public class FindFile {
	
	private int maxFiles;
	private int matchedFilesCount = 0;
	private String[] fileLocations;
	
	public FindFile(int maxFiles){
		this.maxFiles = maxFiles;
		fileLocations = new String[maxFiles];
	}
	
	
	void directorySearch(String target, String dirName){
		
	}
	
	public String[] getFiles(){
		
	}
	
	public int getCount(){
		return matchedFilesCount;
	}
	
	public void setMaxFiles(int maxFiles){
		if(maxFiles <= 0){
			System.out.println("invalid number: " + maxFiles);
		}else{
			this.maxFiles = maxFiles;
		}
	}
}
