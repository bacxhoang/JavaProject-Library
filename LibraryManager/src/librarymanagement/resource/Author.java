package librarymanagement.resource;

public class Author{
	private int authorId;
	private String authorName;
	
	public Author(int authorId,String authorName){
		this.authorId = authorId;
		this.authorName = authorName;
	}
	public int getAuthorId() {
		return authorId;
	}
	public String getAuthorName() {
		return authorName;
	}

}
