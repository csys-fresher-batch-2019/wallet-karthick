package citiipay.models;

import java.sql.Timestamp;

public class MerchantTableDetails {
	
	private int transactionId;
	private String merchantId;
	private long mobileNo;
	private float amount;
	private String comments;
	private Timestamp transactionDate;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Timestamp getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}
	@Override
	public String toString() {
		return "MerchantTableDetails [transactionId=" + transactionId + ", merchantId=" + merchantId + ", mobileNo="
				+ mobileNo + ", amount=" + amount + ", comments=" + comments + ", transactionDate=" + transactionDate
				+ "]";
	}
	
	

}
