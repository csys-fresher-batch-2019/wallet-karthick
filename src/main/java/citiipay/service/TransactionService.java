package citiipay.service;

import java.util.ArrayList;

import citiipay.dao.TransactionDAO;
import citiipay.implementation.TransactiondaoImpl;
import citiipay.messages.DBException;
import citiipay.models.CashBack;
import citiipay.models.Merchant;
import citiipay.models.MerchantTableDetails;
import citiipay.models.TransactionDetails;

public class TransactionService {

	private TransactionDAO transaction = new TransactiondaoImpl();

	public CashBack walletTransaction(long senderMobileNo, long receiverMobileNo, float transferAmount, String comments)
			throws DBException {
		return transaction.walletTransaction(senderMobileNo, receiverMobileNo, transferAmount, comments);
	}

	public String accountToWallet(long mobileNo, long accountNo, float amount, String comments) throws DBException {
		return transaction.accountToWallet(mobileNo, accountNo, amount, comments);
	}

	public Merchant payToMerchant(String merchantId, long mobileNo, float amount) throws DBException {
		return transaction.payToMerchant(merchantId, mobileNo, amount);
	}

	public String refundToCustomer(String merchantId, int transactionId, float amount) throws DBException {
		return transaction.refundToCustomer(merchantId, transactionId, amount);
	}
	
	public ArrayList<TransactionDetails> transactionDebited(long mobileNumber)
			throws DBException{
		return transaction.transactionDebited(mobileNumber);
	}
	
	public ArrayList<TransactionDetails> transactionCredited(long mobileNumber)
			throws DBException{
		return transaction.transactionCredited(mobileNumber);
	}
	
	public ArrayList<MerchantTableDetails> transactionMerchant(long mobileNumber)
			throws DBException{
		return transaction.transactionMerchant(mobileNumber);
	}
}
