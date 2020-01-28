package citipe.DAO;

public interface kycDetailsDAO {
	
	public int walletBalanceCheck(long mobileNumber) throws Exception;
	
	public String addingKyc(long mobileNumber,String aadharNumber,String passportNumber,String drivingLicenseNo,String userName) throws Exception;
	
	public String addingCashback(long mobileNumber,int cashback) throws Exception;
}
