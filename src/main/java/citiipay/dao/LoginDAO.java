package citiipay.dao;

import citiipay.messages.*;

public interface LoginDAO {

	public String personalRegister(long mobileNumber, int pinNumber) throws DBException;

	public int mobPersonalVerification(long mobileNumber) throws DBException;

	public String bussinessRegister(long mobileNumber, String merchantId, long accountNo) throws DBException;

	public int mobBussinessVerification(long mobileNumber) throws DBException;

	public String login(long mobileNumber, int pinNumber) throws DBException;

	public String forgetPassword(long mobileNumber, int pinNumber) throws DBException;
	
	public int balanceCheck(long mobileNumber) throws DBException;
	
	public String pinUpdate(long mobileNumber, int pinNumber) throws DBException;
}
