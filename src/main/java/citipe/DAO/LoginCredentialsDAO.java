package citipe.DAO;

public interface LoginCredentialsDAO {
	
	public String login(long mobileNumber,int pinNumber) throws Exception;
	
	public String pinUpdate(long mobileNumber,int pinNumber) throws Exception;
	
	public String forgetPassword(long mobileNumber, String userName, long accountNumber) throws Exception;
	
	public int mobVerification(long mobileNumber) throws Exception;


}