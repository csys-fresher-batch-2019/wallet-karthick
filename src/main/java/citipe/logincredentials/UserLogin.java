package citipe.logincredentials;

public class UserLogin {
	
	private long mobileNumber;
	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	private int pinNumber;
	
	@Override
	public String toString() {
		return "UserLogin [mobileNumber=" + mobileNumber + ", pinNumber=" + pinNumber + "]";
	}
	
	public UserLogin(long mobileNumber, int pinNumber) {
		super();
		this.mobileNumber = mobileNumber;
		this.pinNumber = pinNumber;
	}

}
