package citiipay.service;

import citiipay.dao.TransactionDAO;
import citiipay.implementation.TransactiondaoImpl;
import citiipay.messages.DBException;
import citiipay.models.CashBack;
import citiipay.models.Merchant;

public class TransactionService {

	private TransactionDAO transaction = new TransactiondaoImpl();

	public String walletTransaction(long senderMobileNo, long receiverMobileNo, float transferAmount, String comments)
			throws DBException {
		return transaction.walletTransaction(senderMobileNo, receiverMobileNo, transferAmount, comments);
	}

	public CashBack accountToWallet(long mobileNo, long accountNo, float amount, String comments) throws DBException {
		return transaction.accountToWallet(mobileNo, accountNo, amount, comments);
	}

	public Merchant payToMerchant(String merchantId, long mobileNo, float amount) throws DBException {
		return transaction.payToMerchant(merchantId, mobileNo, amount);
	}

	public String refundToCustomer(String merchantId, int transactionId, float amount) throws DBException {
		return transaction.refundToCustomer(merchantId, transactionId, amount);
	}
}
