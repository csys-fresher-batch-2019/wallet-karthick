package citipe.transactiondetails;

//import java.sql.Date;
import java.sql.Timestamp;
//import java.time.LocalDate;

public class TransactionDetails {
	
	private long senderNumber;
	private long receiverNumber;
	private String category;
	private float balance;
	private Timestamp transactionDate;
	private float transactionAmount;
	private String transactionStatus;
	public long getSenderNumber() {
		return senderNumber;
	}
	public void setSenderNumber(long senderNumber) {
		this.senderNumber = senderNumber;
	}
	public long getReceiverNumber() {
		return receiverNumber;
	}
	public void setReceiverNumber(long receiverNumber) {
		this.receiverNumber = receiverNumber;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public Timestamp getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}
	public float getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	@Override
	public String toString() {
		return "TransactionDetails [senderNumber=" + senderNumber + ", receiverNumber=" + receiverNumber + ", category="
				+ category + ", balance=" + balance + ", transactionDate=" + transactionDate + ", transactionAmount="
				+ transactionAmount + ", transactionStatus=" + transactionStatus + "]";
	}

	
	/*public TransactionDetails(long senderNumber, long receiverNumber, String category, Date transactionDate,
			float transactionAmount, String transactionStatus) {
		super();
		this.senderNumber = senderNumber;
		this.receiverNumber = receiverNumber;
		this.category = category;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.transactionStatus = transactionStatus;
	}*/
	

	

}
