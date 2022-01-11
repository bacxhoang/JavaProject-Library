package librarymanagement.resource;

import java.sql.Time;
import java.sql.Date;

public class Borrower {
	private int borrowerId;
	private int bookId;
	private Time borrowedFrom;
	private Time borrowedTo;
	private Date returnedDate;
	private int issuedBy;
	
	public Borrower(int borrowerId,int bookId,Time borrowedFrom,Time borrowedTo,Date returnedDate,int issuedBy) {
		this.borrowerId = borrowerId;
		this.bookId = bookId;
		this.borrowedFrom = borrowedFrom;
		this.borrowedTo = borrowedTo;
		this.returnedDate = returnedDate;
		this.issuedBy = issuedBy;
	}
	
	public int getborrowerId() {
		return borrowerId;
	}

	public int getBookId() {
		return bookId;
	}

	public Time getBorrowedFrom() {
		return borrowedFrom;
	}

	public Time getBorrowedTo() {
		return borrowedTo;
	}

	public Date getReturnedDate() {
		return returnedDate;
	}

	public int getIssuedBy() {
		return issuedBy;
	}
}
