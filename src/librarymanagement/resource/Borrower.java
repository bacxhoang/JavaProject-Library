package librarymanagement.resource;

import java.sql.Date;
import java.io.Serializable;

public class Borrower implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int borrowerNum;
	private int borrowerbookId;
	private Date borrowedFrom;
	private Date borrowedTo;
	private Date returnedDate;
	private int issuedBy;
	
	public Borrower(int borrowerNum,int borrowerbookId,Date borrowedFrom,Date borrowedTo,Date returnedDate,int issuedBy) {
		this.borrowerNum = borrowerNum;
		this.borrowerbookId = borrowerbookId;
		this.borrowedFrom = borrowedFrom;
		this.borrowedTo = borrowedTo;
		this.returnedDate = returnedDate;
		this.issuedBy = issuedBy;
	}
	
	public int getBorrowerNum() {
		return borrowerNum;
	}
	public void setBorrowerNum(int borrowerNum) {
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