package citiipay.models;

public class BussinessLogin {

	private long mobileNumber;
	private String merchantId;
	private long accountNo;
	private int status;

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BussinessLogin [mobileNumber=" + mobileNumber + ", merchantId=" + merchantId + ", accountNo="
				+ accountNo + ", status=" + status + "]";
	}

}
