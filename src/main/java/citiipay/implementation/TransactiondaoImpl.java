package citiipay.implementation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Types;
import java.util.Random;

import citiipay.connectionutil.Connect;
import citiipay.dao.TransactionDAO;
import citiipay.messages.DBException;
import citiipay.messages.ErrorMessages;
import citiipay.models.CashBack;
import citiipay.models.Merchant;

public class TransactiondaoImpl implements TransactionDAO {

	public String walletTransaction(long senderMobileNo, long receiverMobileNo, float amount, String comments)
			throws DBException {

		try (Connection conn = Connect.connect();
				CallableStatement cStmt = conn.prepareCall("{call wallet_proc(?,?,?,?,?)}");) {
			cStmt.setLong(1, senderMobileNo);
			cStmt.setLong(2, receiverMobileNo);
			cStmt.setFloat(3, amount);
			cStmt.setString(4, comments);
			cStmt.registerOutParameter(5, Types.VARCHAR);
			cStmt.executeUpdate();
			String result = cStmt.getString(5);
			if (result.equals("Transaction Successfull")) {
				SmsSend.msgSender(senderMobileNo, receiverMobileNo, amount);
				SmsSend.msgReceiver(senderMobileNo, receiverMobileNo, amount);
			}
			return result;
		} catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}
	}

	@Override
	public CashBack accountToWallet(long mobileNo, long accountNo, float amount, String comments) throws DBException {

		try (Connection conn = Connect.connect();
				CallableStatement cStmt = conn.prepareCall("{call account_to_wallet(?,?,?,?,?)}");) {
			cStmt.setLong(1, accountNo);
			cStmt.setLong(2, mobileNo);
			cStmt.setFloat(3, amount);
			cStmt.setString(4, comments);
			cStmt.registerOutParameter(5, Types.VARCHAR);
			cStmt.executeUpdate();
			String result = cStmt.getString(5);
			CashBack object = new CashBack();
			object.setResult(result);
			if (result.equals("Transaction Successfull")) {
				SmsSend.msgReceiver(accountNo, mobileNo, amount);
				TransactiondaoImpl obj = new TransactiondaoImpl();
				int rows = 0;
				if (amount > 100 && amount <= 1000) {
					Random r = new Random();
					int low = 10;
					int high = 50;
					int wallet = r.nextInt(high - low) + low;
					rows = obj.addingCashback(mobileNo, wallet);
					if (rows == 1) {
						object.setCashbackAmount(wallet);
					}
				} else if (amount > 1000 && amount <= 5000) {
					Random r = new Random();
					int low = 50;
					int high = 250;
					int wallet = r.nextInt(high - low) + low;
					rows = obj.addingCashback(mobileNo, wallet);
					if (rows == 1) {
						object.setCashbackAmount(wallet);
					}
				} else if (amount > 5000) {
					Random r = new Random();
					int low = 250;
					int high = 500;
					int wallet = r.nextInt(high - low) + low;
					rows = obj.addingCashback(mobileNo, wallet);
					if (rows == 1) {
						object.setCashbackAmount(wallet);
					}
				}
			}
			return object;
		} catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}
	}

	public int addingCashback(long mobileNo, float amount) throws DBException {

		String sql = "update kyc set kyc_wallet=kyc_wallet+" + amount + " where mobile_no=" + mobileNo;
		try (Connection conn = Connect.connect(); Statement stmt = conn.createStatement();) {
			int rows = stmt.executeUpdate(sql);
			return rows;

		} catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}
	}

	public Merchant payToMerchant(String merchantId, long mobileNo, float amount) throws DBException {

		try (Connection conn = Connect.connect();
				CallableStatement cStmt = conn.prepareCall("{call pay_to_merchant(?,?,?,?,?)}");) {
			cStmt.setString(1, merchantId);
			cStmt.setLong(2, mobileNo);
			cStmt.setFloat(3, amount);
			cStmt.registerOutParameter(4, Types.VARCHAR);
			cStmt.registerOutParameter(5, Types.INTEGER);
			cStmt.executeUpdate();
			Merchant obj = new Merchant();
			int id = cStmt.getInt(5);
			String status = cStmt.getString(4);
			obj.setTransactionId(id);
			obj.setStatus(status);
			if (status.equals("Transaction Successfull")) {
				SmsSend.msgMerchantPay(merchantId, mobileNo, amount);
			}
			return obj;
		} catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}

	}

	@Override
	public String refundToCustomer(String merchantId, int transactionId, float amount) throws DBException {

		try (Connection conn = Connect.connect();
				CallableStatement cStmt = conn.prepareCall("{call refund_to_customer(?,?,?,?)}");) {
			cStmt.setInt(1, transactionId);
			cStmt.setString(2, merchantId);
			cStmt.setFloat(3, amount);
			cStmt.registerOutParameter(4, Types.VARCHAR);
			cStmt.executeUpdate();
			String status = cStmt.getString(4);
			return status;
		} catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}
	}

}
