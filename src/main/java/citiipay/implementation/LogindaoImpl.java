package citiipay.implementation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

import citiipay.connectionutil.Connect;
import citiipay.dao.LoginDAO;
import citiipay.messages.DBException;
import citiipay.messages.ErrorMessages;
import citiipay.messages.InfoMessages;

public class LogindaoImpl implements LoginDAO {

	public String personalRegister(long mobileNumber, int pinNumber) throws DBException {

		try (Connection conn = Connect.connect();
				CallableStatement stmt = conn.prepareCall("{call register_loginpersonal(?,?,?)}");) {
			stmt.setLong(1, mobileNumber);
			stmt.setInt(2, pinNumber);
			stmt.registerOutParameter(3, Types.VARCHAR);
			stmt.executeUpdate();
			String result = stmt.getString(3);
			if (result.equals("Account created")) {
				SmsSend.msgPersonal(mobileNumber);
			}
			return result;
		} catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}

	}

	public int mobPersonalVerification(long mobileNumber) throws DBException {

		try (Connection conn = Connect.connect();
				CallableStatement stmt = conn.prepareCall("{call mob_chk_proc(?,?)}");) {
			stmt.setLong(1, mobileNumber);
			stmt.registerOutParameter(2, Types.INTEGER);
			stmt.executeUpdate();
			int result = stmt.getInt(2);
			return result;
		} catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}
	}

	public String bussinessRegister(long mobileNumber, String merchantId, long accountNo) throws DBException {
		try (Connection conn = Connect.connect();
				CallableStatement stmt = conn.prepareCall("{call register_bussiness(?,?,?,?)}");) {
			stmt.setLong(1, mobileNumber);
			stmt.setString(2, merchantId);
			stmt.setLong(3, accountNo);
			stmt.registerOutParameter(4, Types.VARCHAR);
			stmt.executeUpdate();
			String result = stmt.getString(4);
			if (result.equals("Account created")) {
				SmsSend.msgBussiness(mobileNumber);
			}
			return result;
		} catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}
	}

	public int mobBussinessVerification(long mobileNumber) throws DBException {

		try (Connection conn = Connect.connect(); CallableStatement stmt = conn.prepareCall("{call mob_new(?,?)}");) {
			stmt.setLong(1, mobileNumber);
			stmt.registerOutParameter(2, Types.INTEGER);
			stmt.executeUpdate();
			int result = stmt.getInt(2);
			return result;
		} catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}
	}

	public String login(long mobileNumber, int pinNumber) throws DBException {

		try (Connection conn = Connect.connect();
				CallableStatement cStmt = conn.prepareCall("{call login_personal(?,?,?)}");) {
			cStmt.setLong(1, mobileNumber);
			cStmt.setInt(2, pinNumber);
			cStmt.registerOutParameter(3, Types.VARCHAR);
			cStmt.executeUpdate();
			String result = cStmt.getString(3);
			return result;
		} catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}
	}

	public String forgetPassword(long mobileNumber, int pinNumber) throws DBException {
		String sql = "update login set upi_passwd=? where mobile_no=?";
		try (Connection conn = Connect.connect(); PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, pinNumber);
			stmt.setLong(2, mobileNumber);
			String result = "";
			int rows = stmt.executeUpdate();
			if (rows == 0) {
				result = ErrorMessages.PIN_NOT_UPDATED;
			} else {
				result = InfoMessages.PIN_UPDATED;
			}
			return result;

		} catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}
	}
	
	public int balanceCheck(long mobileNumber) throws DBException {

		String balanceSql = "select kyc_wallet from kyc where mobile_no=?";
		try (Connection conn = Connect.connect();
				PreparedStatement stmt2 = conn.prepareStatement(balanceSql);) {
			stmt2.setLong(1, mobileNumber);
			int result =0;
				try (ResultSet rs2 = stmt2.executeQuery();) {
					while (rs2.next()) {
						result=rs2.getInt("kyc_wallet");
					}
				} catch (Exception e) {
					throw new DBException(ErrorMessages.NO_DATA_FOUND);
				}
				return result;
			}
			catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}
	}
	
	
	public String pinUpdate(long mobileNumber, int pinNumber) throws DBException {
		String sql = "update login set upi_passwd=? where mobile_no=?";
		try (Connection conn = Connect.connect(); 
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, pinNumber);
			stmt.setLong(2, mobileNumber);
			String result = "";
			int rows = stmt.executeUpdate();
			if (rows == 0) {
				result = ErrorMessages.PIN_NOT_UPDATED;
			} else {
				result = InfoMessages.PIN_UPDATED;
			}
			return result;

		} catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}
	}

}
