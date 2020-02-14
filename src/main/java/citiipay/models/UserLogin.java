package citiipay.models;

public class UserLogin {

	private long mobileNumber;
	private int pinNumber;
	private int status;

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserLogin [mobileNumber=" + mobileNumber + ", pinNumber=" + pinNumber + ", status=" + status + "]";
	}

}
