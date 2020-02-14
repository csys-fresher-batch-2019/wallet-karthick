package citiipay.login;

import java.util.Scanner;

import citiipay.implementation.LogindaoImpl;
import citiipay.implementation.SmsSend;
import citiipay.messages.DBException;

public class TestForgetPassword {

	public static void main(String[] args) throws DBException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Mobile Number:");
		long mobileNumber = sc.nextLong();
		LogindaoImpl obj=new LogindaoImpl();
		int results=obj.mobPersonalVerification(mobileNumber);
		if(results==0) {
			int result=SmsSend.msgForegetPassword(mobileNumber);
			System.out.println("Enter the OTP:");
			int otp=sc.nextInt();
			if(otp==result) {
				System.out.println("Enter the Pin Number");
				int pinNumber1 = sc.nextInt();
				System.out.println("Re-Enter the Pin Number");
				int pinNumber2 = sc.nextInt();
				if(pinNumber1==pinNumber2) {
					String rows=obj.forgetPassword(mobileNumber, pinNumber1);
					System.out.println(rows);
				}
				else {
					System.out.println("Re-entered pin wrong");
					System.out.println("Account not created");				
				}
			}
			else {
				System.out.println("Entered OTP is wrong");
			}
			
		}
		else {
			System.out.println("Account doesnot exists");
		}
	}

}
