package citipe.servicelayer;

import citipe.DAO.LoginCredentialsDAO;
import citipe.DAO.TransactionDAO;
import citipe.logincredentials.ImplementLoginCredentials;
import citipe.logincredentials.UserLogin;
import citipe.transactiondetails.ImplementTransactionDetails;

public class UserService {
	
	public boolean walletTransaction(long mobileNumber,long originator,int pinNumber,float amount) throws Exception {
		
	LoginCredentialsDAO userDAO = new ImplementLoginCredentials();
	String result=userDAO.login(mobileNumber,pinNumber);
	System.out.println(result);
	if(result.equals("Account logged-in") || result.equals("Account created")) {
    	TransactionDAO obj=new ImplementTransactionDetails();
    	obj.walletTransaction(mobileNumber, originator, amount);
    	//obj.walletTransaction(mobileNumber, transferAmount)
    	}
    else {
    	throw new Exception(result);
    }
	/*if(result==1) {
		String a=userDAO.login(mobileNumber, pinNumber);
		System.out.println(a);
	}
	UserLogin user=new UserLogin();
	
	TransactionDAO obj=new ImplementTransactionDetails();

	
	return true;*/
	return false;
	
	


}

}