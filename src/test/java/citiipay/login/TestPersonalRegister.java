package citiipay.login;

import java.util.Scanner;

import citiipay.implementation.LogindaoImpl;
import citiipay.implementation.SmsSend;

public class TestPersonalRegister {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Mobile Number:");
		long mobileNumber = sc.nextLong();
		LogindaoImpl obj=new LogindaoImpl();
		int results=obj.mobPersonalVerification(mobileNumber);
		if(results==1) {
			System.out.println("Verification OTP sent to Registered Mobile number..");
			System.out.println("Enter the OTP:");
			int otpSent=SmsSend.msgForegetPassword(mobileNumber);
			int otpTyped=sc.nextInt();
			if(otpSent==otpTyped) {
				System.out.println("Enter the Pin Number:");
				int pinNumber1 = sc.nextInt();
				System.out.println("Re-Enter the Pin Number:");
				int pinNumber2 = sc.nextInt();
				if(pinNumber1==pinNumber2) {
					String result=obj.personalRegister(mobileNumber,pinNumber1);
					System.out.println(result);
				}
				else {
					System.out.println("Re-entered pin wrong");
					System.out.println("Account not created");
				}
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
