package citiipay.login;

import java.util.Scanner;

import citiipay.implementation.LogindaoImpl;
import citiipay.implementation.SmsSend;
import citiipay.messages.DBException;

public class TestBussinessRegister {

	public static void main(String[] args) throws DBException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Mobile Number:");
		long mobileNumber = sc.nextLong();
		LogindaoImpl obj=new LogindaoImpl();
		int results=obj.mobBussinessVerification(mobileNumber);
		if(results==1) {
			System.out.println("Verification OTP sent to Registered Mobile number..");
			System.out.println("Enter the OTP:");
			int otpSent=SmsSend.msgForegetPassword(mobileNumber);
			int otpTyped=sc.nextInt();
			if(otpSent==otpTyped) {
				System.out.println("Enter the Merchant Id:");
				String merchantId = sc.next();
				System.out.println("Enter the Account Number");
				long accountNo = sc.nextLong();
				String result=obj.bussinessRegister(mobileNumber, merchantId,accountNo);
				System.out.println(result);
			}
			else {
				System.out.println("Verification OTP is incorrect");
			}
			
		}
		else {
			System.out.println("Account already exists");
		}
	}

}
