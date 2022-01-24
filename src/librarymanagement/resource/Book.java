package librarymanagement.resource;

public class Book{
	private int isbn;
	private String title;
	private String language;
	private int bookauthorId;
	private int bookcategoryId;
	private int noCopyActual;
	private int noCopyCurrent;
	
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getBookauthorId() {
		return bookauthorId;
	}
	public void setBookauthorId(int bookauthorId) {
		this.bookauthorId = bookauthorId;
	}
	public int getBookcategoryId() {
		return bookcategoryId;
	}
	public void setBookcategoryId(int bookcategoryId) {
		this.bookcategoryId = bookcategoryId;
	}
	public int getNoCopyActual() {
		return noCopyActual;
	}
	public void setNoCopyActual(int noCopyActual) {
		this.noCopyActual = noCopyActual;
	}
	public int getNoCopyCurrent() {
		return noCopyCurrent;
	}
	public void setNoCopyCurrent(int noCopyCurrent) {
		this.noCopyCurrent = noCopyCurrent;
	}
	
	

	
}
