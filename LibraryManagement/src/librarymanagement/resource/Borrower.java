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
	
	public Borrower(int borrowerId,int bookId,Date borrowedFrom,Date borrowedTo,Date returnedDate,int issuedBy) {
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

	public Date getBorrowedFrom() {
		return borrowedFrom;
	}

	public Date getBorrowedTo() {
		return borrowedTo;
	}

	public Date getReturnedDate() {
		return returnedDate;
	}

	public int getIssuedBy() {
		return issuedBy;
	}
}
