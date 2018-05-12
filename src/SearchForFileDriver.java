
public class SearchForFileDriver {

	private String targetFile;
	private String pathToSearch;
	
	public static void main(String[] args) {
		
		FindFile finder = new FindFile(5);
		finder.directorySearch("git", "C:/Users/Quigy Laptop/Desktop");
	}

}
