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

	/*Instances Variables
	 * maxfiles --> Maximum ## of files that may be found during the given search
	 * matchedFilesCount --> Used to keep track of the current standing for the ## of files found
	 * fileLocations --> Array of pathnames that the files were found in
	 * targetFile --> The name of the file that is being searched for
	 * */
	private int maxFiles;
	private int matchedFilesCount = 0;
	private String[] fileLocations;
	private String targetFile;

	public FindFile(int maxFiles){
		this.maxFiles = maxFiles;
		fileLocations = new String[maxFiles];
	}

	/*	directorySearch(String,String)
	 * This method, in conjunction with a helper method,
	 * takes in two String values to represent a target
	 * file name and a directory to start looking through.
	 * A new File object is created and directory is validated
	 * to be a directory using the isDirectory() method from 
	 * the File class.
	 * If it is a directory, send that directory to be looked
	 * through in the lookForFile helper method (where the recursive lookup happens)
	 * */
	public void directorySearch(String target, String dirName){

		File directory = new File(dirName);

		setTargetFileName(target); //set the target name so I can use it later

		if(directory.isDirectory()){
			lookForFile(directory);
		}else{
			/* <p>Will throw an exception caught in the driving class
			 * from returning a null directory. This could be permission
			 * related and the user does not have access
			 * to a particular directory</p>
			 * 
			 * @exception*/
			throw new IllegalArgumentException();
		}
	}
	
	/* This method is where the recursive calling actually
	 * happens. In this method, an object with the value
	 * of a directory is passed in from the method directorySearch.
	 * The directory is then checked here during each stack.
	 * 
	 * @param targetDirectory File Object type used to reference
	 * the varying value of the current working directory.
	 * 
	 * @param currentPosition used as an Object pointer
	 * to compare against the targetDirectory on the String level.
	 * 
	 * @param targetDirectory used to "drop down" a single dimensional
	 * array of a list of Files in the current working directory
	 * */
	private void lookForFile(File targetDirectory) {

		if (targetDirectory.isDirectory()) {
			System.out.println("Looking for: " + getTargetFileName() 
					+ " in: " + targetDirectory.getAbsoluteFile());

			for (File currentPosition : targetDirectory.listFiles()) {
				if (getTargetFileName().equalsIgnoreCase(currentPosition.getName())) {
					fileLocations[matchedFilesCount++] = targetDirectory.getAbsolutePath();
					System.out.println("Found " + targetFile + " in " + targetDirectory.getAbsolutePath());
				} else {
					/*Recursive call with */
					lookForFile(currentPosition);
				}
			}
		}
	}

	public String[] getFileLocations(){
		return fileLocations;
	}

	public int getCount(){
		return matchedFilesCount;
	}

	public String getTargetFileName() {
		return targetFile;
	}

	public void setTargetFileName(String targetFile) {
		this.targetFile = targetFile;
	}

	/*
	 * Sets the maximum number of files 
	 * to find that match the given
	 * target name. Added some minor boundaries
	 * on the possible number. 
	 * 
	 * @see public FindFile constructor
	 * @see maxFiles
	 * */
	public void setMaxFiles(int maxFiles){
		if(maxFiles <= 0 || maxFiles >= 100000000){
			System.out.println("invalid or really large number: " + maxFiles);
		}else{
			this.maxFiles = maxFiles;
		}
	}
}
