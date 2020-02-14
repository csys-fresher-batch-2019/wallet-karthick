package citiipay.service;

import citiipay.dao.LoginDAO;
import citiipay.implementation.LogindaoImpl;
import citiipay.messages.DBException;

public class LoginService {

	private LoginDAO login = new LogindaoImpl();

	public String personalRegister(long mobileNumber, int pinNumber) throws DBException {
		return login.personalRegister(mobileNumber, pinNumber);
	}

	public int mobPersonalVerification(long mobileNumber) throws DBException {
		return login.mobPersonalVerification(mobileNumber);
	}

	public String bussinessRegister(long mobileNumber, String merchantId, long accountNo) throws DBException {
		return login.bussinessRegister(mobileNumber, merchantId, accountNo);
	}

	public int mobBussinessVerification(long mobileNumber) throws DBException {
		return login.mobBussinessVerification(mobileNumber);
	}

	public String login(long mobileNumber, int pinNumber) throws DBException {
		return login.login(mobileNumber, pinNumber);
	}

	public String forgetPassword(long mobileNumber, int pinNumber) throws DBException {
		return login.forgetPassword(mobileNumber, pinNumber);
	}

}
