package librarymanagement.resource;

public class Book{
	private int isbn;
	private String title;
	private String language;
	private int authorId;
	private int categoryId;
	private int noCopyActual;
	private int noCopyCurrent;
	
	public Book() {
		this.isbn = isbn;
		this.title = title;
		this.language = language;
		this.authorId = authorId;
		this.categoryId = categoryId;
		this.noCopyActual = noCopyActual;
		this.noCopyCurrent = noCopyCurrent;
	}
	public int getIsbn(int isbn){
		return isbn;
		}
	public String getTitle(String title) {
		return title;
	}
	public String getLanguage(String language) {
		return language;
	}
	public int getAuthorId(int authorId) {
		return authorId;
	}
	public int getCategoryId(int categoryId) {
		return categoryId;
	}
	public int getNoCopyActual(int noCopyActual) {
		return noCopyActual;
	}
	public int getNoCopyCurrent(int noCopyCurrent) {
		return noCopyCurrent;
	}

	
}
