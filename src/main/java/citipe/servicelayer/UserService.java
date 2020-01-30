package citipe.servicelayer;

import citipe.DAO.LoginCredentialsDAO;
import citipe.DAO.TransactionDAO;
import citipe.logincredentials.ImplementLoginCredentials;
import citipe.transactiondetails.ImplementTransactionDetails;

public class UserService {
	
	public boolean walletTransfer(long mobileNumber,long originator,int pinNumber,float amount) throws Exception {
		
	LoginCredentialsDAO userDAO = new ImplementLoginCredentials();
	String result=userDAO.login(mobileNumber,pinNumber);
	String result1="";
	boolean result2=false;
	if(result.equals("Account logged-in") || result.equals("Account created")) {
    	TransactionDAO obj=new ImplementTransactionDetails();
    	result1=obj.walletTransaction(mobileNumber, originator, amount);
    	if(result1.equals("Transaction Successfull")) {
    		result2=true;
    	}
    	else {
    		result2=false;
    	}
    	}
    else {
    	throw new Exception(result);
    }
	return result2;
}
}