package citiipay.dao;

import java.util.ArrayList;

import citiipay.messages.DBException;
import citiipay.models.CashBack;
import citiipay.models.Merchant;
import citiipay.models.MerchantTableDetails;
import citiipay.models.TransactionDetails;

public interface TransactionDAO {

	public CashBack walletTransaction(long senderMobileNo, long receiverMobileNo, float transferAmount, String comments)
			throws DBException;

	public String accountToWallet(long mobileNo, long accountNo, float amount, String comments) throws DBException;

	public Merchant payToMerchant(String merchantId, long mobileNo, float amount) throws DBException;

	public String refundToCustomer(String merchantId, int transactionId, float amount) throws DBException;
	
	public ArrayList<TransactionDetails> transactionDebited(long mobileNumber)
			throws DBException;
	
	public ArrayList<TransactionDetails> transactionCredited(long mobileNumber)
			throws DBException;
	
	public ArrayList<MerchantTableDetails> transactionMerchant(long mobileNumber)
			throws DBException;
}
