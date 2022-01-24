package librarymanagement.resource;

import java.sql.Time;
import java.sql.Date;

public class Borrower {
	private int borrowerNum;
	private int borrowerbookId;
	private Date borrowedFrom;
	private Date borrowedTo;
	private Date returnedDate;
	private int issuedBy;
	
	public int getBorrowerNum() {
		return borrowerNum;
	}
	public void setBorrowerId(int borrowerNum) {
		this.borrowerNum = borrowerNum;
	}
	public int getBorrowerbookId() {
		return borrowerbookId;
	}
	public void setBorrowerbookId(int borrowerbookId) {
		this.borrowerbookId = borrowerbookId;
	}
	public Date getBorrowedFrom() {
		return borrowedFrom;
	}
	public void setBorrowedFrom(Date borrowedFrom) {
		this.borrowedFrom = borrowedFrom;
	}
	public Date getBorrowedTo() {
		return borrowedTo;
	}
	public void setBorrowedTo(Date borrowedTo) {
		this.borrowedTo = borrowedTo;
	}
	public Date getReturnedDate() {
		return returnedDate;
	}
	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}
	public int getIssuedBy() {
		return issuedBy;
	}
	public void setIssuedBy(int issuedBy) {
		this.issuedBy = issuedBy;
	}

}