package librarymanagement.resource;

public class Book{
	private int isbn;
	private String title;
	private String language;
	private int authorId;
	private int categoryId;
	private int noCopyActual;
	private int noCopyCurrent;
	
	public Book(int isbn,String title,String language,int authorId,int categoryId, int noCopyActual, int noCopyCurrent) {
		this.isbn = isbn;
		this.title = title;
		this.language = language;
		this.authorId = authorId;
		this.categoryId = categoryId;
		this.noCopyActual = noCopyActual;
		this.noCopyCurrent = noCopyCurrent;
	}
	public int getIsbn(){
		return isbn;
		}
	public String getTitle() {
		return title;
	}
	public String getLanguage() {
		return language;
	}
	public int getAuthorId() {
		return authorId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public int getNoCopyActual() {
		return noCopyActual;
	}
	public int getNoCopyCurrent() {
		return noCopyCurrent;
	}

	
}
