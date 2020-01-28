package citipe.bankdatabase;

public class UserDetails {
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public String getKycDetails() {
		return kycDetails;
	}
	public void setKycDetails(String kycDetails) {
		this.kycDetails = kycDetails;
	}
	private String userName;
	private long mobileNumber;
	private String emailId;
	private long accountNumber;
	private float balance;
	private String accountStatus;
	private String kycDetails;
	
	
	
	public UserDetails() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserDetails [userName=" + userName + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId
				+ ", accountNumber=" + accountNumber + ", balance=" + balance + ", accountStatus=" + accountStatus
				+ ", kycDetails=" + kycDetails + "]";
	}
	/*public UserDetails(String userName, long mobileNumber, String emailId, long accountNumber, float balance,
			String accountStatus, String kycDetails) {
		super();
		this.userName = userName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.accountStatus = accountStatus;
		this.kycDetails = kycDetails;
	}*/
	
	
}
