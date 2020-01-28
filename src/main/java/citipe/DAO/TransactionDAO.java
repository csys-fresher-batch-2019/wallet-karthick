package citipe.DAO;

import java.util.ArrayList;

import citipe.transactiondetails.TransactionDetails;

public interface TransactionDAO {
		
	public String balanceCheck(long mobileNumber,int pinNumber) throws Exception;
	
	public String toDoTransaction(long senderMobileNo,long receiverMobileNo,float transferAmount,int pinNumber) throws Exception;
		
	public ArrayList<TransactionDetails> transactionHistoryByCategory(long mobileNumber,String category) throws Exception;
	
	public int pinCheck(long mobileNumber,int pinNumber) throws Exception;
	
	public String pinUpdate(long mobileNumber,int pinNumber) throws Exception ;
	
	public String walletTransaction(long senderMobileNo,long receiverMobileNo,float transferAmount) throws Exception;

}
