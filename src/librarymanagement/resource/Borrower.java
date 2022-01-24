package librarymanagement.resource;

import java.sql.Time;
import java.sql.Date;

public class Borrower {
	private int borrowerId;
	private int bookId;
	private Date borrowedFrom;
	private Date borrowedTo;
	private Date returnedDate;
	private int issuedBy;
	
	public Borrower() {
		this.borrowerId = borrowerId;
		this.bookId = bookId;
		this.borrowedFrom = borrowedFrom;
		this.borrowedTo = borrowedTo;
		this.returnedDate = returnedDate;
		this.issuedBy = issuedBy;
	}
	
	public int getborrowerId(int borrowerId) {
		return borrowerId;
	}

	public int getBookId(int bookId) {
		return bookId;
	}

	public Date getBorrowedFrom(Date borrowedFrom) {
		return borrowedFrom;
	}

	public Date getBorrowedTo(Date borrowedTo) {
		return borrowedTo;
	}

	public Date getReturnedDate(Date returnedDate) {
		return returnedDate;
	}

	public int getIssuedBy(int issuedBy) {
		return issuedBy;
	}
}
