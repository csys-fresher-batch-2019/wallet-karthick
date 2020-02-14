package citiipay.dao;

import citiipay.messages.DBException;
import citiipay.models.CashBack;
import citiipay.models.Merchant;

public interface TransactionDAO {

	public String walletTransaction(long senderMobileNo, long receiverMobileNo, float transferAmount, String comments)
			throws DBException;

	public CashBack accountToWallet(long mobileNo, long accountNo, float amount, String comments) throws DBException;

	public Merchant payToMerchant(String merchantId, long mobileNo, float amount) throws DBException;

	public String refundToCustomer(String merchantId, int transactionId, float amount) throws DBException;
}
