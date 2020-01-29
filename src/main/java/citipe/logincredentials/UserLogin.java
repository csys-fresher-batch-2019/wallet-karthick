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
		return "UserLogin [mobileNumber=" + mobileNumber + ", pinNumber=" + getPinNumber() + "]";
	}
	
	public UserLogin(long mobileNumber, int pinNumber) {
		super();
		this.mobileNumber = mobileNumber;
		this.setPinNumber(pinNumber);
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}

}
