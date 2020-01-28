package citipe.kycdetails;

public class kycDetails {

	private long mobileNumber;
	private String aadharNumber;
	private String passportNumber;
	private String drivingLicenseNo;
	private String userName;
	private String kycStatus;
	private float kycWallet;
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public String getDrivingLicenseNo() {
		return drivingLicenseNo;
	}
	public void setDrivingLicenseNo(String drivingLicenseNo) {
		this.drivingLicenseNo = drivingLicenseNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getKycStatus() {
		return kycStatus;
	}
	public void setKycStatus(String kycStatus) {
		this.kycStatus = kycStatus;
	}
	public float getKycWallet() {
		return kycWallet;
	}
	public void setKycWallet(float kycWallet) {
		this.kycWallet = kycWallet;
	}
	@Override
	public String toString() {
		return "kycDetails [mobileNumber=" + mobileNumber + ", aadharNumber=" + aadharNumber + ", passportNumber="
				+ passportNumber + ", drivingLicenseNo=" + drivingLicenseNo + ", userName=" + userName + ", kycStatus="
				+ kycStatus + ", kycWallet=" + kycWallet + "]";
	}
	
	
	
	
	
}
